package dao;
import java.util.ArrayList;

import model.Usuario;

public class UsuarioDao {
    private ArrayList<Usuario>usuarios = new ArrayList<>();

    public void cadastrar(Usuario usuario){
        usuarios.add(usuario);
    }

    public ArrayList<Usuario>listar(){
        return usuarios;
    }

    public Usuario buscar(String nomeUsuario ){
        for(Usuario usuario:usuarios){
            if(usuario.getUsuario().equalsIgnoreCase(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean alterar(String usuario, String senha){
        Usuario UsuarioEncontrado=buscar(usuario);

        if(usuarios != null){
            UsuarioEncontrado.setUsuario(usuario);
            UsuarioEncontrado.setSenha(senha);
            return true;
        }
        return false;
    }

    public boolean remover(String removerUsuario){
        Usuario usuario=buscar(removerUsuario);

        if(usuario!=null){
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }

}

    

