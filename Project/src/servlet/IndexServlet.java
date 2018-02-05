package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserInfoDao;
import model.UserInfo;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 HttpSession session = request.getSession();
		 if(session.getAttribute("userinfo") == null) {
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		        dispatcher.forward(request, response);
		 } else {
			 response.sendRedirect("UserList");
		 }


	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String loginId = request.getParameter("loginid");
        String password = request.getParameter("password");

        UserInfoDao dao = new UserInfoDao();
        UserInfo userInfo = dao.findbylogin(loginId, password);

        if(userInfo == null) {
        	  request.setAttribute("error","入力された内容は正しくありません");
        	  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
              dispatcher.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("userinfo", userInfo);
            response.sendRedirect("UserList");


        }


	}

}
