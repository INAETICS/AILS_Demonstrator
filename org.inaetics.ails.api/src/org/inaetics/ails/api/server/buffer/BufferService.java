package org.inaetics.ails.api.server.buffer;

import com.google.common.base.Optional;
/**
 * A buffer can be used to temporarily store objects before processing. The buffer provides ways to
 * add and remove elements and to check its size.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 2.1.0
 * @since 28-10-2015
 * @param <E> The type of elements this buffer can handle.
 */
public interface BufferService<E> {

    /**
     * Add an element to the buffer.
     * 
     * @param e @NotNull The element to place in this buffer.
     */
    void add(E e);

    /**
     * Gets an element from the buffer and remove it.
     * 
     * @return An Optional containing the next element if found, or an empty Optional if not.
     */
    Optional<E> remove();

    /**
     * Returns the number of elements in this buffer.
     * 
     * @return the number of elements in this buffer.
     */
    int size();
    
    /**
     * Retrieve the class type of the objects that are buffered by this buffer.
     *  
     * @return The class of the type for this buffer.
     * @since 2.1.0
     */
    Class<E> forType();

}
