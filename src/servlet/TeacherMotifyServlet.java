package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Teacherdao;
import entity.Teacher;
import entity.UserAccount;

/**
 * Servlet implementation class TeacherMotifyServlet
 */
@WebServlet("/TeacherMotifyServlet")
public class TeacherMotifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherMotifyServlet() {
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
		System.out.println("TeacherMotifyServlet");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
		teacher.settName(request.getParameter("motifyname"));
		teacher.settSex(request.getParameter("motifysex"));
		teacher.settBirthday(request.getParameter("motifybirthday"));
		teacher.settTitle(request.getParameter("motifytitle"));
		teacher.settEducation(request.getParameter("motifyeducation"));
		teacher.settCollege(request.getParameter("motifycollege"));
		try {
			Teacherdao.motify(teacher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(teacher);
		response.sendRedirect(request.getContextPath()+"/successmodify.jsp");
	}

}
