package com.study.springmvc.sms;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.study.springmvc.base.BaseTest;
import com.study.springmvc.common.constant.sms.SmsType;
import com.study.springmvc.controller.command.sys.sms.SendSmsCommand;
import com.study.springmvc.service.faces.sys.SmsService;

public class SmsTest extends BaseTest{
	@Autowired
	private SmsService smsService;
	
	@Before
	public void setContext(){
		System.out.println("init");
	}
	@After
	public void doClose(){
		System.out.println("close");
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSaveSmsInfo() {
		SendSmsCommand command=new SendSmsCommand();
		command.setMobile("15201857832");
		command.setSmsType(SmsType.FAST_MOBILE_REGISTER.toString());
		try {
			System.out.println(smsService.sendMessage(command));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
