### <center>MARVEL API</center>
[![Build Status](https://travis-ci.com/liliannss/marvel-api.svg?branch=main)](https://travis-ci.com/liliannss/marvel-api)

[![codecov](https://codecov.io/gh/liliannss/marvel-api/branch/main/graph/badge.svg?token=BWGJINSVPT)](https://codecov.io/gh/liliannss/marvel-api)

### Versão
- V. 0.0.1 -> 13/01/2021

### Java Version
- 11
````json
    java -version
````

### Docker Version
- 20.10.2
````json
    docker -v
````

### Docker Compose Version
- 1.27.4, build 40524192
````json
    docker-compose --version
````

### <center>Instruções local</center>
- Baixar o código do repositório remoto

```json
  git clone https:github.com/liliannss/marvel-api.git
```

- Iniciar a classe GatewayApplication


### <center>Endpoints</center>
*GET* /characters -> Fetches lists of comic characters with optional filters.See notes on individual parameters below.  
*GET* /characters/{characterId} -> This method fetches a single character resource.It is the canonical URI for any character resource provided by the API.  

### <center>Endpoint - Extra</center>
*POST* /characters -> Create a new Hero

### Swagger
[URL Swagger](http:localhost:443/v1/public/swagger-ui.html)

### <center>Autenticação em Memória</center> 
```json
    Nome de usuário: Stan Lee
    Senha: 123
```

### <center>Testes Unitários</center>
- Executar comando mvn para execução dos testes
```json
    mvn clean test
```

### <center>Base de Dados em Memória</center>
- #### Observação: necessário que a aplicação tenha sido startada através da classe Main   
[URL Banco de Dados](http:localhost:443/v1/public/h2-console)

```json
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:marvel-heroes
User Name: marvel
Password:
```

### <center>Dockercompose</center>

- Criar o arquivo .jar do projeto
```json
    mvn clean package
````

- Na pasta do projeto executar     
- #### Espere uns segundos até que o container suba e você consiga fazer suas requisições =)

````json
    docker-compose up -d
````
### <center>![alt text](imgs/docker-compose.png)</center>    



# <center>SAVE THE HEROES</center>

### <center>![alt text](imgs/heroes.png)</center>    
