package br.com.heserproject.imobiliaria.domain.io;

import br.com.heserproject.imobiliaria.core.base.BaseInputEntity;
import br.com.heserproject.imobiliaria.domain.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EnderecoInput extends BaseInputEntity<Endereco> {

    private String cep;
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;
    private String pais;

    @Override
    public Class<Endereco> getTargetType() {
        return Endereco.class;
    }

    @Override
    public Type getType() {
        return this.getClass().getGenericSuperclass();
    }
}
