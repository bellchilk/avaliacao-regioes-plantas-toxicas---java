# 🌿 Avaliação de Regiões com Plantas Tóxicas - Com Java

Projeto acadêmico da disciplina **Linguagem e Programação II**  
Desenvolvido por **Izabella Miranda Silva**.

## 📌 Descrição

Sistema desktop para gerenciamento e avaliação de regiões que possuem plantas tóxicas e medicinais, com foco em apoio à análise de risco e monitoramento ambiental.  
Permite cadastrar botânicos, plantas, regiões e avaliações de toxicidade, além de realizar pesquisas com filtros avançados sobre esses dados.

## 🧪 Funcionalidades principais

- Cadastro de plantas (tóxicas e medicinais) com atributos específicos.  
- Cadastro de botânicos e regiões.  
- Registro de avaliações de toxicidade, relacionando botânico e região, com contagem de plantas de alta e baixa toxicidade.  
- Pesquisa de avaliações de toxicidade com filtros por especialidade do botânico, acessibilidade da região, origem da planta, parte utilizada, composto tóxico e quantidade mínima de plantas de alta toxicidade.  
- Exibição detalhada de avaliações, listando botânico, região e plantas associadas.

## 🚀 Como executar

1. **Requisitos**  
   - Java 8+ instalado.  
   - Banco de dados configurado de acordo com o script `banco.sql` (tabelas de botânicos, plantas, regiões e avaliações de toxicidade).  
   - NetBeans (ou outra IDE Java) para facilitar a execução da aplicação Swing.

2. **Configuração do projeto**  
   - Importe o projeto na IDE (por exemplo, NetBeans).  
   - Configure a conexão com o banco de dados na classe de persistência `BD` (URL, usuário, senha etc.).  

3. **Execução**  
   - Execute a classe `App`, que inicializa a interface gráfica principal (`JanelaSistema`).  
   - Use o menu superior para acessar:
     - **Planta → Cadastrar**: cadastro de plantas.  
     - **Botânico → Cadastrar**: cadastro de botânicos.  
     - **Região → Cadastrar**: cadastro de regiões.  
     - **Avaliação → Cadastrar**: cadastro de avaliações de toxicidade.  
     - **Avaliação → Pesquisar**: pesquisa de avaliações de toxicidade.  

4. **Finalização**  
   - Ao fechar a janela principal, a conexão com o banco é encerrada e o sistema é finalizado.

## 💻 Interface gráfica

- Interface gráfica construída com **Java Swing**, utilizando o editor visual do **NetBeans** para criação das janelas, menus, painéis e formulários.  
- A janela principal (`JanelaSistema`) é um `JFrame` com barra de menu para acessar as operações de cadastro e pesquisa.

## 🛠️ Tecnologias utilizadas

- **Java 8+**  
- **Java Swing**  
- **NetBeans IDE**  
- **JDBC**  
- **Banco de dados relacional** (estrutura definida em `banco.sql`)

## ✨ Autoria

Desenvolvido por **Izabella Miranda Silva**  
📅 Entrega 4 — Linguagem e Programação II  
📍 Dourados – 25/11/2025
