
public class Volunteer {
	/** The profile picture URL */
	public String imgURL;
	/** First Name */
	public String fname;
	/** Last Name */
	public String lname;
	public String email;
	public String phoneNumber;
	/** True if email is allowed to be publicly shown on the profile, False if it should only be shown to the admin */
	public boolean emailPublic;
	/** True if phone number is allowed to be publicly shown on the profile, False if it should only be shown to the admin */
	public boolean phoneNumberPublic;
	/** In case the volunteer was a group of volunteer, they need to have a name */
	public String groupName;
	/** In case the volunteer user was an organization, they need a name */
	public String orgName;
	public String website;
	/** Type of service */
	public String TOS;
	public String livingLocation;
	/** Location where the volunteer prefers to work */
	public String workingLocation;
	/** Any specified description the user would like to give to let people know more about him */
	public String comments;
	/** In case the user was a mentor... */
	public String skills;
	/** In case the user was a donor... */
	public String donations;
	/** an array of projects, each containing its unique field values (check Project object for more info) */
	public Project[] projects;
}
