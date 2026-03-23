package com.springbootacademy.pos_system.dto;

import com.springbootacademy.pos_system.dto.ResponseOrderDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBillDto {

    private int orderId;
    private String customerName;
    private Date date;
    private double total;
    private List<ResponseOrderDetailsDto> orderDetails;
}
