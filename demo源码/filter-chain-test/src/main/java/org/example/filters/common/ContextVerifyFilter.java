package org.example.filters.common;

import lombok.AllArgsConstructor;
import org.example.pipeline.AbstractEventFilter;
import org.example.pipeline.context.AbstractEventContext;

import java.util.function.Consumer;

@AllArgsConstructor
public class ContextVerifyFilter<T extends AbstractEventContext> extends AbstractEventFilter<T> {
    private final Consumer<T> consumer;

    @Override
    protected void handle(T context) {

        consumer.accept(context);
    }
}
