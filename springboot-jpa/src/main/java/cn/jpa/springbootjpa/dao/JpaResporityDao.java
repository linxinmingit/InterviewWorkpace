package cn.jpa.springbootjpa.dao;

import cn.jpa.springbootjpa.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: linxinmin
 * @Date: 2019/2/28 17:33
 */
public interface JpaResporityDao extends JpaRepository<Student,Integer> {
}
