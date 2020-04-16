package com.invillia.producerspringrabbitmqrest.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/*
    Assinatura do método retorna um 'MessageChannel' com
    o binding(vinculo) definido na notação '@Output'.

    Desta forma, a classe que usar esse método direcionará
    as mensagens para o exchange do broker definido no 'application.yml'
    na propriedade customizada 'product-exchange'.
*/

public interface ProductSource {

    @Output("product-exchange")
    MessageChannel sendMessage();
}
