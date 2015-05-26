package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class ProfessorLancamentos extends JPanel {

	
	JTabbedPane tabbedPane;
	
	/**
	 * Create the panel.
	 */
	// página com abas de toos os tipos de cadastro que podem ser realizados por um funcionário
	public ProfessorLancamentos() {
		
		
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblFuncionariocadastrosexplicacao = new JLabel("Escolha o que deseja lançar");
		lblFuncionariocadastrosexplicacao.setBorder(new EmptyBorder(10, 5, 10, 10) );
		add(lblFuncionariocadastrosexplicacao, BorderLayout.NORTH);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		JPanel panel2 = new LancarFrequencia();
		tabbedPane.addTab("Frequência", panel2);
		
		//JPanel panel5 = new CadastrarDisciplina();
		//tabbedPane.addTab("Nota de avaliação", panel5);
		
		JPanel panel3 = new LancarMedia();
		tabbedPane.addTab("Média final", panel3);
	}
	
    public JTabbedPane getTabbedPane() {
    	return tabbedPane;
    }

}
