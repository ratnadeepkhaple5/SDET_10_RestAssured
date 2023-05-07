package com.rmgYantra.GenericLibrary;

public interface EndPoints {

	String createProject="/addProject";
	
	String completeUpdate="/projects/{proId}";

	String getSingleProject="/projects/{proId}";
	
	String getAllProjects="/projects";
	
	String deleteProject="/projects/{proId}";
	
	//String partialUpdate
}
