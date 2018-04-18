# Description
The development of this web application started in October 2015. It is intended for an NGO with the mission to improve volunteering and community service experience throughout Lebanon. The website’s goal is connecting volunteers to NGOs via a Facebook-like interface. Due to university course load and other responsibilities, I resigned from working on it in February 2016.

# Technical Description
This project is implemented using Java servlets. The servlets interact with a MySQL server in order to provide their functionality. More detailed technical description and known bugs are found in the **documentation file**.

# Screenshots
Screenshots of the website as its developed so far is found in the **screenshots** directory.
Description of screenshots:
**Homepage**
Homepage: the first page a viewer would see when visiting the website. The user can sign up or sign in using this page.
**Create Profile - Upload Picture**
Create Profile - Upload Picture: When a new user signs up, this page is visited to upload their picture.
**Create Profile - Enter Info**
Create Profile - Enter Info: When a new user is signing up, this page is visited to take their information (name, email...).
**Dashboard**
- Dashboard: When a user signs in, this is their main page where they can view their notifications and news of their network. They can also take actions like creating a project or editing their profile.
**User Profile**
User Profile: The public profile that appears for a user.
**Project Profile**
Project Profile: The public profile that appears for a project.
**Create Project**
Create Project: When a user is creating a new project, this page is visited to enter the information about the project.

# Directory Description
* Database: Contains the database schema and the SQL queries to create and populate the database.
* Src: Contains the source code of the Java servlets
* WebContent: Contains some supporting scripts and documents for the pages to be viewed correctly; such as images and javascript and css codes.