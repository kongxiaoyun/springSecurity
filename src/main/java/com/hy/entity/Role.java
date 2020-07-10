package com.hy.entity;

import java.io.Serializable;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author Terry
 * @since 2019-05-23
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色标识
     */
    private String id;
    /**
     * 角色名称
     */
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
        ", id=" + id +
        ", name=" + name +
        "}";
    }
}
