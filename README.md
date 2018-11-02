# SCHEDULEME

## What is SCHEDULEME?

SCHEDULEME will be providing a simpler way to navigate through the availability of your group members and figure out when you can plan your meetings. People are more likely to know when they are busy and they have to think more to know when they are free, so with SCHEDULEME they can submit when they are busy, rather than when they are free. With the inclusion of colour to help with readability and understanding, and the ability to deselect, select and resubmit your times, SCHEDULEME is a simple and effective way to figure out the best time for your group to meet.<br>
How it works: each group member submits their name and the shared json file (assuming one has already been created) and selects their **unavailability** for the next week. The application will then output choices of proposed meeting times where everyone in the group is free. It is up to the team to decide which of those times they would like. 

This repository contains:

* A lib repository containing .jar files for the Java modules required to download for compiler
* A tool which schedules meeting times

## Getting Started

1. Download or clone the repository.
2. This tool depends on the following Java modules: java.io, java.lang, com.google.json(provided), java.util, java.nio, org.json.simple(provided). Please ensure these modules are in your Java environment.  Most of the modules you would need should already be included in your Java library, but you may have to add a few which are included in the lib folder.<br>
	- If you are running in Dr. Java, add the necessary jar files to your environment by clicking Edit>Preferences>Add Classpath, then browsing for your files in the lib repository. Once all are added, click 'Apply' then 'OK'.<br>
	- Similarly, if running in eclipse, right-click the project folder>Build Path>Configure Build Path. Click the "Libraries" tab and then the  "Add External JARS..." button. Select your files in the lib repository. Click 'Apply' then 'OK'.
3. Run Main.java

## How to use

1. Run Main.java, enter your name and (if you have a json file with prior results) upload your json file.
2. Submit and enter your **unavailable** times for the next week.
3. Click Calculate when finished and the results will pop on screen for the availability of you and whoever else previously calculated on your json file.

### Notes

* Only accepts json files.<br>
* If no json file is initially provided, it will be stored by default in Downloads/ScheduleMe.json (tested only for Windows). This can be manually changed in SamsFunctions.java on line 48, near the top of the addEntry() function.<br>
* Names must be unique unless you wish to redo your availability.

### Files in project

*Main.java* - runs the program.

*gui_init.java* - sets up and displays the initial gui you see.

*CalendarPanel.java* - contains the buttons that represent the actual days in a calendar.

*DayPanel.java* - contains the JLabels that represent the weekdays of the calendar.

*MonthYearPanel.java* - contains the JLabels that represent the month and the year.

*OneWeek.java* - creates one week of date objects.

*CalendarFrame.java* - adds all of the panels: CalendarPanel, DayPanel, and MonthYearPanel to the main frame that will make up the window.

*convertBinToTime.java* - unused except for testing purposes.

*convert.java* - converts boolean array for availability to a string format and vice versa. The times are 6 AM to 12 AM per day for a week. 

*SamsFunctions.java* - Adds user entries to
	a) a new file, ScheduleMe.json (if none provided), located in the user's Download directory
	b) the file provided (at its original location)
	Compares and calculates the results of each entry (user) and determines common availability.

*gui_final.java* - sets up and displays the results computed by *SamsFunctions.java*.

*gson-2.7.jar*, *json-20140107.jar*, *json-simple-1.1.jar* - jar files needed to run functions in *SamsFunctions.java*.

*help_icon.png* - used to hover over and display a help message in *MonthYearPanel.java*.

### Created By

Vistassja Williams, Samantha Morris, Keara Leibovitz, Aisha Mohammed
