package com.hanwha.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanwha.util.DbUtil_Oracle;

/*
 * DAO(Data Access Object) : Business logic (DB에 접근하는 로직)
 * 
 */
//<bean id="deptDAO", class="com.hanwha.model.DeptDAO"/> 이것과 같은 뜻의 annotation
@Repository
public class DeptDAO {
	
	//new datasource가 만들어져 dao에 삽입된다.
	@Autowired
	DataSource ds;
	
	
	public List<DeptDTO> selectAll() {
		ArrayList<DeptDTO> deptlist = new ArrayList<>();
		Connection conn= null;
		String sql = "select * from departments";
		Statement st = null;
		ResultSet rs = null;
		try {
			conn=ds.getConnection();
			st= conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				int deptid= rs.getInt("department_id");
				String dname= rs.getString("department_name");
				DeptDTO dept = new DeptDTO(deptid, dname);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return deptlist;
	
	}
//부서 아이디가 들어오면 그 부서 아이디의 상세보기
	public DeptDTO selectByID(int deptid) {
		DeptDTO dept = null;
		Connection conn=null;
		//Connection conn= DbUtil_Oracle.getConnect();
		String sql = "select * from departments where department_id = "+deptid;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn= ds.getConnection();
			st= conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				
				String dname= rs.getString("department_name");
				dept = new DeptDTO(deptid, dname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return dept;
	}
	//입력된 개수를 return한다.
	public int insertDept(DeptDTO dept) {
		Connection conn= DbUtil_Oracle.getConnect();
		PreparedStatement st = null;
		int result = 0;
		String sql= "insert into departments(department_id, department_name) values(?,?)";
		try {
			st = conn.prepareStatement(sql);
			//dept 안의 부서이름과 , id를 읽어오는 과정
			st.setInt(1, dept.getDepartment_id());
			st.setString(2, dept.getDepartment_name());
			result= st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//입력된 개수를 return한다.
		public int updateDept(DeptDTO dept) {
			Connection conn= DbUtil_Oracle.getConnect();
			PreparedStatement st = null;
			int result = 0;
			//부서 키에 해당되는 부서이름을 바꿔라
			String sql= "update departments set department_name=? where department_id=?";
			try {
				st = conn.prepareStatement(sql);
				//dept 안의 부서이름과 , id를 읽어오는 과정
				st.setString(1, dept.getDepartment_name());
				st.setInt(2, dept.getDepartment_id());
				result= st.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}
		
		public int deleteDept(int dept) {
			Connection conn= DbUtil_Oracle.getConnect();
			PreparedStatement st = null;
			int result = 0;
			//부서 키에 해당되는 부서이름을 바꿔라
			String sql= "delete from departments where department_id=?";
			try {
				st = conn.prepareStatement(sql);
				//dept 안의 부서이름과 , id를 읽어오는 과정
				st.setInt(1, dept);
				result= st.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}

}
