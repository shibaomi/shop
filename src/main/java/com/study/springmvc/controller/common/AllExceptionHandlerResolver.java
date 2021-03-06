package com.study.springmvc.controller.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.study.springmvc.common.utils.JackJsonUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 统一异常处理，包括ajax请求(只捕获未进入controller只的异常，controller中的异常由ControllerExceptionAdvice捕捉)
 */
@Slf4j
public class AllExceptionHandlerResolver extends SimpleMappingExceptionResolver {
	
	public ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response,
			Object handler,Exception ex) {
		//输出完整错误信息
		ex.printStackTrace();
		//查是否有配置的视图名称
		String viewName = determineViewName(ex, request);
		response.setCharacterEncoding("UTF-8");
		if (viewName != null) {
			// 返回jsp视图
			if (!(request.getHeader("accept").contains("application/json")
					|| (request.getHeader("X-Requested-With") != null
							&& request.getHeader("X-Requested-With").contains("XMLHttpRequest")))) {
				// 若错误页面指定了http状态码则返回状态码，否则返回默认状态码
				Integer statusCode = determineStatusCode(request, viewName);
				if (statusCode != null) {
					//应用状态码，设置状态码到返回状态中
					applyStatusCodeIfPossible(request, response, statusCode);
				}
				log.error("网页请求发生异常：{0}",ex);
				return getModelAndView(viewName, ex, request);
			} else {
				// ajax请求的JSON格式返回
				try {
					PrintWriter writer = response.getWriter();
					writer.write(JackJsonUtils.getJsonStr(getJsonResult(ex)));
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				PrintWriter writer = response.getWriter();
				writer.write(JackJsonUtils.getJsonStr(getJsonResult(ex)));
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView();
	}
	
	/***
	 * 根据异常信息封装返回报文
	 * @param ex
	 * @return
	 */
	public JsonResult getJsonResult(Exception ex){
		JsonResult result=new JsonResult();
		result.setStatus("fail");
		result.setMessage(ex.getMessage());
		result.setStatusCode("FAIL");
//		log.error("ajax请求发生异常：errorCode={},errorMsg={}",result.getStatusCode(),result.getMessage());
		return result;
	}
}

