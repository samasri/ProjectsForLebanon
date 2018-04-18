

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		int sessionNumber = (int) request.getSession().getAttribute("sessionNumber");
		boolean isOwner = true;
		String email = request.getParameter("email");
		UserType type = DumbDatabase.getUserType(email);
		Volunteer current;
		if(email == null) {
			current = DumbDatabase.getVolunteer(sessionNumber);
			type = DumbDatabase.getUserType(sessionNumber);
		}
		else {
			isOwner = false;
			current = DumbDatabase.getVolunteer(email);
		}
		
		PrintWriter p = response.getWriter();
		
		p.write("<!doctype html>");
		p.write("<html>");
		writeHeader(p);
		p.write("<body>");
		writeSearch(p);
		
		p.write("<div id='subConent'>");
		p.write("<div id='imgDiv'>");
		
		
		
		p.write("<!-- Header content -->");
		p.write("<header> <!-- Identity details -->");
		p.write("<div class='image'>");
		p.write("<img src='img/profile.png' alt='' width='350'>");
		p.write("    <input name='button' type='button' class='button' id='button' value='Upload Picture'>");
		p.write("  </div>");
		p.write("  <section class='profileHeader'>");
		p.write("    <h1 class='profile'>Your Profile</h1>");
		p.write("<div class='profile'>");
		p.write("  <h3>About You</h3>");

		p.write("  <p>");
		

		if(type == UserType.Organization) {
			p.write("      <p>");
			p.write("          <label for='textfield2'>Name: &nbsp; </label>");
			p.write("          <input name='textfield2' type='text' class='inputs-edit' id='orgName' value='" + current.orgName + "' readonly>");
			p.write("          <button type='button' id='editOrgName' class='btn btn-sm btn-default button-edit'>Edit</button>");
			p.write("      </p>");
		}
		else if(type == UserType.Group) {
			p.write("      <p>");
			p.write("          <label for='textfield2'>Group Name: &nbsp; </label>");
			p.write("          <input name='textfield2' type='text' class='inputs-edit' id='groupName' value='" + current.groupName + "' readonly>");
			p.write("          <button type='button' id='editGroupName' class='btn btn-sm btn-default button-edit'>Edit</button>");
			p.write("      </p>");
		}
		//if(type == UserType.Organization || type == UserType.Group) {
			p.write("<div id='contactPerson'>");
			p.write("Contact info:<br>");
			
			p.write("      <p>");
			p.write("          <label for='textfield2'>First Name: &nbsp; </label>");
			p.write("          <input name='textfield2' id='fName' type='text' class='inputs-edit' value='" + 
			current.fname + "' readonly>");
			if(isOwner) p.write("          <button type='button' id='editFName' class='btn btn-sm btn-default button-edit'>Edit</button>");
			p.write("      </p>");
			
			p.write("      <p>");
			p.write("          <label for='textfield2'>Last Name: &nbsp; </label>");
			p.write("          <input name='textfield2' id='lName' type='text' class='inputs-edit' value='" + 
			current.lname + "' readonly>");
			if(isOwner) p.write("          <button type='button' id='editLName' class='btn btn-sm btn-default button-edit'>Edit</button>");
			p.write("      </p>");
			
			if(isOwner || (!isOwner && current.emailPublic)) {
				p.write("      <p>");
				p.write("          <label for='textfield2'>Email: &nbsp; </label>");
				p.write("          <input id='email' name='textfield2' type='text' class='inputs-edit' value='" + 
				current.email + "' readonly>");
				p.write("          <button type='button' id='editEmail' class='btn btn-sm btn-default button-edit'>Edit</button>");
				p.write("      </p>");
				 
			}
			if(isOwner) {
				
				p.write("Your email is <b>" + ((current.emailPublic) ? "visible" : "not visible") + "</b> to others " +
						" <button class='btn btn-sm btn-default' id='toggleEmail'> Toggle privacy </button> <br> ");
			}
			else p.write("<br>");
			
			if(isOwner || (!isOwner && current.emailPublic)) p.write("Mobile Number: <input id='phoneNumber' type='text' value='" + 
						current.phoneNumber + "' readonly>");
			if(isOwner) {
				CommonMethods.writeEditButton(p, "editPhoneNumber", isOwner, true);
				p.write("Your phone Number is <b>" + ((current.phoneNumberPublic) ? "visible" : "not visible") + " </b> to others " +
						" <button class='btn btn-sm btn-default' id='togglePhoneNumber'> Toggle privacy </button> <br> ");
			}
			
			if(type == UserType.Mentor) {
				p.write("      <p>");
				p.write("          <label for='textfield2'>Skills: &nbsp; </label>");
				p.write("          <input name='textfield2' id='skills' type='text' class='inputs-edit' value='" + 
				current.skills + "' readonly>");
				if(isOwner) p.write("          <button type='button' id='editSkills' class='btn btn-sm btn-default button-edit'>Edit</button>");
				p.write("      </p>");
			}
			
			if(type == UserType.Donor) {
				p.write("      <p>");
				p.write("          <label for='textfield2'>Donations: &nbsp; </label>");
				p.write("          <input name='textfield2' id='donations' type='text' class='inputs-edit' value='" + 
				current.donations  + "' readonly>");
				if(isOwner) p.write("          <button type='button' id='editDonations' class='btn btn-sm btn-default button-edit'>Edit</button>");
				p.write("      </p>");
			}			
			p.write("</div>");
		//}
			
		if(current.website != null) {
			p.write("      <p>");
			p.write("          <label for='textfield2'>Website: &nbsp; </label>");
			p.write("          <input name='textfield2' id='website' type='text' class='inputs-edit' value='" + 
			current.donations  + "' readonly>");
			if(isOwner) p.write("          <button type='button' id='editWebsite' class='btn btn-sm btn-default button-edit'>Edit</button>");
			p.write("      </p>");
			
		}
		
		p.write("      <p id='TOSp'>");
		p.write("          <label id='TOS1' for='textfield2'>Type of Service: &nbsp; </label>");
		p.write("          <input id='TOS2' name='textfield2' id='webSpan' type='text' class='inputs-edit' value='" + 
		current.TOS  + "' readonly>");
		if(isOwner) p.write("          <button type='button' id='editTOS' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("      </p>");
		
		
		if(type == UserType.Organization) {
			
			p.write("      <p id=livingLocationP>");
			p.write("          <label id='livivngLocation1' for='textfield2'>Headquarters: &nbsp; </label>");
			p.write("          <input id='livivngLocation2' name='textfield2' id='livingLocationSpan' type='text' class='inputs-edit' value='" + 
			current.livingLocation  + "' readonly>");
			
		}
		else {
			p.write("      <p id='livingLocationP'>");
			p.write("          <label id='livivngLocation1' for='textfield2'>Living Location: &nbsp; </label>");
			p.write("          <input id='livivngLocation2' name='textfield2' id='livingLocationSpan' type='text' class='inputs-edit' value='" + 
			current.livingLocation + "' readonly>");
		}
		if(isOwner) p.write("          <button type='button' id='editLivingLocation' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("      </p>");
		
		p.write("      <p id='workingLocationP'>");
		p.write("          <label id='livivngLocation1' for='textfield2'>Working Location: &nbsp; </label>");
		p.write("          <input id='livivngLocation2' name='textfield2' id='webSpan' type='text' class='inputs-edit' value='" + 
		current.workingLocation  + "' readonly>");
		if(isOwner) p.write("          <button type='button' id='editWorkingLocation' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("      </p>");
			
		p.write("      <p id='description' >");
		p.write("          <label for='textfield2'>Description: &nbsp; </label>");
		p.write("          <input name='textfield2' id='comments' type='text' class='inputs-edit' value='" + 
		current.comments  + "' readonly>");
		if(isOwner) p.write("          <button type='button' id='editComments' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("      </p>");
		
		p.write("</p>");
		
		p.write("<div id='projects'>");
		if(current.projects.length == 0) {
			p.write("<h2>" + current.fname + " is not involved in the any project right now, when they have any projects,"
					+ " this is where " + current.fname + "'s projects will be listed </h2>");			
		}
		else p.write("<h2>" + current.orgName + " is involved in the following projects </h2>");
		

		p.write("<div class='row'>");
		for(int i = 0; i < current.projects.length; i++) {
			Project currentProject = current.projects[i];
			
			if(!isOwner && currentProject.waitingAcception) {}
			
			else {
				
				p.write("  <div id='project" + currentProject.projectID + "' class='col-md-4'>");
				String picURL = currentProject.picURL;
				if(picURL == null) picURL = "/Project/img/project.png";
					p.write("    <a href='" + "/Project/ProjectProfile?projectId=" + currentProject.projectID + "' class='thumbnail'>");
				p.write("      <img src='" +  picURL + "' style='width:150px;height:150px'>");
				p.write("      <p>Name: " + currentProject.name + "</p>");
				p.write("      <p>Status: " + currentProject.status + "</p>");
				p.write("    </a>");
				if(isOwner) p.write("<br> <button class='delete' id='" + currentProject.projectID + "'> Delete </button>");
				p.write("  </div>");
			}
		}
		p.write("</div>");
		p.write("</div>");
		p.write("</div>");
		p.write("</div>");
		p.write("</body>");
		p.write("</html>");
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void writeHeader(PrintWriter p) {
		p.write("<head>");
		p.write("<meta charset='utf-8'>");
		p.write("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		p.write("<title>About Page template By Adobe Dreamweaver CC</title>");
		p.write("<link href='AboutPageAssets/styles/aboutPageStyle.css' rel='stylesheet' type='text/css'>");
		p.write("");
		p.write("<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->");
		p.write("<script>var __adobewebfontsappname__='dreamweaver'</script><script src='http://use.edgefonts.net/montserrat:n4:default;source-sans-pro:n2:default.js' type='text/javascript'></script>");
		p.write("<title>Light Theme</title>");
		p.write("<script src='js/jquery-1.11.3.min.js'></script>");
		p.write("<script src='js/bootstrap.js'></script>");
		p.write("<link href='css/bootstrap.css' rel='stylesheet'>");
		p.write("<link href='css/style.css' rel='stylesheet' type='text/css'>");
		p.write("<link rel='stylesheet' href='assets/font-awesome/css/font-awesome.min.css'>");
		p.write("<script src='js/script.js'></script>");
		p.write("<script src='JSCSS/userProfile.js'></script>");
		p.write("<script src='assets/js/jquery-1.11.1.min.js'></script>");
		p.write("        <script src='assets/bootstrap/js/bootstrap.min.js'></script>");
		p.write("        <script src='assets/js/jquery.backstretch.min.js'></script>");
		p.write("        <script src='assets/js/retina-1.1.0.min.js'></script>");
		p.write("        <script src='assets/js/scripts.js'></script>");
		p.write("</head>");

	}
	
	public void writeSearch(PrintWriter p) {
		p.write("<nav  class='navbar navbar-default navbar-fixed-top col-sm-5 col-sm-offset-6 header col-md-offset-5'>");
		p.write("  <div class='container-fluid'>");
		p.write("    <!-- Brand and toggle get grouped for better mobile display -->");
		p.write("    <div class='navbar-header'> </div>");
		p.write("    <!-- Collect the nav links, forms, and other content for toggling -->");
		p.write("    <nav  class='navbar navbar-default navbar-fixed-top col-sm-5 col-sm-offset-6 header col-md-offset-5'>");
		p.write("  <div class='container-fluid'>");
		p.write("    <!-- Brand and toggle get grouped for better mobile display -->");
		p.write("    <div class='navbar-header'> </div>");
		p.write("    <!-- Collect the nav links, forms, and other content for toggling -->");
		p.write("    <div class='collapse navbar-collapse' id='topFixedNavbar1'>");
		p.write("      <p>");
		p.write("        <label>");
		p.write("          <img src='img/logo.PNG' alt='' width='311' height='54' class='logo'/><img src='img/profile-header.png' alt='' width='50' height='51' class='profile-picture'/><img src='img/home.png' width='60' height='60' alt=''/>");
		p.write("          <input type='text' name='textfield' id='textfield'>");
		p.write("          <input type='radio' name='RadioGroup1' value='radio' id='RadioGroup1_0'>");
		p.write("          Name</label>");
		p.write("        ");
		p.write("        <label>");
		p.write("          <input type='radio' name='RadioGroup1' value='radio' id='RadioGroup1_1'>");
		p.write("          Skills</label>");
		p.write("        ");
		p.write("        <label>");
		p.write("          <input type='radio' name='RadioGroup1' value='radio' id='RadioGroup1_2'>");
		p.write("          Donations</label>");
		p.write("        <label>");
		p.write("          <input type='radio' name='RadioGroup1' value='radio' id='RadioGroup1_3'>");
		p.write("          Location</label>");
		p.write("      </p>");
		p.write("    </div>");
		p.write("    <!-- /.navbar-collapse -->");
		p.write("  </div>");
		p.write("  <!-- /.container-fluid -->");
		p.write("</nav>");
		p.write("");
		p.write("    <!-- /.navbar-collapse -->");
		p.write("  </div>");
		p.write("  <!-- /.container-fluid -->");
		p.write("</nav>");

	}
}
