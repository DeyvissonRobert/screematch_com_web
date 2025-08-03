package br.com.alura.screematch_spring.repository;

import br.com.alura.screematch_spring.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRespository extends JpaRepository<Serie, Long> {
}
