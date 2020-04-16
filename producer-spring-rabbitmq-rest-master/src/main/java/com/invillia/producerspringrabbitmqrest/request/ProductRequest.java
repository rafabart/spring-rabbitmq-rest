package com.invillia.producerspringrabbitmqrest.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRequest {

    private String name;

    private Double value;

    private Integer amount;
}
