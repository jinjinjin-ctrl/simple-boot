package com.simpleboot.entity.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RelationActionParam extends BaseParam{
    private String toUserId;
    private String actionType;
}
