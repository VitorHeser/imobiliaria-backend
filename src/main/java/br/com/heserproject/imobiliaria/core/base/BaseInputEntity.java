package br.com.heserproject.imobiliaria.core.base;

import br.com.heserproject.imobiliaria.core.factory.DomainIOFactory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Classe responsável por prover abstração para entidades de input.
 *
 * @author Vitor Heser Rosa
 * @since 20 de mai de 2021
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonInclude
public abstract class BaseInputEntity<T> implements BaseCommonInputOutputEntity {

    private static final long serialVersionUID = -6150143320493842896L;

    /**
     * Retorna o class do tipo alvo da conversão (um POJO, uma entidade, etc)
     *
     * @return Class
     */
    @JsonIgnore
    public abstract Class<T> getTargetType();

    /**
     * Retorna o objeto com o tipo alvo já convertido.
     *
     * @return T
     */
    @JsonIgnore
    public final T getTargetObject() {
        return DomainIOFactory.create(this, getTargetType());
    }
}
