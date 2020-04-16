Projeto demo de mensageria com Spring, Docker e RabbitMQ.

Usando:

* RabbitMQ
* Spring Cloud
* JDK 11
* Springboot 2.2.1
* IntelliJ
* Rest
* Lombok
* Devtools
* Gradle
* Docker

Subindo um container docker com RabbitMQ:
```
  docker run -d --name rabbitmq \
 -p 5672:5672 \
 -p 15672:15672 \
 --restart=always \
 --hostname rabbitmq-master \
 rabbitmq:3-management
 ```
 
 
Para acessar o RabbitMQ Dashboard:

URL: http://localhost:15672/#/

<p>Usuário: guest</p>
<p>Senha: guest</p>


Este projeto é um 'productService' de mensagens(do tipo objeto da entidade 'Produto'), ele tem dois andpoints. O primeiro
cria um 'Produto' e envia para o Broker(RabbitMQ), o segundo gera uma lista de 'Produtos' de forma randômica, a partir
do numero fornecido e envia todos para o Broker.

Para este projeto existe um outro projeto (https://github.com/rafabart/consumer-spring-rabbitmq)
que é o 'consumer' do RabbitMQ, subindo as duas instâncias dos projetos é possível verificar a comunicação entre elas.
O 'consumer' persiste os objetos recebidos do RabbitMQ em um banco H2.

<p>1) Endpoint</p>
Usando o Postman para criar um novo Produto:

URL: http://localhost:8080/products

Verbo: POST usando JSON
```
{
 	"name": "Play 4",
 	"value": 2000.00,
	"amount": 3
}
```

<p>2) Endpoint</p>
URL: http://localhost:8080/products/QUANTIDADE_DE_PRODUTOS_A_GERAR

Verbo: GET

Será exibito no log do 'consumer' todos o objetos persistidos.

É possível observar a escalabilida de leitura das filas do RabbitMQ subindo varias instância do 'consumer',
que persistirá no mesmo banco os objetos de todas instâncias 'consumer'
