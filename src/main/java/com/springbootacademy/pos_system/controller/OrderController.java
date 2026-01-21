package com.springbootacademy.pos_system.controller;
import com.springbootacademy.pos_system.dto.request.RequestOrderSaveDto;
import com.springbootacademy.pos_system.service.OrderService;
import com.springbootacademy.pos_system.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(
            @RequestBody RequestOrderSaveDto requestOrderSaveDto) {

        String message = orderService.addOrder(requestOrderSaveDto);

        StandardResponse response = new StandardResponse(
                201,
                "SUCCESS",
                message
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

