# SCHEDULEME


## What is SCHEDULEME?

SCHEDULEME will be providing a simpler way to navigate through the availability of your group members and figure out when you can plan your meetings. How it works: each group member submits their calendar, and a group leader will input a length of time needed for the meeting. The application will then output choices of proposed meeting times where everyone in the group is free, and it is up to the team leader to decide which of those meeting times they would like. 

This repository contains:

* Repository (lib) for .jar files for the Java modules required to download for compiler
	
* A tool which schedules meeting times


## Getting Started

1.	Download or clone the repository
2.	This tool depends on the following Java modules: java.io, java.lang, com.google.json(provided), java.util, java.nio, org.json.simple(provided). Please ensure these modules are in your Java environment.
	a. If you are running on Dr. Java, add the neccessary jar files to your environment by clicking Edit>Preferences> Add Classpath then browsing for you files. Once all are added, click 'Apply' then 'OK'.

## How to run

Run Main.java, enter your name and (if you have a json file with prior results) upload your json file.
Submit and enter your **unavailble** times for the next week.
Hit calculate when finished and the results will pop on screen for the availability of you and whoever else mentioned on your json file.

### Notes

If no json file is initially provided, it will be stored by default in Downloads/ScheduleMe.json (tested only for Windows).


