package view;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ListarDiscConcluidas extends Listar {

	private JTable table;

	public ListarDiscConcluidas() {
		setLayout(new BorderLayout(0, 0));
		
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Media"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

	}
	
	public JTable getTabela() {
		return table;
	}
}
