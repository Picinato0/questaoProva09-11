package com.avaliacao.questaoProva.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ContatoExistenteException extends ServiceException {
    public ContatoExistenteException(String message) {
        super(message);
    }
}