package com.invillia.consumerspringrabbitmq.service;

import com.invillia.consumerspringrabbitmq.entity.User;


public interface UserService {

    User create(final User product);

    void readMessage(final String message);
}
