# luiza-code-centopeia
<h1 align="center">WishList</h1>
<p align="center">Descrição</p>
Projeto final do curso Luiza code 2° edição onde desenvolvemos o back-end de uma wishlist.


## Conteúdos

<!--ts-->
   * [Sobre](#Sobre)
   * [Tabela de Conteudo](#tabela-de-conteudo)
   * [Configuração do ambiente](#instalacao)
   * [Como usar](#como-usar)
      * [Pre Requisitos](#pre-requisitos)
      * [Local files](#local-files)
      * [Remote files](#remote-files)
      * [Multiple files](#multiple-files)
      * [Combo](#combo)
   * [Tests](#testes)
   * [Tecnologias](#tecnologias)
<!--te-->

### Features

- [v] Cadastro de clientes
- [x] Cadastro de produtos
- [x] Wishlist

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Maven](https://maven.apache.org/), [SpringBoot](https://spring.io/projects/spring-boot), [Postman](https://www.postman.com/).
Além disto é bom ter um editor da sua preferência.

### 🎲 Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone <https://github.com/tgmarinho/nlw1>

# Execute a aplicação em modo de desenvolvimento
$ mvn clean install

# O servidor inciará na porta:8080 - acesse <http://localhost:8080>
```
### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [JDK](https://www.oracle.com/br/java/technologies/javase-downloads.html)
- [Maven](https://nodejs.org/en/)
- [React](https://pt-br.reactjs.org/)
- [SpringBoot](https://reactnative.dev/)
- [Postman](https://www.typescriptlang.org/)
- [Mysql](https://www.mysql.com/)
- [mysql workbench](https://www.mysql.com/products/workbench/)
======================================================================================
Necessária pré configuração das seguintes tecnologias:

Apache Maven 3.5.0 ( ou superior) Java version: 1.8.0_144 ( ou superior) Seguintes extensões foram utilizadas para implementação org.springframework.boot - 1.5.7.RELEASE -spring-boot-starter-security -spring-boot-starter-data-mongodb

1. Fazer download do projeto

2. Alterar conexões do banco de dados no arquivo application.properties

Em caso de utilização do banco localmente ( Gerar um arquivo Js para os inserts abaixo)

db.user.insertMany([{"nickname": "root","password": "123456"}])

db.product.insertMany([{"name":"Beer","type": "drink"}, {"name":"Coca-cola","type": "drink"}, {"name":"Doritos","type": "Snack"}])

3. No cmd na pasta do projeto rodar os seguintes comando:
• mvn clean install
• mvn spring-boot:run
4. Browser ( De sua preferencia)
http:localhost:8080 ( Esperado Erro 402: Access Denied)

* Recomendo a utilzação do Postman

http:localhost:8080/login 

Em Header adicionar um novo usúario e fazer uma nova requisição GET para o endereço http:localhost:8080/home
