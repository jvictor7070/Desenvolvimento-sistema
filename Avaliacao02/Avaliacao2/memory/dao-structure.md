---
name: dao-structure
description: Estrutura do DAO para avaliacao02 - FuncionarioDao
metadata:
  type: reference
---

## Estrutura do FuncionarioDao

### Padrão seguido
Baseado no `ProdutoDAO` da aula, adaptado para o modelo com herança (`Funcionario`, `Gerente`, `Operador`) e coluna `tipo` no banco de dados.

### Principais características:

1. **Conexão**
   - Método auxiliar `getConexao()` que instancia `new Conexao().conectar()`
   - `Conexao.conectar()` é método de instância (não static)

2. **Operações CRUD**
   - `cadastrar(Funcionario)` → INSERT com definição do `tipo` (FUNC/GER/OPR via `instanceof`)
   - `listar()` → SELECT que verifica `tipo` para popular `Gerente` (com `departamento`) ou `Operador` (com `funcao`)
   - `buscar(int matricula)` → SELECT por PK com mesma lógica de tipagem
   - `alterar(int, String, int)` → UPDATE dos campos nome e idade
   - `remover(int matricula)` → DELETE pela PK

3. **Banco de dados**
   - Tabela: `funcionarios`
   - Coluna `tipo` diferencia os tipos: "FUNC", "GER", "OPR"
   - Follows Single Table Inheritance pattern

4. **Tratamento de erros**
   - Todos os métodos capturam `SQLException`
   - Mensagens de erro impressas via `System.out.println`
   - Retornos `true/false`, `null` ou `ArrayList` conforme operação

5. **Padrão try-with-resources**
   - Conexão, Statement e ResultSet são auto-fechados
   - Evita vazamento de recursos

### Observações
- Warnings de "Convert to switch" são apenas sugestões de otimização
- As classes `Gerente` e `Operador` precisam ser `public` no pacote `model` para serem acessíveis do `dao`
- O construtor de `Gerente(int, String, int, String)` e `Operador(int, String, int, String)` devem existir