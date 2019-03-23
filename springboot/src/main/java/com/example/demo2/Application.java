package com.example.demo2;



import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class Application {
	 @ResponseBody
	 @RequestMapping("/hello") 
	public String index() {
		return "Hello World";
	}
	@ResponseBody
	@RequestMapping("/index")
	public String index(Map<String, Object> map) {
		    map.put("name","小明");
			return "name";
		} 
	 	
}
