package com.springbootacademy.pos_system.service.impl;

import java.util.stream.Collectors;
import com.springbootacademy.pos_system.dto.ResponseBillDto;
import com.springbootacademy.pos_system.dto.ResponseOrderDetailsDto;
import com.springbootacademy.pos_system.dto.request.RequestOrderDetails;
import com.springbootacademy.pos_system.dto.request.RequestOrderSaveDto;
import com.springbootacademy.pos_system.entity.Item;
import com.springbootacademy.pos_system.entity.Order;
import com.springbootacademy.pos_system.entity.OrderDetails;
import com.springbootacademy.pos_system.repo.CustomerRepo;
import com.springbootacademy.pos_system.repo.ItemRepo;
import com.springbootacademy.pos_system.repo.OrderDetailsRepo;
import com.springbootacademy.pos_system.repo.OrderRepo;
import com.springbootacademy.pos_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public String addOrder(RequestOrderSaveDto requestOrderSaveDto) {

        double totalAmount = 0;

        List<OrderDetails> orderDetailsList = new ArrayList<>();

        for (RequestOrderDetails dto : requestOrderSaveDto.getOrderDetails()) {
            Item item = itemRepo.findById(dto.getItems())
                    .orElseThrow(() -> new RuntimeException("Item not found with id: " + dto.getItems()));

            double amount = dto.getQty() * item.getSellingPrice();
            totalAmount += amount;

            OrderDetails od = new OrderDetails();
            od.setItemName(item.getItemName());
            od.setQty(dto.getQty());
            od.setAmount(amount);
            od.setItems(item);

            orderDetailsList.add(od);
        }

        // Save Order
        Order order = new Order(
                customerRepo.getById(requestOrderSaveDto.getCustomer()),
                requestOrderSaveDto.getDate(),
                totalAmount
        );
        orderRepo.save(order);

        // Link OrderDetails to Order
        for (OrderDetails od : orderDetailsList) {
            od.setOrder(order);
        }

        orderDetailsRepo.saveAll(orderDetailsList);

        return "Order Saved Successfully with total: " + totalAmount;
    }

    @Override
    @Transactional
    public ResponseBillDto getBill(int orderId) {

        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        // ✅ Fixed: replaced .toList() with .collect(Collectors.toList()) for Java 11 compatibility
        List<ResponseOrderDetailsDto> detailsDtoList = order.getOrderDetails().stream()
                .map(od -> new ResponseOrderDetailsDto(
                        od.getItemName(),
                        od.getQty(),
                        od.getAmount()
                )).collect(Collectors.toList());

        return new ResponseBillDto(
                order.getOrderId(),
                order.getCustomer().getCustomerName(),
                order.getOrderDate(),
                order.getTotal(),
                detailsDtoList
        );
    }
}