package com.project.m;

public class Util {

	public static String Extension(String name)
	{
	int pointIndex = name.lastIndexOf(".");	
	
	if(pointIndex==-1)
	{
		return null;
	}
	
	if(pointIndex==name.length()-1)
	{
		return null;
	}
	
	return name.substring(pointIndex+1, name.length());
	}
	
}
