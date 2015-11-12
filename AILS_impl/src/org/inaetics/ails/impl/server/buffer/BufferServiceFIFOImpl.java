package org.inaetics.ails.impl.server.buffer;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

import org.inaetics.ails.api.server.buffer.BufferService;

import com.google.common.base.Preconditions;

/**
 * The BufferServiceImpl class provides an implementation of the {@link BufferService BufferService}
 * for buffering elements in a First In First Out (FIFO) order.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @param <E> The type of elements this buffer can handle.
 * @since 04-11-2015
 */
public class BufferServiceFIFOImpl<E> implements BufferService<E> {

    private final Queue<E> fifoQueue;

    /**
     * Creates a new BufferService implementation for a FIFO Queue.
     */
    public BufferServiceFIFOImpl() {
        fifoQueue = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        fifoQueue.add(Preconditions.checkNotNull(e));
    }

    @Override
    public Optional<E> remove() {
        return Optional.ofNullable(fifoQueue.poll());
    }

    @Override
    public int size() {
        return fifoQueue.size();
    }

}