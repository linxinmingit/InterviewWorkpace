package cn.yr.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@Autowired
	private Dao daoImpl;

	@ModelAttribute
	public void model(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		if (id != null && id != 0) {
			User user = daoImpl.getUserById(id);
			map.put("user", user);
		}
	}

	@RequestMapping(value = "/jumpList", method = RequestMethod.GET)
	public String jump() {
		return "list";
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	@ResponseBody
	public List<User> getAll() {
		List<User> list = daoImpl.getUserList();
		for (User user : list) {
			System.out.println(user.toString());
		}
		return daoImpl.getUserList();
	}
	
	@RequestMapping(value = "/uesr1111", method = RequestMethod.GET)
	public String save(User user, Map<String, Object> map) {
		map.put("user", new User());
		return "updataOrAdd";
	}
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String save2(@ModelAttribute("user") User user) {
		daoImpl.save(user);
		return "redirect:jumpList";
	}
	
	@RequestMapping(value = "/uesr/{id}", method = RequestMethod.GET)
	public String update(@PathVariable Integer id, Map<String, Object> map) {
		User user = daoImpl.getUserById(id);
		map.put("user", user);
		return "updataOrAdd";
	}
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public String update2(@ModelAttribute("user") User user) {
		daoImpl.update(user);
		return "redirect:jumpList";
	}

}
