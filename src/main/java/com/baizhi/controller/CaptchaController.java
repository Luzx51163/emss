package com.baizhi.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/util")
public class CaptchaController {
	@Autowired
	HttpSession session;

	@RequestMapping("/getCaptcha")
	public void getCaptcha(HttpServletResponse response) {
		LineCaptcha captcha = CaptchaUtil.createLineCaptcha(180, 40, 4, 10);
		session.setAttribute("captchaCode", captcha.getCode());
		try {
			captcha.write(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
