package com.invillia.producerspringrabbitmqrest.controller;

import com.invillia.producerspringrabbitmqrest.factory.ProductFactory;
import com.invillia.producerspringrabbitmqrest.service.ProductService;
import com.invillia.producerspringrabbitmqrest.source.ProductSource;
import com.invillia.producerspringrabbitmqrest.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    final private ProductSource productSource;

    final private ProductService productService;

    final private ProductFactory productFactory;

    @Autowired
    public ProductController(final ProductSource productSource, final ProductService productService, final ProductFactory productFactory) {
        this.productSource = productSource;
        this.productService = productService;
        this.productFactory = productFactory;
    }


    /*
        Neste endpoint é recebido um JSON da entidade, serializado pelo spring
        e enviado para o broker
    */
    @PostMapping
    public ResponseEntity<String> create(@RequestBody final ProductRequest productRequest) {

        boolean result = productService.sendMessageProduct(productRequest, productSource);

        return ResponseEntity.ok("Produto enviado com sucesso? " + result);
    }


    /*
        Neste endpoint é recebido um inteiro, que será a quantidade de
        objetos fakes criados pelo JBacon, e todos serão enviado para o broker
    */
    @GetMapping("/{amount}")
    public ResponseEntity<String> findById(@PathVariable final Integer amount) {

        final List<ProductRequest> productRequestList = productFactory.build(amount);

        productRequestList.forEach(
                productRequest -> productService.sendMessageProduct(productRequest, productSource)
        );

        return ResponseEntity.ok("Lista de Produto enviados com sucesso!");
    }
}
