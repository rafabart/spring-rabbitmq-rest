package com.invillia.producerspringrabbitmqrest.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {

    private String name;

    private String cpf;
}
