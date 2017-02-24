package com.project.m;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Toolbar extends JPanel implements ActionListener {
	

	private JButton bt1,bt2,bt3,bt4;
	TextPanel panel;
	Toolbar()
	{
		setLayout(new FlowLayout(FlowLayout.LEFT));
		bt1 = new JButton("File");
		bt2 = new JButton("view");
		bt3 = new JButton("About us");
		bt4 = new JButton("edit");
	add(bt1);
	add(bt2);
	add(bt3);
	add(bt4);
	bt1.addActionListener(this);
	bt2.addActionListener(this);
	
		//setLayout(new BorderLayout());
		/*JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu view = new JMenu("View");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		bar.add(file);
		bar.add(edit);	bar.add(view);	bar.add(help);
		
		JMenuItem op = new JMenuItem("open");
		JMenuItem cl = new JMenuItem("Close");
		JMenuItem sv = new JMenuItem("Save");
		JMenuItem svs = new JMenuItem("Save As..");
		JMenuItem p = new JMenuItem("print");
		JMenuItem th = new JMenuItem("Theme");
		cl.setEnabled(false);
JCheckBoxMenuItem lc = new JCheckBoxMenuItem("Licence");		
		file.add(op);
		file.add(sv);
		file.add(svs);
		file.add(p);
		
		file.add(cl);
		file.add(lc);
		
	
		JMenu jm = new JMenu("Italic");
		JMenuItem it = new JMenuItem("Classic");
		JMenuItem iy = new JMenuItem("Crystal");
		jm.add(it);
		jm.add(iy);
		
		th.add(jm);
		file.add(th);
		
		
		
		
		
		*/
		
		
		
		
		
		
	}
	
	

	public void setTextPanel(TextPanel panel) {
		// TODO Auto-generated method stub
		
		this.panel=panel;
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton btn1=(JButton) e.getSource();
		
		if(btn1==bt1)
		{
		panel.appendText("Hello\n");
		}
		if(btn1==bt2)
		{
			panel.appendText("Sorry! bro\n");
		}
		
	}
	
	
	
}
