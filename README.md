# Routine Quest - Sistema de Gamificação de Hábitos (TCC)

O **Routine Quest** é um ecossistema de produtividade que transforma tarefas diárias em uma jornada de RPG. O projeto utiliza dados de atividades físicas e rotinas de estudo para evoluir os atributos de um personagem digital, incentivando o desenvolvimento pessoal através da gamificação.

Este repositório contém o **Backend (API)** do projeto, desenvolvido para a disciplina de Trabalho de Conclusão de Curso (TCC) na **UNIPAC Barbacena**.

## Funcionalidades Implementadas

### 1. Sistema de Autenticação e Segurança
- **Cadastro de Usuários:** Persistência de dados utilizando PostgreSQL.
- **Segurança:** Senhas criptografadas com o algoritmo **BCrypt**.
- **Autenticação JWT (JSON Web Token):** Geração de tokens de acesso para comunicação segura com o aplicativo móvel.

### 2. CRUD de Tarefas (Quests)
- **Criação de Missões:** Definição de nome, descrição, recompensa de XP e atributos alvo (Strength, Agility, Intelligence, Resistance).
- **Gerenciamento de Status:** Controle de estados via Enum (`PENDING`, `COMPLETED`, `FAILED`).
- **Persistência Completa:** Operações de Listagem, Edição e Exclusão integradas ao banco de dados.

### 3. Core de Gamificação
- Estrutura base para evolução de níveis e pontos de experiência.
- Atributos vinculados ao perfil do usuário.

## Tecnologias Utilizadas

- **Linguagem:** Java 17
- **Framework:** Spring Boot 3
- **Banco de Dados:** PostgreSQL
- **Segurança:** Spring Security + JWT (JJWT)
- **Persistência:** Spring Data JPA (Hibernate)
- **Gerenciador de Dependências:** Maven

## Estrutura do Projeto

- `src/main/java/Api`: Contém os Controllers (Endpoints da API).
- `src/main/java/Model`: Entidades do banco de dados e lógica de negócio.
- `src/main/java/Data`: Interfaces de repositório (JPA).
- `src/main/java/Utils`: Utilitários (Gerador de Tokens, filtros).
- `src/main/java/Config`: Configurações de segurança e beans.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/LucasCimino-prog/RoutineQuest.git
   
2. coloque a pasta "src" como source

3. coloque a pasta "resources" como resource

4. modifique o "application.properties" para seus dados do postgres, caso for necessário usar outra porta coloque "server.port=8081".

5. Execute "RoutineQuestApplication"

6. caso queira execute o test.http