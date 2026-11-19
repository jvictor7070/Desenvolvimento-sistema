package br.com.api2.produtos.servicos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service; // <-- Importação necessária

import br.com.api2.produtos.modelo.ProdutoModelo;
import br.com.api2.produtos.modelo.RespostaModelo;
import br.com.api2.produtos.repositorio.ProdutoRepositorio;

@Service // <-- Esta é a anotação que resolve o seu erro principal!
public class ProdutoServico {
    
    private final ProdutoRepositorio repositorio;
    
    public ProdutoServico(ProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Iterable<ProdutoModelo> listar() {
        return repositorio.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo produto, String acao) {
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            return ResponseEntity.badRequest().body(criarResposta("O nome do produto é obrigatório."));
        }
        if (produto.getMarca() == null || produto.getMarca().isBlank()) {
            return ResponseEntity.badRequest().body(criarResposta("A marca do produto é obrigatória."));
        }
        ProdutoModelo produtoSalvo = repositorio.save(produto);
        
        if ("cadastrar".equals(acao)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
        } else {
            return ResponseEntity.ok(produtoSalvo);
        }
    }

    public ResponseEntity<RespostaModelo> remover(long codigo) {
        repositorio.deleteById(codigo);
        return ResponseEntity.ok(criarResposta("Produto removido com sucesso."));
    }

    private RespostaModelo criarResposta(String mensagem) {
        RespostaModelo resposta = new RespostaModelo();
        resposta.setMensagem(mensagem);
        return resposta;
    }
}