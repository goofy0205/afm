package com.kh.afm.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.afm.user.model.vo.User;

@WebFilter({ 
	"/user/userDetail", 
	"/user/userDelete", 
	"/user/userUpdate",
	"/csboard/csboardList",
	"/csboard/csboardForm",
	"/csboard/csboardUpdate",
	"/csboard/csboardDelete",
	"/csboard/csboardView",
	"/csboard/productReportForm",
	"/product/productForm",
	"/product/productUpdate",
	"/product/productDelete",
	"/cart/cartList",
	"/cart/cartDeleteAll",
	"/cart/cartUpdate",
	"/cart/deleteOneItem",
	"/csboard/productReportForm",
	"/admin/adminMain",
	"/admin/deleteDelUser",
	"/admin/delUserList",
	"/admin/processReport",
	"/admin/updateProductExpose",
	"/admin/productFinder",
	"/admin/productList",
	"/admin/productSort",
	"/admin/productReportList",
	"/admin/userAddressList",
	"/admin/updateUserExpose",
	"/admin/userSort",
	"/admin/userList",
	"/admin/userFinder"
})
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// login여부확인
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		User loginMember = (User) session.getAttribute("loginUser");
		
		if(loginMember == null) {
			session.setAttribute("msg", "로그인후 이용할 수 있습니다.");
			HttpServletResponse httpRes = (HttpServletResponse) response; 
			httpRes.sendRedirect(httpReq.getContextPath() + "/user/userLogin");
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
}
