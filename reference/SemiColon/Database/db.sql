drop database if exists semicolon;

create database semicolon;

use semicolon;


DROP TABLE IF EXISTS `systemadmin`;
CREATE TABLE `systemadmin` (
	`username` varchar(50) PRIMARY KEY not null,
	`fullname` varchar(50) not null,
	`password` varchar(50) not null,
	`email` varchar(70) not null,
	`profilename` varchar(50) not null
);

DROP TABLE IF EXISTS `reviewer`;
CREATE TABLE `reviewer` (
	`username` varchar(50) PRIMARY KEY not null,
	`fullname` varchar(50) not null,
	`password` varchar(50) not null,
	`email` varchar(70) not null,
	`profilename` varchar(50) not null
);

DROP TABLE IF EXISTS `conference`;
CREATE TABLE `conference` (
	`username` varchar(50) PRIMARY KEY not null,
	`fullname` varchar(50) not null,
	`password` varchar(50) not null,
	`email` varchar(70) not null,
	`profilename` varchar(50) not null
);

DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
	`username` varchar(50) PRIMARY KEY not null,
	`fullname` varchar(50) not null,
	`password` varchar(50) not null,
	`email` varchar(70) not null,
	`profilename` varchar(50) not null
);

DROP TABLE IF EXISTS `userprofile`;
CREATE TABLE `userprofile` (
	`profilename` varchar(50) PRIMARY KEY not null,
	`description` varchar(50) not null
);

INSERT INTO `systemadmin` (`username`,`fullname`, `password`, `email` , `profileName`) VALUES
('admin', 'Admin1', 'admin', 'admin1@asda.com', "SystemAdmin"),
('reviewer', 'Reviewer1', 'reviewer', 'reviewer1@asda.com', "SystemAdmin"),
('cc', 'CC', 'cc', 'cc@asda.com', "SystemAdmin"),
('author', 'Author', 'author', 'author1@asda.com', "SystemAdmin");

INSERT INTO `reviewer` (`username`,`fullname`, `password`, `email` , `profileName`) VALUES
('admin', 'Admin1', 'admin', 'admin1@asda.com', "Reviewer"),
('reviewer', 'Reviewer1', 'reviewer', 'reviewer1@asda.com', "Reviewer"),
('cc', 'CC', 'cc', 'cc@asda.com', "Reviewer"),
('author', 'Author', 'author', 'author1@asda.com', "Reviewer");

INSERT INTO `conference` (`username`,`fullname`, `password`, `email` , `profileName`) VALUES
('admin', 'Admin1', 'admin', 'admin1@asda.com', "Conference"),
('reviewer', 'Reviewer1', 'reviewer', 'reviewer1@asda.com', "Conference"),
('cc', 'CC', 'cc', 'cc@asda.com', "Conference"),
('author', 'Author', 'author', 'author1@asda.com', "Conference");

INSERT INTO `author` (`username`,`fullname`, `password`, `email` , `profileName`) VALUES
('admin', 'Admin1', 'admin', 'admin1@asda.com', "Author"),
('reviewer', 'Reviewer1', 'reviewer', 'reviewer1@asda.com', "Author"),
('cc', 'CC', 'cc', 'cc@asda.com', "Author"),
('author', 'Author', 'author', 'author1@asda.com', "Author");

INSERT INTO `userprofile` (`profilename`,`description`) VALUES
("System Admin", "Manage User Accounts and User Profile"),
("Reviewer", "Review Book"),
("Conference Chair", "???"),
("Author", "???");



