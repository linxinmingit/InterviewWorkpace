package cn.jpa.springbootjpa.service;

import cn.jpa.springbootjpa.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: linxinmin
 * @Date: 2019/2/28 17:41
 */
public class ServiceInterfaceImpl implements ServiceInterface {

    @Autowired
    private JpaRepository<Student,Integer> jpaRepository;


    @Override
    public List<Student> getStudentList() {
        return jpaRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer sid) {
        return jpaRepository.getOne(sid);
    }

    @Override
    public void save(Student student) {
        jpaRepository.save(student);
    }

    @Override
    public void update(Student student) {
        jpaRepository.save(student);
    }

    @Override
    public void del(Integer id) {
        jpaRepository.deleteById(id);
    }
}
