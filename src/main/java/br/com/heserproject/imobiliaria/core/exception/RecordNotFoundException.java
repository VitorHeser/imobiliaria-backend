package br.com.heserproject.imobiliaria.core.exception;


import br.com.heserproject.imobiliaria.core.base.BaseException;
import br.com.heserproject.imobiliaria.core.domain.enums.MessageTypeEnum;

/**
 * Classe responsável por prover exceção para registros não encontrados durante
 * operações de consultas.
 *
 * @author Vitor Heser Rosa
 * @since Jan 23, 2020
 */
public class RecordNotFoundException extends BaseException {

    private static final long serialVersionUID = 8611239787670946825L;

    public RecordNotFoundException(String key, String message, MessageTypeEnum type, String... params) {
        super(key, message, type, params);
    }

    public RecordNotFoundException(String key, String message, String... params) {
        super(key, message, MessageTypeEnum.WARNING, params);
    }

    public static RecordNotFoundException throwMe() {
        return new RecordNotFoundException("error.registro.nao.encontrado", "Nenhum registro encontrado", MessageTypeEnum.WARNING);
    }

    @Override
    public String toString() {
        return "RecordNotFoundException [messages=" + getMessages() + ", getMessage()=" + getMessage() + "]";
    }

}
