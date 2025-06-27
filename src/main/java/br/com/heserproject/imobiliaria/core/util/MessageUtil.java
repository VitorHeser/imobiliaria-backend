package br.com.heserproject.imobiliaria.core.util;

import br.com.heserproject.imobiliaria.core.domain.domain.Message;
import br.com.heserproject.imobiliaria.core.domain.enums.MessageTypeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Locale;

/**
 * Classe utilitária responsável por prover métodos para manipulação de
 * mensagens dos arquivos message.properties.
 *
 * @author Vitor Heser Rosa
 * @since Nov 22, 2019
 */
@Component
public class MessageUtil implements Serializable {

    private static final long serialVersionUID = -2568130385093338292L;

    private static final Locale LOCALE_PT_BR = new Locale("pt", "BR");

    private MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    @Value("#{messageSource}")
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Converte a descrição de uma {@link Message} de acordo com as chaves constantes no {@link MessageSource}.
     * As mensagens devem estar presentes no arquivo message.properties.
     *
     * @param message {@link Message}.
     */
    public void convertMessage(Message message) {
        String messageText = null;
        try {
            messageText = messageSource.getMessage(message.getKey(), message.getParams(), LOCALE_PT_BR);
        } catch (NoSuchMessageException e) {
            messageText = (ObjectUtil.isNotEmpty(message.getDescription())) ? message.getDescription() : message.getKey();
        } finally {
            message.setDescription(messageText);
        }
    }

    /**
     * Recupera a descrição da {@link Message} de acordo com o que está descrito no message.properties.
     * A chave da mensagem deve ser a mesma do message.properties.
     *
     * @param key    - {@link String} chave da mensagem.
     * @param params - {@link String}[] parâmetros a serem substituídos.
     * @return {@link String}
     */
    public String getDescriptionMessage(String key, String... params) {
        String messageText;
        try {
            messageText = messageSource.getMessage(key, params, LOCALE_PT_BR);
        } catch (NoSuchMessageException e) {
            messageText = key;
        }
        return messageText;
    }

    /**
     * Cria um objeto {@link Message} de acordo com os parâmetros informados.
     *
     * @param key         - {@link String} chave da mensagem.
     * @param description - {@link String} descrição da mensagem.
     * @param type        - {@link MessageTypeEnum} tipo da mensagem.
     * @param params      - {@link String}[] parâmetros da mensagem.
     * @return {@link Message}
     */
    public static Message createMessage(String key, String description, MessageTypeEnum type, String... params) {
        return new Message(key, description, type, params);
    }

    /**
     * Cria um objeto {@link Message} do tipo SUCCESS.
     *
     * @param key         - {@link String} chave da mensagem.
     * @param description - {@link String} descrição da mensagem.
     * @param params      - {@link String}[] parâmetros da mensagem.
     * @return {@link Message}
     */
    public static Message createSuccessMessage(String key, String description, String... params) {
        return createMessage(key, description, MessageTypeEnum.SUCCESS, params);
    }

    /**
     * Cria um objeto {@link Message} do tipo ERROR.
     *
     * @param key         - {@link String} chave da mensagem.
     * @param description - {@link String} descrição da mensagem.
     * @param params      - {@link String}[] parâmetros da mensagem.
     * @return {@link Message}
     */
    public static Message createErrorMessage(String key, String description, String... params) {
        return createMessage(key, description, MessageTypeEnum.ERROR, params);
    }

    /**
     * Cria um objeto {@link Message} do tipo WARNING.
     *
     * @param key         - {@link String} chave da mensagem.
     * @param description - {@link String} descrição da mensagem.
     * @param params      - {@link String}[] parâmetros da mensagem.
     * @return {@link Message}
     */
    public static Message createWarnMessage(String key, String description, String... params) {
        return createMessage(key, description, MessageTypeEnum.WARNING, params);
    }

    /**
     * Cria um objeto {@link Message} do tipo INFO.
     *
     * @param key         - {@link String} chave da mensagem.
     * @param description - {@link String} descrição da mensagem.
     * @param params      - {@link String}[] parâmetros da mensagem.
     * @return {@link Message}
     */
    public static Message createInfoMessage(String key, String description, String... params) {
        return createMessage(key, description, MessageTypeEnum.INFO, params);
    }

}
