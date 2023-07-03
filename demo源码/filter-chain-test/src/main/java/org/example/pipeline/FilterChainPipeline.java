package org.example.pipeline;

public class FilterChainPipeline<T extends EventFilter> {
    private DefaultFilterChain first;
    private DefaultFilterChain last;

    public FilterChainPipeline() {
    }

    public DefaultFilterChain getFilterChain() {
        return this.first;
    }

    public FilterChainPipeline addNext(T filter) {
        DefaultFilterChain newChain = new DefaultFilterChain(filter);
        if (first == null) {
            first = last = newChain;
        } else {
            last.setNext(newChain);
            this.last = newChain;
        }

        return this;
    }

}
