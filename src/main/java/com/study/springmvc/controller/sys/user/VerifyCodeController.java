package com.study.springmvc.controller.sys.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.springmvc.common.utils.VerifyCodeUtils;

import io.swagger.annotations.Api;

/**
 * 图片验证码生成
 * @author shibaomi
 */
@Api(description="图片验证码")
@Controller
@RequestMapping(value = "sys/verify_img")
public class VerifyCodeController {
	
	/***
	 * 获取图片验证码信息
	 * @throws Exception 
	 */
	@RequestMapping(value = "",method=RequestMethod.GET,produces={"image/webp"})
	public void getVerifyCodeImage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setHeader("Pragma", "No-cache"); 
		resp.setHeader("Cache-Control", "no-cache"); 
        resp.setDateHeader("Expires", 0); 
        resp.setContentType("image/jpeg"); 
        //生成随机字串 
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4); 
        //存入会话session 
        HttpSession session = req.getSession(true); 
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase()); 
        //生成图片 
        int w = 100, h = 30; 
        VerifyCodeUtils.outputImage(w, h, resp.getOutputStream(), verifyCode); 
	}
	
}
