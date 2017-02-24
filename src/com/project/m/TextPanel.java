package com.project.m;

import java.awt.*;
import javax.swing.*;
public class TextPanel extends JPanel {

	JTextArea area;
	
	 public TextPanel()
	 {
		 area = new JTextArea(22,30);
		 setLayout(new BorderLayout());
		 add(new JScrollPane(area));
	 }
	 
	 
	 public void appendText(String su)
	 {
		 area.append(su+"\n");
		 
	 }
	
	
	public void setT(String n)
	{
		area.setText(n);
	}
	 
}
