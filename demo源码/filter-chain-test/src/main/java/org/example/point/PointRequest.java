package org.example.point;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PointRequest {

    private String bizCode;

    private BigDecimal point;

    private Integer pointType;

    private Integer expiredType;


}
