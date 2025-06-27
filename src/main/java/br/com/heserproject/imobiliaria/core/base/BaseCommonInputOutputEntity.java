package br.com.heserproject.imobiliaria.core.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * Classe básica (abstrata) para entidades para Input e Output.
 *
 * @author Vitor Heser Rosa
 * @since 20 de mai de 2021
 */
public interface BaseCommonInputOutputEntity extends Serializable {

    /**
     * Retorna o {@link Type} para conversão de objetos (deep copy). Exemplo:<br/>
     * <p>
     * return new TypeToken<Entidade>() {}.getType();
     * </p>
     *
     * @return {@link Type}
     */
    @JsonIgnore
    Type getType();

}
