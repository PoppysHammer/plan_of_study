package org.example.demo.design;

import cn.hutool.core.util.StrUtil;

public class EngineController {

    //岗位、部门
    public String process(final String userId, final String department, final String position) {
        System.out.println(StrUtil.format("ifelse实现方式判断用户结果。userId：{} department：{} position：{}", userId, department, position));

        if ("技术".equals(department)) {
            if ("项目经理".equals(position)) {
                return "开发方案设计";
            }
            return "代码开发";
        }

        if ("财务".equals(department)) {
            if ("财务主管".equals(position)) {
                return "账单审批";
            }
            return "财务审计";
        }
        return null;
    }
}
