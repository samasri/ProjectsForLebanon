

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TogglePrivacy")
public class TogglePrivacy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TogglePrivacy() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int sessionNumber = (int) request.getSession().getAttribute("sessionNumber");
		String whatPrivacy = request.getParameter("typeOfPrivacy");
		
		if("email".equals(whatPrivacy)) {
			DumbDatabase.toggleEmailPrivacy(sessionNumber);
			response.getWriter().write("success");
		}
		else if("phoneNumber".equals(whatPrivacy)) {
			DumbDatabase.togglePhoneNumberPrivacy(sessionNumber);
			response.getWriter().write("success");
		}
		else {
			response.getWriter().write("fail");
		}
		
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
