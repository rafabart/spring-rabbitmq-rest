package com.invillia.producerspringrabbitmqrest.service;

import com.invillia.producerspringrabbitmqrest.request.UserRequest;
import com.invillia.producerspringrabbitmqrest.source.UserSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /*
        O método recebe 2 parametros: A mensagem, no caso o objeto da entidade
        e o binding de destino no broker
     */
    public boolean sendMessageUser(final UserRequest userRequest, final UserSource userSource) {

        Message<UserRequest> message = MessageBuilder.withPayload(userRequest).build();

        //Envia a mensagem e retorna 'true' em caso de sucesso.
        return userSource.sendMessage().send(message);
    }
}
