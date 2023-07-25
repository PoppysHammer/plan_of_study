package org.example.pipeline.basic;


import org.example.pipeline.basic.context.EventContext;

/**
 * @author gim
 */
public interface Handler<T extends EventContext> {

    boolean handleVerify(T context);

    /**
     * 过滤逻辑封装点
     *
     * @param context
     */
    void doHandle(T context) throws Exception;

    void next(Handler<T> next);

    void exceptionCaught(T context, Exception e) throws Exception;

    void fireException(T context, Exception e) throws Exception;

}
