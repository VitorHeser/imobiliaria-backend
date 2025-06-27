package br.com.heserproject.imobiliaria.domain.io;

import br.com.heserproject.imobiliaria.core.base.BaseOutputEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EnderecoOutput extends BaseOutputEntity {

    private String rua;
    private Integer numero;

    @Override
    public Type getType() {
        return this.getClass().getGenericSuperclass();
    }
}
