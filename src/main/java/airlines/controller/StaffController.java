package airlines.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airlines.dao.staffDAO;
import airlines.dao.userDAO;
import airlines.model.staff;

/**
 * Servlet implementation class StaffController
 */
@WebServlet("/StaffController")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private staffDAO sdao;
	private userDAO udao;
    String action="";
    String forward="";
    String role ="";
    RequestDispatcher view;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffController() {
        super();
        sdao = new staffDAO();
        udao = new userDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("viewProfileStaff")) {
			forward = "staff/StaffProfile.jsp";
			int uid = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("staff", staffDAO.getStaffByUId(uid));
		}
		
		if(action.equalsIgnoreCase("updateStaff")) {
			forward = "staff/StaffProfileEdit.jsp";
			int uid = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("staff", staffDAO.getStaffByUId(uid));
		}
		
		if(action.equalsIgnoreCase("viewStaff")) {
			forward ="staff/viewStaff.jsp";
			int uid = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("staff", staffDAO.getStaffById(uid));
		}
		
		if (action.equalsIgnoreCase("staffList")) {
			forward = "staff/staffList.jsp";
			request.setAttribute("staff", staffDAO.getAllStaff());
		}
		
		if(action.equalsIgnoreCase("deleteAcc")) {
            int uid= Integer.parseInt(request.getParameter("id"));
            udao.deleteUser(uid);

            forward = "staff/HomeStaff.jsp";
        }
		
		if (action.equalsIgnoreCase("addStaff")){
			forward = "staff/AddStaff.jsp";
			}
		
		 view = request.getRequestDispatcher(forward);
	     view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		staff staff = new staff();
		int staffuid = Integer.parseInt(request.getParameter("staffuid"));
		String staffname = request.getParameter("staffname");
		
		staff.setStaffname(staffname);
		staff.setUserid(staffuid);
		
		sdao.updateStaff(staff);
		
		request.setAttribute("staff", staffDAO.getStaffByUId(staffuid));
		view = request.getRequestDispatcher("staff/viewStaff.jsp");
		view.forward(request, response);
		
	}

}
