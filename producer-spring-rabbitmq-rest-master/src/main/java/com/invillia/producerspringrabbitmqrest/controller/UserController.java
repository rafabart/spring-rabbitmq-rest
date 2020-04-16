package com.invillia.producerspringrabbitmqrest.controller;

import com.invillia.producerspringrabbitmqrest.factory.UserFactory;
import com.invillia.producerspringrabbitmqrest.request.UserRequest;
import com.invillia.producerspringrabbitmqrest.service.UserService;
import com.invillia.producerspringrabbitmqrest.source.UserSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    final private UserSource userSource;

    final private UserService userService;

    final private UserFactory userFactory;

    @Autowired
    public UserController(final UserSource userSource, final UserService userService, final UserFactory userFactory) {
        this.userSource = userSource;
        this.userService = userService;
        this.userFactory = userFactory;
    }


    /*
        Neste endpoint é recebido um JSON da entidade, serializado pelo spring
        e enviado para o broker
    */
    @PostMapping
    public ResponseEntity<String> create(@RequestBody final UserRequest userRequest) {

        boolean result = userService.sendMessageUser(userRequest, userSource);

        return ResponseEntity.ok("Usuário enviado com sucesso? " + result);
    }


    /*
        Neste endpoint é recebido um inteiro, que será a quantidade de
        objetos fakes criados pelo JBacon, e todos serão enviado para o broker
    */
    @GetMapping("/{amount}")
    public ResponseEntity<String> findById(@PathVariable final Integer amount) {

        final List<UserRequest> userRequestList = userFactory.build(amount);

        userRequestList.forEach(
                userRequest -> userService.sendMessageUser(userRequest, userSource)
        );

        return ResponseEntity.ok("Lista de Usuário enviados com sucesso!");
    }
}
