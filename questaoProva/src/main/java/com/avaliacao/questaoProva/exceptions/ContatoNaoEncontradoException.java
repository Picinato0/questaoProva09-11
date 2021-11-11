package com.avaliacao.questaoProva.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContatoNaoEncontradoException extends ServiceException {

    public ContatoNaoEncontradoException(String message) {
        super(message);
    }
}