# Desafio CRUD de clientes - Java Spring Professional

Projeto desenvolvido como parte do quarto desafio da formação Java Spring Professional, da plataforma Devsuperior

## Tecnologias

- Java 21
- Spring Boot 4.1.0
- Spring Data JPA
- Banco de dados H2
- Maven

## Objetivo

O objetivo é desenvolver um sistema de vendas (Sale) e vendedores (Seller). Cada venda está associada a um vendedor, enquanto um vendedor pode possuir várias vendas

A aplicação possui os seguintes casos de uso

- Relatório de vendas
- Sumário de vendas por vendedor

## Diagrama de classe

<img width="507" height="146" alt="Image" src="https://github.com/user-attachments/assets/ad7bb3d2-b504-4165-b91b-bfcf5f176160" />

## 1. Relatório de vendas

Permite consultas as vendas realizadas em determinado período, com a possibilidade de filtrar pelo nome do vendedor

### Entrada

O usuário pode informar, opcionalmente

- Data inicial
- Data final
- Um trecho do nome do vendedor

### Saída

O sistema deverá retornar uma `listagem paginada` contendo as vendas que atendam aos filtros informados.
Cada registro deverá apresentar
- `id` da venda
- `date`- data da venda
- `amount` - quantia vendida
- `sellerName` - nome do vendedor

### Regras de negócio

- Se a `data final` não for informada, será considerada a data atual do sistema
- Se a `data inicial` não for informada, será considerada a data de 1 ano antes da `data final`
- Se o nome não for informado, será considerado um `texto vazio`

## 2. Sumário de vendas por vendedor

Permite consultar o total de vendas realizado por cada vendedor em determinado período

### Entrada

O usuário pode informar, opcionalmente

- Data inicial
- Data final

### Saída

O sistema deverá retornar uma `listagem` contendo
- `sellerName` - nome do vendedor
- `total` - total de vendas realizadas pelo vendedor no período informado

### Regras de negócio

- Se a `data final` não for informada, será considerada a data atual do sistema
- Se a `data inicial` não for informada, será considerada a data de 1 ano antes da `data final`

## Testes

### Relatório de vendas

<img width="664" height="735" alt="Image" src="https://github.com/user-attachments/assets/c0a48621-2a4c-4d95-8f47-b80ced177014" />

- `Observação`: o ID da venda para o teste 2 pode mudar de acordo com atualizações no seed do banco de dados fornecido pela plataforma

### Sumário de vendas

<img width="1152" height="648" alt="Image" src="https://github.com/user-attachments/assets/0f22cb70-f731-4ee2-b262-a58416021020" />

## Critérios de correção

- Sumário de vendas por vendedor passando argumentos minDate e maxDate deve retornar os dados previstos no enunciado
- Sumário de vendas por vendedor sem passar argumentos deve retornar os dados dos últimos 12 meses
- Relatório de vendas sem passar argumentos deve retornar vendas dos últimos 12 meses
- Relatório de vendas passando argumentos minDate e maxDate deve retornar os dados previstos no enunciado

## Competências avaliadas

- Realização de casos de uso
- Criação de endpoints de API Rest com parâmetros de consulta opcionais
- Implementação de consultas em banco de dados relacional com Spring Data JPA
