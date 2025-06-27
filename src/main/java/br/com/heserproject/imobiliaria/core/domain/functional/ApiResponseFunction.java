package br.com.heserproject.imobiliaria.core.domain.functional;


import br.com.heserproject.imobiliaria.core.exception.BadRequestException;

@FunctionalInterface
public interface ApiResponseFunction<T, R> {
    R apply(T var1) throws BadRequestException;
}
