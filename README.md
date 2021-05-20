<img src="https://img.shields.io/static/v1?label=java&message=java&color=blue&style=flat&logo=ghost"/> [![GitHub license](https://img.shields.io/github/license/Naereen/StrapDown.js.svg)](https://github.com/Naereen/StrapDown.js/blob/master/LICENSE) [![GitHub version](https://badge.fury.io/gh/Naereen%2FStrapDown.js.svg)](https://github.com/Naereen/StrapDown.js) ![Heroku](https://heroku-badge.herokuapp.com/?app=heroku-badge)


# luiza-code-centopeia
<h1 align="center">WishList</h1>
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

<h4 align="center"> 
	🚧  WishList 🚀 Concluída  🚧
</h4>

### Features

- [x] Cadastro de clientes
- [x] Cadastro de produtos
- [x] Wishlist

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Maven](https://maven.apache.org/), [SpringBoot](https://spring.io/projects/spring-boot), [Postman](https://www.postman.com/).
Além disto é bom ter um editor da sua preferência.

### 🎲 Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone <https://github.com/silvaalejesus/luiza-code-centopeia>

# instale as dependências
$ mvn clean install
$ mvn spring-boot:run

# O servidor inciará na porta:8080 - acesse <http://localhost:8080>
```
### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [JDK](https://www.oracle.com/br/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/)
- [ReactJs](https://pt-br.reactjs.org/)
- [SpringBoot](https://spring.io/projects/spring-boot)
- [Postman](https://www.postman.com/)
- [Mysql](https://www.mysql.com/)
- [mysql workbench](https://www.mysql.com/products/workbench/)
======================================================================================
Necessária pré configuração das seguintes tecnologias:

Apache Maven 3.5.0 ( ou superior) Java version: 1.8.0_144 ( ou superior) Seguintes extensões foram utilizadas para implementação org.springframework.boot - 1.5.7.RELEASE

1. Fazer download do projeto

2. Alterar conexões do banco de dados no arquivo application.properties
 * url do seu banco de dados
 * user
 * password
3. No cmd na pasta do projeto rodar os seguintes comando:
• mvn clean install
• mvn spring-boot:run
4. Browser ( De sua preferencia)
http:localhost:8080 ( Esperado Erro 402: Access Denied)

* Recomendo a utilzação do Postman

http:localhost:8080/login 

Em Header adicionar um novo usúario e fazer uma nova requisição GET para o endereço http:localhost:8080/cliente
