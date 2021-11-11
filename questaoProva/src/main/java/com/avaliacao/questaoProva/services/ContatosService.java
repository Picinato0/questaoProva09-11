package com.avaliacao.questaoProva.services;

import com.avaliacao.questaoProva.exceptions.ContatoExistenteException;
import com.avaliacao.questaoProva.exceptions.ContatoNaoEncontradoException;
import com.avaliacao.questaoProva.models.ContatosModel;
import com.avaliacao.questaoProva.repositories.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatosService {

    @Autowired
    private ContatosRepository repository;

    public List<ContatosModel> index() {
        List<ContatosModel> result = repository.findAll();
        return result.stream().map(x -> new ContatosModel(x)).collect(Collectors.toList());
    }

    public ContatosModel show(Long id) {
        Optional<ContatosModel> result = repository.findById(id);
        return result.orElseThrow(() -> new ContatoNaoEncontradoException("Contact not found. Please try again."));
    }

    public ContatosModel create(ContatosModel contatos){

        Optional<ContatosModel> emailContato = repository.findByEmail(contatos.getEmail());
        if(emailContato.isPresent()){
            throw new ContatoExistenteException("Este contato ja existe, tente cadastrar outro");
        }

        Optional<ContatosModel> telefoneContato = repository.findByTelefone(contatos.getTelefone());
        if(telefoneContato.isPresent()){
            throw new ContatoExistenteException("Este contato ja existe, tente cadastrar outro");
        }

        ContatosModel unit = new ContatosModel();
        unit.setNome(contatos.getNome());
        unit.setTelefone(contatos.getTelefone());
        unit.setEmail(contatos.getEmail());
        unit = repository.save(unit);

        return unit;
    }

    public ContatosModel update(Long id, ContatosModel update){
        ContatosModel updated = show(id);

        Optional<ContatosModel> emailContatos = repository.findByEmail(update.getEmail());
        if(emailContatos.isPresent()){
            throw new ContatoExistenteException("Este contato ja existe, tente outro email");
        }

        Optional<ContatosModel> telefoneContatos = repository.findByTelefone(update.getTelefone());
        if(telefoneContatos.isPresent()){
            throw new ContatoExistenteException("Este contato ja existe, tente outro telefone");
        }

        updated.setNome(updated.getNome());
        updated.setEmail(update.getEmail());
        updated.setTelefone(updated.getTelefone());

        repository.save(updated);

        return updated;
    }

    public void delete(Long id){
        repository.delete(show(id));
    }

}