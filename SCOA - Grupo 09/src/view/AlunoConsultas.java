package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class AlunoConsultas extends JPanel {

	
	JTabbedPane tabbedPane;
	
	public AlunoConsultas() {
		
		
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblFuncionariocadastrosexplicacao = new JLabel("Escolha o que deseja listar");
		lblFuncionariocadastrosexplicacao.setBorder(new EmptyBorder(10, 5, 10, 10) );
		add(lblFuncionariocadastrosexplicacao, BorderLayout.NORTH);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		
		JPanel panel3 = new ListarProfessores();
		tabbedPane.addTab("Professor", panel3);
		
		JPanel panel4 = new ListarDisciplinas();
		tabbedPane.addTab("Disciplina", panel4);
		
		JPanel panel6 = new ListarTurmas();
		tabbedPane.addTab("Turma", panel6);

	}
	
    public JTabbedPane getTabbedPane() {
    	return tabbedPane;
    }

}
