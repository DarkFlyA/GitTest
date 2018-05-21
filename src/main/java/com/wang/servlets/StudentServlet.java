package com.wang.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jason.page.bean.PageInfo;
import com.jason.util.DBHelper;
import com.wang.beans.Student;
import com.wang.dao.StudentDao;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/stu")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		StudentDao dao = DBHelper.getDao(StudentDao.class);
		String pageCountStr = request.getParameter("pageCount");
		String pageSizeStr = request.getParameter("pageSize");
		String ajax = request.getParameter("ajax");
		int pageCount, pageSize;
		if (pageCountStr == null || !pageCountStr.matches("\\d+")) {
			pageCount = 1;
		} else {
			pageCount = Integer.valueOf(pageCountStr);
			pageCount = pageCount > 0 ? pageCount : 1;
		}
		if (pageSizeStr == null || !pageSizeStr.matches("\\d+")) {
			pageSize = 4;
		} else {
			pageSize = Integer.valueOf(pageSizeStr);
			pageSize = pageSize > 0 ? pageSize : 4;
		}
		
		DBHelper.startPage(pageCount, pageSize);
		//构建分页结果对象
		PageInfo<Student> pageInfo = (PageInfo<Student>) dao.queryStudent();
		if (!"true".equals(ajax)) {
			request.setAttribute("pageInfo", pageInfo);
			request.getRequestDispatcher("/student.jsp").forward(request, response);
		} else {
			Gson gson = new Gson();
			response.getWriter().println(gson.toJson(pageInfo));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
