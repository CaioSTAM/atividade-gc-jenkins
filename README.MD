# atividade-gc-jenkins

Projeto desenvolvido para a atividade de Gerência de Configuração com Jenkins e GitHub.

## Objetivo

Demonstrar um processo inicial de Integração Contínua usando Jenkins integrado com GitHub, executando build, testes automatizados e cobertura de código.

## Tecnologias utilizadas

- Java 25
- Maven
- JUnit 5
- JaCoCo
- Jenkins
- GitHub

## Classe principal

A classe `StoreService` possui dois métodos principais:

1. `calculateDiscountedPrice(double originalPrice, double discountPercentage)`

Calcula o preço final de um produto após a aplicação de um desconto percentual.

2. `isFreeShipping(double purchaseValue)`

Verifica se uma compra possui frete grátis. Neste projeto, compras a partir de R$ 150,00 possuem frete grátis.

## Executar localmente

Compilar o projeto:

```bash
mvn clean compile
```

Rodar os Testes:

```bash
mvn test
```

Gerar relatório de cobertura:

```bash
mvn verify
```