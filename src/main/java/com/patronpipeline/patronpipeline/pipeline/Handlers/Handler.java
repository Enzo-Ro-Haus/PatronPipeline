package com.patronpipeline.patronpipeline.pipeline.Handlers;

@FunctionalInterface
public interface Handler<T> {
    T process(T input);
}