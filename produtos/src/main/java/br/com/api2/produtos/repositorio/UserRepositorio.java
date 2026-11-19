package br.com.api2.produtos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api2.produtos.modelo.UserModelo;

public interface UserRepositorio extends JpaRepository<UserModelo, Long>{
    
    UserModelo findByUsuario (String usuario);
}
