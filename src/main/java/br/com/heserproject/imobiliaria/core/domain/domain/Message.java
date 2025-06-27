package br.com.heserproject.imobiliaria.core.domain.domain;

import br.com.heserproject.imobiliaria.core.domain.enums.MessageTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Classe que mapeia a a mensagem que retorna via response.
 *
 * @author Vitor Heser Rosa
 * @since Nov 22, 2019
 */
@Data
@NoArgsConstructor
public class Message implements Serializable {

    private static final long serialVersionUID = 6644501686436801533L;

    private String key;
    private String description;
    private MessageTypeEnum type;
    private String[] params;

    public Message(String key, String description, MessageTypeEnum type, String... params) {
        this.key = key;
        this.description = description;
        this.type = type;
        this.params = params;
    }

    public Message(String description) {
        this.description = description;
    }

}
