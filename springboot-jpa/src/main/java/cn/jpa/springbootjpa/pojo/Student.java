package cn.jpa.springbootjpa.pojo;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

/**
 * @Author: linxinmin
 * @Date: 2019/2/28 17:33
 */
@Entity
@Table(name = "TABLE_JPA_STUDENT")
public class Student {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer sid;


    private String name;

    @Range(max = 18,min = 6)
    private String age;

    private Integer sex;
    private String address;
    private String tel;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
