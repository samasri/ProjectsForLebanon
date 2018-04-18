

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProjectProfile")
public class ProjectProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int sessionNumber = (int) request.getSession().getAttribute("sessionNumber");
		String project = request.getParameter("projectId");
		PrintWriter p = response.getWriter();
		
		if(project == null) {p.write("No projectId parameter"); return; }
		
		int projectId = Integer.parseInt(project);
		Project current = DumbDatabase.getProject(projectId);
		if(current == null) {p.write("No project with ID: " + projectId); return; }
		
		boolean isOwner = DumbDatabase.isProjectOwner(sessionNumber, projectId);
		if(current.status == Status.finished) isOwner = false;
		boolean approvedByAdmin = !current.waitingAcception;
		
		p.write("<!doctype html>");
		p.write("<html>");
		writeHeader(p);
		p.write("<body>");
		writeSearch(p);
		
		p.write("<div id='projectImgDiv' class='image'>");
		p.write("<img src='img/project.png' alt='' width='144'>");
		p.write("    <input name='button' type='button' class='button' id='button' value='Upload Picture'>");
		p.write("    </div>");

		writeContactInfo(p, isOwner, current);
		writeProjectInfo(p, approvedByAdmin, isOwner, current);
		p.write("<div class='properties' id='projectId' hidden>" + project + "</div>");
		p.write("</body> </html>");
		}
		catch(Exception e) {e.printStackTrace();}
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
		p.write("<script src='JSCSS/projectProfile.js'></script>");
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
	
	public void writeProjectInfo(PrintWriter p, boolean approvedByAdmin, boolean isOwner, Project proj) {
		p.write("  <section class='profileHeader'>");
		p.write("<div class='profile'>");
		p.write("  <h3>Project Information</h3>");
		p.write("  <p>");
		p.write("        <p>");
		p.write("          <label for='textfield2'>Status: &nbsp; </label>");
		p.write("          <input id='status' name='textfield2' type='text' class='inputs' value='" + proj.status + "' readonly>");
		if(approvedByAdmin) p.write("		  <button type='button' id='startProject' class='btn btn-sm btn-default button-edit'>Start Project</button>");
		p.write("      </p>");
		p.write("        <p>");
		p.write("          <label for='textfield2'>Project Name: &nbsp; </label>");
		p.write("          <input id='name' name='textfield2' type='text' class='inputs' value='" + proj.name + "'  readonly>");
		if(isOwner) p.write("		  <button type='button' id='editName' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("      </p>");
		p.write("      <p id='TOSp'>");
		p.write("        <label id='TOS1' for='textfield3'>Type Of Service: &nbsp; </label>");
		p.write("		<input id='TOS2' name='textfield2' type='text' class='inputs' value='" + proj.tos + "'  readonly>");
		if(isOwner) p.write("		<button id='editTOS' type='button' id='editTOS' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("      </p>");
		p.write("      <p id='locationP'>");
		p.write("        <label id='location1' for='select2'>Location : &nbsp; </label>");
		p.write("		<input id='location2' name='textfield2' type='text' class='inputs' value='" + proj.areaOfService + "'  readonly>");
		if(isOwner) p.write("		<button type='button' id='editLocation' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("        &nbsp;");
		p.write("	   </p>");
		p.write("      <p>");
		p.write("        <label for='textfield4'>Prefered Date: &nbsp; </label>");
		p.write("        <input id='date' name='textfield7' type='text' class='inputs' value='" + proj.date + "' readonly>");
		if(isOwner) p.write("		<button type='button' id='editDate' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("      </p>");
		p.write("      <p>");
		p.write("        <label for='textfield5'>Age group: &nbsp; </label>");
		p.write("        <input id='age' name='textfield8' type='text' class='inputs' value='" + proj.ageGroup + "' readonly>");
		if(isOwner) p.write("		<button type='button' id='editAge' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("      </p>");
		p.write("      <p>");
		p.write("        <label for='textfield6'>Mentoring skills needed: &nbsp; </label>");
		p.write("        <input id='skills' name='textfield9' type='text' class='inputs' value='" + proj.basicSkills + "' readonly>");
		if(isOwner) p.write("		<button type='button' id='editSkills' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("      </p>");
		p.write("      <p>");
		p.write("        <label for='textfield7'>Donation needs: &nbsp; </label>");
		p.write("        <input id='needs' name='textfield10' type='text' class='inputs' value='" + proj.needs + "' readonly>");
		if(isOwner) p.write("		<button type='button' id='editNeeds' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("      </p>");
		p.write("      <p>");
		p.write("        <label for='textfield8'>Description or Comments: &nbsp; </label>");
		p.write("          <textarea id='comments' name='textfield11' type='text' class='inputs' value='" + "temp" + "' id='textfield11' readonly> </textarea>");
		if(isOwner) p.write("		  <button type='button' id='editComments' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("      </p>");
		p.write("      </p>");
		p.write("  &nbsp;</div>");
		p.write("  </section>");
	}

	public void writeContactInfo(PrintWriter p, boolean isOwner, Project proj) {
		p.write("<section class='mainContent'> ");
		p.write("  <!-- Contact details -->");
		p.write("  <section class='section1'>");
		p.write("<hr class='sectionTitleRule2 profile'>");
		p.write("    <div class='section1Content content col-md-offset-0 col-xs-offset-0'>");
		p.write("      <h3>Contact Person Information</h3>");
		p.write("      <p>");
		p.write("        <label for='textfield9'>First Name: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </label>");
		p.write("        <input id='fName' name='textfield4' type='text' value='" + "temp" + "' class='inputs' readonly>");
		if(isOwner) p.write("		<button type='button' id='editfName' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("      &nbsp;</p>");
		p.write("      <p>");
		p.write("        <label for='textfield20'>Last Name: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </label>");
		p.write("        <input id='lName'  name='textfield5' type='text' value='" + "temp" + "' class='inputs'>");
		if(isOwner) p.write("		<button type='button' id='editlName' class='btn btn-sm btn-default button-edit' readonly>Edit</button>");
		p.write("  &nbsp;</p>");
		p.write("      <p>");
		p.write("        <label for='textfield10'>Phone Number: &nbsp; &nbsp; </label>");
		p.write("        <input id='phoneNumber' name='textfield6' type='text' value='" + "temp" + "' class='inputs' readonly>");
		if(isOwner) p.write("		<button type='button' id='editPhoneNumber' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("  &nbsp;</p>");
		p.write("      <p>");
		p.write("        <label for='textfield11'>Email: &nbsp; &nbsp; </label>");
		p.write("        <input id='email' name='textfield3' type='text' value='" + "temp" + "' class='inputs' readonly>");
		if(isOwner) p.write("		<button type='button' id='editEmail' class='btn btn-sm btn-default button-edit'>Edit</button>");
		p.write("  &nbsp;</p>");
		p.write("    </div>");
		p.write("  </section>");
		p.write("  </section>");

	}
}
