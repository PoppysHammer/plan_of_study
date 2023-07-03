package org.example.filters;

import org.example.pipeline.AbstractEventFilter;
import org.example.pipeline.context.PointContext;

public class PointFilter3 extends AbstractEventFilter<PointContext> {
    @Override
    protected void handle(PointContext context) {
        context.setUserId(3L);
        System.out.println("33333");
    }
}
