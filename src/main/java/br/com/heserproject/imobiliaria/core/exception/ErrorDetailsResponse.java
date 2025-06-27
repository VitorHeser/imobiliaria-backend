package br.com.heserproject.imobiliaria.core.exception;

import br.com.heserproject.imobiliaria.core.domain.domain.Message;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe responsável por prover bean que detalha as propriedades de
 * errors/exceptions.
 *
 * @author Vitor Heser Rosa
 * @since Nov 26, 2019
 */
@Data
public class ErrorDetailsResponse {

    private Date timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private List<Message> messages = new ArrayList<>();

    public ErrorDetailsResponse(String error, String message, String path, int status) {
        this.timestamp = new Date();
        this.error = error;
        this.message = message;
        this.path = path;
        this.status = status;
    }

    public ErrorDetailsResponse(String error, String message, String path, int status, List<Message> messages) {
        this(error, message, path, status);
        this.messages = messages;
    }
}
