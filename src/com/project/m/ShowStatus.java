package com.project.m;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;

import javax.swing.*;

public class ShowStatus extends JDialog {
	
	
	JButton okBtn,cancelBtn;
	JSpinner portSpinner;
	SpinnerNumberModel number;
	JTextField user;
	JPasswordField password;
	StatusListener status;
	
	ShowStatus(JFrame parent)
	{
	super(parent,"Status",false);
	
	okBtn = new JButton("Ok");
	cancelBtn = new JButton("cancel");
	
	number = new SpinnerNumberModel(3304,0,9999,1);
	portSpinner = new JSpinner(number);
	
	
 JPanel text = new JPanel();
 JPanel button = new JPanel();
 
 setLayout(new BorderLayout());
 
 Border outside = BorderFactory.createEmptyBorder(15, 15, 15, 15);
 Border inside = BorderFactory.createTitledBorder("Database Prefrences");
 
 text.setBorder(BorderFactory.createCompoundBorder(outside, inside));
 add("Center",text);
	
button.setLayout(new FlowLayout(FlowLayout.RIGHT));	
	text.setLayout(null);
	
	add("South",button);

	JLabel name =new  JLabel("Port No");
	name.setBounds(60, 30, 100, 30);
	text.add(name);
	
portSpinner.setBounds(140, 30, 100, 30);
	text.add(portSpinner);
	
	JLabel User = new JLabel("Username");
	User.setBounds(60,70,100,30);
	
	user = new JTextField(10);
	user.setBounds(140,70,100,30);
	text.add(user);
	text.add(User);
	
	JLabel Password = new JLabel("Password");
	Password.setBounds(60,110,100,30);
	password= new JPasswordField(10);
	password.setBounds(140,110,100,30);
	text.add(Password);
	text.add(password);
		
	okBtn.setBounds(50,150, 50, 30);
	okBtn.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent arg0) {
				Integer value =(Integer)	portSpinner.getValue();
				String userName =	user.getText();
				String pass= new String(password.getPassword());
				
				if(status!=null)
				{
					status.statusSet(userName, pass, value);
				}
				
				setVisible(false);
				}
		
			});
	button.add(okBtn);
	cancelBtn = new JButton("Cancel");
	cancelBtn.setBounds(150,150,90,30);
	
	cancelBtn.addActionListener(new ActionListener()
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			
		
		setVisible(false);
		}

	});

	button.add(cancelBtn);
		
		Dimension cancel =cancelBtn.getPreferredSize();
	okBtn.setPreferredSize(cancel);
	
		setSize(300,300);
		setMinimumSize(new Dimension(300,300));
		setLocationRelativeTo(parent);
		setMaximumSize(new Dimension(300,300));
		
	}

public void setStatus(StatusListener status)
{
	
	this.status = status;
	
}

public void setDefault(String name,String  pass,int port)
{
	user.setText(name);
	password.setText(pass);
	portSpinner.setValue(port);
	
}
	

	

}
