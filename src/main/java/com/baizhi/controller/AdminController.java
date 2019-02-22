package com.baizhi.controller;

import com.baizhi.entity.EmsAdmin;
import com.baizhi.service.EmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private EmsAdminService emsAdminService;

	@RequestMapping("/register")
	public String register(EmsAdmin admin, String captcha, HttpSession session) {
		System.out.println(admin + captcha);
		String captchaCode = (String) session.getAttribute("captchaCode");
		Map<String, Object> map = new HashMap<String, Object>();
		if (captchaCode.equals(captcha)) {
			emsAdminService.insertEmsAdmin(admin);
			return "redirect:/admin/showAll";
		} else {
			return "regist";
		}

	}

	@RequestMapping("/login")
	public Map<String, Object> login(String username, String password) {
		EmsAdmin emsAdmin = emsAdminService.selectByUserName(username);
		Map<String, Object> map = new HashMap();
		if (emsAdmin.getEmsPassword().equals(password)) {
			map.put("code", 200);
			map.put("msg", "登陆成功");
		} else {
			map.put("code", 200);
			map.put("msg", "用户名或密码错误");
		}
		return map;
	}

	@RequestMapping("/showAll")
	public ModelAndView showAll(Integer page, ModelAndView modelAndView) {
		Map<String, Object> all = emsAdminService.getAll(1, 10);
		List<EmsAdmin> rows = (List<EmsAdmin>) all.get("rows");
		modelAndView.addObject("list", rows);
		modelAndView.setViewName("forward:/emplist.jsp");
		return modelAndView;
	}

	@RequestMapping("/add")
	public String add(EmsAdmin admin) {
		System.out.println(admin + "ppp");
		Map<String, Object> map = new HashMap<String, Object>();
		emsAdminService.add(admin);
		return "redirect:/admin/showAll.do";
	}

	@RequestMapping("/delete")
	public String delete(Integer id) {
		emsAdminService.delete(id);
		return "redirect:/admin/showAll.do";
	}


}
