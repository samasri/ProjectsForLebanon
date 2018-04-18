import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int sessionNumber = (int) request.getSession().getAttribute("sessionNumber");
		PrintWriter p = response.getWriter();
		
		p.write("<!doctype html>");
		p.write("<html>");
		writeHeader(p);
		writeBody(p);
		p.write("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	void writeHeader(PrintWriter p) {
		p.write("<head>");
		p.write("<meta charset='utf-8'>");
		p.write("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
		p.write("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		p.write("<title>Light Theme</title>");
		p.write("<link href='css/simpleGridTemplate.css' rel='stylesheet' type='text/css'>");
		p.write("<!-- <link href='../Gallery/css/bootstrap.css' rel='stylesheet'> -->");
		p.write("<link href='css/bootstrap-3.3.5.css' rel='stylesheet' type='text/css'>");
		p.write("<script src='../Gallery/js/jquery-1.11.3.min.js'></script>");
		p.write("<!-- <script src='../Gallery/js/bootstrap.js'></script> -->");
		p.write("<link href='css/style.css' rel='stylesheet' type='text/css'>");
		p.write("<link rel='stylesheet' href='assets/font-awesome/css/font-awesome.min.css'>");
		p.write("<script src='js/script.js'></script>");
		p.write("<script src='assets/js/jquery-1.11.1.min.js'></script>");
		p.write("<!-- <script src='assets/bootstrap/js/bootstrap.min.js'></script> -->");
		p.write("<script src='js/bootstrap-3.3.5.js' type='text/javascript'></script>");
		p.write("<script src='assets/js/jquery.backstretch.min.js'></script>");
		p.write("<script src='assets/js/retina-1.1.0.min.js'></script>");
		p.write("<script src='assets/js/scripts.js'></script>");
		p.write("<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->");
		p.write("<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->");
		p.write("<script src='JSCSS/dashboard.js'></script>");
		p.write("<!--[if lt IE 9]>");
		p.write("<script src='https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js'></script>");
		p.write("<script src='https://oss.maxcdn.com/respond/1.4.2/respond.min.js'></script>");
		p.write("<![endif]-->");
		p.write("</head>");
	}
	
	void writeBody(PrintWriter p) {
		p.write("<body>");
		writeHomePageHeader(p);
		p.write("");
		
		p.write("  <!-- Hero Section -->");
		p.write("<section class='profile'>");
		p.write("  <div class='profile-detail'>");
		p.write("      <h3>Welcome to your Profile </h3>");
		p.write("    <img src='img/profile.png' alt='' width='400'>");
		p.write("    <input name='button' type='button' class='button' id='updateProfileB' value='Update Profile'>");
		p.write("    <input name='button' type='button' class='button' id='createProjectB' value='Create Project'>");
		p.write("</div>");
		p.write("</section>");
		p.write("<div class='row'>");
		p.write("  <div class='col-md-4 col-sm-12'>");
		p.write("    <div id='projectDiv' class='thumbnail classes'><img src='img/lamp.png' alt='Thumbnail Image 1' width='200'>");
		p.write("      <div class='caption'>");
		p.write("        <h3>Projects</h3>");
		p.write("        <p></p>");
		p.write("</div>");
		p.write("    </div>");
		p.write("  </div>");
		p.write("  <div class='col-md-4 col-sm-12 classes-2 col-md-offset-2'>");
		p.write("    <div id='notificationDiv' class='thumbnail classes classes-2'><img src='img/unnamed.png' alt='Thumbnail Image 1' width='216'>");
		p.write("      <div class='caption'>");
		p.write("        <h3>Notifications</h3>");
		p.write("        <p></p>");
		p.write("        ");
		p.write("      </div>");
		p.write("    </div>");
		p.write("  </div>");
		p.write("</div>");
		p.write("  <!-- Stats Gallery Section -->");
		p.write("  <!-- Footer Section -->");
		p.write("<footer class='footer-in footer'>");
		p.write("<p class='col-md-10'><span style='color: #000000'></span>	&copy; Copyright</p> </footer>");
	}
	
	void writeHomePageHeader(PrintWriter p) {
		p.write("<!-- Main Container -->");
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
	}
}
