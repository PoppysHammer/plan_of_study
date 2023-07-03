package org.example.pipeline;


import lombok.Setter;
import org.example.pipeline.context.EventContext;

import java.util.Objects;

/**
 * @author gim
 */
public class DefaultFilterChain<T extends EventContext> implements EventFilterChain<T> {

    @Setter
    private EventFilterChain<T> next;
    private EventFilter<T> filter;

    public DefaultFilterChain(EventFilter filter) {
        this.filter = filter;
    }

    @Override
    public void handle(T context) {
        filter.doFilter(context, this);
    }

    @Override
    public void fireNext(T ctx) {
        EventFilterChain nextChain = this.next;
        if (Objects.nonNull(nextChain)) {
            nextChain.handle(ctx);
        }
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
