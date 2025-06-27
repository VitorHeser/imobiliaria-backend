package br.com.heserproject.imobiliaria.core.base;

import br.com.heserproject.imobiliaria.core.domain.domain.Message;
import br.com.heserproject.imobiliaria.core.domain.enums.MessageCommonEnum;
import br.com.heserproject.imobiliaria.core.domain.enums.MessageTypeEnum;
import br.com.heserproject.imobiliaria.core.util.ObjectUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável por prover exceção base. <br/>
 * Herda de {@link RuntimeException}.
 *
 * @author Vitor Heser Rosa
 * @since Jan 16, 2020
 */
@Slf4j
@NoArgsConstructor
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -5306343134799128915L;

    @Getter
    @Setter
    private List<Message> messages = new ArrayList<>();

    /**
     * Construtor que recebe uma lista de mensagens.
     *
     * @param messages - {@link ArrayList} de {@link Message}.
     */
    public BaseException(List<Message> messages) {
        setMessages(new ArrayList<>(messages));
    }

    /**
     * Construtor que recebe uma série de parâmetros para a exceção.
     *
     * @param key     - {@link String} chave da mensagem (a ser inserida no como mensagem no message.properties)
     * @param message - {@link String} descrição da mensagem.
     * @param type    - {@link MessageTypeEnum} tipo da mensagem.
     * @param params  - {@link String}[] parâmetros a serem substituídos.
     */
    public BaseException(String key, String message, MessageTypeEnum type, String... params) {
        append(key, message, type, params);
    }

    /**
     * Construtor que recebe uma série de parâmetros para a exceção.<br/>
     * O tipo da mensagem é definido como WARNING por padrão.
     *
     * @param key     - {@link String} chave da mensagem (a ser inserida no como mensagem no message.properties)
     * @param message - {@link String} descrição da mensagem.
     * @param params  - {@link String}[] parâmetros a serem substituídos.
     */
    public BaseException(String key, String message, String... params) {
        append(key, message, MessageTypeEnum.WARNING, params);
    }

    /**
     * Lança exceção caso a mensagem esteja preenchida e a condição
     * seja atendida.
     *
     * @param message   - {@link Message} mensagem
     * @param condition - condição a ser satisfeita
     */
    public static <T extends BaseException> void throwIfCondition(Message message, boolean condition, Class<T> clazz) {
        if (condition && message != null) {
            throwIfHasMessages(List.of(message), clazz);
        }
    }

    /**
     * Lança exceção caso a lista de mensagens esteja preenchida e a condição
     * seja atendida.
     *
     * @param messages  - {@link List} de {@link Message}
     * @param condition - condição a ser satisfeita
     */
    public static <T extends BaseException> void throwIfCondition(List<Message> messages, boolean condition, Class<T> clazz) {
        if (condition) {
            throwIfHasMessages(messages, clazz);
        }
    }

    /**
     * Lança exceção caso a mensagem esteja preenchida e a condição
     * seja atendida.
     *
     * @param message   - {@link Message} mensagem
     * @param condition - condição a ser satisfeita
     */
    public static void throwIfCondition(Message message, boolean condition) {
        throwIfCondition(message, condition, BaseException.class);
    }

    /**
     * Lança exceção caso a lista de mensagens esteja preenchida e a condição
     * seja atendida.
     *
     * @param messages  - {@link List} de {@link Message}
     * @param condition - condição a ser satisfeita
     */
    public static void throwIfCondition(List<Message> messages, boolean condition) {
        throwIfCondition(messages, condition, BaseException.class);
    }

    /**
     * Lança uma exceção caso existam mensagens na lista da instância.
     *
     * @param messages - {@link List} de {@link Message}.
     */
    public static void throwIfHasMessages(List<Message> messages) {
        throwIfHasMessages(messages, BaseException.class);
    }

    /**
     * Lança uma exceção caso existam mensagens na lista passada como parâmetro.
     *
     * @param <T>      - Tipo da exceção
     * @param messages {@link List} - lista de mensagens
     * @param clazz    {@link Class} - class da exceção.
     */
    public static <T extends BaseException> void throwIfHasMessages(List<Message> messages, Class<T> clazz) {

        if (ObjectUtil.isNotEmpty(messages)) {
            try {
                T exception = clazz.getConstructor().newInstance();
                exception.setMessages(messages);
                throw exception;
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                log.error("BaseException: erro ao criar exceção para o tipo: " + clazz.getName());
                throw new BaseException(messages);
            }
        }

    }

    /**
     * Adiciona uma mensagem <b>não tipada (common)</b> e o seu tipo a lista
     * existente na instância.
     *
     * @param message {@link Message} - mensagem comum a ser adicionada.
     * @param type    {@link MessageTypeEnum} - tipo da mensagem.
     * @param params  {@link String}... - parâmetros.
     */
    public void append(MessageCommonEnum message, MessageTypeEnum type, String... params) {
        append(message.getMessage(), null, type, params);
    }

    /**
     * Adiciona uma mensagem através da chave mapeada nos properties a lista
     * existente na instância.
     *
     * @param key     {@link String} - chave mapeada nos arquivos
     *                messages.properties.
     * @param message {@link String} - descrição da mensagem a ser logada.
     * @param params  {@link String}... - parâmetros.
     */
    public void append(String key, String message, String... params) {
        append(key, message, MessageTypeEnum.WARNING, params);
    }

    /**
     * Adiciona uma mensagem comum a lista existente na instância.
     *
     * @param message {@link Message} - mensagem comum a ser adicionada.
     * @param params  {@link String}... - parâmetros.
     */
    public void append(MessageCommonEnum message, String... params) {
        append(message.getMessage(), null, MessageTypeEnum.WARNING, params);
    }

    /**
     * Adiciona uma mensagem <b>tipada</b> através da chave mapeada nos properties a
     * lista existênte na instância.
     *
     * @param key     {@link String} - chave mapeada nos arquivos
     *                messages.properties.
     * @param message {@link String} - descrição da mensagem a ser logada.
     * @param type    {@link MessageTypeEnum} - tipo da mensagem.
     * @param params  {@link String}... - parâmetros.
     */
    public void append(String key, String message, MessageTypeEnum type, String... params) {
        getMessages().add(new Message(key, message, type, params));
    }

    /**
     * Verifica se existem mensagens na lista da instância.
     *
     * @return boolean
     */
    public boolean areNoMessages() {
        return getMessages().isEmpty();
    }

    /**
     * Verifica se existem mensagens na lista da instância, caso existam mensagens
     * lança this como exceção.
     *
     * @return boolean.
     */
    public boolean check() {
        if (areNoMessages()) {
            return true;
        } else {
            throw this;
        }
    }

    @Override
    public String getMessage() {
        return getMessages().stream().map(Message::toString).collect(Collectors.joining(" # "));
    }

    @Override
    public String toString() {
        return "BaseException [messages=" + messages + "]";
    }

}
