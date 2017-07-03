package org.xyc.jdbc.hibernate4.sample;

import javax.persistence.*;

/**
 * Created by bugu on 2016/2/20.
 */
@Entity
@Table(name = "test")
public class TestModel {

    private Integer id;
    private String name;
    private Integer age;
    private String address;

    public TestModel() {
    }

    public TestModel(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
