package br.com.api2.produtos.servicos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api2.produtos.modelo.RespostaModelo;
import br.com.api2.produtos.modelo.UserModelo;
import br.com.api2.produtos.repositorio.UserRepositorio;

@Service
public class LoginServico {

    private final UserRepositorio userRepo;

    public LoginServico(UserRepositorio userRepo) {
        this.userRepo = userRepo;
    }

    public ResponseEntity<RespostaModelo> login(UserModelo usuarioReq){
        RespostaModelo resposta = new RespostaModelo();
    
        String usuario=usuarioReq.getUsuario();
        String senha=usuarioReq.getSenha();
        
        if (usuario==null || usuario.isBlank() || senha==null || senha.isBlank()){
            resposta.setMensagem("Informe o usuário e a senha.");
            return ResponseEntity.badRequest().body(resposta);
        }
    
        UserModelo user = userRepo.findByUsuario(usuario);

        if (user==null){
            resposta.setMensagem("Usuário não encontrado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
    }

        if(!senha.equals(user.getSenha())){
            resposta.setMensagem("seenha incorreta.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resposta);
        }
        
    resposta.setMensagem("Login realizado com sucesso.");
        return ResponseEntity.ok(resposta);
}
}
