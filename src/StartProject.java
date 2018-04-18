

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StartProject")
public class StartProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StartProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sessionNumber = (int) request.getSession().getAttribute("sessionNumber");
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		PrintWriter p = response.getWriter();
		try {
		if(DumbDatabase.startProject(sessionNumber, projectId)) p.write("success");
		else p.write("Your project is not yet approved by the admin");
		
		}
		catch (Exception e) { e.printStackTrace();}
	}

}
