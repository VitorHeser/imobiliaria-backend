package br.com.heserproject.imobiliaria.core.domain.enums;


import lombok.Getter;

/**
 * Enum que mapeia as mensagens comuns e básicas.
 *
 * @author Vitor Heser Rosa
 * @since Nov 22, 2019
 */
public enum MessageCommonEnum {

    // @formatter:off
    ERROR_ACESSO_NEGADO("error.acesso.negado"),
    ERROR_METODO_NAO_IMPLEMENTADO("error.method.not.implemented"),
    ERROR_CAMPO_OBRIGATORIO("error.field.required"),
    ERROR_CAMPO_INVALIDO("error.field.invalid"),
    ERROR_NENHUM_REGISTRO_ENCONTRADO("warning.record.not.found"),
    ERROR_BAD_REQUEST("error.bad.request"),
    ERROR_RECURSO_INDISPONIVEL("error.recurso.indisponivel"),
    ERROR_DATA_ACCESS("error.data.access"),
    ERROR_DATA_ACCESS_INTEGRITY_VIOLATION("error.data.access.integrity.violation"),
    ERROR_DATA_ACCESS_INTEGRITY_VIOLATION_DELETE("error.data.access.integrity.violation.delete"),
    ERROR_GERAR_JASPER_REPORT("error.gerar.jasper.report");
    // @formatter:on

    @Getter
    private final String message;

    MessageCommonEnum(String message) {
        this.message = message;
    }

}
