package br.com.heserproject.imobiliaria.core.exception;


import br.com.heserproject.imobiliaria.core.base.BaseException;
import br.com.heserproject.imobiliaria.core.domain.enums.MessageTypeEnum;

public class BadRequestException extends BaseException {
    private static final long serialVersionUID = 3647825452199326506L;

    public BadRequestException(String key, String message, String... params) {
        super(key, message, MessageTypeEnum.ERROR, params);
    }

    public String toString() {
        return "BadRequestException [messages=" + this.getMessages() + "]";
    }
}
