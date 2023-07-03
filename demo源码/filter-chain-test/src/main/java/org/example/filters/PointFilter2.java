package org.example.filters;

import org.example.pipeline.AbstractEventFilter;
import org.example.pipeline.context.PointContext;

public class PointFilter2 extends AbstractEventFilter<PointContext> {
    @Override
    protected void handle(PointContext context) {
        context.setName("222");
        System.out.println("22222");
    }
}
