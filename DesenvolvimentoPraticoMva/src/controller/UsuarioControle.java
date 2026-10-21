package controller;

import dao.UsuarioDao;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioControle {

    private UsuarioDao dao;

    public UsuarioControle(){
        dao = new UsuarioDao();
    }

    public void cadastrar(String usuario, String senha){

        Usuario novoUsuario = new Usuario(usuario,senha);
        dao.cadastrar(novoUsuario);
    }

    public ArrayList<Usuario>listar(){
        return dao.listar();
    }

    public Usuario buscar(String usuario){
        return dao.buscar(usuario);
    }

    public boolean  alterar(String usuario, String senha){
        return dao.alterar(usuario, senha);}


    public boolean remover(String usuario){
        return dao.remover(usuario);
    }
}


