package kr.or.connect.daoExam.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoExam.dao.RoleDao;
import kr.or.connect.daoExam.dto.Role;
import kr.or.connect.daoExam.config.ApplicationConfig;

public class SelectAllTest {

	
	public static void main(String[] args) { 
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		List<Role> list = roleDao.selectAll();
		
		for(Role role : list) {
			System.out.println(role);
		}
		
	}

}
