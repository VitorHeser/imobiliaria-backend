package br.com.heserproject.imobiliaria.core.factory;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.lang.reflect.Type;

/**
 * Classe factory responsável criar e replicar propriedades de objetos de
 * domínio.
 *
 * @author Vitor Heser Rosa
 * @since Nov 25, 2019
 */
public class DomainIOFactory {

    private static ModelMapper modelMapper;

    private DomainIOFactory() {
        throw new IllegalStateException("Classe Factory. Não pode ser instanciada.");
    }

    public static ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }
        return modelMapper;
    }

    /**
     * Cria um novo objeto de acordo com o class informado. Replica as propriedades
     * em comum.
     *
     * @param source
     * @param clazzTarget
     * @return {@link Object}
     */
    public static <T> T create(Object source, Class<T> clazzTarget) {
        if (source == null) {
            return null;
        }
        return getModelMapper().map(source, clazzTarget);
    }

    /**
     * Cria um novo objeto de acordo com o class informado. Replica as propriedades
     * em comum via deep copy.
     *
     * @param source
     * @param type
     * @return {@link Object}
     */
    public static <T> T create(Object source, Type type) {
        return getModelMapper().map(source, type);
    }

    /**
     * Replica as propriedades em comum de dois objetos.
     *
     * @param source
     * @param target
     * @return {@link Object}
     */
    public static void copy(Object source, Object target) {
        Assert.notNull(source, "O parâmetro [source] deve ser informado.");
        Assert.notNull(target, "O parâmetro [target] deve ser informado.");
        BeanUtils.copyProperties(source, target);
    }

}
