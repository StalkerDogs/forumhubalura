# ForumHub

```
  _____                            _   _       _     
 |  ___|                          | | | |     | |    
 | |__ _ __ ___  _ __   ___  _ __  | |_| |_   _| |__  
 |  __| '__/ _ \| '_ \ / _ \| '_ \ |  _  | | | | '_ \ 
 | |__| | | (_) | | | | (_) | | | || | | | |_| | |_) |
 \____/_|  \___/|_| |_|\___/|_| |_|\_| |_/\__,_|_.__/ 
                                                     
```

> // Um farol na chuva digital. Um nexo para dados renegados e troca de conhecimento clandestino na metrópole encharcada de neon.

---

### `>` Status do Sistema

*   **Status:** `OPERACIONAL`
*   **Versão:** `1.0.0_beta`
*   **Objetivo Atual:** `Aprimorar protocolos de fluxo de dados`

---

## O Terminal (Sobre o Projeto)

O **ForumHub** não é apenas uma API. É um terminal de dados seguro para uma nova geração de fóruns, construído sobre o chassi robusto do Spring Boot. Neste sistema, Netrunners autenticados podem se conectar, postar suas descobertas (Tópicos), debater com outros operativos e gerenciar seus fluxos de dados.

Todas as interações são protegidas por autenticação JWT, garantindo que apenas pessoal autorizado possa acessar ou modificar informações sensíveis na grade.

## Recompensas Coletadas (Funcionalidades)

-   `[x]` **Porta de Acesso Segura:** Autenticação baseada em JWT (`/login`).
-   `[x]` **Criação de Fluxo de Dados:** Publicar novos tópicos (`POST /topicos`).
-   `[x]` **Recuperação de Dados de Espectro Total:** Listar todos os tópicos ativos e visualizar tópicos específicos (`GET /topicos`, `GET /topicos/{id}`).
-   `[x]` **Modificação de Fluxo:** Atualizar tópicos existentes (`PUT /topicos/{id}`).
-   `[x]` **Purga de Dados:** Excluir tópicos da grade (`DELETE /topicos/{id}`).
-   `[x]` **Validação de Entrada:** Validação do lado do servidor para manter a integridade dos dados.
-   `[x]` **Integração com Banco de Dados:** Persistência transparente com Spring Data JPA.

## Chromes Principais (Tecnologias Utilizadas)

*   **Framework Principal:** `Java 17` & `Spring Boot 3`
*   **Módulo de Segurança:** `Spring Security` & `JWT`
*   **Camada de Persistência:** `Spring Data JPA` & `Hibernate`
*   **Banco de Dados:** `MySQL` / `PostgreSQL` (configurável)
*   **Sistema de Build:** `Maven`
*   **Aprimoramentos de Código:** `Lombok`

## Protocolos de Acesso (Endpoints da API)

### Autenticação

`POST /login`

**Corpo da Requisição (Credenciais):**
```json
{
  "login": "seu_usuario",
  "senha": "sua_senha"
}
```
**Resposta de Sucesso (Token de Acesso):**
```json
{
  "token": "seu.token.jwt",
  "type": "Bearer"
}
```

---

### Tópicos

*Todos os endpoints de `/topicos` exigem um `Bearer Token` no cabeçalho `Authorization`.*

| Verbo  | Endpoint         | Descrição                               |
| :----- | :--------------- | :-------------------------------------- |
| `GET`  | `/topicos`       | Recupera uma lista de todos os tópicos. |
| `GET`  | `/topicos/{id}`  | Recupera um tópico específico pelo ID.  |
| `POST` | `/topicos`       | Cria um novo tópico.                    |
| `PUT`  | `/topicos/{id}`  | Atualiza um tópico existente.           |
| `DELETE`| `/topicos/{id}`| Exclui um tópico.                       |


## Conectando-se (Instalação)

1.  **Clone o Repositório:**
    ```bash
    git clone https://github.com/seu-usuario/forumhubalura.git
    cd forumhubalura
    ```

2.  **Configure a Fonte de Dados:**
    Abra `src/main/resources/application.properties` e configure sua conexão com o banco de dados.
    ```properties
    # Exemplo para MySQL
    spring.datasource.url=jdbc:mysql://localhost:3306/forumhub_db
    spring.datasource.username=seu_usuario_db
    spring.datasource.password=sua_senha_db
    spring.jpa.hibernate.ddl-auto=update
    ```

3.  **Compile e Execute o Sistema:**
    Use o wrapper do Maven para iniciar o servidor.
    ```bash
    ./mvnw spring-boot:run
    ```

4.  **Acesse o Terminal:**
    A API estará ativa em `http://localhost:8080`. Use um cliente como Insomnia ou Postman para interagir com os endpoints.

---

> // Codificado nas sombras por Samuel Redstar
