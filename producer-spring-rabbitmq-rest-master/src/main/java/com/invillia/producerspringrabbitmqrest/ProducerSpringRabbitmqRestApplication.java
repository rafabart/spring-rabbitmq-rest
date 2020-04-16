package com.invillia.producerspringrabbitmqrest;

import com.invillia.producerspringrabbitmqrest.source.ProductSource;
import com.invillia.producerspringrabbitmqrest.source.UserSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/*
    @EnableBinding(Source.class) indicando que a classe de
    publicação de mensagens estará habilitando um custom binding,
    que no caso esta na interface Source.
    Aceita como parametro uma lista de bindings. @EnableBinding({ProductSource.class, UserSource.class})
*/
@SpringBootApplication
@EnableBinding({ProductSource.class, UserSource.class})
public class ProducerSpringRabbitmqRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerSpringRabbitmqRestApplication.class, args);
    }

}

