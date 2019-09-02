package com.hanwha.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO_mybatis {
	
	@Autowired
	SqlSession session;
	String namespace="com.hanwha.emp.";
	
	
	public List<EmpVO> selectAll(){
		return session.selectList("com.hanwha.emp.selectall");
	}
	
	public EmpVO selectByID(int empid) {
		//selectone(실행해야 되는 것, 매개변수)
		return session.selectOne("com.hanwha.emp.selectbyid", empid);
	}
	
	public int insertEmp(EmpVO emp) {
		return session.insert("com.hanwha.emp.insert", emp);
	}
	
	public int updateEmp(EmpVO emp) {
		return session.update("com.hanwha.emp.update", emp);
	}
	
	public int deleteEmp(int emp) {
		return session.delete("com.hanwha.emp.delete",emp);
	}
	
	public List<Integer> selectAllManager() {
		return session.selectList(namespace+"selectallmanager");
	}
	
	public List<String> selectAllJob() {
		return session.selectList(namespace+"selectalljob");
	}
	
	
		
}
