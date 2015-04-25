package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class FuncionarioInicio extends JPanel {

	/**
	 * Create the panel.
	 */
	public FuncionarioInicio() {
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(20, 15, 15, 15));
		
		JLabel lblBemVindo = new JLabel("<html><style>p { margin-bottom: 10px; }</style><p>Olá,</p><p>Bem vindo à area do funcionário! Para começar, escolha algum item do menu acima.</p></html>");
		add(lblBemVindo, BorderLayout.NORTH);
	}

}
