package com.hanwha.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//서비스: DB에 가지 않는 로직을 담당한다
//컨트롤러요청 ->서비스가 받음->DAO에 방문해서 결과를 가져와서 바로 컨트롤러에 리턴
//이걸 틀처럼 미리 작성하고 dao 작성하는 사람, 컨트롤러 작성하는 사람에게 넘겨준다(함수 이름 등 때문에)

@Service
public class EmpService {
	
	//@Autowired
	//EmpDAO dao;
	
	@Autowired
	EmpDAO_mybatis dao;
	
	public List<Integer> selectAllManager() {
		return dao.selectAllManager();
	}
		
	
	public List<String> selectAllJob() {
		return dao.selectAllJob();
	}
	
	/*
	public List<EmpVO> selectByJob(String job_id, int sal) {
		return dao.selectByJob(job_id, sal);
	}
	
	public List<EmpVO> selectByDept(int department_id) {
		return dao.selectByDept(department_id);
	}
	*/
	public List<EmpVO> selectAll() {
		return dao.selectAll();
	}

	public EmpVO selectByID(int employee_id) {
		return dao.selectByID(employee_id);
	}

	public int insertEmp(EmpVO emp) {
		return dao.insertEmp(emp);
	}
	
	/*
	public int updateEmpAll(EmpVO emp) {
		return dao.updateEmpAll(emp);
	}*/
	
	public int updateEmp(EmpVO emp) {
		return dao.updateEmp(emp);
	}
	
	
	
	public int deleteEmp(int employee_id) {
		return dao.deleteEmp(employee_id);
	}

}
