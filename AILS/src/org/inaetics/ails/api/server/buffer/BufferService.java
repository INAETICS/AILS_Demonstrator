package org.inaetics.ails.api.server.buffer;


/**
 * This service provides a buffer.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 28-10-2015
 */
public interface BufferService<E> {

    /**
     * Add an element to the buffer. 
     * 
     * @param e @NotNull the type of elements held in this collection.
     * 
     * @return true if element was added successfully.
     */
    boolean add(E e);
    
    /**
     * Removes an element from the buffer.
     * 
     * @return the element to remove.
     */
    E remove();
}