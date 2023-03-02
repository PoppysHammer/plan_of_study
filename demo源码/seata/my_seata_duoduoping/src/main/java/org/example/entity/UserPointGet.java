package org.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 积分领取表
 * </p>
 *
 * @author
 * @since 2022-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserPointGet implements Serializable {

    private static final long serialVersionUID = 1L;

    // "主键"
    private Long id;

    //"领取积分数量"
    private Integer pointGet;

}
