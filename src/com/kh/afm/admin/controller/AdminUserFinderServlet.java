package com.kh.afm.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.afm.admin.model.service.AdminService;
import com.kh.afm.common.MvcUtils;
import com.kh.afm.user.model.vo.User;

/**
 * 회원 검색 
 */
@WebServlet("/admin/userFinder")
public class AdminUserFinderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminService(); 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 검색유형, 검색키워드
			String searchType = request.getParameter("searchType");
			String searchKeyword = request.getParameter("searchKeyword");
			
			// 검색결과 페이징 처리
			int cPage = 1;
			int numPerPage = 10;
			try {
				cPage = Integer.parseInt(request.getParameter("cPage"));
			} catch(NumberFormatException e) {
				// 처리코드 없음
			}
			int start = cPage * numPerPage - (numPerPage - 1);
			int end = cPage * numPerPage;
			
			// 업무로직
			Map<String, Object> param = new HashMap<>();
			param.put("searchType", searchType);
			param.put("searchKeyword", searchKeyword);
			param.put("start", start);
			param.put("end", end);
			
			// 검색결과 리스트 
			List<User> list = adminService.searchUser(param);
			
			// 페이지바
			int totalContents = adminService.searchUserCount(param);
			String queryString = String.format("?searchType=%s&searchKeyword=%s", searchType, searchKeyword);
			String url = request.getRequestURI() + queryString; 
			String pagebar = MvcUtils.getPagebar(cPage, numPerPage, totalContents, url);
			
			// view단처리
			request.setAttribute("list", list);
			request.setAttribute("pagebar", pagebar);
			request
				.getRequestDispatcher("/WEB-INF/views/admin/userList.jsp")
				.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
