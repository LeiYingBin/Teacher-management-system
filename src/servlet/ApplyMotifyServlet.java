package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AbroadApplyRecorddao;
import entity.AbroadApplyRecord;

/**
 * Servlet implementation class ApplyMotifyservlet
 */
@WebServlet("/ApplyMotifyservlet")
public class ApplyMotifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyMotifyServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		AbroadApplyRecord apply = new AbroadApplyRecord();
		apply = (AbroadApplyRecord) request.getSession().getAttribute("motifyapply");
		apply.setCountry(request.getParameter("applycountry"));
		apply.setReasontype(request.getParameter("applyreasontype"));
		apply.setBeginTime(request.getParameter("applybegintime"));
		apply.setEndTime(request.getParameter("applyendtime"));
		apply.setReasonDetails(request.getParameter("applyreasondetail"));
		apply.setFundSource(request.getParameter("applyfundsource"));
//		System.out.println(apply);
		try {
			AbroadApplyRecorddao.motify(apply);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/teacherinform.jsp");
	}

}
