package com.deloitte.ecommerce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.ecommerce.dao.WalletDaoImpl;
import com.deloitte.ecommerce.service.CustomerServiceImpl;
import com.deloitte.ecommerce.service.ICustomerService;

@WebServlet(value = "/first")

public class Servlet1 extends HttpServlet {

	private ICustomerService service = new CustomerServiceImpl(new WalletDaoImpl());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		String mobileno = req.getParameter("mobileno");
		String password = req.getParameter("password");
		boolean correct = service.credentialsCorrect(mobileno, password);
		if (correct) {
			HttpSession session = req.getSession();
			session.setAttribute("mobileno", mobileno);
			resp.sendRedirect("/second");
		} else {
			resp.sendRedirect("html/form.html");

		}
	}
}
