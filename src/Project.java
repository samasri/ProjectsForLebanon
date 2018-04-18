
public class Project {
	/** A unique ID for each project */
	public int projectID;
	/** The URL of the profile picture of each project */
	public String picURL;
	/** potential (not yet assigned to volunteers), inProgress, or finished */
	public Status status;
	/** True if the project is still waiting acception from admin (visibile only to user) */
	public boolean waitingAcception;
	public String name;
	public String areaOfService;
	/** Type of service */
	public String tos;
	public String date;
	//public String location; Need to figure out what this is
	public String ageGroup;
	/** Skills needed for this project to be done (mentors should have these skills) */
	public String basicSkills;
	/** Needed donations from donors for this project to be done */
	public String needs;
	
	public String fName;
	public String lName;
	public String email;
	public String phoneNumber;
}
