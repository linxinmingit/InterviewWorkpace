package cn.jpa.springbootjpa;

import cn.jpa.springbootjpa.pojo.Student;
import cn.jpa.springbootjpa.service.ServiceInterface;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: linxinmin
 * @Date: 2019/2/28 17:48
 */
@Controller
@RequestMapping("/springboot")
public class controller {

    @Autowired
    private ServiceInterface serviceInterface;

    @RequestMapping(value = "all",method = RequestMethod.POST)
    @ResponseBody
    public List<Student> getList()
    {
        return  serviceInterface.getStudentList();
    }

//    @RequestMapping(value = "singlet",method = RequestMethod.GET)
//    public Student getStudentById(Integer sid)
//    {
//        return  serviceInterface.getStudentById(sid);
//    }

    @RequestMapping(value = "stu",method = RequestMethod.POST)
    public void save(Student student)
    {
        serviceInterface.save(student);
    }

    @RequestMapping(value = "stu",method = RequestMethod.PUT)
    public void update(Student student)
    {
        serviceInterface.update(student);
    }

    @RequestMapping(value = "stu",method = RequestMethod.DELETE)
    public void del(Integer sid)
    {
        serviceInterface.del(sid);
    }
}
