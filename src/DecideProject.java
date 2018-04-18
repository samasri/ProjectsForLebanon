

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DecideProject")
public class DecideProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DecideProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sessionNumber = (int) request.getSession().getAttribute("sessionNumber");
		
		//Get Paramters
		String choice = request.getParameter("choice");
		int projectID = Integer.parseInt(request.getParameter("project"));
		String comment = request.getParameter("comment");
		String groupEmail = request.getParameter("group");
		
		try {
		if("yes".equals(choice)) DumbDatabase.acceptConnection(sessionNumber, projectID, groupEmail, comment);
		if("no".equals(choice)) DumbDatabase.rejectConnection(sessionNumber, projectID, groupEmail, comment);
		
		}
		catch(Exception e) { e.printStackTrace();}
	}

}
