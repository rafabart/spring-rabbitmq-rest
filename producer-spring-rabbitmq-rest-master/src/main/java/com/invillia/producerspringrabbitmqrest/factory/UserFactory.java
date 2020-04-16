package com.invillia.producerspringrabbitmqrest.factory;

import br.com.leonardoferreira.jbacon.JBacon;
import com.github.javafaker.Faker;
import com.invillia.producerspringrabbitmqrest.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserFactory extends JBacon<UserRequest> {

    private final Faker faker = new Faker();

    @Override
    protected UserRequest getDefault() {

        UserRequest userRequest = new UserRequest();

        userRequest.setName(faker.gameOfThrones().character());
        userRequest.setCpf(faker.number().digits(11));

        return userRequest;
    }

    @Override
    protected UserRequest getEmpty() {
        return new UserRequest();
    }

    @Override
    protected void persist(UserRequest userRequest) {
        throw new UnsupportedOperationException();
    }
}
