package com.avaliacao.questaoProva.repositories;

import com.avaliacao.questaoProva.models.ContatosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContatosRepository extends JpaRepository<ContatosModel, Long> {
    Optional<ContatosModel> findByEmail(String email);
    Optional<ContatosModel> findByTelefone(String telefone);
}