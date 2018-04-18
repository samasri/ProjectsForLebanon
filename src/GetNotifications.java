import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetNotifications")
public class GetNotifications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetNotifications() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int sessioNumber = (int) request.getSession().getAttribute("sessionNumber");
		
		Notification[] notifications = DumbDatabase.getNotifications(sessioNumber);
		
		if(notifications == null) return;
		
		PrintWriter p = response.getWriter();
		
		for(int i = 0; i < notifications.length; i++) {
			Notification current = notifications[i];
			writeJSON(current, p);
			p.write("\n");
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void writeJSON(Notification current, PrintWriter p) {
		p.write("{ \"type\" : \"" + current.type + "\", ");
		p.write("\"groupName\" : \"" + current.groupName + "\", ");
		p.write("\"groupEmail\" : \"" + current.groupEmail + "\", ");
		p.write("\"projectName\" : \"" + current.projectName + "\", ");
		p.write("\"comment\" : \"" + current.comment + "\", ");
		p.write("\"projectID\" : \"" + current.projectID + "\" }");
	}

}
