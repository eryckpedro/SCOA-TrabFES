package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class ProfessorCadastros extends JPanel {

	
	JTabbedPane tabbedPane;
	
	// página com abas de todos os tipos de cadastro que podem ser realizados por um professor
	public ProfessorCadastros() {
		
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblFuncionariocadastrosexplicacao = new JLabel("Escolha o que deseja cadastar");
		lblFuncionariocadastrosexplicacao.setBorder(new EmptyBorder(10, 5, 10, 10) );
		add(lblFuncionariocadastrosexplicacao, BorderLayout.NORTH);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		JPanel panel1 = new CadastrarPauta();
		tabbedPane.addTab("Pauta de aula", panel1);
		
		//JPanel panel2 = new CadastrarAvaliacao();
		//tabbedPane.addTab("Avaliação", panel2);
	}
	
    public JTabbedPane getTabbedPane() {
    	return tabbedPane;
    }

}
