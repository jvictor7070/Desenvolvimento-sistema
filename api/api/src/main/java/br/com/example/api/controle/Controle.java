package br.com.example.api.controle;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.api.modelo.Pessoa;
import br.com.example.api.repositorio.Repositorio;

@RestController
public class Controle {

    private final Repositorio acao;

    public Controle(Repositorio acao){
        this.acao = acao;
    }

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }

    @GetMapping("/api")
    public List<Pessoa> selecionar(){
        return acao.findAll();
    }

    @GetMapping("/api/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable Integer codigo){
        return acao.findById(codigo).orElse(null);
}
    @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa obj){
        return acao.save(obj);
}   
    @DeleteMapping ("/api/{codigo}")
    public void remover(@PathVariable Integer codigo){
        Pessoa obj = selecionarPeloCodigo(codigo);
        acao.delete(obj);
    }



// -------------------------------------------------------------------------------------------------------
    // injeção de dependencia
    @GetMapping("")
    public String mensagem(){
    return "ola mundo";}
    

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Seja Bem-vindo";
    }

    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome){
        return "Seja Bem-vindo! "+nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }



}