package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import entity.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
     }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AbroadApplyRecord> applys= new ArrayList<AbroadApplyRecord>();
		String ID = request.getParameter("ID");
		String password = request.getParameter("password");
		
		UserAccount user = new UserAccount();
		try {
			user = UserAccountdao.getUser(ID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//判断用户名和密码是否合法
		if(user.getUserPwd().equals(password)){
			request.getSession().setAttribute("user",user);
			response.sendRedirect(request.getContextPath()+"/teacherinform.jsp");
		}else
			response.sendRedirect(request.getContextPath()+"/failure.jsp");
	}

}
