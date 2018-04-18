import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;


public class CommonMethods {

	static void writeHeaderBK(PrintWriter p, String scriptName, String cssName) {
		p.write("<head>");
		p.write("<title> Dashboard </title>");
		p.write("<script src='/Project/JSCSS/search.js'> </script>");
		p.write("<script src='/Project/jquery.js'> </script>");
		p.write("<script src='/Project/JSCSS/" + scriptName + ".js'> </script>");
		p.write("<link rel='stylesheet' type='text/css' href='/Project/JSCSS/" + cssName + ".css'>");
		p.write("<link rel='stylesheet' type='text/css' href='/Project/JSCSS/search.css'>");
		p.write("</head>");
	}
	
	static void writeHeader(PrintWriter p, String scriptName, String cssName) {
		p.write("<head>");
		p.write("<meta charset='utf-8'>");
		p.write("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
		p.write("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		p.write("<title>Home</title>");
		p.write("<script src='js/jquery-1.11.3.min.js'></script>");
		p.write("<script src='js/bootstrap.js'></script>");
		p.write("<link href='css/bootstrap.css' rel='stylesheet'>");
		p.write("<link href='css/style.css' rel='stylesheet' type='text/css'>");
		p.write("<link rel='stylesheet' href='assets/font-awesome/css/font-awesome.min.css'>");
		p.write("<script src='js/script.js'></script>");
		p.write("<script src='assets/js/jquery-1.11.1.min.js'></script>");
		p.write("<script src='assets/bootstrap/js/bootstrap.min.js'></script>");
		p.write("<script src='assets/js/jquery.backstretch.min.js'></script>");
		p.write("<script src='assets/js/retina-1.1.0.min.js'></script>");
		p.write("<script src='assets/js/scripts.js'></script>");
		p.write("");
		p.write("</head>");
	}
	
	static void writeSearch(PrintWriter p) {
		p.write("<div id='header'>");
		p.write("<input id='search' type='text' placeholder='Search for potential projects'><br>");
		p.write("<div class='searchRadios'> <input id='nameRadio' type='radio' name='type'> By name </div>");
		p.write("<div class='searchRadios'> <input id='skillRadio' type='radio' name='type'> By skills needed </div>");
		p.write("<div class='searchRadios'> <input id='needsRadio' type='radio' name='type'> By needed donations </div>");
		p.write("<div class='searchRadios'> <input id='kadaaRadio' type='radio' name='type'> By kadaa </div>");
		p.write("<a id='dashBoardIcon' href='/Project/Dashboard'> <img id='dashBoardPic' src='Pictures/home.png' title='Homepage'> </a>");
		p.write("<a id='profileIcon' href='/Project/UserProfile'> <img id='profileIconPic' src='Pictures/profile.png' title='Profile'> </a>");
		p.write("</div>");
	}
	
	static String saveImage(HttpServletRequest request, int sessionNumber) throws Exception {
		String saveFile = new String();
		String contentType = request.getContentType();
		
		if((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)){
			DataInputStream in = new DataInputStream(request.getInputStream());
			
			int formDataLength = request.getContentLength();
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			
			while(totalBytesRead < formDataLength) {
				byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
				totalBytesRead += byteRead;
			}
			
			String file = new String(dataBytes);
			
			saveFile = file.substring(file.indexOf("filename=\"") + 10);
			saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));
			
			int lastIndex = contentType.lastIndexOf("=");
			
			String boundary = contentType.substring(lastIndex + 1, contentType.length());
			
			int pos;
			
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("'n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			
			int boundaryLocation = file.indexOf(boundary, pos) - 4;
			
			int startPos = ((file.substring(0, pos)).getBytes()).length;
			int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;

			saveFile = "C:/Users/Samer/eclipseEE/Project/WebContent/Pictures/" + DumbDatabase.getEmail(sessionNumber) + ".jpg"; //Not working
			//Bad for portability!
			//check if image (a virus may be uploaded this way)
			
			File ff = new File(saveFile);
			
			try {
				FileOutputStream fileOut = new FileOutputStream(ff);
				fileOut.write(dataBytes, startPos, (endPos - startPos));
				fileOut.flush();
				fileOut.close();
			}
			catch(Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
			
			return saveFile;
		}
		return null;
	}
	
	static void writeEditButton(PrintWriter p, String id, boolean isOwner, boolean withBr) {
		if(isOwner) p.write(" <button id='" + id + "'> Edit </button> ");
		if(withBr) p.write("<br>");
	}
	
	static void writeHomePageHeader(PrintWriter p) {
		p.write("<div id='homePageHeader'>");
		p.write("<br/>");
		p.write("<div id='logo'>Projects for Lebanon</div>");
		p.write("</div>");
	}
}
