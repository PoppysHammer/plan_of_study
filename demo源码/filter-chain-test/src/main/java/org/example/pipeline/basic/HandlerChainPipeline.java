package org.example.pipeline.basic;


import org.example.pipeline.basic.context.EventContext;

public class HandlerChainPipeline<T extends EventContext> {
    private Handler<T> first;
    private Handler<T> last;

    public HandlerChainPipeline() {
    }

    public Handler<T> getHandlerChain() {

        return this.first;
    }

    public HandlerChainPipeline<T> addNext(Handler<T> handler) {
        if (first == null) {
            first = last = handler;
        } else {
            last.next(handler);
            this.last = handler;
        }
        return this;
    }

}
