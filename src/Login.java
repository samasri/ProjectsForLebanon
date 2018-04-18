

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		//Get params
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		
		int sessionNumber = DumbDatabase.getSessionNumber(username, password);
		request.getSession().setAttribute("sessionNumber", sessionNumber); 
		
		if((int) request.getSession().getAttribute("sessionNumber") == -1) {
			response.getWriter().write("fail");
		}
		else {
			UserType type = DumbDatabase.getUserType(sessionNumber);
			request.getSession().setAttribute("type", type);
			if(DumbDatabase.isNewUser(sessionNumber)) {
				DumbDatabase.makeOld(sessionNumber);
				response.getWriter().write("/Project/UploadPicture"); 			
			}
			else response.getWriter().write("/Project/Dashboard");
		}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
