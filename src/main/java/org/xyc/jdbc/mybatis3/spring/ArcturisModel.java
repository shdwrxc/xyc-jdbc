package org.xyc.jdbc.mybatis3.spring;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * created by wks on date: 2017/6/28
 */
//@Alias("ArcturisModel")
public class ArcturisModel implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private String address;

    public ArcturisModel() {
    }

    public ArcturisModel(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ArcturisModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
