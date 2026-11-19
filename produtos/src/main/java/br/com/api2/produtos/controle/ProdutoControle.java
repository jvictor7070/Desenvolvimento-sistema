package br.com.api2.produtos.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api2.produtos.modelo.ProdutoModelo;
import br.com.api2.produtos.modelo.RespostaModelo;
import br.com.api2.produtos.modelo.UserModelo;
import br.com.api2.produtos.servicos.LoginServico;
import br.com.api2.produtos.servicos.ProdutoServico;

@RestController
public class ProdutoControle {

    private final ProdutoServico produtoServico;
    private final LoginServico loginServico;

    public ProdutoControle(LoginServico loginServico, ProdutoServico produtoServico) {
        this.produtoServico = produtoServico;
        this.loginServico = loginServico;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo produto) {
        return produtoServico.cadastrarAlterar(produto, "cadastrar");
    }
    
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo produto) {
        return produtoServico.cadastrarAlterar(produto, "alterar");
    }

    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar() {
        return produtoServico.listar();
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable("codigo") long codigo) {
        return produtoServico.remover(codigo);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserModelo usuario) {
        return loginServico.login(usuario);
    }

    @GetMapping("")
    public String rota() {
        return "api de produtos funcionando!";
    }
}