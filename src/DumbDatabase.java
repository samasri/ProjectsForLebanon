import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DumbDatabase {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	static String C = "'";
	
	static int sessionCount = 1;
	static int dbProjectCount = 0;
	
	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost/projectleb";
	//  Database credentials
	private static final String USER = "root";
	private static final String PASS = "1234";
	//Connection objects
	private static Connection conn = null;
	private static Statement stmt = null;

	private static boolean firstTime = true;
	
	private static void openConnection() throws Exception {
		if(firstTime) {
			Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    firstTime = false;
		    
		    /*String sql = "UPDATE logcredentials set sessionNumber=-13;";
		    System.out.println("INITIAL STATEMENT: " + sql);
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);*/
		}
	}
	
	public static boolean signUp(String fname, String lname, String phoneNumber, //SignUp.java
			String email, String password, int type) throws Exception {
		openConnection();
		
		String sql = "";
		String table = "";
		//specify table using the Type integer
		if(type == 0)  {
			table = "organization";		
		}
		else if (type == 1) {
			table = "donor";			
		}
		else if (type == 2) {
			table = "mentor";
		}
		else if (type == 3) {
			table = "projectleb.group";
		}

		//Check if email is already registered
		if(emailFound(table, email)) return false;
		
		sql = "INSERT INTO " + table + "(contactFname, contactLname, "
				+ "contactMobile, contactEmail, contactEmailPrivacy, "
				+ "contactMobilePrivacy) VALUES ('" + fname + 
				"', '" + lname + "', " + phoneNumber + ", '" + 
				email + "', 1, 1);";

		System.out.println("INSERT STATEMENT: " + sql);
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		
		//Add record in credentials table
		sql = "INSERT INTO logCredentials VALUES ('" + email + "', "
				+ "'" + password + "', -13, " + type + ", 1);";
		
		System.out.println("INSERT STATEMENT: " + sql);
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	public static boolean emailFound(String table, String email) throws Exception {
		openConnection();
		
		String sql = "Select contactEmail from " + table + " where contactEmail='" + email + "';";
		
		System.out.println("SELECT STATEMENT: " + sql);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			return true;
		}
		System.out.println("---------------------------------");
		return false;
	}
	public static int getSessionNumber(String email, String password) throws Exception { //Login.java
		//return -1 if no user/pass combination
		openConnection();
		
		String sql = "Select email, password from logcredentials;";
		
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("SELECT STATEMENT: " + sql);
		
		int sessionNumberResult = -1;
		
		while(rs.next()) {
			String currentEmail = rs.getString("email");
			String currentPassword = rs.getString("password");
			if(email.equals(currentEmail) && password.equals(currentPassword)) {
				edit("logcredentials", email, "sessionNumber", ""+sessionCount);
				sessionNumberResult = sessionCount++;
			}
		}
		System.out.println("---------------------------------");
		return sessionNumberResult;
	}
	
	public static UserType getUserType(int sessionNumber) throws Exception { //Login.java, UploadPicture.java
		openConnection();
		
		String sql = "select sessionNumber, Typ from logCredentials;";
		
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("SELECT STATEMENT: " + sql);
		
		UserType type = null;
		
		while(rs.next()) {
			int currentSessionNumber = rs.getInt("sessionNumber");
			int currentType = rs.getInt("Typ");
			if(currentSessionNumber == sessionNumber) {
				if(currentType == 0) type = UserType.Organization;
				else if(currentType == 1) type = UserType.Donor;
				else if(currentType == 2) type = UserType.Mentor;
				else if(currentType == 3) type = UserType.Group;
			}
		}

		System.out.println("---------------------------------");
		return type;
	}
	
	static UserType getUserType(String email) throws Exception { //Login.java, UserProfile.java
		openConnection();
		
		String sql = "select email, Typ from logCredentials;";

		System.out.println("SELECT STATEMENT: " + sql);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		UserType type = null;
		
		while(rs.next()) {
			String currentEmail = rs.getString("email");
			int currentType = rs.getInt("Typ");
			if(currentEmail== email) {
				if(currentType == 0) type = UserType.Organization;
				else if(currentType == 1) type = UserType.Donor;
				else if(currentType == 2) type = UserType.Mentor;
				else if(currentType == 3) type = UserType.Group;
			}
		}

		System.out.println("---------------------------------");
		return type;
	}
	
	public static Notification[] getNotifications(int sessionNumber) throws Exception { //GetNotifications.java
		openConnection();

		String sql = "Select email from logCredentials WHERE sessionNumber=" + sessionNumber + ";";
		System.out.println("SELECT STATEMENT: " + sql);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		if(!rs.next()) {
			Notification[] empty = new Notification[0];
			return empty;
		}
		String email = rs.getString("email");


		sql = "Select * from notifications where ownerEmail='" + email + "';";
		System.out.println("SELECT STATEMENT: " + sql);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		ArrayList<Notification> notifications = new ArrayList<Notification>();
		while(rs.next()) {
			int type = rs.getInt("type");
			String projectName = rs.getString("ProjectName");
			int projectID = rs.getInt("ProjectID");
			String groupName = rs.getString("GroupName");
			String groupEmail = rs.getString("GroupEmail");
			String comment = rs.getString("Comment");
			
			Notification temp = new Notification();
			if(type == 0) temp.type = Type.ACCEPTEDProject;
			else if(type == 1) temp.type = Type.REJECTEDProject;
			else if(type == 2) temp.type = Type.CONNECTED;
			else if(type == 3) temp.type = Type.ACCEPTEDUser;
			else if(type == 4) temp.type = Type.REJECTEDUser;
			temp.projectID = projectID;
			temp.projectName = projectName;
			temp.groupName = groupName;
			temp.groupEmail = groupEmail;
			temp.comment = comment;
			
			notifications.add(temp);
		}
		
		Notification[] notification = new Notification[notifications.size()];
		for (int i = 0; i < notification.length; i++) {
			notification[i] = notifications.get(i);
		}
		System.out.println("---------------------------------");
		return notification;
	}
	
	public static Project[] getProjects(int sessionNumber) throws Exception { //GetProjects.java
		openConnection();
		
		String email = getEmail(sessionNumber);
		
		String sql = "Select * from project WHERE contactEmail='" + email + "';";
		System.out.println("SELECT STATEMENT: " + sql);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Project> projects = new ArrayList<Project>();
		while(rs.next()) {
			Project current = new Project();
			current.name = rs.getString("Name");
			current.picURL = rs.getString("ImageURL");
			int status = rs.getInt("Status");
			if(status == 0) current.status = Status.potential;
			else if (status == 1) current.status = Status.inProcess;
			else if (status == 2) current.status = Status.finished;
			current.projectID = rs.getInt("id");
			projects.add(current);
		}
		
		Project[] projArr = new Project[projects.size()];
		for (int i = 0; i < projArr.length; i++) {
			projArr[i] = projects.get(i);
		}
		
		System.out.println("---------------------------------");
		return projArr;
	}
	static Volunteer getVolunteer(int sessionNumber) throws Exception { //UserProfile.java, CommonMethods.java
		return getVolunteer(getEmail(sessionNumber));
	}
	static Volunteer getVolunteer(String email) throws Exception { //UserProfile.java
		openConnection();
		
		//Get table where volunteer is
		String sql = "SELECT typ FROM logCredentials WHERE email='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		
		int typ = -1;
		if(rs.next()) typ = rs.getInt("Typ");
		else return null;
		
		String table = "";
		if(typ == 0) table = "organization";
		else if(typ == 1) table = "Donor";
		else if(typ == 2) table = "Mentor";
		else if(typ == 3) table = "projectleb.group";
		
		//Get volunteer info
		sql = "SELECT * FROM " + table + " WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		rs = stmt.executeQuery(sql);

		Volunteer p = new Volunteer();
		rs.next();
		p.imgURL = rs.getString("ImageURL");
		//p.imgURL = "/Project/Pictures/Logo2.jpg";
		p.fname = rs.getString("contactFname");
		p.lname = rs.getString("contactLname");
		p.email = rs.getString("contactEmail");
		p.phoneNumber = rs.getString("contactMobile");
		p.emailPublic = (rs.getInt("contactEmailPrivacy") == 1) ? true: false;
		p.phoneNumberPublic = (rs.getInt("contactMobilePrivacy") == 1) ? true : false;
		try {p.groupName = rs.getString("Name");} catch(SQLException e) {p.groupName = null;}
		p.orgName = p.groupName;
		p.website = rs.getString("Website");
		p.TOS = getTOS(email, table);
		p.livingLocation = rs.getString("LivingLocation");
		try {p.workingLocation = rs.getString("workingLocation"); } catch(SQLException e) { p.workingLocation = null; }
		p.comments = rs.getString("Description");
		//p.comments = "Volunteer With Lebanon has been established to serve as the national hub for volunteering in Lebanon with the mission 'to promote, facilitate, and improve volunteering and community service throughout Lebanon.'";
		p.skills = getSkills(email, table);
		p.donations = ("donor".equalsIgnoreCase(table)) ? rs.getString("donations") : null;
		
		//Get projects from connections table
		sql="SELECT projectID from connections where VolunteerEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		rs = stmt.executeQuery(sql);
		ArrayList<Project> projects = new ArrayList<Project>();
		while(rs.next()) {
			Project current = getProject(rs.getInt("projectId"));
			projects.add(current);
		}
		
		//Get Projects that this volunteer owns
		sql = "SELECT id FROM Project WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Project current = getProject(rs.getInt("id"));
			projects.add(current);
		}
		
		//Collect the results in a Project[] array and return it
		Project[] projArray = new Project[projects.size()];
		for (int i = 0; i < projArray.length; i++) {
			projArray[i] = projects.get(i);
		}
		p.projects = projArray;
		
		System.out.println("---------------------------------");
		return p;
	}
	
	static String getTOS(String email, String table) throws Exception {
		openConnection();
		String result = null;
		String sql = "";
		if("organization".equals(table.toLowerCase())) {
			sql = "SELECT contactEmail, service FROM "
				+ "OrganizationService Inner Join TypeOfService ON TypeOfServiceID=id "
				+ "INNER JOIN Organization ON organization.id = OrganizationID "
				+ "WHERE contactEmail='" + email + "';";
		
		
		}
		else if ("donor".equals(table.toLowerCase())) {
			sql = "SELECT contactEmail, service FROM "
					+ "DonorService Inner Join TypeOfService ON TypeOfServiceID=id "
					+ "INNER JOIN Donor ON Donor.id = DonorService.DonorID"
					+ "WHERE contactEmail='" + email + "';";
		}
		else if("mentor".equals(table.toLowerCase())) {
			sql = " SELECT contactEmail, service FROM "
					+ "MentorService Inner Join TypeOfService ON TypeOfServiceID=id "
					+ "INNER JOIN Mentor ON Mentor.id = MentorID"
					+ "WHERE contactEmail='" + email + "';";
		}
		else if("projectleb.group".equals(table.toLowerCase())) {
			sql = "SELECT contactEmail, service FROM "
					+ "GroupService Inner Join TypeOfService ON TypeOfServiceID=id "
					+ "INNER JOIN projectleb.Group ON projectleb.Group.id = GroupID "
					+ "WHERE contactEmail='" + email + "';";
		}
		
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) result = rs.getString("Service");
		while(rs.next()) {
			result += ", " + rs.getString("Service");
		}
		System.out.println("---------------------------------");
		return result;
	};
	static String getSkills(String email, String table) throws Exception {
		openConnection();
		String result = null;
		String sql = "";
		if("organization".equals(table.toLowerCase())) {
			return null;		
		}
		else if ("donor".equals(table.toLowerCase())) {
			return null;
		}
		else if("mentor".equals(table.toLowerCase())) {
			sql = " SELECT contactEmail, skill FROM "
					+ "MentorSkill Inner Join Skills ON SkillID=id "
					+ "INNER JOIN Mentor ON Mentor.id = MentorID"
					+ "WHERE contactEmail='" + email + "';";
		}
		else if("projectleb.group".equals(table.toLowerCase())) {
			return null;
		}
		
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) result = rs.getString("Skill");
		while(rs.next()) {
			result += ", " + rs.getString("Skill");
		}
		System.out.println("---------------------------------");
		return result;
	};

	
	static void acceptConnection(int sessionNumber, int projectID, String groupEmail, String comment) throws Exception { //DecideProject.java
		openConnection();
		String email = getEmail(sessionNumber);
		
		//Get rest of the info from db
		String sql = "Select * from Notifications WHERe OwnerEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		if(!rs.next()) return;
		String projectName = rs.getString("ProjectName");
		String groupName = rs.getString("GroupName");
		
		//Delete old notification
		sql = "DELETE FROM Notifications WHERE ownerEmail=" + email + ";";
		stmt = conn.createStatement();
		System.out.println("DELETE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		
		//Insert new notification to accepted group/volunteer
		int type = 3;
		sql = "INSERT INTO Notifications (ownerEmail, Type, ProjectName, ProjectID, GroupName, GroupEmail, Comment) VALUES ("
				+ "'" + email +"', " + type + ", '" +projectName + "', '" + projectID + "', '" + groupName + "', '" 
				+ groupEmail + "', '" + comment + "');";
		stmt = conn.createStatement();
		System.out.println("INSERT STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		
		//Connect project to group/volunteer
		sql = "UPDATE Project SET assignedEmail='" + groupEmail + "' WHERE id=" + projectID + ";";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		System.out.println("---------------------------------");
		
	}
	static void rejectConnection(int sessionNumber, int projectID, String groupEmail, String comment) throws Exception { //DecideProject.java
		openConnection();
		String email = getEmail(sessionNumber);
		
		//Get rest of the info from db
		String sql = "Select * from Notifications WHERe OwnerEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		if(!rs.next()) return;
		String projectName = rs.getString("ProjectName");
		String groupName = rs.getString("GroupName");
		
		//Delete old notification
		sql = "DELETE FROM Notifications WHERE ownerEmail=" + email + ";";
		stmt = conn.createStatement();
		System.out.println("DELETE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		
		//Insert new notification to accepted group/volunteer
		int type = 4;
		sql = "INSERT INTO Notifications (ownerEmail, Type, ProjectName, ProjectID, GroupName, GroupEmail, Comment) VALUES ("
				+ "'" + email +"', " + type + ", '" +projectName + "', '" + projectID + "', '" + groupName + "', '" 
				+ groupEmail + "', '" + comment + "');";
		stmt = conn.createStatement();
		System.out.println("INSERT STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		System.out.println("---------------------------------");
	}
	
	static boolean isNewUser(int sessionNumber) throws Exception { //Login.java
		openConnection();
		String email = getEmail(sessionNumber);
		String sql = "Select IsNewUser from LogCredentials WHERE email='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		if(!rs.next()) return true;
		boolean isNewUser = (rs.getInt("IsNewUser") == 0) ? false : true;

		System.out.println("---------------------------------");
		return isNewUser;
	}
	static boolean makeOld(int sessionNumber) throws Exception { //Login.java
		openConnection();
		String email = getEmail(sessionNumber);
		String sql = "UPDATE LogCredentials SET IsNewUser=0 WHERE email='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	
	static String getEmail(int sessionNumber) throws Exception { 
		openConnection();
		
		String sql = "Select email from logCredentials "
				+ "where sessionNumber=" + sessionNumber + ";";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("---------------------------------");
		if(rs.next()) {
			return rs.getString("email");
		}
		return null;
	}
	
	//Profile Setters
	static boolean setOrgName(int sessionNumber, String input) throws Exception { //EditProfile
		String email = getEmail(sessionNumber);
		openConnection();
		String sql = "UPDATE Organization SET Name='" + input + "' WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	static boolean setGroupName(int sessionNumber, String input) throws Exception { //EditProfile
		String email = getEmail(sessionNumber);
		openConnection();
		String sql = "UPDATE projectleb.group SET Name='" + input + "' WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	static boolean setWebsite(int sessionNumber, String input) throws Exception { //EditProfile
		String email = getEmail(sessionNumber);
		String table = getUserType(sessionNumber) + "";
		if("group".equals(table.toLowerCase())) table = "projectleb.group";
		
		openConnection();
		String sql = "UPDATE " + table + " SET Website='" + input + "' WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	static boolean setLivingLocation(int sessionNumber, String input) throws Exception { //EditProfile
		String email = getEmail(sessionNumber);
		String table = getUserType(sessionNumber) + "";
		if("group".equals(table.toLowerCase())) table = "projectleb.group";
		
		openConnection();
		String sql = "UPDATE " + table + " SET LivingLocation='" + input + "' WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	static boolean setWorkingLocation(int sessionNumber, String input) throws Exception { //EditProfile
		String email = getEmail(sessionNumber);
		String table = getUserType(sessionNumber) + "";
		if("group".equals(table.toLowerCase())) table = "projectleb.group";
		if("organization".equals(table.toLowerCase())) {
			System.out.println("ATTENTION: Trying to update workingLocation to organization, there is no such thing in organization table");
			return false;
		}
		
		openConnection();
		String sql = "UPDATE " + table + " SET Website='" + input + "' WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	static boolean setDonation(int sessionNumber, String input) throws Exception { //EditProfile	
		String email = getEmail(sessionNumber);
		openConnection();
		String sql = "UPDATE Donor SET Donations='" + input + "' WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	static boolean setTOS(int sessionNumber, String input) throws Exception { //EditProfile
		openConnection();
		
		//Get email and table name
		String email = getEmail(sessionNumber);
		String table = getUserType(sessionNumber) + "";
		if("group".equals(table.toLowerCase())) table = "projectleb.group";
		
		//Get ID of user in his specific table
		String sql = "SELECT ID FROM LogCredentials INNER JOIN " + table + " ON email=contactEmail WHERE email='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " +  sql);
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		int id = rs.getInt("id");
		
		
		//Get Type Of Service ID
		String[] typesOfService = input.split(", ");
		int[] typeIDs = new int[typesOfService.length];
		for (int i = 0; i < typesOfService.length; i++) {
			sql = "SELECT ID FROM TypeOfService WHERE Service='" + typesOfService[i] + "';";
			stmt = conn.createStatement();
			System.out.println("SELECT STATEMENT: " + sql);
			rs = stmt.executeQuery(sql);
			if(!rs.next()) return false;
			typeIDs[i] = rs.getInt("id");
		}

		//Update database with new connection (volunteer-->TOS)
		sql = "DELETE FROM " + table + "Service WHERE " + table + "ID=" + id + ";";
		stmt = conn.createStatement();
		System.out.println("DELETE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		
		for (int i = 0; i < typeIDs.length; i++) {
			sql = "INSERT INTO " + table + "Service (" + table + "ID, TypeOfServiceID) VALUES ("
					+ id + ", " + typeIDs[i] + ");";
			stmt = conn.createStatement();
			System.out.println("INSERT STATEMENT: " + sql);
			stmt.executeUpdate(sql);
		}
		

		System.out.println("---------------------------------");
		return true;
	}
	static boolean setSkills(int sessionNumber, String input) throws Exception { //EditProfile
		openConnection();
		//Get email and table name
		String email = getEmail(sessionNumber);
		String table = getUserType(sessionNumber) + "";
		if(!"mentor".equals(table.toLowerCase())) return false;
		
		//Get ID of user in his specific table
		String sql = "SELECT ID FROM LogCredentials INNER JOIN " + table + " ON email=contactEmail WHERE email='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " +  sql);
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		int id = rs.getInt("id");
		
		//Get skill ID
		sql = "SELECT ID FROM Skills WHERE Skill='" + input + "';";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		rs = stmt.executeQuery(sql);
		int skillID = rs.getInt("id");
		
		//Update database with new connection (volunteer-->skill)
		sql = "INSERT INTO " + table + "Skill (" + table + "ID, SkillID) VALUES ("
				+ id + ", " + skillID + ");";
		stmt = conn.createStatement();
		System.out.println("INSERT STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	static boolean setDescription(int sessionNumber, String input) throws Exception { //EditProfile
		String email = getEmail(sessionNumber);
		String table = getUserType(sessionNumber) + "";
		if("group".equals(table.toLowerCase())) table = "projectleb.group";
		
		openConnection();
		String sql = "UPDATE " + table + " SET Description='" + input + "' WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	/*static boolean setType(int sessionNumber, String input) {
		return true;
	}*/
	static boolean setEmail(int sessionNumber, String input) throws Exception { //EditProfile
		openConnection();
		//Get old email
		String email = getEmail(sessionNumber);
		//Get table where the record is saved
		String table = getUserType(sessionNumber) + "";
		if("group".equals(table.toLowerCase())) table = "projectleb.group";
		
		//Get some info from this table
		String sql = "Select * from " + table + " WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		if(!rs.next()) return false;
		String description = rs.getString("Description");
		String contactFname = rs.getString("contactFname");
		String contactLname = rs.getString("contactLname");
		String LivingLocation = rs.getString("LivingLocation");
		
		
		//Updating db
		sql = "UPDATE " + table + " SET contactEmail='" + input + "' WHERE contactFname='" + contactFname+ "' AND contactLname='"
				+ contactLname + "' AND LivingLocation='" + LivingLocation + "' AND Description='" + description + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		
		sql = "UPDATE logCredentials set email='" + input +"' WHERE sessionNumber=" + sessionNumber + ";";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		
		System.out.println("---------------------------------");
		return true;
	}
	static boolean setPhoneNumber(int sessionNumber, String input) throws Exception { //EditProfile
		String email = getEmail(sessionNumber);
		String table = getUserType(sessionNumber) + "";
		if("group".equals(table.toLowerCase())) table = "projectleb.group";
		
		openConnection();
		String sql = "UPDATE " + table + " SET contactMobile='" + input + "' WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	static boolean setfName(int sessionNumber, String input) throws Exception { //EditProfile
		String email = getEmail(sessionNumber);
		String table = getUserType(sessionNumber) + "";
		if("group".equals(table.toLowerCase())) table = "projectleb.group";
		
		openConnection();
		String sql = "UPDATE " + table + " SET contactFname='" + input + "' WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	static boolean setlName(int sessionNumber, String input) throws Exception { //EditProfile
		String email = getEmail(sessionNumber);
		String table = getUserType(sessionNumber) + "";
		if("group".equals(table.toLowerCase())) table = "projectleb.group";
		
		openConnection();
		String sql = "UPDATE " + table + " SET contactLname='" + input + "' WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	static boolean setImage(int sessionNumber, String fileName) throws Exception { //CreateProfile.java
		openConnection();
		String email = getEmail(sessionNumber);
		String table = getUserType(sessionNumber) + "";
		if("group".equals(table.toLowerCase())) table = "projectleb.group";
		
		String sql = "UPDATE " + table + " SET ImageURL='" + fileName + "' WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	static boolean toggleEmailPrivacy(int sessionNumber) throws Exception { //TogglePrivacy.java
		openConnection();
		String email = getEmail(sessionNumber);
		String table = getUserType(sessionNumber) + "";
		if("group".equals(table.toLowerCase())) table = "projectleb.group";
		
		//Get old contactEmailPrivacy
		String sql = "SELECT contactEmailPrivacy from " + table + " WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		if(!rs.next()) return false;
		boolean contactEmailPrivacy = (rs.getInt("contactEmailPrivacy") == 1) ? true : false;
		
		//Set new contactEmailPrivacy to opposite of the old one
		int input = (contactEmailPrivacy) ? 0 : 1;
		
		sql = "UPDATE " + table + " SET contactEmailPrivacy='" + input + "' WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}
	static boolean togglePhoneNumberPrivacy(int sessionNumber) throws Exception { //TogglePrivacy.java
		openConnection();
		String email = getEmail(sessionNumber);
		String table = getUserType(sessionNumber) + "";
		if("group".equals(table.toLowerCase())) table = "projectleb.group";
		
		//Get old contactPhoneNumberPrivacy
		String sql = "SELECT contactMobilePrivacy from " + table + " WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		if(!rs.next()) return false;
		boolean contactEmailPrivacy = (rs.getInt("contactMobilePrivacy") == 1) ? true : false;
		
		//Set new contactPhoneNumberPrivacy to opposite of the old one
		int input = (contactEmailPrivacy) ? 0 : 1;
		
		sql = "UPDATE " + table + " SET contactMobilePrivacy='" + input + "' WHERE contactEmail='" + email + "';";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		System.out.println("---------------------------------");
		return true;
	}

	//Project
	static boolean isProjectOwner(int sessionNumber, int projectID) throws Exception { //GetProjects.java, UserProfile.java
		openConnection();
		String email = getEmail(sessionNumber);
		
		String sql = "Select id from Project WHERE ContactEmail='"
				+ email + "';";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		
		boolean result = false;
		while(rs.next()) {
			int id = rs.getInt("id");
			if(projectID == id) result = true;
		}		
		
		System.out.println("---------------------------------");
		return result;
		
	}
	static boolean deleteProject(int sessionNumber, int id) throws Exception { //DeleteProject.java
		openConnection();
		
		String sql = "Delete From Project WHERE id=" + id + ";";
		stmt = conn.createStatement();
		System.out.println("DELETE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		
		System.out.println("---------------------------------");
		return true;
	}
	static Project getProject(int id) throws Exception { //ProjectProfile.java
		openConnection();
		
		String sql = "SELECT * from Project WHERE id=" + id + ";";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);

		if(!rs.next()) return null;
		
		Project current = new Project();
		current.ageGroup = rs.getString("ageRange");
		current.areaOfService = rs.getString("Location");
		current.basicSkills = getProjectSkill(id);
		current.date = rs.getString("dueDate");
		current.name = rs.getString("Name");
		current.needs = rs.getString("needs");
		current.picURL = rs.getString("ImageURL");
		current.projectID = id;
		int status = rs.getInt("Status");
		if(status == 0) {
			current.status = Status.potential;
			current.waitingAcception = true;
		}
		else if(status == 1) {
			current.status = Status.potential;
			current.waitingAcception = false;
		}
		else if(status == 2) {
			current.status = Status.inProcess;
			current.waitingAcception = false;
		}
		else if(status == 3) {
			current.status = Status.finished;
			current.waitingAcception = false;
		}
		current.tos = getProjectService(id);
		current.fName = rs.getString("contactFname");
		current.lName = rs.getString("contactLname");
		current.email = rs.getString("contactEmail");
		current.phoneNumber = rs.getString("contactMobile");
				
		return current;
	}
	static String getProjectService(int id) throws Exception {
		openConnection();
		String sql = "Select service from project INNER JOIN TypeOfService on TypeofService=TypeOfService.id WHERE project.id="+id+";";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		
		String result = "";
		if(rs.next()) result = rs.getString("service");
		while(rs.next()) {
			result += ", " + rs.getString("service");
		}
		if("".equals(result)) result = null;
		
		System.out.println("---------------------------------");
		return result;		
	}
	static String getProjectSkill(int id) throws Exception {
		openConnection();
		String sql = "Select skill from ProjectSkill INNER JOIN Skills on skillID=skills.id INNER JOIN "
				+ "Project on projectID = project.id WHERE project.id="+id+";";
		stmt = conn.createStatement();
		System.out.println("SELECT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		
		String result = "";
		if(rs.next()) result = rs.getString("skill");
		while(rs.next()) {
			result += ", " + rs.getString("skill");
		}
		if("".equals(result)) result = null;
		
		System.out.println("---------------------------------");
		return result;		
	}
	static int generateProjectId() throws Exception{ //CreateProject.java
		openConnection();
		int dbProjectCount = DumbDatabase.dbProjectCount++;
		String sql = "INSERT INTO Project (Name) VALUES ('temp" + dbProjectCount + "')";
		stmt = conn.createStatement();
		System.out.println("INSERT STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		
		sql = "Select id from Project WHERE Name='temp" + dbProjectCount + "'";
		stmt = conn.createStatement();
		System.out.println("INSERT STATEMENT: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		if(!rs.next()) return -1;
		int projectID = rs.getInt("id");
		if(rs.next()) {
			throw new Exception("There are multiple results for temp" + dbProjectCount);
		}
		
		System.out.println("---------------------------------");
		return projectID;
	}
	
	//Project setters
	static boolean setProjectImage(int sessionNumber, int projectId, String input) throws Exception { //CreateProfile.java
		openConnection();
		
		if(!isProjectOwner(sessionNumber, projectId)) return false;
		
		String sql = "Update Project SET ImageURL='" + input + "' WHERE id=" + projectId + ";";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		return true;
	}
	static boolean setProjectTOS(int sessionNumber, int projectId, String input) throws Exception { //EditProject.java
		openConnection();
		
		//Get Type Of Service ID
		String[] typesOfService = input.split(", ");
		int[] typeIDs = new int[typesOfService.length];
		for (int i = 0; i < typesOfService.length; i++) {
			String sql = "SELECT id FROM TypeOfService WHERE Service='" + typesOfService[i] + "';";
			stmt = conn.createStatement();
			System.out.println("SELECT STATEMENT: " + sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.next()) return false;
			typeIDs[i] = rs.getInt("id");
		}

		//Update database with new connection (volunteer-->TOS)
		String sql = "DELETE FROM ProjectService WHERE ProjectID=" + projectId + ";";
		stmt = conn.createStatement();
		System.out.println("DELETE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		
		for (int i = 0; i < typeIDs.length; i++) {
			sql = "INSERT INTO ProjectService (ProjectID, TypeOfServiceID) VALUES ("
					+ projectId + ", " + typeIDs[i] + ");";
			stmt = conn.createStatement();
			System.out.println("INSERT STATEMENT: " + sql);
			stmt.executeUpdate(sql);
		}
		

		System.out.println("---------------------------------");
		return true;
	}
	static boolean setProjectDate(int sessionNumber, int projectId, String input) throws Exception { //EditProject.java
		openConnection();
		
		//if(!isProjectOwner(sessionNumber, projectId)) return false;
		
		String sql = "Update Project SET dueDate='" + input + "' WHERE id=" + projectId + ";";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		return true;
	}
	static boolean setProjectLocation(int sessionNumber, int projectId, String input) throws Exception  { //EditProject.java
		openConnection();
		
		//if(!isProjectOwner(sessionNumber, projectId)) return false;
		
		String sql = "Update Project SET Location='" + input + "' WHERE id=" + projectId + ";";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		return true;
	}
	static boolean setProjectfName(int sessionNumber, int projectId, String input) throws Exception { //EditProject.java
		openConnection();
		
		//if(!isProjectOwner(sessionNumber, projectId)) return false;
		
		String sql = "Update Project SET contactFname='" + input + "' WHERE id=" + projectId + ";";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		return true;
	}
	static boolean setProjectlName(int sessionNumber, int projectId, String input) throws Exception { //EditProject.java
		openConnection();
		
		//if(!isProjectOwner(sessionNumber, projectId)) return false;
		
		String sql = "Update Project SET contactLname='" + input + "' WHERE id=" + projectId + ";";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		return true;
	}
	static boolean setProjectPhoneNumber(int sessionNumber, int projectId, String input) throws Exception { //EditProject.java
		openConnection();
		
		if(!isProjectOwner(sessionNumber, projectId)) return false;
		
		String sql = "Update Project SET contactMobile='" + input + "' WHERE id=" + projectId + ";";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		return true;
	}
	static boolean setProjectEmail(int sessionNumber, int projectId, String input) throws Exception { //EditProject.java
		openConnection();
		
		//if(!isProjectOwner(sessionNumber, projectId)) return false;
		
		String sql = "Update Project SET contactEmail='" + input + "' WHERE id=" + projectId + ";";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		return true;
	}
	static boolean setProjectAge(int sessionNumber, int projectId, String input) throws Exception { //EditProject.java
		openConnection();
		
		//if(!isProjectOwner(sessionNumber, projectId)) return false;
		
		String sql = "Update Project SET ageRange='" + input + "' WHERE id=" + projectId + ";";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		return true;
	}
	static boolean setProjectSkills(int sessionNumber, int projectId, String input) throws Exception { //EditProject.java
		openConnection();

		return true;
	}
	static boolean setProjectDonations(int sessionNumber, int projectId, String input) throws Exception { //EditProject.java
		openConnection();
		
		//if(!isProjectOwner(sessionNumber, projectId)) return false;
		
		String sql = "Update Project SET Needs='" + input + "' WHERE id=" + projectId + ";";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		return true;
	}
	static boolean setProjectComments(int sessionNumber, int projectId, String input) throws Exception { //EditProject.java
		openConnection();
		
		//if(!isProjectOwner(sessionNumber, projectId)) return false;
		
		String sql = "Update Project SET Description='" + input + "' WHERE id=" + projectId + ";";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		return true;
	}
	static boolean setProjectName(int sessionNumber, int projectId, String input) throws Exception { //EditProject.java
		openConnection();
		//if(!isProjectOwner(sessionNumber, projectId)) return false;
		
		String sql = "Update Project SET Name='" + input + "' WHERE id=" + projectId + ";";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);
		return true;
	}
	
	static boolean startProject(int sessionNumber, int projectId) throws Exception { //StartProject.java
		openConnection();
		
		String sql = "UPDATE Project Set Status=2 WHERE id=" + projectId + ";";
		stmt = conn.createStatement();
		System.out.println("UPDATE STATEMENT: " + sql);
		stmt.executeUpdate(sql);

		return true;
	}
	
	//search
	static Volunteer[] getVolunteerSearch(int sessionNumber, String type, String keyword) { //GetSearch.java
		//if type==name, put either groupName or orgName, the other one is empty
		Volunteer[] v = new Volunteer[5];
		for(int i = 0; i < 5; i++) {
			v[i] = new Volunteer();
			v[i].orgName = "Organization " + i;
			v[i].imgURL = "test";
			v[i].fname = "Samer" + i;
			v[i].lname = "AL Masri" + i;
			v[i].email = "myEmail" + i;
			v[i].donations = "myDonations" + i;
			v[i].skills = "mySkills" + i;
			v[i].workingLocation = "myLocations" + i;
			v[i].orgName = "SamerOrg";
			v[i].groupName = "";
			v[i].imgURL = "/Project/Pictures/search.jpg";
		}
		return v;
	}
	
	//Database Framework
	public static void insert (String table, String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6,
			 String arg7, String arg8, String arg9, String arg10, String arg11) throws Exception {
		openConnection();
		String[] arg = {arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11};
		
		String sql = "INSERT INTO " + table + " VALUES (";
		
		int tempCount = 0;
		for (int i = 0; i < arg.length; i++) {
			if(arg[i] != null) {
				if(tempCount==0) sql += arg[i];
				else sql += ", " + arg[i];
				tempCount++;
			}
		}
		sql += ");";
		
		System.out.println("INSERT STATEMENT: " + sql);
		
		stmt = conn.createStatement();
	    stmt.executeUpdate(sql);
	}
	
	public static void edit (String table, String email, String columnName, String value) throws Exception {
		openConnection();
		String sql = "UPDATE " + table + " SET " + columnName + "=" + value + " WHERE email='"+ email +"';";
		
		System.out.println("EDIT STATEMENT: " + sql);

		stmt = conn.createStatement();
	    stmt.executeUpdate(sql);
	}
	
	public static void remove(String table, String email) throws Exception {
		openConnection();
		String sql = "DELETE FROM " + table + " WHERE contactEmail=" + email + ";";
		
		System.out.println("DELETE STATEMENT: " + sql);
		
		stmt = conn.createStatement();
	    stmt.executeQuery(sql);
	}
	
}
