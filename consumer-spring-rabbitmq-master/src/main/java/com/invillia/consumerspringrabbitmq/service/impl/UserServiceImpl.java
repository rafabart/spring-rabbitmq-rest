package com.invillia.consumerspringrabbitmq.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.invillia.consumerspringrabbitmq.entity.User;
import com.invillia.consumerspringrabbitmq.repository.UserRepository;
import com.invillia.consumerspringrabbitmq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {


    final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User create(final User user) {
        return userRepository.save(user);
    }


    @StreamListener("user-exchange")
    public void readMessage(String message) {

        try {
             /*
                ObjectMapper().readValue mapeia a string da mensagem para um objeto
                da entidade.
            */

            User user = new ObjectMapper().readValue(message, User.class);


            //Salva no banco H2
            User userSaved = create(user);

            //Exibe o objeto retornado do banco
            System.out.println("User saved: " + userSaved);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
