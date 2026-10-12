# Sistema de Gestão de Loja — Projeto POO

Aplicação desktop em Java para controle de produtos e estoque, vendas de produtos e serviços, e relatórios de estoque, clientes, colaboradores e vendas.

Projeto acadêmico desenvolvido em grupo na disciplina de Programação Orientada a Objetos, 2ª fase de Análise e Desenvolvimento de Sistemas da Faculdade Senac Criciúma.

## Funcionalidades
- Login com validação de usuário e senha
- Cadastro de clientes, colaboradores, produtos e serviços
- Controle de estoque
- Registro de vendas de produtos e serviços
- Relatórios de estoque, clientes, colaboradores e vendas

## Conceitos de POO aplicados
- Herança: `Pessoa` como base de `Cliente` e `Colaborador`; `Id` como base das entidades
- Encapsulamento das entidades com getters e setters
- Enum para tipo de pessoa (`TipoPessoa`)
- Camada de repositório separada da interface (`repository/`)

## Tecnologias
- Java 8
- Swing (`JOptionPane`) para a interface
- Dados mantidos em memória durante a execução

## Como executar
Abra o projeto no IntelliJ IDEA e execute a classe `Main`.
