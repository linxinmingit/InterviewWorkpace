package cn.jpa.springbootjpa.service;

import cn.jpa.springbootjpa.pojo.Student;
import java.util.List;

/**
 * @Author: linxinmin
 * @Date: 2019/2/28 17:38
 */
public interface ServiceInterface {

      List<Student> getStudentList();
      Student getStudentById(Integer sid);
      void save(Student student);
      void update(Student student);
      void del(Integer id);
}
