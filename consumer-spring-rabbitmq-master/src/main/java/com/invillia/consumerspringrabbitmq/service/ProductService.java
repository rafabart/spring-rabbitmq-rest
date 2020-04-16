package com.invillia.consumerspringrabbitmq.service;

import com.invillia.consumerspringrabbitmq.entity.Product;


public interface ProductService {

    public Product create(final Product product);

    public void readMessage(String message);
}
