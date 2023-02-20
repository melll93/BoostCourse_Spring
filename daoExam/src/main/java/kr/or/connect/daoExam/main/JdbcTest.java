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
//		role.setRoleId(201);
//		role.setDescription("PROGRAMMER");
//		
//		int count = roleDao.update(role);
//		System.out.println(count + "건 수되었습니다.");
		
		/*******SELECT BY ID*******/
		Role resultRole = roleDao.selectById(201);
		System.out.println(resultRole+"이 조회되었습니다.");
		
		/*******DELETE BY ID*******/
		int deleteCount = roleDao.deleteById(500);
		System.out.println(resultRole+"건 삭제되었습니다.");
		System.out.println(roleDao.selectById(500));
		
	}

}
