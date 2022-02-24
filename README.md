# Desafio-Backend
API REST TO-DO Gerenciador de tarefas

## ✔️ Tecnologias utilizadas:
-``Java 11``
-``Spring Boot``
-``Spring Security``
-``Sprng Web``
-``Spring JPA``
-``Swagger (Springfox)``
-``Postresql``
-``Postman``

## Baixe todas as dependências do meven que estão no pom.xml
## Para alterar o banco de dados que deseja ultilizar no application.properties e adicionando a dependência dele no pom.xml
### O Token dura 10 minutos

## Para obter o token JWt e ter acesso as funcinalidades da API
Comente as 3 classes JWT no pacote security e coloque a anotação @SpringBootApplication(exclude = SecurityAutoConfiguration.class) na classe TodoListApplication
Rode o projeto e cadastre um usuário.

Depois de ter cadastrado um usuário. Pode reverte as mudanças e rodar o projeto novamente
faça um post com o email e senha do usuário criado para gerar o token JWT.
