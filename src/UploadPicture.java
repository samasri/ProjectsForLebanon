

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UploadPicture")
public class UploadPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UploadPicture() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int sessionNumber = (int) request.getSession().getAttribute("sessionNumber");
		UserType type;
			type = DumbDatabase.getUserType(sessionNumber);
		PrintWriter p = response.getWriter();
		
		writeHTML(p);	

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public static void writeHTML(PrintWriter p) {
		p.write("<!doctype html>");
		p.write("<html>");
		p.write("<head>");
		p.write("<meta charset='utf-8'>");
		p.write("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
		p.write("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		p.write("<title>Light Theme</title>");
		p.write("<link href='css/simpleGridTemplate.css' rel='stylesheet' type='text/css'>");
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
		p.write("</head>");
		p.write("<body>");
		p.write("<!-- Main Container -->");
		p.write(" <nav  class='navbar navbar-default navbar-fixed-top col-sm-5 col-sm-offset-6 header col-md-offset-5'>");
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
		p.write("  <!-- Hero Section -->");
		p.write("<section class='intro Total'>");
		p.write("    <div class='column'>");
		p.write("		<h3>Update Profile Picture</h3>");
		p.write("    <img src='img/profile.png' alt='' width='400'>");
		p.write("	<form name='uploadForm' action='/Project/CreateProfile' method='POST' enctype='multipart/form-data' id='imgUplForm'>");
		p.write("    <input type='file' name='file' value='' width='100' id='button' class='button'/>");
		p.write("	<input type='submit' id='submitButton' value='Upload Picture' name='submit' class='button' />");
		p.write("	 </form>");
		p.write("    </div>");
		p.write("    <div class='column paragraph'>");
		p.write("      <p class='paragraph'>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla </p>");
		p.write("</div>");
		p.write("  </section>");
		p.write("  <!-- Stats Gallery Section -->");
		p.write("  <!-- Footer Section -->");
		p.write("  <footer class='footer-in footer'> <p class='col-md-10'><span style='color: #000000'></span>	&copy; Copyright</p> </footer>");
		p.write("</body>");
		p.write("</html>");

	}

}
