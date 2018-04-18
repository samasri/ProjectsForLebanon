

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetSearch")
public class GetSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sessionNumber = (int) request.getSession().getAttribute("sessionNumber");
		
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		
		PrintWriter p = response.getWriter();
		
		Volunteer[] result = DumbDatabase.getVolunteerSearch(sessionNumber, type, keyword);
		
		for(int i = 0; i < result.length; i++) {
			writeJSON(result[i], p);
			p.write("\n");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public void writeJSON(Volunteer current, PrintWriter p) {
		p.write("{ \"fname\" : \"" + current.fname + "\", ");
		p.write("\"imgURL\" : \"" + current.imgURL + "\", ");
		p.write("\"lname\" : \"" + current.lname + "\", ");
		p.write("\"orgName\" : \"" + current.orgName + "\", ");
		p.write("\"workingLocation\" : \"" + current.workingLocation + "\", ");
		p.write("\"email\" : \"" + current.email+ "\", ");
		p.write("\"donations\" : \"" + current.donations+ "\", ");
		p.write("\"skills\" : \"" + current.skills+ "\", ");
		p.write("\"workingLocation\" : \"" + current.workingLocation + "\" }");
	}
}
