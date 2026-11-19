package br.com.api2.produtos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api2.produtos.modelo.ProdutoModelo;

public interface ProdutoRepositorio extends JpaRepository<ProdutoModelo, Long> {
    
}
