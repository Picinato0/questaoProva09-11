package com.avaliacao.questaoProva.controllers;

import com.avaliacao.questaoProva.models.ContatosModel;
import com.avaliacao.questaoProva.services.ContatosService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/contatos")
public class ContatosController {

    @Autowired
    private ContatosService service;

    @GetMapping
    public ResponseEntity<List<ContatosModel>> index(){
        List<ContatosModel> list = service.index();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ContatosModel> show(@PathVariable Long id) {
        return ResponseEntity.ok(service.show(id));
    }

    @PostMapping
    public ResponseEntity<ContatosModel> create(@RequestBody ContatosModel entity) {
        try {
            ContatosModel obj = service.create(entity);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).body(obj);
        } catch (ServiceException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ContatosModel> update(@PathVariable Long id, @RequestBody ContatosModel update){
        return ResponseEntity.ok(service.update(id, update));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("Contato" + id + " deletado!");
    }

}