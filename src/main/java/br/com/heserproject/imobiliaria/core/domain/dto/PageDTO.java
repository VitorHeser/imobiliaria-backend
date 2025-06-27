package br.com.heserproject.imobiliaria.core.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Classe responsável por encapsular o response para consultas paginadas.
 *
 * @author Vitor Heser Rosa
 * @since Mai 05, 2021
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO<T> {
    private int totalPages;
    private long totalElements;
    private int numberOfElements;
    private List<T> content;
    private Boolean hasContent;

    public Boolean getHasContent() {
        return br.com.heserproject.imobiliaria.core.util.ObjectUtil.isNotEmpty(getContent());
    }
}
