package com.program.wanandroiddemo.model.domain;

/**
 * 体系分类子内容，只有id和name
 */
public class SystemChild {

    private Integer id;
    private String name;

    public SystemChild(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "SystemChild{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
