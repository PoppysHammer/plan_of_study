package org.example.filters;

import org.example.pipeline.AbstractEventFilter;
import org.example.pipeline.context.PointContext;

public class PointFilter1 extends AbstractEventFilter<PointContext> {
    @Override
    protected void handle(PointContext context) {
        context.setPoint(1);
        System.out.println("11111");
    }
}
