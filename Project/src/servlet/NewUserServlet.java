package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserInfo;
import dao.UserInfoDao;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 HttpSession session = request.getSession();
		 if(session.getAttribute("userinfo") == null) {
			 response.sendRedirect("Index");
			 return;
		 }

        String loginId = request.getParameter("loginid");


        UserInfoDao dao = new UserInfoDao();
        UserInfo user = dao.findbylogin(loginId);

        request.setAttribute("user", user);

  	  	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newUser.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");




        String loginid = request.getParameter("loginid");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");

		boolean isError = false;

		if(loginid.equals("")||password.equals("")||name.equals("")||birthday.equals("")) {
			isError = true;
		}


		if(!password.equals(password2)) {
			isError = true;
		}

        UserInfoDao dao = new UserInfoDao();
        boolean Ischeck = dao.searchbylogin(loginid);
        if(Ischeck) {
        	isError = true;
        }

        if(isError) {
        	  request.setAttribute("error","入力された内容は正しくありません");
        	  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newUser.jsp");
        	    dispatcher.forward(request, response);
        	} else {
        	  dao.findbylogin(loginid, password,name,birthday);
        	  response.sendRedirect("UserList");
        	}

	}

}
