# SCHEDULEME

## What is SCHEDULEME?

SCHEDULEME will be providing a simpler way to navigate through the availability of your group members and figure out when you can plan your meetings.<br>
How it works: each group member submits their name and the shared json file (assuming one has already been created) and selects their **unavailability** for the next week. The application will then output choices of proposed meeting times where everyone in the group is free. It is up to the team to decide which of those times they would like. 

This repository contains:

* Repository (lib) for .jar files for the Java modules required to download for compiler
	
* A tool which schedules meeting times

## Getting Started

1. Download or clone the repository.
2. This tool depends on the following Java modules: java.io, java.lang, com.google.json(provided), java.util, java.nio, org.json.simple(provided). Please ensure these modules are in your Java environment.<br>
If you are running on Dr. Java, add the neccessary jar files to your environment by clicking Edit>Preferences> Add Classpath then browsing for your files. Once all are added, click 'Apply' then 'OK'.

## How to run

1. Run Main.java, enter your name and (if you have a json file with prior results) upload your json file.
2. Submit and enter your **unavailable** times for the next week.
3. Hit calculate when finished and the results will pop on screen for the availability of you and whoever else previously calculated on your json file.

### Notes

Only accepts json files.<br>
If no json file is initially provided, it will be stored by default in Downloads/ScheduleMe.json (tested only for Windows). This can be manually changed in SamsFunctions.java near the top of the addEntry() function.

### Created By

Vistassja Williams, Samantha Morris, Keara Leibovitz, Aisha Mohammed


