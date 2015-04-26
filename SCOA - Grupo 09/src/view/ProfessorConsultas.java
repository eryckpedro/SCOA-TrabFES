package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class ProfessorConsultas extends JPanel {

	
	JTabbedPane tabbedPane;
	
	/**
	 * Create the panel.
	 */
	// página com abas de toos os tipos de cadastro que podem ser realizados por um funcionário
	public ProfessorConsultas() {
		
		
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblFuncionariocadastrosexplicacao = new JLabel("Escolha o que deseja listar");
		lblFuncionariocadastrosexplicacao.setBorder(new EmptyBorder(10, 5, 10, 10) );
		add(lblFuncionariocadastrosexplicacao, BorderLayout.NORTH);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);

		JPanel panel2 = new ListarAlunos();
		tabbedPane.addTab("Aluno", panel2);
		
		JPanel panel3 = new ListarProfessores();
		tabbedPane.addTab("Professor", panel3);
		
		JPanel panel4 = new ListarDisciplinas();
		tabbedPane.addTab("Disciplina", panel4);
		
		JPanel panel5 = new ListarSalas();
		tabbedPane.addTab("Sala", panel5);
		
		JPanel panel6 = new ListarTurmas();
		tabbedPane.addTab("Turma", panel6);

	}
	
    public JTabbedPane getTabbedPane() {
    	return tabbedPane;
    }

}
