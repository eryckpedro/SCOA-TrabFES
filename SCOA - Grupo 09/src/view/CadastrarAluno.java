package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class CadastrarAluno extends Cadastrar {
	private JTextField txtNome;
	private JTextField txtMatricula;
	private JButton btnCadastrar;
	private JTextField txtLogin;
	private JLabel lblLogin;
	private JPasswordField txtSenha;
	private JLabel lblSenha;

	/**
	 * Create the panel.
	 */
	public CadastrarAluno() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("78px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("114px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("1px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("251px"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("max(4dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		JLabel lblPorVavorEntre = new JLabel("Por favor, entre com as informações do aluno que deseja cadastrar:");
		add(lblPorVavorEntre, "4, 4, 7, 1, left, top");
		
		JLabel lblNome = new JLabel("Nome");
		add(lblNome, "6, 6");
		
		txtNome = new JTextField();
		add(txtNome, "8, 6, left, default");
		txtNome.setColumns(10);
		
		JLabel lblSetor = new JLabel("Matricula");
		add(lblSetor, "6, 8");
		
		txtMatricula = new JTextField();
		add(txtMatricula, "8, 8, left, default");
		txtMatricula.setColumns(10);
		
		lblLogin = new JLabel("Login");
		add(lblLogin, "6, 10");
		
		txtLogin = new JTextField();
		add(txtLogin, "8, 10, left, default");
		txtLogin.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		add(lblSenha, "6, 12");
		
		txtSenha = new JPasswordField();
		add(txtSenha, "8, 12, left, default");
		txtSenha.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "8, 18, left, default");

	}
	
	
	public String getNome() {
		return txtNome.getText();
	}
	
	public String getMatricula() {
		return txtMatricula.getText();
	}
	
	public String getLogin() {
		return txtLogin.getText();
	}
	
	public String getSenha() {
		try {
			return new String(txtSenha.getPassword());
		} catch(Exception e) { }
		
		return null;
	}
	
	
	
	public JButton getBotao() {
		return btnCadastrar;
	}
	
	public void limpaCampos() {
		txtNome.setText("");
		txtMatricula.setText("");
		txtLogin.setText("");
		txtSenha.setText("");
	}
}
