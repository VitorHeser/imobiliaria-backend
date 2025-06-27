package br.com.heserproject.imobiliaria.core.exception;


import br.com.heserproject.imobiliaria.core.domain.domain.Message;
import br.com.heserproject.imobiliaria.core.util.ExceptionUtil;
import br.com.heserproject.imobiliaria.core.util.MessageUtil;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class BaseGlobalExceptionHandler implements Serializable {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(BaseGlobalExceptionHandler.class);
    private static final long serialVersionUID = 8352657131658203239L;
    private MessageUtil messageUtil;

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity businessException(BusinessException ex, WebRequest request) {
        log.error("GlobalExceptionExceptionHandler - BusinessException: ", ex);
        return this.createErrorsResponseEntity("BusinessException", "Regra(s) de negócio violada(s).", ex.getMessages(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({RecordNotFoundException.class})
    public ResponseEntity recordNotFoundException(RecordNotFoundException ex, WebRequest request) {
        log.error("GlobalExceptionExceptionHandler - RecordNotFoundException: ", ex);
        return this.createErrorsResponseEntity("RecordNotFoundException", "Nenhum registro encontrado.", ex.getMessages(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity badRequestException(BadRequestException ex, WebRequest request) {
        log.error("GlobalExceptionExceptionHandler - BadRequestException: ", ex);
        return this.createErrorsResponseEntity("BadRequestException", "A requisição enviada é inválida.", ex.getMessages(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({DataAccessException.class})
    public ResponseEntity dataAccessException(DataAccessException ex, WebRequest request) {
        log.error("GlobalExceptionExceptionHandler - DataAccessException: execução de SQL com erro.", ex);
        return this.createErrorsResponseEntity("DataAccessException", "Falha na execução de instrução na database.", Collections.singletonList(MessageUtil.createErrorMessage(ex.getMessage(), (String) null, new String[0])), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity globalException(Exception ex, WebRequest request) {
        log.error("Exceção: ", ex);
        return this.createErrorsResponseEntity("Exception", "Erro inesperado ao atender a solicitação (erro geral).", ExceptionUtil.toListMessage(new Exception[]{ex}), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    protected ResponseEntity createErrorsResponseEntity(String title, String detail, List<Message> messages, HttpStatus status, WebRequest request) {
        this.convertMessages(messages);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/problem+json");
        ErrorDetailsResponse errorDetailsResponse = new ErrorDetailsResponse(title, detail, request.getDescription(false), status.value());
        return new ResponseEntity(errorDetailsResponse, headers, status);
    }

    protected void convertMessages(List<Message> messages) {
        messages.forEach((m) -> {
            this.messageUtil.convertMessage(m);
        });
    }

    public MessageUtil getMessageUtil() {
        return this.messageUtil;
    }

    @Value("#{messageUtil}")
    public void setMessageUtil(MessageUtil messageUtil) {
        this.messageUtil = messageUtil;
    }
}
