package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class VerFuncionarios extends JPanel {

	private JTable table;

	public VerFuncionarios() {
		setLayout(new BorderLayout(0, 0));
		
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Setor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		//add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

	}
	
	public JTable getTabela() {
		return table;
	}
}
