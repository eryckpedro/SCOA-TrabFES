package view;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class CadastrarPauta extends Cadastrar {
	private JTextField txtMatricula;
	private JButton btnCadastrar;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JComboBox comboBoxDisciplinas;
	private JComboBox comboBoxSalas;
	JSpinner timeSpinner;
	
	private ArrayList<Integer> idsTurmas;
	
	JTextArea txtrPauta;
	JLabel texto;

	
	JLabel lblNome;
	JLabel lblSetor;
	
	/**
	 * Create the panel.
	 */
	public CadastrarPauta() {
		
		idsTurmas = new ArrayList<>();
		
		
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("97px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("199px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("21px:grow"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("max(4dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				FormFactory.LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("top:default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		texto = new JLabel();
		add(texto, "4, 4, 7, 1, left, top");
		
		
		
		lblNome = new JLabel("Turma");
		add(lblNome, "6, 6");
		
		comboBoxDisciplinas = new JComboBox();
		add(comboBoxDisciplinas, "8, 6, left, default");
		
		
		
		lblSetor = new JLabel("Pauta de aula");
		lblSetor.setVerticalAlignment(SwingConstants.TOP);
		add(lblSetor, "6, 8");
		
		txtrPauta = new JTextArea();
		
		txtrPauta.setLineWrap(true);
		txtrPauta.setWrapStyleWord(true);
		add(txtrPauta, "8, 8, fill, fill");
		
		btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "8, 12, left, default");
	}
	
	public void comErro(String string) {
		texto.setText(string);
		lblNome.setVisible(false);
		lblSetor.setVisible(false);
		comboBoxDisciplinas.setVisible(false);
		txtrPauta.setVisible(false);
		btnCadastrar.setVisible(false);
	}
	
	public void semErro() {
		texto.setText("Por favor, entre com as informações da pauta de aula que deseja cadastrar:");
		lblNome.setVisible(true);
		lblSetor.setVisible(true);
		comboBoxDisciplinas.setVisible(true);
		txtrPauta.setVisible(true);
		btnCadastrar.setVisible(true);
	}
	
	
	public JButton getBotao() {
		return btnCadastrar;
	}
	
	public JComboBox getComboBox() {
		return this.comboBoxDisciplinas;
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
	
	public void limpaCampos() {
		this.comboBoxDisciplinas.setSelectedIndex(-1);
	}
	
	public String getPauta() {
		return this.txtrPauta.getText();
		
	}
	
	public void alert(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
