package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AbroadApplyRecorddao;
import entity.AbroadApplyRecord;
import entity.UserAccount;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/ApplyServlet")
public class ApplyAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyAddServlet() {
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
		System.out.println("ApplyAddServlet");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		AbroadApplyRecord apply = new AbroadApplyRecord();
		apply.setUserId(request.getParameter("applyid"));
//		apply.setSerialNum((int)request.getAttribute("applynum"));
		apply.setUserName(request.getParameter("applyname"));
		apply.setCountry(request.getParameter("applycountry"));
		apply.setReasontype(request.getParameter("applyreasontype"));
		apply.setBeginTime(request.getParameter("applybegintime"));
		apply.setEndTime(request.getParameter("applyendtime"));
		apply.setAbroadState("Î´³ö¹ú");
		apply.setReasonDetails(request.getParameter("applyreasondetail"));
		apply.setAuditState("´ýÉóºË");
		apply.setApplyTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		apply.setFundSource(request.getParameter("applyfundsource"));
		System.out.println(apply);
		try {
			AbroadApplyRecorddao.addApply(apply);  
		} catch (Exception e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/teacherinform.jsp");
		}
}
