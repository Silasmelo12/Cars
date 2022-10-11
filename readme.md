# Consumindo API externa com OpenFeign



Este projeto é um Projeto que consome uma API externa com o OpenFeign e cria um logs com as informações do **_id_** e **_data_** dos carros que foram criados. Para cadastrar um novo carro é necessário informar os seguintes parametros: **_title_**, **_brand_**, **_price_** e **_age_**. Estas informações são enviadas para a API externa e se tiver exito em persistir, então é criado o log com o **_id_** do carro cadastrado que a API externa retorna, e então é persistido em um bando de dados não relacional **mongoDB** com o nome **_logs_** armazenando também a **_data_** da realiazação do cadastro do carro. O mongoDB é executado por um **Container** no **Docker**.

> **_NOTE:_** É necessário ter o Docker instalado.

1. Baixar a imagem do mongodb no docker.

```
docker pull tutum/mongodb
```

1. Criar um container com a imagem do mongodb sem usuario e senha com o nome *logs*.

```
docker run -d -p 27017:27017 -p 28017:28017 -e AUTH=no --name logs tutum/mongodb
```

1. Inicializando a base de dados *logs*.

```
docker start logs
```

1. Configuração em yml.

```
spring:
  data:
    mongodb:
      authentication-database: admin
      database: logs
      port: 27017
      host: localhost
```

> **_NOTE:_** Sobre as dependências, o Maven e Spring Boot são os responsáveis por fazer o trabalho. Estão no arquivo *pom.xml*



Afim consumir esta API, utilizei o **Postman**.

1. Cadastro de um bicicleta

   - Abrir o Postman e selecionar o método HTTP **_POST_**. Em **_Body_**, selecione arquivo em **_JSON_**. E então envie o seguinte exemplo para o link `http://localhost:8080/api/createCar`:

   ```
   {
       "title": "mobi",
       "brand": "Fiat",
       "price": "57000",
       "age": 2000
   }
   ```

   A imagem a seguir ilustra bem o exemplo

   ![This is an image](hthttps://github.com/Silasmelo12/cars/blob/master/imagens/Captura%20de%20tela%202022-10-11%20005454.png)


1. Consultar todas as bicicletas

   - Selecione o método **_GET_** e envie: 

   ```
   http://localhost:8080/api/logs
   ```

   ​