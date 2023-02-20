package kr.or.connect.daoExam.dao;

public class RoleDaoSqls {
	public static final String SELECT_ALL = "SELECT role_id, description FROM role oreder by role_id";
	public static final String UPDATE = "UPDATE role set description = :description where role_id = :roleId";
}
