

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateProfile")
public class CreateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int sessionNumber = (int) request.getSession().getAttribute("sessionNumber");
		
		String fileName = CommonMethods.saveImage(request, sessionNumber);
		
		DumbDatabase.setImage(sessionNumber, fileName);

		UserType type = (UserType) request.getSession().getAttribute("type");
		
		PrintWriter p = response.getWriter();
		
		
		writeHTML(p, type);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeHTML(PrintWriter p, UserType type) {
			
		p.write("<!doctype>");
		p.write("<html>");
		writeHeader(p);
		p.write("<body>");
		
		writeHomePageHeader(p);
		writeInfo(p, type);

		p.write("<div id='type' style='display: none;'>" + type + "</div>");
		p.write("</body>");
		p.write("</html>");
	}
	
	static void writeInfo(PrintWriter p, UserType type) {
		p.write("<header>");
		p.write("<!-- Identity details -->");
		p.write("  <section class='profileHeader'>");
		p.write("    <h1 class='profile'>Almost There We Just Need Some More Information</h1>");
		p.write("<p class='profile'>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in.</p>");
		p.write("<div class='profile'>");
		p.write("  <h3>About You</h3>");
		p.write("  <p>");
		
		if(type == UserType.Organization) {
			p.write("  <p>");
			p.write("			<label for='textfield24'>Organization Name: &nbsp; </label>");
			p.write("			<input id='orgName' name='textfield2' type='text' class='inputs' id='textfield3'>");
			p.write("		</p>");
			p.write("	  ");

		}
		if(type == UserType.Group) {
			p.write("        <p>");
			p.write("        <label for='textfield24'>Group Name: &nbsp; </label>");
			p.write("        <input id='groupName' name='textfield2' type='text' class='inputs' id='textfield3'>");
			p.write("      </p>");
		}

		p.write("      <p>");
		p.write("        <label for='textfield2'>Web Site (Optional): &nbsp; </label>");
		p.write("        <input id='website' name='textfield2' type='text' class='inputs' id='textfield2'>");
		p.write("      </p>");
		p.write("      <p>");
		
		if(type == UserType.Organization) {
			p.write("      <p>");
			p.write("        <label for='select'>Headquarters : &nbsp; </label>");
			p.write("        <select name='select' class='inputs' id='livingLocation'>");
			for(int i = 0; i < Enums.Kadaa.length; i++) p.write("<option value='" + Enums.Kadaa[i] + "'> " + Enums.Kadaa[i] + " </option>");
			p.write("        </select>");
			p.write("        ");
			p.write("&nbsp;</p>");
		}
		else {
			p.write("      <p>");
			p.write("        <label for='select'>Place of residence : &nbsp; </label>");
			p.write("        <select name='select' class='inputs' id='livingLocation'>");
			for(int i = 0; i < Enums.Kadaa.length; i++) p.write("<option value='" + Enums.Kadaa[i] + "'> " + Enums.Kadaa[i] + " </option>");
			p.write("        </select>");
			p.write("        ");
			p.write("&nbsp;</p>");
		}
		
		if(type != UserType.Organization) {
			p.write("        <label for='select'>Location you would like to work in: &nbsp; </label>");
			p.write("        <select name='select' class='inputs' id='workingLocation' multiple>");
			for(int i = 0; i < Enums.Kadaa.length; i++) p.write("<option value='" + Enums.Kadaa[i] + "'> " + Enums.Kadaa[i] + " </option>");
			p.write("        </select>");
		}
		
		p.write("</p>");

		p.write("  &nbsp;</div>");
		p.write("  </section>");
		p.write("  <!-- Links to Social network accounts -->");
		p.write("</header>");
		p.write("<!-- content -->");
		p.write("<section class='mainContent'> ");
		p.write("  <!-- Contact details -->");
		p.write("  <section class='section1'>");
		p.write("<hr class='sectionTitleRule2 profile'>");
		p.write("    <div class='section1Content content col-md-offset-0 col-xs-offset-0'>");
		p.write("      <h3>How Can You Help</h3>");
		
		
		if(type == UserType.Donor) {
			p.write("      <p>");
			p.write("        <label for='textfield17'>Donations: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </label>");
			p.write("        <input name='textfield4' type='text' class='inputs' id='donations'>");
			p.write("      &nbsp;</p>");
		}
		
		if(type == UserType.Mentor) {
			p.write("      <p>");
			p.write("        <label for='textfield20'>Skills: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </label>");
			p.write("        <input name='textfield5' type='text' class='inputs' id='skills'>");
			p.write("  &nbsp;</p>");
		}

		p.write("      <p>");
		p.write("        <label for='textfield21'>Type of Service(Select as many as appropriate): &nbsp; &nbsp; </label>");
		p.write("        <select name='select' class='inputs' id='TOSselect' multiple>");
		for(int i = 0; i < Enums.TOS.length; i++) p.write("<option value='" + Enums.TOS[i] + "'> " + Enums.TOS[i] + " </option>");
		p.write("</select>");
		p.write("  &nbsp;</p>");
		
	
		p.write("      <p>");
		p.write("        <label for='textfield27'>Additional Comments: &nbsp; &nbsp; </label>");
		p.write("        <input name='textfield3' type='text' class='inputs' id='desc'>");
		p.write("  &nbsp;</p>");
		
	

		p.write("      <input name='button' type='button' class='button' id='submit' value='Submit'>");
		p.write("    </div>");
		p.write("  </section>");
		p.write("  <!-- Previous experience details -->");
		p.write("  <section class='section2'>");
		p.write("<hr class='sectionTitleRule2 profile'>");
		p.write("    <!-- First Title & company details  -->");
		p.write("    <article class='section2Content'> </article>");
		p.write("    <!-- Second Title & company details  -->");
		p.write("    <article class='section2Content'> </article>");
		p.write("    <!-- Replicate the above Div block to add more title and company details --> ");
		p.write("  </section>");
		p.write("<!-- Links to expore your past projects and download your CV --></section>");
		p.write("<footer class='footer-in footer'> <p class='col-md-10 footer-profile'><span style='color: #000000'></span>	&copy; Copyright</p> </footer>");

	}
	
	public static void writeHeader(PrintWriter p) {
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
		p.write("<script src='assets/js/jquery-1.11.1.min.js'></script>");
		p.write("        <script src='assets/bootstrap/js/bootstrap.min.js'></script>");
		p.write("        <script src='assets/js/jquery.backstretch.min.js'></script>");
		p.write("        <script src='assets/js/retina-1.1.0.min.js'></script>");
		p.write("        <script src='assets/js/scripts.js'></script>");
		p.write("<script src='JSCSS/createProz.js'></script>");
		p.write("</head>");
	}
	
	public static void writeHomePageHeader(PrintWriter p) {
		p.write("<nav  class='navbar navbar-default navbar-fixed-top col-sm-5 col-sm-offset-6 header col-md-offset-5'>");
		p.write("  <div class='container-fluid'>");
		p.write("    <!-- Brand and toggle get grouped for better mobile display -->");
		p.write("    <div class='navbar-header'> </div>");
		p.write("    <!-- Collect the nav links, forms, and other content for toggling -->");
		p.write("    <div class='collapse navbar-collapse' id='topFixedNavbar1'>");
		p.write("		<img src='img/logo.PNG' alt='' width='311' height='54' class='logo'/>    </div>");
		p.write("    <!-- /.navbar-collapse -->");
		p.write("  </div>");
		p.write("  <!-- /.container-fluid -->");
		p.write("</nav>");
	}

}
