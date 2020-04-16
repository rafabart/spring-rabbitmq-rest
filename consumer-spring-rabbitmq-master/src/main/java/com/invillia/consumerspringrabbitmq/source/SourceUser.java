package com.invillia.consumerspringrabbitmq.source;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


public interface SourceUser {

    @Input("user-exchange")
    public SubscribableChannel receiveMessage();
}
