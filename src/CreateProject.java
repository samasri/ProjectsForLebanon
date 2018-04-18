

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateProject")
public class CreateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int sessionNumber = (int) request.getSession().getAttribute("sessionNumber");
		PrintWriter p = response.getWriter();
		
		int id = DumbDatabase.generateProjectId();
		String fileName = CommonMethods.saveImage(request, sessionNumber);
		DumbDatabase.setProjectImage(sessionNumber, id, fileName);
		
		p.write("<!doctype html>");
		p.write("<html>");
		writeHeader(p);
		p.write("<body>");
		writeSearch(p);
		writeContactPerson(p);
		
		writeInfo(p);
		p.write("</div>");
		p.write("</div>");
		p.write("<div id='id' hidden>" + id + "</div>");
		p.write("<body>");
		p.write("</html>");
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void writeInfo(PrintWriter p) {
		p.write("<section class='mainContent'> ");
		p.write("  <!-- Contact details -->");
		p.write("  <section class='section1'>");
		p.write("<hr class='sectionTitleRule2 profile'>");
		p.write("    <div class='section1Content content col-md-offset-0 col-xs-offset-0'>");
		p.write("      <h3>Project Info:</h3>");
		p.write("      ");
		p.write("      <p>");
		p.write("        <label for='textfield21'>Project Name: &nbsp; &nbsp; </label>");
		p.write("        <input id='name' name='textfield6' type='text' class='inputs' id='textfield6'>");
		p.write("  &nbsp;</p>");
		p.write("      <p>");
		p.write("        <label for='textfield27'>Location: &nbsp; &nbsp; </label>");
		p.write("			<select id='locationSelect' name='select' class='inputs' id='select'>");
		for(int i = 0; i < Enums.Kadaa.length; i++) p.write("<option value='" + Enums.Kadaa[i] + "'> " + Enums.Kadaa[i] + " </option>");
		p.write("            </select>	");
		p.write("  &nbsp;</p>");
		p.write("  ");
		p.write("  <p>");
		p.write("        <label for='textfield17'> Due Date: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </label>");
		p.write("        <input name='textfield4' type='text' class='inputs' id='date'>");
		p.write("      &nbsp;</p>");
		p.write("	  ");
		p.write("	  <p>");
		p.write("        <label for='textfield17'> Type of Service: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </label>");
		p.write("		<select id='TOSSelect' name='select' class='inputs' id='select' multiple>");
		for(int i = 0; i < Enums.TOS.length; i++) p.write("<option value='" + Enums.TOS[i] + "'> " + Enums.TOS[i] + " </option>");
		p.write("        </select>		");
		p.write("	  &nbsp;</p>");
		p.write("	  ");
		p.write("	  <p>");
		p.write("        <label for='textfield17'> Age range: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </label>");
		p.write("        <input id='age' name='textfield4' type='text' class='inputs' id='textfield4'>");
		p.write("      &nbsp;</p>");
		p.write("	  ");
		p.write("	  <p>");
		p.write("        <label for='textfield17'> Skills needed: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </label>");
		p.write("        <input  id='skill' name='textfield4' type='text' class='inputs' id='textfield4'>");
		p.write("      &nbsp;</p>");
		p.write("	  ");
		p.write("	  <p>");
		p.write("        <label for='textfield17'>  Needs: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </label>");
		p.write("        <input id='need' name='textfield4' type='text' class='inputs' id='textfield4'>");
		p.write("      &nbsp;</p>");
		p.write("	  ");
		p.write("	  <p>");
		p.write("        <label for='textfield17'>  Comments: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </label>");
		p.write("        <input id='comments' name='textfield4' type='text' class='inputs' id='textfield4'>");
		p.write("      &nbsp;</p>");
		p.write("	  ");
		p.write("      <input name='button' type='button' class='button' id='submit' value='Submit'>");
		p.write("    </div>");
		p.write("  </section>");
	}
	
	public void writeContactPerson(PrintWriter p) {
		p.write("<header>");
		p.write("  <div class='profileLogo'> ");
		p.write("    <p class='logoPlaceholder'><!-- <img src='logoImage.png' alt='sample logo'> --></p>");
		p.write("  </div>");
		p.write("<!-- Identity details -->");
		p.write("  <section class='profileHeader'>");
		p.write("<div class='profile'>");
		p.write("  <h3>Contact Info:</h3>");
		p.write("  <p>");
		p.write("        <p>");
		p.write("        <label for='textfield24'>First Name: &nbsp; </label>");
		p.write("        <input id='fName' name='textfield2' type='text' class='inputs' id='textfield3'>");
		p.write("      </p>");
		p.write("      <p>");
		p.write("        <label for='textfield2'>Last Name: &nbsp; </label>");
		p.write("        <input id='lName' name='textfield2' type='text' class='inputs' id='textfield2'>");
		p.write("      </p>");
		p.write("      <p>");
		p.write("        <label for='select'>Email: &nbsp; </label>");
		p.write("		<input id='email' name='textfield2' type='text' class='inputs' id='textfield2'>");
		p.write("        ");
		p.write("&nbsp;</p>");
		p.write(" <p>");
		p.write("        <label for='select'>Phone Number: &nbsp; </label>");
		p.write("		<input id='phoneNumber' name='textfield2' type='text' class='inputs' id='textfield2'>");
		p.write("");
		p.write("        ");
		p.write("&nbsp;</p>");
		p.write("</p>");
		p.write("  &nbsp;</div>");
		p.write("  </section>");
		p.write("  <!-- Links to Social network accounts --></header>");
	}
	
	public void writeHeader(PrintWriter p) {
		p.write("<head>");
		p.write("<meta charset='utf-8'>");
		p.write("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		p.write("<title>About Page template By Adobe Dreamweaver CC</title>");
		p.write("<link href='AboutPageAssets/styles/aboutPageStyle.css' rel='stylesheet' type='text/css'>");
		p.write("<script src='http://use.edgefonts.net/montserrat:n4:default;source-sans-pro:n2:default.js' type='text/javascript'></script>");
		p.write("<title>Light Theme</title>");
		p.write("<script src='js/jquery-1.11.3.min.js'></script>");
		p.write("<script src='js/bootstrap.js'></script>");
		p.write("<link href='css/bootstrap.css' rel='stylesheet'>");
		p.write("<link href='css/style.css' rel='stylesheet' type='text/css'>");
		p.write("<link rel='stylesheet' href='assets/font-awesome/css/font-awesome.min.css'>");
		p.write("<script src='js/script.js'></script>");
		p.write("<script src='JSCSS/createProject.js'></script>");
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
		p.write("    <div class='collapse navbar-collapse' id='topFixedNavbar1'>");
		p.write("      <p>");
		p.write("        <label>");
		p.write("          <img src='img/logo.PNG' alt='' width='311' height='54' class='logo'/><img src='img/profile-header.png' alt='' width='50' height='51' class='profile-picture'/><img src='img/home.png' width='60' height='60' alt=''/>");
		p.write("          <input type='text' name='textfield' id='textfield'>");
		p.write("          <input id='nameRadio' type='radio' name='RadioGroup1' value='radio' id='RadioGroup1_0'>");
		p.write("          Name</label>");
		p.write("        ");
		p.write("        <label>");
		p.write("          <input id='skillRadio' type='radio' name='RadioGroup1' value='radio' id='RadioGroup1_1'>");
		p.write("          Skills</label>");
		p.write("        ");
		p.write("        <label>");
		p.write("          <input id='needsRadio' type='radio' name='RadioGroup1' value='radio' id='RadioGroup1_2'>");
		p.write("          Donations</label>");
		p.write("        <label>");
		p.write("          <input id='kadaaRadio' type='radio' name='RadioGroup1' value='radio' id='RadioGroup1_3'>");
		p.write("          Kadaa </label>");
		p.write("      </p>");
		p.write("    </div>");
		p.write("    <!-- /.navbar-collapse -->");
		p.write("  </div>");
		p.write("  <!-- /.container-fluid -->");
		p.write("</nav>");
	}

}
