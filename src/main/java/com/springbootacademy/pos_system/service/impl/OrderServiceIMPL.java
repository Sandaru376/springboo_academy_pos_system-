package com.springbootacademy.pos_system.service.impl;

import com.springbootacademy.pos_system.dto.request.RequestOrderDetails;
import com.springbootacademy.pos_system.dto.request.RequestOrderSaveDto;
import com.springbootacademy.pos_system.entity.Item;
import com.springbootacademy.pos_system.entity.Oder;
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

        double totalAmount = 0; // ✅ initialize total

        // 1️⃣ Process Order Details first to calculate total
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        for (RequestOrderDetails dto : requestOrderSaveDto.getOrderDetails()) {

            Item item = itemRepo.findById(dto.getItems())
                    .orElseThrow(() ->
                            new RuntimeException("Item not found with id: " + dto.getItems())
                    );

            double amount = dto.getQty() * item.getSellingPrice();

            totalAmount += amount;

            OrderDetails od = new OrderDetails();
            od.setItemName(item.getItemName());
            od.setQty(dto.getQty());
            od.setAmount(amount);
            od.setItems(item);

            orderDetailsList.add(od);
        }


        // 2️⃣ Save Order with calculated total
        Oder order = new Oder(
                customerRepo.getById(requestOrderSaveDto.getCustomer()),
                requestOrderSaveDto.getDate(),
                totalAmount // ✅ automatically calculated
        );

        orderRepo.save(order);

        // 3️⃣ Link order to order details
        for (OrderDetails od : orderDetailsList) {
            od.setOders(order);
        }

        // 4️⃣ Save order details
        orderDetailsRepo.saveAll(orderDetailsList);

        return "Order Saved Successfully with total: " + totalAmount;
    }


}