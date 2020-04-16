package com.invillia.producerspringrabbitmqrest.service;

import com.invillia.producerspringrabbitmqrest.source.ProductSource;
import com.invillia.producerspringrabbitmqrest.request.ProductRequest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    /*
        O método recebe 2 parametros: A mensagem, no caso o objeto da entidade
        e o binding de destino no broker
     */
    public boolean sendMessageProduct(final ProductRequest productRequest, final ProductSource productSource) {

        Message<ProductRequest> message = MessageBuilder.withPayload(productRequest).build();

        //Envia a mensagem e retorna 'true' em caso de sucesso.
        return productSource.sendMessage().send(message);
    }
}
