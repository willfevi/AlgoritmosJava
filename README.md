# Projeto de Grafos - Java Web

Este é um projeto de aplicação web em **Java** para criação e manipulação de grafos, desenvolvido utilizando a arquitetura **MVC** com o **Spring Boot** e o motor de templates **Thymeleaf**. A aplicação permite criar dois tipos de grafos (direcionais e ponderados), além de implementar os algoritmos de Ordenação Topológica, Dijkstra e A*.

## Funcionalidades

- **Criação de grafos**: O usuário pode selecionar entre:
  - Grafo Direcional Não Ponderado.
  - Grafo Não Direcional Ponderado.
- **Visualização dos nós e arestas**: O grafo criado é exibido na interface.
- **Algoritmos disponíveis**:
  - **Ordenação Topológica** (para grafos direcionais).
  - **Dijkstra** (para encontrar o caminho mínimo em grafos ponderados).
  - **Algoritmo A*** (para encontrar o caminho mínimo com heurística).

## Requisitos

- **Java 17+**
- **Maven 3.6+**
- **Spring Boot 2.7+**
- **Thymeleaf**

## Estrutura do Projeto

/src/main/java /com/exemplo/grafos /controller /model /service /algorithm /src/main/resources /templates index.html grafo.html resultado.html /static /css /js pom.xml


### Tecnologias Utilizadas
**Spring Boot: Framework para a construção da aplicação web.**
**Thymeleaf: Motor de templates para renderização de páginas HTML.**
**Maven: Gerenciamento de dependências.**
**Java: Linguagem principal do projeto.**
**CSS/JavaScript: Utilizado para estilização e interatividade da interface.**

### Melhorias Futuras
**Implementar visualização gráfica dos grafos.**
**Adicionar testes unitários para os algoritmos de grafos.**
**Melhorar a usabilidade e design da interface.**

### Contribuição
**Fique à vontade para abrir issues ou pull requests. Agradecemos sua contribuição!**
