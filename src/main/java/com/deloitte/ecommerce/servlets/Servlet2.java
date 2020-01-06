package com.deloitte.ecommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.ecommerce.dao.WalletDaoImpl;
import com.deloitte.ecommerce.entities.Wallet;
import com.deloitte.ecommerce.service.CustomerServiceImpl;
import com.deloitte.ecommerce.service.ICustomerService;

@WebServlet("/second")

public class Servlet2 extends HttpServlet{
	
	private ICustomerService service=new CustomerServiceImpl(new WalletDaoImpl());
	
	 @Override
	    protected void doGet(HttpServletRequest req,
	                         HttpServletResponse resp)
	            throws ServletException, IOException {
	        resp.setContentType("text/html");
	        resp.setCharacterEncoding("UTF-8");
	        PrintWriter writer = resp.getWriter();
	        HttpSession session = req.getSession();
	        String signedOutVal = req.getParameter("signout");
	        boolean sessionDestroyed = false;
	        if (signedOutVal != null && signedOutVal.equals("true")) {
	            session.invalidate();
	            sessionDestroyed = true;
	        }
	        Object mobilenoObj=null;
	        if (!sessionDestroyed) {
	            mobilenoObj = session.getAttribute("mobileno");
	        }
	        
	        if (mobilenoObj == null || mobilenoObj.toString().isEmpty()) {
	            resp.getWriter().println("you are not signed in yet");
	            String signInLink = "<a href='/form.html'>Sign In </a> ";
	            writer.println(signInLink);
	            return;
	        }
	        
	        String mobileno=mobilenoObj.toString();
	        Wallet user=service.findByMobileno(mobileno);
	        String name=user.getName();
	        double balance=user.getBalance();
	        writer.println("Welcome " + name);
	        writer.println("your mobileno is "+mobileno);
	        writer.println("your current balance is "+balance);
	        String signoutLink = "<a href='/second?signout=true'>Sign out </a> ";
	        writer.println(signoutLink);

	

}
}
