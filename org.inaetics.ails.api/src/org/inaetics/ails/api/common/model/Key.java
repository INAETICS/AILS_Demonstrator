package org.inaetics.ails.api.common.model;

/**
 * This interface provides a way for model objects to let themselves be uniquely identifiable. This
 * is necessary for data persistence. This abstraction provides a nice type-safe way to provide such
 * a key.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 11-11-2015
 * @param <E> The type of key that will be provided.
 */
public interface Key<E> {

    /**
     * Provides a uniquely identifying key for this object.
     * 
     * @return The key.
     */
    E getKey();

}
