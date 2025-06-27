package br.com.heserproject.imobiliaria.core.util;

import org.springframework.util.ObjectUtils;

import java.io.Serializable;

/**
 * Classe utilitária responsável por prover métodos para validação de objetos.
 *
 * @author Vitor Heser Rosa
 * @since Nov 22, 2019
 */
public final class ObjectUtil implements Serializable {

    private static final long serialVersionUID = 8725702469069757544L;

    private ObjectUtil() {
        throw new IllegalStateException("Classe Utilitária. Não pode ser instanciada.");
    }

    /**
     * Verifica se determinado objeto está preenchido. Verifica os tipos possíveis e
     * seus valores.<br/>
     * <p>
     * Utiliza a classe utilitária {@link ObjectUtils} do Spring Framework.
     *
     * @param object {@link Object}
     * @return boolean
     */
    public static boolean isNotEmpty(Object object) {
        if (ObjectUtils.isArray(object)) {
            return !ObjectUtils.isEmpty((Object[]) object);
        } else {
            return !ObjectUtils.isEmpty(object);
        }
    }

    public static boolean isEmpty(Object object) {
        return !isNotEmpty(object);
    }

    /**
     * Verifica se dois objetos são equivalentes.
     *
     * @param object1 {@link Object}
     * @param object2 {@link Object}
     * @return {@link Boolean}
     */
    public static boolean isEquals(Object object1, Object object2) {
        boolean isEquals = true;
        if (ObjectUtil.isNotEmpty(object1) && ObjectUtil.isEmpty(object2)
                || ObjectUtil.isEmpty(object1) && ObjectUtil.isNotEmpty(object2)
                || (ObjectUtil.isNotEmpty(object1) && ObjectUtil.isNotEmpty(object2) && !object1.equals(object2))) {
            isEquals = false;
        }
        return isEquals;
    }

    /**
     * Verifica se o objeto é nulo, caso contrario aplica o default
     *
     * @param object1 {@link Object}
     * @param object2 {@link Object}
     * @return {@link Boolean}
     */
    public static Object ifNullDefault(Object object1, Object object2) {
        return object1==null ? object2 : object1;
    }

}
