package com.project.m;

import java.io.File;

public class PersonFile extends javax.swing.filechooser.FileFilter {

	@Override
	public boolean accept(File file) {
		// TODO Auto-generated method stub
		if(file.isDirectory())
		{
			return true;
		}
		String name = file.getName();
		String extension = Util.Extension(name);
		if(extension == null)
		{
			return false;
		}
		
		if(extension.equals("per"))
		{
			return true;
		}
		return false;
	}

	@Override
	public String getDescription() {
		
		
		return "Person database file(*.per)";
	}

}
