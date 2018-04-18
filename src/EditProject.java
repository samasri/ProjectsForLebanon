

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditProject")
public class EditProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sessionNumber = (int) request.getSession().getAttribute("sessionNumber");
		
		String name = request.getParameter("name");
		String TOS = request.getParameter("TOS");
		String date = request.getParameter("date");
		String location = request.getParameter("location");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String skills = request.getParameter("skills");
		String donations = request.getParameter("donations");
		String comments = request.getParameter("comments");
		int projectId = Integer.parseInt(request.getParameter("id"));
		
		String element = request.getParameter("element");
		String value = request.getParameter("value");
		if(element != null) {
			switch (element) {
			case "name":
				name = value;
				System.out.println("Name: " + name);
				break;
			case "TOS":
				TOS = value;
				System.out.println("TOS: " + TOS);
				break;				
			case "date": 
				date = value;
				System.out.println("Date: " + date);
				break;				
			case "location":
				location = value;
				System.out.println("Location: " + location);
				break;
			case "fName":
				fName = value;
				System.out.println("fName: " + fName);
				break;
			case "lName":
				lName = value;
				System.out.println("lName: " + lName);
				break;
			case "phoneNumber":
				if(value.isEmpty()) return;
				phoneNumber = value;
				System.out.println("PhoneNumber: " + phoneNumber);
				break;
			case "email":
				email = value;
				System.out.println("Email: " + email);
				break;
			case "age":
				if(value.isEmpty()) return;
				age = value;
				System.out.println("Age: " + age);
				break;
			case "skills":
				skills = value;
				System.out.println("Skills: " + skills);
				break;
			case "needs":
				donations = value;
				System.out.println("Donations: " + donations);
				break;
			case "comments":
				comments = value;
				System.out.println("Comments: " + comments);
				break;
			}
		}
		
		
		boolean result = true;
		try {
		if(name != null) result &= DumbDatabase.setProjectName(sessionNumber, projectId, name);
		if(TOS != null) result &= DumbDatabase.setProjectTOS(sessionNumber, projectId, TOS);
		if(date != null) result &= DumbDatabase.setProjectDate(sessionNumber, projectId, date);
		if(result) response.getWriter().write("true");
		else response.getWriter().write("false");
		if(location != null) result &= DumbDatabase.setProjectLocation(sessionNumber, projectId, location);
		if(fName != null) result &= DumbDatabase.setProjectfName(sessionNumber, projectId, fName);
		if(lName != null) result &= DumbDatabase.setProjectlName(sessionNumber, projectId, lName);
		if(phoneNumber != null) result &= DumbDatabase.setProjectPhoneNumber(sessionNumber, projectId, phoneNumber);
		if(email != null) result &= DumbDatabase.setProjectEmail(sessionNumber, projectId, email);
		if(age != null) result &= DumbDatabase.setProjectAge(sessionNumber, projectId, age);
		if(skills != null) result &= DumbDatabase.setProjectSkills(sessionNumber, projectId, skills);
		if(donations != null) result &= DumbDatabase.setProjectDonations(sessionNumber, projectId, donations);
		if(comments != null) result &= DumbDatabase.setProjectComments(sessionNumber, projectId, comments);
		
		/*if(result) response.getWriter().write("true");
		else response.getWriter().write("false");*/
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
