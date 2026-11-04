# Projeto Cadastro de Eletrodomésticos com JOptionPane

Projeto desenvolvido em **Java** com **Swing (JOptionPane)**, **MySQL** e **Maven**, seguindo o padrão **MVC + DAO**.

## Estrutura do Projeto

- **com.example.Eletrodomestico**: Classe de modelo (atributos, getters/setters e construtores).
- **com.example.ConexoMySQL**: Classe para gerenciamento de conexão JDBC com o MySQL.
- **com.example.EletrodomesticoDAO**: Responsável por todas as consultas e comandos SQL (CRUD).
- **com.example.EletrodomesticoControle**: Intermedia a View e o DAO.
- **com.example.EletrodomesticoView**: Interface com JOptionPane, controle de fluxo e validações.
- **com.example.EletroDomesticos**: Classe principal que executa o sistema.

---

## Passo a Passo para Configuração

### 1. Configurar o Banco de Dados MySQL
1. Abra seu gerenciador MySQL (MySQL Workbench, phpMyAdmin, DBeaver ou Terminal).
2. Execute o arquivo de script `loja.sql` que está na raiz deste projeto.
3. Altere as credenciais de acesso no arquivo `ConexoMySQL.java`:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/loja";
   private static final String USUARIO = "root"; // coloque seu usuário do MySQL
   private static final String SENHA = "sua_senha_aqui"; // coloque sua senha do MySQL
   ```

### 2. Executar no VS Code
1. Certifique-se de ter as extensões instaladas no VS Code:
   - **Extension Pack for Java** (Microsoft)
2. Abra esta pasta (`Eletrodomesticos_Java`) no VS Code.
3. Abra o arquivo `EletroDomesticos.java` (`src/main/java/com/example/EletroDomesticos.java`).
4. Clique na opção **Run** ou aperte `F5` para iniciar.

---

## Funcionalidades Atendidas
- [x] Menu principal com JOptionPane (1 a 5).
- [x] Cadastro com validação de campos vazios e preço positivo com ponto decimal.
- [x] Listagem com quebra de linhas e aviso caso vazio.
- [x] Alteração mantendo ID com valores padrão pré-preenchidos.
- [x] Remoção com confirmação via `JOptionPane.showConfirmDialog`.
- [x] Tratamento de exceções SQL e erros de digitação sem crash da aplicação.
- [x] Organização em padrão MVC + DAO.