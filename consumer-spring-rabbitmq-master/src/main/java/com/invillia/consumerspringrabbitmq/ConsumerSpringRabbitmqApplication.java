package com.invillia.consumerspringrabbitmq;

import com.invillia.consumerspringrabbitmq.source.SourceProduct;
import com.invillia.consumerspringrabbitmq.source.SourceUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({SourceProduct.class, SourceUser.class})
public class ConsumerSpringRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerSpringRabbitmqApplication.class, args);
    }

}
