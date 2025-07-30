package com.patronpipeline.patronpipeline.pipeline;

import com.patronpipeline.patronpipeline.pipeline.Handlers.Handler;

import java.util.ArrayList;
import java.util.List;


public class Pipeline<T> {
    private final List<Handler<T>> handlers = new ArrayList<>();

    public Pipeline<T> addHandler(Handler<T> handler) {
        handlers.add(handler);
        return this;
    }

    public T execute(T input) {
        T current = input;
        for (Handler<T> handler : handlers) {
            current = handler.process(current);
        }
        return current;
    }
}