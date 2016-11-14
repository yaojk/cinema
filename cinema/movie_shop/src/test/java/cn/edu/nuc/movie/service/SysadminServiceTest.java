package cn.edu.nuc.movie.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.movie.entity.Sysadmin;


public class SysadminServiceTest extends BaseTest {

	@Autowired
	private SysadminService sysadminService;
	
	@Test
	public void login(){
		
		Sysadmin sysadmin = sysadminService.login("yjk", "123");
		
		System.out.println(sysadmin);
		
	}

}
