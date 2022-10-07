# <img src="https://user-images.githubusercontent.com/77124683/194066051-ae286a3b-9a56-46f6-b2c6-431e2495db90.png" width="5%"> ToDo APP
## Start By Capgemini -Lógica de Programação e Algoritmos III 

## Sobre o projeto

O projeto foi construído durante a etapa de lógica de programação e algoritmos III, usando Java Swing para construção de telas e JDBC para persistência de dados.

Ferramenta/Tecnologia   | Versão
--------- | ------
OpenJDK | 17
Maven | 3.8.6
Apache Netbeans | 15
MySQL | 8.0
JDBC / Connector | 8.0.26

A aplicação consiste em um gerenciador de tarefas básicos a fim de utilizar todas as tecnologias vistas em trilhasa anteriores. As operações de persistência de dados traduz um CRUD.

### Diagrama ER e Classe

![todoapp](https://user-images.githubusercontent.com/77124683/194144566-1688dddc-49ed-49a1-8570-2f529e575420.png)
<img alt="login" src="https://user-images.githubusercontent.com/77124683/194446747-2a1875f8-2c17-4797-841e-23a6cb21ba5a.png" width="50%">

### Estrutura do Projeto

![image](https://user-images.githubusercontent.com/77124683/194446990-720331f9-5c29-4d7b-9d4f-b3bca4b85a3a.png)

### Demonstração

https://user-images.githubusercontent.com/77124683/194456844-73980591-945f-4ccf-84bf-8b0ffea471d3.mp4

#### Extras

Como desafio, foi sugerido a função de editar tarefas ao clicar no botão, que foi implementado e mostrado no vídeo

### Como iniciar na máquina local

Clone o repositório na sua máquina

Importe como um projeto maven existente a partir de sua IDE

Certifique-se que as depedências do pom.xml foram baixadas e adicionadas ao projeto

Inicie MainScreen.java

![image](https://user-images.githubusercontent.com/77124683/194457235-3f61fd6c-3428-45c1-9812-60fabe03fe20.png)

Configurar variáveis de acordo com as configurações do seu SGBD
```
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp"; // necessário criar schema manualmente ou adicionar a constraint "?createDatabaseIfNotExist=true&serverTimezone=UTC"
    public static final String USER = "seu usuario";
    public static final String PASS = "sua senha";
```

### Sobre o programa
É uma iniciativa da Capgemini para acelerar a formação de novos talentos em tecnologia, valorizando a inclusão e a diversidade, com cursos online gratuitos que, após finalizados, voce terá a chance de conquistar uma das mais de 500 vagas para trabalhar no time Capgemini!




![download](https://user-images.githubusercontent.com/77124683/190933768-0c4f8ecd-ef2b-4139-943d-2c88540e9f93.png)

[Mais informações](https://startcapgemini.com.br/)
