package com.study.springmvc.controller.common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常监控处理
 * @author shibaomi
 */
@ControllerAdvice
@ResponseBody
public class ControllerExceptionAdvice {

    private static Logger logger = LoggerFactory.getLogger(ControllerExceptionAdvice.class);

    /**
     * 验证异常监控
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        JsonResult resultJson = new JsonResult();
        resultJson.setStatusCode("FAIL");
        resultJson.setStatus("fail");
        StringBuilder errMsg=new StringBuilder();
        for (ObjectError error : result.getAllErrors()) {
        	if(errMsg.length()<1){
        		errMsg.append(error.getDefaultMessage());
        	}else{
        		errMsg.append(",").append(error.getDefaultMessage());
        	}
        }
        resultJson.setMessage(errMsg.toString());
        logger.error("参数验证失败:{}", resultJson.getMessage(),e);
        return resultJson;
    }
    
    /**
     * 验证异常监控
     */
    @ExceptionHandler(Exception.class)
    public JsonResult handleMethodArgumentNotValidException(Exception ex) {
    	JsonResult result=new JsonResult();
		result.setStatus("fail");
		result.setMessage(ex.getMessage());
		result.setStatusCode("FAIL");
		logger.error("ajax请求发生异常：errorCode={},errorMsg={}",result.getStatusCode(),result.getMessage(),ex);
		return result;
    }
}
