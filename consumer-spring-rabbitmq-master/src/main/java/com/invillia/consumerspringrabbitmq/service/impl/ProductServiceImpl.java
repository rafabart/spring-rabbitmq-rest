package com.invillia.consumerspringrabbitmq.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.invillia.consumerspringrabbitmq.entity.Product;
import com.invillia.consumerspringrabbitmq.repository.ProductRepository;
import com.invillia.consumerspringrabbitmq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {


    final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(final Product product) {
        return productRepository.save(product);
    }

    @StreamListener("product-exchange")
    public void readMessage(String message) {

        try {
             /*
                ObjectMapper().readValue mapeia a string da mensagem para um objeto
                da entidade.
            */

            Product product = new ObjectMapper().readValue(message, Product.class);


            //Salva no banco H2
            Product productSaved = create(product);

            //Exibe o objeto retornado do banco
            System.out.println("Product saved: " + productSaved);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
