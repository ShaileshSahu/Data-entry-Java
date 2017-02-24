package com.project.m;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.*;

public class MenuBars extends JPanel {
	JButton b1,b2,b3,b4;
	
	
	MenuBars()
	{
setLayout(new FlowLayout());
	JMenuBar br = new JMenuBar();
	JMenu mn = new JMenu("File");
	JMenu mn1 = new JMenu("Close");
	br.add(mn1);
	br.add(mn);
	add(br);

	
	}

	
	
}
