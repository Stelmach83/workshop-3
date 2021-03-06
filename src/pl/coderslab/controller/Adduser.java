package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Group;
import pl.coderslab.model.User;
import pl.coderslab.utils.DbUtil;

@WebServlet("/addUser")
public class Adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Adduser() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		Cookie[] check = request.getCookies();
		Group[] groups = null;
		User[] users = null;

		HttpSession sess = request.getSession();

		if (request.getParameter("add") == null) {
			response.sendRedirect("panel");
		} else {
			if (sess.getAttribute("sessionAdmin") != null) {
				if (sess.getAttribute("sessionAdmin").equals("true")) {
					if (check != null) {
						for (Cookie c : check) {
							if ("panelLogin".equals(c.getName())) {
								request.setAttribute("admin", "true");
								try {
									groups = GroupDao.loadAllGroups();
									users = UserDao.loadAllUsers();

								} catch (SQLException e) {
									e.printStackTrace();
								}
							}

						}
					}
				}
			}
			request.setAttribute("addnew", "true");
			request.setAttribute("groups", groups);
			request.setAttribute("users", users);
			getServletContext().getRequestDispatcher("/WEB-INF/views/panel.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		Cookie[] check = request.getCookies();
		Group[] groups = null;
		User[] users = null;

		HttpSession sess = request.getSession();
		if (sess.getAttribute("sessionAdmin") != null) {
			if (sess.getAttribute("sessionAdmin").equals("true")) {
				if (check != null) {
					for (Cookie c : check) {
						if ("panelLogin".equals(c.getName())) {
							try {
								String email = request.getParameter("email");
								String username = request.getParameter("name");
								String password = request.getParameter("pass");
								String userg_id = request.getParameter("group");
								int usergroup_id = Integer.parseInt(userg_id);
								if (checkIfEmailExists(email) || "".equals(email) || !email.contains("@")
										|| email.charAt(0) == ' ') {
									groups = GroupDao.loadAllGroups();
									users = UserDao.loadAllUsers();
									request.setAttribute("invalidemail", "true");
									request.setAttribute("addnew", "true");
								} else {
									User newUser = new User(username, password, email, usergroup_id);
									UserDao.saveToDB(newUser);
									users = UserDao.loadAllUsers();
								}
							} catch (NumberFormatException e) {
								e.printStackTrace();
							} catch (SQLException e) {
								e.printStackTrace();
							}
							request.setAttribute("admin", "true");
							request.setAttribute("groups", groups);
							request.setAttribute("users", users);
						}
					}
				}
			}
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/panel.jsp").forward(request, response);
	}

	public static boolean checkIfEmailExists(String email) throws SQLException {
		Connection conn = DbUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<String> userEmails = new ArrayList<>();
		try {
			ps = conn.prepareStatement("SELECT email FROM Users");
			rs = ps.executeQuery();
			while (rs.next()) {
				String userEmail = rs.getString("email");
				userEmails.add(userEmail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (userEmails.contains(email)) {
			rs.close();
			rs = null;
			ps.close();
			ps = null;
			conn.close();
			conn = null;
			return true;
		}
		rs.close();
		rs = null;
		ps.close();
		ps = null;
		conn.close();
		conn = null;
		return false;
	}

}
