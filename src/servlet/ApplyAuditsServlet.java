package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AbroadApplyRecorddao;

/**
 * Servlet implementation class ApplyAuditsServlet
 */
@WebServlet("/ApplyAuditsServlet")
public class ApplyAuditsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyAuditsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ApplyAuditsServlet");
		String a = request.getParameter("number");
//		System.out.println(a);
		String b[] = a.split(",");
		System.out.println(b[0]+" "+b[1]);
		
		
		try {
			if(b[0].equals("0")){
//					System.out.println("不通过");	
				AbroadApplyRecorddao.ApplyAudits(Integer.parseInt(b[1]), "不通过");
			}else{
//				System.out.println("通过");
				AbroadApplyRecorddao.ApplyAudits(Integer.parseInt(b[1]), "通过");
				}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/audits.jsp");	
		
	}

}
