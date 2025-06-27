package br.com.heserproject.imobiliaria.core.exception;


import br.com.heserproject.imobiliaria.core.base.BaseException;
import br.com.heserproject.imobiliaria.core.domain.domain.Message;
import br.com.heserproject.imobiliaria.core.domain.enums.MessageCommonEnum;
import br.com.heserproject.imobiliaria.core.domain.enums.MessageTypeEnum;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Classe reponsável por prover exceção de negócio.
 *
 * @author Vitor Heser Rosa
 * @since Nov 22, 2019
 */
@Component
public class BusinessException extends BaseException {

    private static final long serialVersionUID = -9146577437520232269L;

    public BusinessException() {
    }

    public BusinessException(List<Message> messages) {
        super(messages);
    }

    public BusinessException(String key, MessageTypeEnum type, String... params) {
        super(key, null, type, params);
    }

    public BusinessException(String key, String message, MessageTypeEnum type, String... params) {
        super(key, message, type, params);
    }

    public BusinessException(MessageCommonEnum message, MessageTypeEnum type, String... params) {
        super(message.getMessage(), null, type, params);
    }

    public BusinessException(String key, String message, String... params) {
        super(key, message, MessageTypeEnum.WARNING, params);
    }

    public BusinessException(MessageCommonEnum message, String... params) {
        super(message.getMessage(), null, MessageTypeEnum.WARNING, params);
    }

    public static void throwIfHasMessages(List<Message> messages) {
        throwIfHasMessages(messages, BusinessException.class);
    }

    public static void throwIfCondition(Message message, boolean condition) {
        throwIfCondition(message, condition, BusinessException.class);
    }

    public static void throwIfCondition(String message, boolean condition) {
        throwIfCondition(new Message(message), condition, BusinessException.class);
    }

    public static void throwIfCondition(List<Message> messages, boolean condition) {
        throwIfCondition(messages, condition, BusinessException.class);
    }

    @Override
    public String toString() {
        return "BusinessException [messages=" + getMessages() + ", getMessage()=" + getMessage() + "]";
    }

}
