package org.example.pipeline.context;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PointContext extends AbstractEventContext {

    private Integer point;

    private Long userId;

    private String name;


    @Override
    public boolean continueChain() {
        return true;
    }
}
