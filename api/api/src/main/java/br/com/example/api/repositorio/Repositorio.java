package br.com.example.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.example.api.modelo.Pessoa;

public interface Repositorio extends JpaRepository<Pessoa, Integer> {
}