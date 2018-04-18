

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int sessionNumber = (int) request.getSession().getAttribute("sessionNumber");
		
		//get parameters
		String onlyOne = request.getParameter("onlyOne");
		String orgName = request.getParameter("orgName");
		String groupName = request.getParameter("groupName");
		String website = request.getParameter("website");
		String livingLocation = request.getParameter("livingLocation");
		String workingLocation = request.getParameter("workingLocation");
		String donations = request.getParameter("donations");
		String TOS = request.getParameter("TOS");
		if(TOS == null) TOS = request.getParameter("tOS");
		String skills = request.getParameter("skills");
		String desc = request.getParameter("desc");
		String type = request.getParameter("type");
		
		//Handle case where only one field needs to be edited
		if(onlyOne != null) {
			boolean result = false;
			String elementName = onlyOne;
			String value = request.getParameter("element");
			switch(elementName) {
			case "orgName":
				System.out.println("Entered orgName");
				result |= DumbDatabase.setOrgName(sessionNumber, value);
				break;
			case "groupName":
				System.out.println("Entered groupName");
				result |= DumbDatabase.setGroupName(sessionNumber, value);
				break;
			case "fName":
				System.out.println("fname");
				result |= DumbDatabase.setfName(sessionNumber, value);
				break;
			case "lName":
				System.out.println("lname");
				result |= DumbDatabase.setlName(sessionNumber, value);
				break;
			case "website":
				System.out.println("Entered website");
				result |= DumbDatabase.setWebsite(sessionNumber, value);
				break;
			case "livingLocation":
				System.out.println("Edited living location: " + value);
				result |= DumbDatabase.setLivingLocation(sessionNumber, value);
				break;
			case "workingLocation":
				System.out.println("Entered working location");
				result |= DumbDatabase.setWorkingLocation(sessionNumber, value);
				break;
			case "donations":
				System.out.println("Entered donations");
				result |= DumbDatabase.setDonation(sessionNumber, value);
				break;
			case "tOS":
				System.out.println("Entered TOS: " + value);
				result |= DumbDatabase.setTOS(sessionNumber, value);
				break;
			case "skills":
				System.out.println("Entered skills");
				result |= DumbDatabase.setSkills(sessionNumber, value);
				break;
			case "comments":
				System.out.println("Entetered comments");
				result |= DumbDatabase.setDescription(sessionNumber, value);
				break;
			case "email":
				System.out.println("Entered email");
				result |= DumbDatabase.setEmail(sessionNumber, value);
			break;
			case "phoneNumber":
				System.out.println("Entered phone number");
				result |= DumbDatabase.setPhoneNumber(sessionNumber, value);
				break;
			}
			if(result) response.getWriter().write("true");
			else response.getWriter().write("false");
			return;
		}
		
		
		if(!type.trim().toLowerCase().equals(request.getSession().getAttribute("type").toString().toLowerCase())) {
			response.getWriter().write("Are you trying to hack us?! If not, then "
					+ "there is some trouble in the connection, please log out then try again");
			return;
		}
		boolean result = true;
		if("organization".equals(type.trim().toLowerCase())) result &= DumbDatabase.setOrgName(sessionNumber, orgName); 
		if("group".equals(type.trim().toLowerCase())) result &= DumbDatabase.setGroupName(sessionNumber, groupName);
		if(website != null) result &= DumbDatabase.setWebsite(sessionNumber, website);
		if("donor".equals(type.trim().toLowerCase())) result &= DumbDatabase.setDonation(sessionNumber, donations);
		if("mentor".equals(type.trim().toLowerCase())) result &= DumbDatabase.setSkills(sessionNumber, skills);
		if(!"organization".equalsIgnoreCase(type.trim())) result &= DumbDatabase.setWorkingLocation(sessionNumber, workingLocation);
		result &= DumbDatabase.setTOS(sessionNumber, TOS);
		result &= DumbDatabase.setLivingLocation(sessionNumber, livingLocation);
		result &= DumbDatabase.setDescription(sessionNumber, desc);
		
		if(result) response.getWriter().write("true");
		else response.getWriter().write("false");
		
		}
		catch (Exception e) {e.printStackTrace(); }
	}

}