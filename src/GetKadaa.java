

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetKadaa")
public class GetKadaa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetKadaa() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		for(int i = 0; i < Enums.Kadaa.length; i++) {
			p.write(Enums.Kadaa[i]);
			if(i != Enums.Kadaa.length-1) p.write(", ");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
