package com.invillia.producerspringrabbitmqrest.factory;

import br.com.leonardoferreira.jbacon.JBacon;
import com.github.javafaker.Faker;
import com.invillia.producerspringrabbitmqrest.request.ProductRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductFactory extends JBacon<ProductRequest> {

    private final Faker faker = new Faker();

    @Override
    protected ProductRequest getDefault() {

        ProductRequest productRequest = new ProductRequest();

        productRequest.setName(faker.commerce().productName());
        productRequest.setValue(faker.number().randomDouble(2, 10, 500));
        productRequest.setAmount(faker.number().numberBetween(1, 20));

        return productRequest;
    }

    @Override
    protected ProductRequest getEmpty() {
        return new ProductRequest();
    }

    @Override
    protected void persist(ProductRequest productRequest) {
        throw new UnsupportedOperationException();
    }
}
