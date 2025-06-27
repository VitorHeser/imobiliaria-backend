package br.com.heserproject.imobiliaria.core.util;


import br.com.heserproject.imobiliaria.core.base.BaseApiResponse;
import br.com.heserproject.imobiliaria.core.domain.dto.PageDTO;
import br.com.heserproject.imobiliaria.core.factory.DomainIOFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class HttpUtil implements Serializable {
    private static final long serialVersionUID = 8590948736974473408L;

    public HttpUtil() {
    }

    public static ResponseEntity createResponse(Object object, HttpStatus status) {
        return new ResponseEntity(new BaseApiResponse(object), status);
    }

    public static ResponseEntity createResponse(Object object, Class<?> outputClass, HttpStatus status) {
        Assert.notNull(outputClass, "O parâmetro outputClass deve ser informado.");
        if (object instanceof Page) {
            return createPageResponse((Page) object, outputClass, status);
        } else {
            return object instanceof Collection ? createListResponse((Collection) object, outputClass, status) : createResponse(DomainIOFactory.create(object, outputClass), status);
        }
    }

    private static ResponseEntity createListResponse(Collection<Object> object, Class<?> outputClass, HttpStatus status) {
        List<Object> newList = new ArrayList();
        Iterator var4 = object.iterator();

        while (var4.hasNext()) {
            Object o = var4.next();
            newList.add(DomainIOFactory.create(o, outputClass));
        }

        return createResponse(newList, status);
    }

    private static ResponseEntity createPageResponse(Page<Object> object, Class<?> outputClass, HttpStatus status) {
        List<Object> newList = new ArrayList();
        Iterator var5 = object.getContent().iterator();

        while (var5.hasNext()) {
            Object o = var5.next();
            newList.add(DomainIOFactory.create(o, outputClass));
        }

        PageDTO<?> pageOutput = PageDTO.builder().totalPages(object.getTotalPages()).numberOfElements(object.getNumberOfElements()).totalElements(object.getTotalElements()).content(newList).build();
        return createResponse(pageOutput, status);
    }
}
