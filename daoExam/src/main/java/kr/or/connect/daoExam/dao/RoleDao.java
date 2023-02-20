package kr.or.connect.daoExam.dao;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoExam.dto.Role;
import static kr.or.connect.daoExam.dao.RoleDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("role");
	}

	public List<Role> selectAll() {

		return jdbc.query(SELECT_ALL, Collections.EMPTY_MAP, rowMapper);
	}

	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return insertAction.execute(params);
	}

	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return jdbc.update(UPDATE, params);
	}

	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("roleId", id); // 굳이 한 건을 가지고 객체를 params 객체를 생성해서 사용할 필요없으니 Collections 활 
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}

	public Role selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);
			return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper); // query VS queryForObject
		} catch (EmptyResultDataAccessException e) { // 조회하지 못할 경우 Exception 발생 >> null 반환 >> JS nullish 처리?
			return null;
		}
	}

}
