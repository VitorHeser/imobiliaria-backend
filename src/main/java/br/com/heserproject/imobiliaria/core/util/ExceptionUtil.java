package br.com.heserproject.imobiliaria.core.util;


import br.com.heserproject.imobiliaria.core.domain.domain.Message;
import br.com.heserproject.imobiliaria.core.domain.enums.MessageTypeEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitária que manipula as exceções juntamente com mensagens.
 *
 * @author Vitor Heser Rosa
 * @since Nov 22, 2019
 */
public class ExceptionUtil implements Serializable {

    private static final long serialVersionUID = -3801115916092780160L;

    private ExceptionUtil() {
        throw new IllegalStateException("Classe Utilitária. Não pode ser instanciada.");
    }

    /**
     * Converte ium conjunto de mensagens (String) em uma {@link List} de
     * {@link Message}.
     *
     * @param messages - {@link String}[] de mensagens.
     * @return {@link List}
     */
    public static List<Message> toListMessage(String... messages) {
        List<Message> list = new ArrayList<>();
        for (String message : messages) {
            list.add((new Message(message)));
        }
        return list;
    }

    /**
     * Converte um conjunto de {@link Exception} em uma {@link List} de
     * {@link Message} com o {@link MessageTypeEnum} = ERROR.
     *
     * @param exceptions - {@link Exception}[] exceções.
     * @return {@link List}
     */
    public static List<Message> toListMessage(Exception... exceptions) {
        return toListMessage(MessageTypeEnum.ERROR, exceptions);
    }

    /**
     * Converte um conjunto de {@link Exception} em uma {@link List} de
     * {@link Message} de acordo com o {@link MessageTypeEnum}.
     *
     * @param type       - {@link MessageTypeEnum} tipo da mensagem.
     * @param exceptions - {@link Exception}[] exceções.
     * @return {@link List}
     */
    public static List<Message> toListMessage(MessageTypeEnum type, Exception... exceptions) {
        List<Message> list = new ArrayList<>();
        for (Exception e : exceptions) {
            list.add(new Message("error.internal", e.getMessage(), type));
        }
        return list;
    }

}
