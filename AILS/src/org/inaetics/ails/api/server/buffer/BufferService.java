package org.inaetics.ails.api.server.buffer;

/**
 * A buffer can be used to temporarily store objects before processing. The buffer provides ways to
 * add and remove elements and to check its size.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 28-10-2015
 * @param <E> The type of elements this buffer can handle.
 */
public interface BufferService<E> {

    /**
     * Add an element to the buffer.
     * 
     * @param e @NotNull the type of elements held in this collection.
     */
    void add(E e);

    /**
     * Removes an element from the buffer.
     * 
     * @return the element to remove.
     */
    E remove();

    /**
     * Returns the number of elements in this buffer.
     * 
     * @return the number of elements in this buffer.
     */
    int size();

}
