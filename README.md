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

O **FórumHub** não é apenas uma API. É um terminal de dados seguro para uma nova geração de fóruns, construção sobre o chassi robusto do Spring Boot. Neste sistema, os Netrunners autorizaram poder se conectar, postar suas descobertas (Tópicos), debateram com outros operativos e gerenciar seus fluxos de dados.

Todas como interações são protegidas por autenticação JWT, garantindo que como pessoas pessoais autorizadas tenham acesso ou modificar informações sensíveis na série.

## Recompensas Coletadas (Funcionalidades)

-   `[x]` **Porta de Acesso Segura:** Autenticação baseada em JWT (Autorização baseada em JWT)`/login`).
-   `[x]` **Criação de Fluxo de Dados:** Publicar novos tópicos (`POSTAGEM /tópicos`).
-   `[x]` **Recuperação de Dados de Espectro Total:** Listar todos os ópicos ativos e visualizadores ópicos específicos (`OBTER/tópicos`, `OBTER/tópicos/{id}`).
-   `[x]` **Modificação de Fluxo:** Atualizar tópicos existentes (`COLOCAR /tópicos/{id}`).
-   `[x]` **Purga de Dados:** Excluir tópicos da grade (`EXCLUIR /tópicos/{id}`).
-   `[x]` **Validação de Entrada:** Validação do lado do servidor para manter a integral dos dados.
-   `[x]` **Integração com Banco de Dados:** Persistência transparente com Spring Data JPA.

## Chromes Principais (Tecnologias Utilizadas)

*   **Diretor da Estrutura:** `Java 17` & `Bota de mola 3`
*   **Módulo de Segurança:** `Segurança Primavera` & `JWT`
*   **Camada de Persistência:** `Spring Data JPA` & `Hibernar`
*   **Banco de Dados:** `MySQL` / `PostgreSQL` (configurável)
*   **Sistema de Construção:** `Maven`
*   **Aprimoramentos de Código:** `Lombok`

## Protocolos de Acesso (Endpoints da API)

### Autenticação

`POSTAR/login`

**Corpo da Requisição (Credenciais):**
`json
{
 "login": "seu_usuario",
 "senha": "sua_senha"
}
`
**Resposta de Sucesso (Token de Acesso):**
`json
{
 "token": "seu.token.jwt",
 "tipo": "Portador"
}
`

---

### Tópicos

*Todos os endpoints de `/tópicos` exigem um `Token Portador` no cabeçalho `Autorização`.*

| Verbo | Ponto final | Descrição |
| | |:----- | :---------- | :-----------------------------
| `OBTER`  | `/tópicos` | Recupera uma lista de todos os ópicos. |
| `OBTER`  | `/tópicos/{id}` | Recupera um tópico específico pelo ID. |
| `PÓS-AR` | `/tópicos` | Cria um novo tópico. |
| `COLOCAR`  | `/tópicos/{id}` | Atualiza um tópico existente. |
| `APÁGARO`| `/tópicos/{id}`| Exclui um tópico. |


## Conectando-se (Instalação)

1.  **Clone o Repositório:**
    `bash
 clone Git https://github.com/seu-usuario/forumhubalura.git
 cd forumhubalura
    `

2.  **Configurar uma Fonte de Dados:**
 Abra `src/main/recursos/aplicação.propriedades` e configurar sua conexão com o banco de dados.
 `propriedades
    # Exemplo para MySQL
 spring.datasource.url=jdbc:mysql://localhost:3306/forumhub_db
 spring.datasource.username=seu_usuario_db
 spring.datasource.password=sua_senha_db
 spring.jpa.hibernate.ddl-auto=atualização
    `

3.  **Compilar e Executar o Sistema:**
 Use o wrapper do Maven para iniciar o servidor.
    `bash
 . ./mvnw spring-boot:run
    `

4.  **Acesse o Terminal:**
 Uma API está ativa em `http://localhost:8080`. Use um cliente como Insomnia ou Postman para interagir com os endpoints.

---

 // Codificado nas sombras por Samuel Redstar
