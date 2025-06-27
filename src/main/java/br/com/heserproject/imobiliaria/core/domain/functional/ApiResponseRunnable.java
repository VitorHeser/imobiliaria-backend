package br.com.heserproject.imobiliaria.core.domain.functional;


import br.com.heserproject.imobiliaria.core.exception.BadRequestException;

@FunctionalInterface
public interface ApiResponseRunnable {
    void run() throws BadRequestException;
}
