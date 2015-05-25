package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class AlunoInscricoes extends JPanel {

	
	JTabbedPane tabbedPane;
	
	public AlunoInscricoes() {
		
		
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblFuncionariocadastrosexplicacao = new JLabel("Escolha o que deseja listar");
		lblFuncionariocadastrosexplicacao.setBorder(new EmptyBorder(10, 5, 10, 10) );
		add(lblFuncionariocadastrosexplicacao, BorderLayout.NORTH);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		
		JPanel panel3 = new InscricaoTurma();
		tabbedPane.addTab("Turmas", panel3);

	}
	
    public JTabbedPane getTabbedPane() {
    	return tabbedPane;
    }

}
