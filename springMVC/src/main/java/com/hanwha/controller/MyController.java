package com.hanwha.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hanwha.model.DeptDAO_mybatis;
import com.hanwha.model.DeptDTO;
import com.hanwha.model.EmpDAO;
import com.hanwha.model.EmpService;
import com.hanwha.model.EmpVO;

//<bean id="myController", class="" > 이것과 같은 annotation
@Controller
public class MyController {
	//autowired쓰면 자동으로 new() 새로운 객체가 생성되서 들어온다. >이것과 같은 annotation
	//단, DAO가 repository여야한다.
	@Autowired
	DeptDAO_mybatis dao;
	

	//DeptDAO dao;
	/*
	 * @RequestMapping("/500") public String error500(Model model) {
	 * model.addAttribute("company", "한화ICT"); model.addAttribute("manager",
	 * "말랑카우"); model.addAttribute("phone", "010-2323-1515");
	 * 
	 * return "error500"; }
	 */
	
	@RequestMapping("/404")
	public String error404(Model model) {
		model.addAttribute("company", "한화ICT");
		model.addAttribute("manager", "말랑카우");
		return "error404";
	}
	@ExceptionHandler(Exception.class)
	public String error500(Exception ex, Model model) {
		model.addAttribute("company", "한화ICT");
		model.addAttribute("manager", "말랑카우");
		model.addAttribute("phone", "010-2323-1515");
		model.addAttribute("errormessage", ex.getMessage());
		return "error500";
	}
	
	@Autowired
	EmpDAO dao2;
	
	//부서 리스트 전부조회
	@RequestMapping("/dept/deptlist2") //요청의 이름 = 주소창이름
	public String deptlist(Model model) {
		model.addAttribute("deptlist",dao.selectAll());
		return "dept/deptlist"; // view의 이름 = 페이지 이름(요청의 이름과 달라도 된다)
	}
	
	//부서 아이디에 해당하는 상세보기
	@RequestMapping(value="/dept/deptdetail", method=RequestMethod.GET)
	public String deptDetailGet(int deptid, Model model) {
		model.addAttribute("dept", dao.selectByID(deptid));
		System.out.println(dao.selectByID(deptid));
		return "dept/deptdetail";
	}
	

	
	
	//상세내용 수정
	@RequestMapping(value="/dept/deptdetail", method=RequestMethod.POST)
	public String deptDetailPost(DeptDTO dept) {
		dao.updateDept(dept);
		return "redirect:deptlist2";
	}
	
	//부서입력: 폼 보여주기
	@RequestMapping(value="/dept/deptinsert", method=RequestMethod.GET)
	public String deptInsertGet() {
		return "dept/deptinsert";
	}
	
	// 부서입력:
	@RequestMapping(value = "/dept/deptinsert", method = RequestMethod.POST)
	public String deptInsertPost(DeptDTO dept, HttpServletRequest request) {
		MultipartFile uploadfile = dept.getUploadfile();
		if (uploadfile == null)
			return "redirect:deptinsert";

		String path = request.getSession().getServletContext().getRealPath("/resources");
		System.out.println("웹 서버의 실제경로: " + path);
		String fileName = uploadfile.getOriginalFilename();
		String fpath = path + "\\" + fileName;
		dept.setFileName(fileName);
		try {// 방법1) FileOutputStream 사용
				// byte[] fileData = file.getBytes();
				// FileOutputStream output = new FileOutputStream(fpath);
				// output.write(fileData);
				// 2. File 사용
			File file = new File(fpath);
			uploadfile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dao.insertDept(dept);
		return "redirect:deptlist2";
	}
		
		
	
	@RequestMapping("/dept/deptdelete")
	public String deptDeleteGet(int deptid) {
		dao.deleteDept(deptid);
		return "redirect:deptlist2";
	}
	
	@Autowired
	EmpService service;
	
	@RequestMapping("/emp/emplist")
	public ModelAndView selectAll() {
		ModelAndView mv= new ModelAndView();
		mv.addObject("empAll", service.selectAll());
		mv.setViewName("emp/empAll");
		return mv;
	}
	
	@RequestMapping("/emp/empdetail")
	public ModelAndView selectDetail(int empid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp", service.selectByID(empid));
		mv.addObject("deptlist", dao.selectAll());
		mv.addObject("joblist", service.selectAllJob());
		mv.addObject("managerlist", service.selectAllManager());
		mv.setViewName("emp/empdetail");
		return mv;
	}
	
		//상세내용 수정
		@RequestMapping(value="/emp/empdetail", method=RequestMethod.POST)
		public String updateEmp(EmpVO empvo) {
			ModelAndView mv= new ModelAndView();
			mv.addObject("emp", service.updateEmp(empvo));
			
			return "redirect:emplist";
		}
		
		//insert
		
		//직원입력: 폼 보여주기
		@RequestMapping(value="/emp/empinsert", method=RequestMethod.GET)
		public ModelAndView empInsertGet() {
			ModelAndView mv = new ModelAndView();
			mv.addObject("deptlist", dao.selectAll());
			mv.addObject("joblist", service.selectAllJob());
			mv.addObject("managerlist", service.selectAllManager());
			return mv;
		}
		
		@RequestMapping(value="/emp/empinsert", method=RequestMethod.POST)
		public String insertEmp(EmpVO emp) {
			service.insertEmp(emp);
			return "redirect:emplist";
		}
		
		@RequestMapping(value="/emp/empdelete")
		public String deleteEmp(int empid) {
			service.deleteEmp(empid);
			return "redirect:emplist";
		}
		
		@RequestMapping("/dept/deptdownload")
		public void download(String folder, String file, HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setHeader("Content-Disposition", "attachment;filename=" + file);
		String fullPath = request.getSession().getServletContext().getRealPath(folder + "/" + file);
		FileInputStream fi = new FileInputStream(fullPath);
		ServletOutputStream sout = response.getOutputStream();
		byte[] buf = new byte[1024];
		int size = 0;
		while ((size = fi.read(buf, 0, 1024)) != -1) {
			sout.write(buf, 0, size);
		}
		fi.close();
		sout.close();
		}
		
		
}






	//DeptDAO dao = new DAO();
	//<bean id="dao" class="com.hanhwa.model.DeptDAO"/>
	
	//<bean id="myController", class="" >
	//	<property name="dao" ref="dao">
	//</bean>