package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class FuncionarioCadastros extends JPanel {

	
	JTabbedPane tabbedPane;
	
	/**
	 * Create the panel.
	 */
	// página com abas de toos os tipos de cadastro que podem ser realizados por um funcionário
	public FuncionarioCadastros() {
		
		
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblFuncionariocadastrosexplicacao = new JLabel("Escolha o que deseja cadastar");
		lblFuncionariocadastrosexplicacao.setBorder(new EmptyBorder(10, 5, 10, 10) );
		add(lblFuncionariocadastrosexplicacao, BorderLayout.NORTH);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		JPanel panel1 = new CadastrarFuncionario();
		tabbedPane.addTab("Funcionário", panel1);
		
		JPanel panel2 = new CadastrarAluno();
		tabbedPane.addTab("Aluno", panel2);
		
		JPanel panel3 = new CadastrarProfessor();
		tabbedPane.addTab("Professor", panel3);
		
		JPanel panel4 = new CadastrarDisciplina();
		tabbedPane.addTab("Disciplina", panel4);
		
		JPanel panel5 = new CadastrarSala();
		tabbedPane.addTab("Sala", panel5);
		
		JPanel panel6 = new CadastrarTurma();
		tabbedPane.addTab("Turma", panel6);

	}
	
    public JTabbedPane getTabbedPane() {
    	return tabbedPane;
    }

}
