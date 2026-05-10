# Login-Screen-Java
Projeto de tela de login em Java com Swing, desenvolvido como prática durante meus estudos em Análise e Desenvolvimento de Sistemas.

Treinamos a criação de formulários, validação de dados e navegação entre telas em uma aplicação desktop simples. As credenciais são fixas no código porque o mais importante é a lógica e a interface, não autenticação real.

---
# Sobre o projeto

Esse foi um projeto bem importante para praticar interfaces em Java de forma mais organizada.

Durante o desenvolvimento, foquei em:

- criação de formulários com Swing
- validação de campos
- navegação entre telas
- uso de eventos com botões e teclado
- separação entre lógica e interface
- entendimento básico de autenticação simulada

---

# Funcionalidades

- Campo de usuário e senha
- Botão de login com validação
- Validação de campos vazios
- Mensagens de erro e sucesso com `JOptionPane`
- Tela inicial após login correto
- Botão de sair voltando para login
- Login também via tecla Enter

---

# Credenciais de teste

- Usuário: `admin`
- Senha: `1234`

---

# Tecnologias

- Java 8+
- Swing

---

# Estrutura do projeto

```
tela-login-visual/
├── src/
│   ├── Main.java
│   ├── TelaLogin.java
│   ├── TelaInicial.java
│   └── Autenticador.java
└── README.md
```

- `Main.java` → inicia o programa
- `TelaLogin.java` → interface de login
- `TelaInicial.java` → tela após login
- `Autenticador.java` → validação das credenciais

---

# Como funciona

A lógica foi separada para deixar tudo mais simples de entender.

## Autenticação

A validação é feita em uma classe separada:

```
returnUSUARIO_VALIDO.equals(usuario)&&SENHA_VALIDA.equals(senha);
```

---

## Validação do login

Antes de autenticar, o sistema verifica se os campos estão preenchidos:

```
if (usuario.isEmpty()||senha.isEmpty()) {
mostrarAviso("Preencha usuario e senha.");
return;
}
```

---

## Troca de telas

Quando o login dá certo, a tela de login é fechada e a tela inicial é aberta:

- login correto → abre `TelaInicial`
- botão sair → volta para `TelaLogin`

---

## Sobre a senha

Usei `JPasswordField`, que esconde a senha digitada. Para comparar, transformei em `String`:

```
Stringsenha=newString(campoSenha.getPassword());
```

---

# O que aprendi com esse projeto

- uso de formulários no Swing
- validação de campos
- navegação entre telas
- diferença entre `==` e `.equals()`
- uso de `JOptionPane`
- separação de responsabilidades no código
- lógica básica de autenticação

---

# Melhorias futuras

- adicionar banco de dados
- tela de cadastro de usuário
- criptografia de senha
- melhorar design da interface
- controle de sessão
