package com.invillia.consumerspringrabbitmq.source;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


/*
    Assinatura do método retorna um 'SubscribableChannel' com
    o binding(vinculo) definido na notação '@Output'.

    Desta forma, a classe que usar esse método buscara
    as mensagens no exchange do broker definido no 'application.yml'
    na propriedade customizada 'product-exchange'.
*/
public interface SourceProduct {

    @Input("product-exchange")
    public SubscribableChannel receiveMessage();
}
