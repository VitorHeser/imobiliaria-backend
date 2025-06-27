package br.com.heserproject.imobiliaria.core.domain.functional;


import br.com.heserproject.imobiliaria.core.exception.BadRequestException;

@FunctionalInterface
public interface ApiResponseConsumer<T> {
    void accept(T var1) throws BadRequestException;
}
