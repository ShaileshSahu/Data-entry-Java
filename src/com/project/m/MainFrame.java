package com.project.m;

import javax.swing.*;

import controller.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.prefs.Preferences;
public class MainFrame extends JFrame
{
TextPanel panel;
	Toolbar tool;
	FormPanel form;
	JFileChooser choose;	
	Controller controller;
	TablePanel tb;
	ShowStatus status;
	Preferences pref;
	
	MainFrame()
	{
		
		pref= Preferences.userRoot().node("db");
		setTitle("Swing Project");
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setMinimumSize(new Dimension(500,500));
		setLayout(new BorderLayout());
	
		tool = new Toolbar();
		
		panel = new TextPanel();
	
		tool.setTextPanel(panel);
		form = new FormPanel();
		
		controller= new Controller();
status = new ShowStatus(this);

status.setStatus(new StatusListener()
		{

			@Override
			public void statusSet(String name, String pass, int port) {

				
				pref.put("name", name);
				pref.put("pass", pass);
				pref.putInt("port",port);
System.out.println(name+"\t:"+(pass));
				
			}
			
		
		
			
			
			
	
		});

String name=	pref.get("name", "");
String pass= pref.get("pass", "");
int port = pref.getInt("port", 3002);

status.setDefault(name,pass,port);
		tb = new TablePanel();
choose = new JFileChooser();
choose.addChoosableFileFilter(new PersonFile());
tb.setData(controller.getPeople());


tb.setPersonTable(new PersonModelListener()
		{
	public void rowDeleted(int row)
	{
		System.out.println(row);
		
		controller.removeItem(row);
	}
	
		}
		
		);





		setJMenuBar(createMenu());
		form.setFrameListener(new FormListener()
	
				{public void FormOccured(FomEvent e)		
		{
			/*String name=e.getName(); // This used to show the content on the display where we get desired result.
				String pass=e.getPass();
				
			String age= e.getAge();
				String emp1= e.getEmp1();
				
				String id = e.getId();
				String gender = e.getGender();
		panel.appendText(name+":"+pass+":"+emp1+":"+age);
		panel.appendText(id+":"+gender);
		*/
		controller.addController(e);
		tb.refresh();
		}});
		
		//add("Center",panel);
	add("Center",new JScrollPane(tb));
		
		add("North",tool);
		
	add("West",form);
	try{
	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	SwingUtilities.updateComponentTreeUI(this);
	}catch(Exception e)
	
	{
		
	}
	}
	
	private JMenuBar createMenu()
	{
		JMenuBar br = new JMenuBar();
		JMenu file = new JMenu("File");
		
		JMenuItem op = new JMenuItem("open");
		JMenuItem sv = new JMenuItem("save");
		JMenuItem st = new JMenuItem("status");
		JMenuItem ex = new JMenuItem("exit");
		
		//sv.setMnemonic(KeyEvent.VK_S);
		sv.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		sv.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
					choose.showSaveDialog(MainFrame.this);
						try {
							controller.toSaveFile(choose.getSelectedFile());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(MainFrame.this, "Couldn't load this file we are sorry","Sorry",JOptionPane.WARNING_MESSAGE);
						}
					}
			
				});
		
		st.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						status.setVisible(true);
						
					}
			
				});
		
		st.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		op.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		//op.setMnemonic(KeyEvent.VK_O);
		op.addActionListener(new ActionListener()
				{

					
					public void actionPerformed(ActionEvent we) {
						
						
					choose.showOpenDialog(MainFrame.this);
					try {
						controller.toOpenFile(choose.getSelectedFile());
						tb.refresh();
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(MainFrame.this, "Couldn't load this file we are sorry","Sorry",JOptionPane.WARNING_MESSAGE);					}
					
					
						
					}
			
				});
		ex.setMnemonic(KeyEvent.VK_X);
		ex.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
					String text =JOptionPane.showInputDialog(MainFrame.this, "UserName", "Exit", JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
					
					System.out.println(text);
						int ok =JOptionPane.showConfirmDialog(MainFrame.this, " exit ", "Doy you really want to exit?", JOptionPane.OK_CANCEL_OPTION);
					if(ok == JOptionPane.OK_OPTION)
					{
						System.exit(0);
					}
					
						
					}
					
				
			
				});
		file.add(op);
		file.add(sv);
		file.add(st);
		file.add(ex);
		
		JMenu edit = new JMenu("Edit");
		JMenuItem fn = new JMenuItem("Font");
		JMenuItem co = new JMenuItem("Color");
		
		JMenu nv = new JMenu("Navigation");
		
		JMenuItem nx = new JMenuItem("Next");
		JMenuItem pr = new JMenuItem("previous");
		JCheckBoxMenuItem  show = new JCheckBoxMenuItem("Disply Person");
		show.setSelected(true);
		edit.add(nv);
		nv.add(nx);
		nv.add(pr);
		nv.add(show);
		
		
		
		edit.add(fn);
		edit.add(co);
		
		
		
		JMenu window = new JMenu("WIndow");
		JMenu download = new JMenu("Downloads");
		JMenu help = new JMenu("Help");
		
		br.add(file);
		br.add(edit);
		br.add(window);
		br.add(download);
		br.add(help);
		
show.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent tr)
			{
			JCheckBox check =(JCheckBox)tr.getSource();
			form.setVisible(check.isSelected());
			}
		});
		return br;
	}
	
	
		
		
}
