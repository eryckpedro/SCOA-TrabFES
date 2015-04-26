package view;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.Box;

import java.awt.Panel;
import java.awt.Component;

public class Login extends JPanel {
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	
	private JRadioButton rdbtnAluno;
	private JRadioButton rdbtnProfessor;
	private JRadioButton rdbtnFuncionario;
	
	JButton btnEntrar;

	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		Component verticalGlue = Box.createVerticalGlue();
		add(verticalGlue);
		
				
				Panel panel = new Panel();
				add(panel);
				panel.setLayout(null);
				panel.setMaximumSize(new Dimension(300, 280));
				panel.setMinimumSize(new Dimension(300, 280));
				panel.setPreferredSize(new Dimension(300, 280));
				
				
				JLabel lblEuSou = new JLabel("Eu sou...");
				lblEuSou.setBounds(12, 85, 100, 15);
				panel.add(lblEuSou);
				
				JLabel lblTitulo = new JLabel("<html><div style='font-size: 30px; border-bottom: 3px solid black; width: 300px;'>SCOA</div></html>");
				lblTitulo.setBounds(12, 12, 390, 48);
				panel.add(lblTitulo);
				
				Box horizontalBox = Box.createHorizontalBox();
				horizontalBox.setBounds(8, 104, 280, 20);
				panel.add(horizontalBox);
				
				
				rdbtnAluno = new JRadioButton("aluno");
				horizontalBox.add(rdbtnAluno);
				
				rdbtnProfessor = new JRadioButton("professor");
				horizontalBox.add(rdbtnProfessor);
				
				rdbtnFuncionario = new JRadioButton("funcionário");
				horizontalBox.add(rdbtnFuncionario);
				
				ButtonGroup tipo = new ButtonGroup();
				tipo.add(rdbtnAluno);
				tipo.add(rdbtnProfessor);
				tipo.add(rdbtnFuncionario);
				
				JLabel lblLogin = new JLabel("Login");
				lblLogin.setBounds(12, 150, 55, 15);
				panel.add(lblLogin);
				
				txtLogin = new JTextField();
				txtLogin.setBounds(84, 148, 114, 19);
				panel.add(txtLogin);
				
				txtSenha = new JPasswordField();
				txtSenha.setBounds(84, 177, 114, 19);
				panel.add(txtSenha);
				
				JLabel lblSenha = new JLabel("Senha");
				lblSenha.setBounds(12, 179, 55, 15);
				panel.add(lblSenha);
				
				btnEntrar = new JButton("Entrar");
				btnEntrar.setBounds(12, 227, 98, 25);
				panel.add(btnEntrar);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		add(verticalGlue_1);
	}
	
	public String getLogin() {
		return txtLogin.getText();
	}
	
	public String getSenha() {
		return new String(txtSenha.getPassword());
		
	}
	
	public int getTipo() {
		
		     if(rdbtnAluno.isSelected())       return 1;
		else if(rdbtnProfessor.isSelected())   return 2;
		else if(rdbtnFuncionario.isSelected()) return 3;
		
		return 0;
	}
	
	public JButton getBotao() {
		return btnEntrar;
	}
	
	// TODO remover
	public void testeRapido() {
		txtLogin.setText("admin");
		txtSenha.setText("senha");
		rdbtnFuncionario.setSelected(true);
	}
}
