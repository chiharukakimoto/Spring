package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@Autowired
	private HelloService service;
	
	@GetMapping("/hello")
	public String getHello() {
		// hello.htmlに画面遷移
		return "hello";
	}

	// 受け付けるURLを、@PostMappingの引数に設定
	@PostMapping("/hello")
	// HTMLのname属性と一致するように、@RequestParamアノテーションの引数を指定
	public String postRequest(@RequestParam("text1") String str, Model model) {
		// 画面から受け取った文字列をModelに登録
		// addAttributeメソッドにキー名と値を指定
		model.addAttribute("sample", str);

		// response.htmlに画面遷移
		return "hello/response";

	}
	
	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2")String id, Model model) {
		Employee employee = service.getEmployee(id);
		model.addAttribute("employee", employee);
		return "hello/db";
	}

}