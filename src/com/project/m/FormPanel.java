package com.project.m;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.event.*;
public class FormPanel extends JPanel  //implements ActionListener //implements ActionListener 

	
{ TextPanel panel;
	JLabel name,pass,citizen,idno,genderl;
	JTextField name1,pass1,id;
	JButton btn;
	JList ageList;
	JComboBox emp;
	JCheckBox java,html,php,c,country;
	FormListener formlistener;
	TextPanel pp;
	JRadioButton male,female;
	ButtonGroup gender;
	
	FormPanel()
	{
Dimension dim = getPreferredSize();
dim.width=250;
setPreferredSize(dim);

Border inner = BorderFactory.createTitledBorder("Add Person");
Border outer = BorderFactory.createEmptyBorder();

setBorder(BorderFactory.createCompoundBorder(outer, inner));


setLayout(null);
name = new JLabel("Name");
/*GridBagConstraints gc = new GridBagConstraints();
gc.gridx=0;
gc.fill= GridBagConstraints.NONE;
gc.anchor = GridBagConstraints.LINE_START;
gc.gridy=0;
gc.weightx=0;
gc.weighty=0;*/
name.setBounds(20,20,80,30);
add(name);

name1 = new JTextField(15);
//gc.gridx=1;
//gc.gridy=0;
name1.setBounds(100,20,120,20);
add(name1);

pass = new JLabel("Password");
/*gc.anchor= GridBagConstraints.CENTER;
gc.gridx=0;
gc.gridy=1;

gc.weightx=0.42;
gc.weighty=0.033;
*/
pass.setBounds(20,80,80,30);
add(pass);

pass1 = new JTextField(15);
//gc.gridx=1;
//gc.gridy=1;
pass1.setBounds(100,80,120,20);
add(pass1);

String[] age={"under 18","b/w 18to65","above 65"};

ageList = new JList(age);
ageList.setBorder(BorderFactory.createEtchedBorder());
ageList.setPreferredSize(new Dimension(120,70));
//gc.gridx=2;
//gc.gridy=2;
ageList.setBounds(105,120,100,100);
add(ageList);

emp = new JComboBox();
emp.addItem("Employed");
emp.addItem("Unemployed");
emp.addItem("HouseWife");
emp.addItem("Govt. official");
emp.setPreferredSize(new Dimension(120,50));
emp.setBounds(105,230,100,30);
add(emp);

btn = new JButton("Ok");
//gc.gridx =1;
//gc.gridy =3;
//gc.weightx=4;
//gc.weighty=4;

java = new JCheckBox("Java",true);
html = new JCheckBox("Html");
php = new JCheckBox("PHP");
c = new JCheckBox("C");
java.setBounds(10, 270, 60, 20);
html.setBounds(70, 270, 60, 20);
php.setBounds(130, 270, 60, 20);
c.setBounds(190, 270, 60, 20);




add(java);
add(php);
add(html);
add(c);


btn.setBounds(150,450,70,20);
add(btn);

country = new JCheckBox("India");
country.setBounds(90,300,70,20);
country.addActionListener(new ActionListener()
		{
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
	boolean isTicked=	country.isSelected();
		id.setEnabled(isTicked);
	}
		});
add(country);

citizen = new JLabel("Citizen:");
citizen.setBounds(20,300,50,20);
add(citizen);

id = new JTextField(10);
id.setBounds(90,330,70,20);
id.setEnabled(false);
add(id);

idno = new JLabel("Id no:");
idno.setBounds(20,330,70,20);
add(idno);

male = new JRadioButton("male");
female = new JRadioButton("Female");

male.setBounds(80,365,50,20);
female.setBounds(140,365,70,20);
male.setActionCommand("Male");
female.setActionCommand("Female");
gender = new ButtonGroup();

gender.add(male);
gender.add(female);

add(male);
add(female);

genderl= new JLabel("Gender");
genderl.setBounds(20,365,70,20);
add(genderl);



 



btn.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent ae) {
				String name2 = name1.getText();
String pass2 = pass1.getText();
String age = (String)ageList.getSelectedValue();
String emp1 = (String) emp.getSelectedItem();
String no = id.getText();
String genderc = gender.getSelection().getActionCommand();

FomEvent fo = new FomEvent(this,name2,pass2,age,emp1,no,genderc);
if(formlistener!=null)
{
	formlistener.FormOccured(fo);
}

				
			}
	
		}
		);

//name1.addActionListener(this);
//p//ass1.addActionListener(this);

	}
	
	
	
	
	public void setFrameListener(FormListener listener)
	{
		formlistener=listener;
	}





	
	
}
