Projeto demo da incubadora. Mensageria com RabbitMQ.

Usando:

* RabbitMQ
* Spring Cloud
* JDK 11
* Springboot 2.2.1
* IntelliJ
* Lombok
* Devtools
* Gradle
* Docker
* H2

Banco de Dados em memória, não necessita configuração.

Subindo um container docker com RabbitMQ:
```docker run -d --name rabbitmq \
 -p 5672:5672 \
 -p 15672:15672 \
 --restart=always \
 --hostname rabbitmq-master \
 rabbitmq:3-management
 ```
 
 
Para acessar o RabbitMQ Dashboard:

URL:``` http://localhost:15672/#/```

Usuário: guest
Senha: guest


Este projeto é um 'consumer' de mensagens(do tipo objeto da entidade 'Produto') do RabbitMQ, o 'producer' esta no link:
https://github.com/rafabart/producer-spring-rabbitmq-rest

O 'consumer' persiste no banco H2 os dados recebidos do RabbitMQ e exibe no log os dados salvos.
