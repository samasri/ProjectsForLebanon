CREATE DATABASE projectleb;
/*Use projectleb;*/

CREATE TABLE `Group` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(100),
  `contactFname` VARCHAR(100) ,
  `contactLname` VARCHAR(100) ,
  `Website` VARCHAR(50) ,
  `LivingLocation` VARCHAR(500) ,
  `WorkingLocation` VARCHAR(500) ,
  `Description` VARCHAR(500) ,
  `contactEmail` VARCHAR(100) ,
  `contactMobile` VARCHAR(100) ,
  `contactEmailPrivacy` INT(1) ,
  `contactMobilePrivacy` INT(1) ,
  `ImageURL` VARCHAR(200),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB; 
 
CREATE TABLE `Donor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Website` VARCHAR(50) ,
  `LivingLocation` VARCHAR(500) ,
  `WorkingLocation` VARCHAR(500) ,
  `Donations` VARCHAR(500) ,
  `Description` VARCHAR(500) ,
  `contactFname` VARCHAR(100) ,
  `contactLname` VARCHAR(100) ,
  `contactEmail` VARCHAR(100) ,
  `contactMobile` VARCHAR(100) ,
  `contactEmailPrivacy` INT(1) ,
  `contactMobilePrivacy` INT(1) ,
  `ImageURL` VARCHAR(200) ,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;

CREATE TABLE `Organization` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(10) ,
  `Website` VARCHAR(50) ,
  `LivingLocation` VARCHAR(500) ,
  `Description` VARCHAR(500) ,
  `contactFname` VARCHAR(100) ,
  `contactLname` VARCHAR(100) ,
  `contactEmail` VARCHAR(100) ,
  `contactMobile` VARCHAR(100),
  `contactEmailPrivacy` INT(1) ,
  `contactMobilePrivacy` INT(1) ,
  `ImageURL` VARCHAR(200) ,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;
        
CREATE TABLE `Mentor` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Website` VARCHAR(50) ,
  `LivingLocation` VARCHAR(500) ,
  `WorkingLocation` VARCHAR(500),
  `Description` VARCHAR(500) ,
  `contactFname` VARCHAR(100) ,
  `contactLname` VARCHAR(100) ,
  `contactEmail` VARCHAR(100) ,
  `contactMobile` VARCHAR(100) ,
  `contactEmailPrivacy` INT(1) ,
  `contactMobilePrivacy` INT(1) ,
  `ImageURL` VARCHAR(200) ,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;

 CREATE TABLE `TypeOfService` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Service` VARCHAR(100) ,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;
 
CREATE TABLE `Project` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `Status` INT ,
  `Name` VARCHAR(100) ,
  `Location` VARCHAR(100),
  `TypeOfService` INT,
  `dueDate` VARCHAR(50) ,
  `AgeRange` VARCHAR(20) ,
  `Needs` VARCHAR(500) ,
  `contactFname` VARCHAR(100) ,
  `contactLname` VARCHAR(100) ,
  `contactEmail` VARCHAR(100) ,
  `contactMobile` VARCHAR(100),
  `contactEmailPrivacy` INTEGER(1) ,
  `contactMobilePrivacy` INTEGER(1) ,
  `ImageURL` VARCHAR(200) ,
  `assignedEmail` VARCHAR(100) ,
  `Description` VARCHAR(500) ,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`TypeOfService`) REFERENCES `TypeOfService`(id)

)ENGINE=InnoDB;

