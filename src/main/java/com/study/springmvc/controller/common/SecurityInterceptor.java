package com.study.springmvc.controller.common;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecurityInterceptor implements HandlerInterceptor {

	public static final Logger log = LoggerFactory.getLogger(SecurityInterceptor.class);
	
	@Autowired
	private TokenService tokenService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("SecurityInterceptor preHandle:contextPath={},requestURI={},method={}",
				request.getContextPath(),request.getRequestURI(),request.getMethod());
		//从头部或者请求参数获取session属性获得请求token值
		String token=!StringUtils.isEmpty(request.getHeader ("token"))
				?request.getHeader ("token"):
					//从请求参数中获取token
					(!StringUtils.isEmpty(request.getParameter("token"))?request.getParameter("token"):
						//从请求属性中获取token
						(!StringUtils.isEmpty(request.getAttribute("token"))?request.getAttribute("token").toString():
							null));
		// 映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod ();
        // 验证是否需要登录，登录的需要传token值
        if (method.getAnnotation (NeedLogin.class) != null) {
        	if(tokenService.validateToken(token)){
        		response.setHeader("token", tokenService.reflushToken(token));
        		return true;
        	}else{
        		//验证token失败，返回token失败
                response.setStatus (HttpServletResponse.SC_UNAUTHORIZED);
                return false;
        	}
        }
        return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

}
