

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetProjects")
public class GetProjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetProjects() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int sessionNumber = (int) request.getSession().getAttribute("sessionNumber");
		Project[] projects = DumbDatabase.getProjects(sessionNumber);
		
		PrintWriter p = response.getWriter();
		for(int i = 0; i < projects.length; i++) {
			writeJSON(projects[i], p, sessionNumber);
			p.write("\n");
		}
		
		}
		catch(Exception e) {e.printStackTrace();}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public void writeJSON(Project current, PrintWriter p, int sessionNumber) throws Exception {
		p.write("{ \"picURL\" : \"" + current.picURL + "\", ");
		p.write("\"name\" : \"" + current.name + "\", ");
		p.write("\"projectID\" : \"" + current.projectID+ "\", ");
		p.write("\"owner\" : \"" + DumbDatabase.isProjectOwner(sessionNumber, current.projectID) + "\", ");
		p.write("\"status\" : \"" + current.status + "\" }");
	}
}
