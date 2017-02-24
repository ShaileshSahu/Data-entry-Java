package com.project.m;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import Model.Person;
import java.awt.event.*;
public class TablePanel extends JPanel{
	
	private JTable table;
	PersonTableModel model;
	JPopupMenu popup;
	PersonModelListener delete;

	public TablePanel()
	{
		
		
		Vector<String> cols = new Vector<String>();
		
		cols.add("Id");
		cols.add("Name");
		cols.add("Password");
		cols.add("Age");
		cols.add("Employement");
		cols.add("Tax");
		cols.add("Gender");
		
		Vector<String> data = null;
		JTable table1 = new JTable(data,cols);
		JTableHeader head = table1.getTableHeader();
		
		
		
	model = new PersonTableModel();
		table = new JTable(model);
		popup = new JPopupMenu();
		JMenuItem item = new JMenuItem("Delete");
		popup.add(item);
		
		
		table.addMouseListener(new MouseAdapter()
				{

				
					public void mousePressed(MouseEvent e) {
						
						
						int row = table.rowAtPoint(e.getPoint());
						      table.getSelectionModel().setSelectionInterval(row, row);
						
					if(e.getButton() == MouseEvent.BUTTON3)
					{
						popup.show(table, e.getX(), e.getY());
					}
						
					}
			
				});
		
		
		item.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
		int i=		table.getSelectedRow();
		
		if(delete!=null)
		{
			delete.rowDeleted(i);;
			model.fireTableRowsDeleted(i, i);
		}
		
			
			}
			
		}
				);
		
		
		table.setBorder(BorderFactory.createLineBorder(Color.gray,4));
		table.setFont(new Font("Courier New",Font.BOLD,15));
		table.setRowHeight(30);
		setLayout(new BorderLayout());
	
	
	add("Center",table);
	add("North",head);
	}

	public void setPersonTable(PersonModelListener row)
	{
		this.delete=row;
	}
	public void setData(ArrayList<Person> db)
	{
	  model.setData(db);
	}
	
	public void refresh()
	{
		model.fireTableDataChanged();
	}
}
