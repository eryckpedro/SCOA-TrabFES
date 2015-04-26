package view;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ListarAlunos extends Listar {

	private JTable table;

	public ListarAlunos() {
		setLayout(new BorderLayout(0, 0));
		
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Matricula", "CR"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true
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
