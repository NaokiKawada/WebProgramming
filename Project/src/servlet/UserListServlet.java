package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserInfo;
import dao.UserDao;
import dao.UserInfoDao;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/UserList")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
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


		UserInfoDao dao = new UserInfoDao();
        List<UserInfo> userInfoList = dao.findAll();


		// 取得したリストをリクエストスコープに保存

        request.setAttribute("userInfoList", userInfoList);

  	  	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        String loginid = request.getParameter("loginid");
        String name = request.getParameter("name");
        String birthdayFrom = request.getParameter("birthdayFrom");
		String birthdayTo = request.getParameter("birthdayTo");

		UserDao dao = new UserDao();
        List<UserInfo> usersearchList;
		try {
			usersearchList = dao.searchUser(loginid, name,birthdayFrom,birthdayTo);
	        request.setAttribute("userInfoList", usersearchList);

	  	  	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
	        dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}



       }
}