CREATE TABLE `Skills` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Skill` VARCHAR(500) ,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;
                               
CREATE TABLE `MentorSkill` (
  `MentorID` INT NOT NULL AUTO_INCREMENT ,
  `SkillID` INT ,
  PRIMARY KEY (`MentorID`, `SkillID`),
  FOREIGN KEY (`MentorID`) REFERENCES `Mentor`(id),
  FOREIGN KEY (`SkillID`) REFERENCES `Skills`(id)

)ENGINE=InnoDB;
                               
CREATE TABLE `ProjectSkill` (
  `SkillID` INT,
  `ProjectID` INT,
  PRIMARY KEY (`ProjectID`, `SkillID`),
  FOREIGN KEY (`ProjectID`) REFERENCES `Project`(id),
   FOREIGN KEY (`SkillID`) REFERENCES `Skills`(id)
)ENGINE=InnoDB;
  
CREATE TABLE `GroupService` (
  `GroupID` INT NOT NULL AUTO_INCREMENT ,
  `TypeOfServiceID` INT,
  PRIMARY KEY (`GroupID`, `TypeOfServiceID`),
  FOREIGN KEY (`GroupID`) REFERENCES `Group`(id),
    FOREIGN KEY (`TypeOfServiceID`) REFERENCES `TypeOfService`(id)

)ENGINE=InnoDB;

CREATE TABLE `DonorService` (
  `DonorID` INT NOT NULL AUTO_INCREMENT ,
  `TypeOfServiceID` INT ,
  PRIMARY KEY (`DonorID`, `TypeOfServiceID`),
  FOREIGN KEY (`DonorID`) REFERENCES `Donor`(id),
    FOREIGN KEY (`TypeOfServiceID`) REFERENCES `TypeOfService`(id)

)ENGINE=InnoDB;
 
CREATE TABLE `MentorService` (
  `MentorID` INT NOT NULL AUTO_INCREMENT ,
  `TypeOfServiceID` INT,
  PRIMARY KEY (`MentorID`, `TypeOfServiceID`),
  FOREIGN KEY (`MentorID`) REFERENCES `Mentor`(id),
    FOREIGN KEY (`TypeOfServiceID`) REFERENCES `TypeOfService`(id)
)ENGINE=InnoDB;

CREATE TABLE `OrganizationService` (
  `TypeOfServiceID` INT,
  `OrganizationID` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`OrganizationID`, `TypeOfServiceID`),
  FOREIGN KEY (`OrganizationID`) REFERENCES `Organization`(id),
  FOREIGN KEY (`TypeOfServiceID`) REFERENCES `TypeOfService`(id)


)ENGINE=InnoDB;

CREATE TABLE `LogCredentials` (
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100),
  `sessionNumber` INT,
  `Typ` VARCHAR(50), 
  `IsNewUser` INT
)ENGINE=InnoDB;

CREATE TABLE `Notifications` (
  `OwnerEmail` VARCHAR(100),
  `Type` VARCHAR(100) NOT NULL,
  `ProjectName` VARCHAR(100),
  `ProjectID` INT,
  `GroupName` VARCHAR(100),
  `GroupEmail` VARCHAR(100)
)ENGINE=InnoDB;

CREATE TABLE `Connections` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `VolunteerEmail` VARCHAR(100) NOT NULL,
  `ProjectID` INT,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;

CREATE TABLE `ProjectService` (
  `ProjectID` INT NOT NULL AUTO_INCREMENT ,
  `TypeOfServiceID` INT,
  PRIMARY KEY (`ProjectID`, `TypeOfServiceID`)
)ENGINE=InnoDB;


Insert INTO TypeOfService VALUES (1, 'Animals'); 
Insert INTO TypeOfService VALUES (2, 'Children Or Youth');
Insert INTO TypeOfService VALUES (3, 'Culture');
Insert INTO TypeOfService VALUES (4, 'Disabled');
Insert INTO TypeOfService VALUES (5, 'Disaster Relief');
Insert INTO TypeOfService VALUES (6, 'Education');
Insert INTO TypeOfService VALUES (7, 'Elderly');
Insert INTO TypeOfService VALUES (8, 'Environment');
Insert INTO TypeOfService VALUES (9, 'Health');
Insert INTO TypeOfService VALUES (10, 'Heritage');
Insert INTO TypeOfService VALUES (11, 'Housing Homeless');
Insert INTO TypeOfService VALUES (12, 'Human Rights');
Insert INTO TypeOfService VALUES (13, 'Legal Aid');
Insert INTO TypeOfService VALUES (14, 'Refugees');
Insert INTO TypeOfService VALUES (15, 'Social Integration');
Insert INTO TypeOfService VALUES (16, 'Sports And Recreation');
Insert INTO TypeOfService VALUES (17, 'Substance Abuse');
Insert INTO TypeOfService VALUES (18, 'Women');
Insert INTO TypeOfService VALUES (19, 'Other (explain more in the description)');


Insert INTO Skills VALUES (1, 'Akkar'); 
Insert INTO Skills VALUES (2, 'Aley');
Insert INTO Skills VALUES (3, 'Baabda');
Insert INTO Skills VALUES (4, 'Baalbek');
Insert INTO Skills VALUES (5, 'Batroun');
Insert INTO Skills VALUES (6, 'Beirut');
Insert INTO Skills VALUES (7, 'Bint Jbeil');
Insert INTO Skills VALUES (8, 'Bsharri');
Insert INTO Skills VALUES (9, 'Chouf');
Insert INTO Skills VALUES (10, 'Hasbaya');
Insert INTO Skills VALUES (11, 'Hermel');
Insert INTO Skills VALUES (12, 'Jbeil');
Insert INTO Skills VALUES (13, 'Jezzine');
Insert INTO Skills VALUES (14, 'Keserwan');
Insert INTO Skills VALUES (15, 'Koura');
Insert INTO Skills VALUES (16, 'Marjayoun');
Insert INTO Skills VALUES (17, 'Matn');
Insert INTO Skills VALUES (18, 'Miniyeh Danniyeh');
Insert INTO Skills VALUES (19, 'Rashaya');
Insert INTO Skills VALUES (20, 'Sidon');
Insert INTO Skills VALUES (21, 'Tripoli');
Insert INTO Skills VALUES (22, 'Tyre');
Insert INTO Skills VALUES (23, 'West Beqaaa');