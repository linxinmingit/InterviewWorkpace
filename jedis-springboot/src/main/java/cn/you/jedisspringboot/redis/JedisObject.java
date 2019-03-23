package cn.you.jedisspringboot.redis;

import java.io.Serializable;

/**
 * @Author: linxinmin
 * @Date: 2019/3/1 20:22
 */
public class JedisObject implements Serializable{
    private Integer id;
    private String name;
    private String age;
    private String address;

    @Override
    public String toString() {
        return "JedisObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public JedisObject() {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
