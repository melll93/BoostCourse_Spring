package kr.or.connect.daoExam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoExam.config.ApplicationConfig;
import kr.or.connect.daoExam.dao.RoleDao;
import kr.or.connect.daoExam.dto.Role;

public class JdbcTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		RoleDao roleDao = ac.getBean(RoleDao.class);
		Role role = new Role();
		
		/*******INSERT*******/
//		role.setRoleId(500);
//		role.setDescription("CEO");

//		int count = roleDao.insert(role);
//		System.out.println(count + "건 입력되었습니다.");
		
		/*******UPDATE*******/
		role.setRoleId(201);
		role.setDescription("PROGRAMMER");
		
		int count = roleDao.update(role);
		
	}

}
