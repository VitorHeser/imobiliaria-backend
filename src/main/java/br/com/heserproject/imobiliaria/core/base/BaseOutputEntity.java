package br.com.heserproject.imobiliaria.core.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

/**
 * Classe responsável por prover abstração para entidades de output.
 *
 * @author Vitor Heser Rosa
 * @since 20 de mai de 2021
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonInclude
public abstract class BaseOutputEntity extends RepresentationModel<BaseOutputEntity> implements BaseCommonInputOutputEntity {

    private static final long serialVersionUID = 7778644345813013180L;

    @Override
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Links getLinks() {
        return super.getLinks();
    }
}
