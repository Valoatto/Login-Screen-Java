# Login-Screen-Java
Conversor de moedas desktop feito em Java com Swing. Projeto desenvolvido como atividade prática durante o curso de Análise e Desenvolvimento de Sistemas.

# Conversor de Moedas Visual

Projeto desktop em Java com Swing criado como prática dos meus estudos em Análise e Desenvolvimento de Sistemas.

Treinamos a manipulação de números decimais, conversão de tipos, uso de `JComboBox` e separação entre lógica e interface. As taxas foram deixadas fixas no código porque o foco aqui é aprendizado e não precisão de valores reais.

---

# Sobre o projeto

Esse projeto foi feito para praticar conceitos básicos de interface gráfica no Java e lógica de conversão de valores.

Durante o desenvolvimento, consegui reforçar principalmente:

- uso de Swing para interfaces simples
- manipulação de eventos
- conversão de `String` para `double`
- uso de `JComboBox`
- tratamento de erros com `try/catch`
- organização do código em classes separadas

---

# Funcionalidades

- Conversão entre BRL, USD, EUR, GBP, JPY e ARS
- Campo para inserir valor
- Seleção de moeda de origem e destino
- Botão de conversão
- Aceita vírgula ou ponto decimal
- Validação de entrada (vazio, letras, valores inválidos)

---

# Tecnologias utilizadas

- Java 8+
- Swing

---

# Estrutura do projeto

```
conversor-moedas-visual/
├── src/
│   ├── Main.java
│   ├── TelaConversor.java
│   ├── Moeda.java
│   └── Conversor.java
└── README.md
```

- `Main.java` → inicia o programa
- `TelaConversor.java` → interface gráfica
- `Moeda.java` → modelo de dados da moeda
- `Conversor.java` → lógica de conversão

---

# Como funciona

A lógica de conversão é bem simples e usa o real como base intermediária.

Primeiro o valor é convertido para reais e depois para a moeda de destino:

```
doublevalorEmReal=valor*origem.getTaxaEmReal();
returnvalorEmReal/destino.getTaxaEmReal();
```

Isso evita criar várias funções diferentes para cada par de moedas.

---

# Entrada de dados

O usuário pode digitar valores com vírgula ou ponto. Eu trato isso assim:

```
valor=Double.parseDouble(texto.replace(",","."));
```

Se a entrada for inválida, uso `try/catch` para não quebrar o programa.

---

# O que aprendi com esse projeto

- uso de `JComboBox` com objetos
- importância do `toString()` na interface
- tratamento de exceções
- manipulação de números decimais
- organização de código em classes separadas
- separação entre lógica e interface

---

# Melhorias futuras

- buscar taxas reais via API
- histórico de conversões
- inverter moedas com um botão
- modo escuro
- melhorias visuais
