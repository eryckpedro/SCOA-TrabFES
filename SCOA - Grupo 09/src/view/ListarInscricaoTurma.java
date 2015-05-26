package view;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Box;

import java.awt.Component;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JLabel;

public class ListarInscricaoTurma extends Listar {

	private JTable table;
	private ArrayList<Integer> idsTurmas;
	JButton btnCadastrar;

	public ListarInscricaoTurma() {
		
		idsTurmas = new ArrayList<>();
		setLayout(new BorderLayout(0, 0));
		
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblNewLabel = new JLabel("<html>Você está escrito nas matérias seguintes.<br>Dê um duplo clique para maiores informações <span style='color: #AA0000'>(não implementado)</span>.");
		lblNewLabel.setBorder(new EmptyBorder(5, 5, 10, 10) );
		add(lblNewLabel, BorderLayout.NORTH);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Disciplina", "Horário", "Professor", "Sala"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
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
	
	public JButton getBotao() {
		return this.btnCadastrar;
	}
	
	
	public void addIdTurma(int id) {
		this.idsTurmas.add(id);
	}

	public int getIdTurma(int id) {
		return this.idsTurmas.get(id);
	}

	public void limpaIdTurma() {
		this.idsTurmas.clear();
	}

}
