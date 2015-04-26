package view;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JSeparator;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.BoxLayout;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CadastrarSala extends Cadastrar {
	private JTextField txtSala;
	private JTextField txtAndar;
	private JButton btnCadastrar;
	private JTextField txtBloco;
	private JLabel lblAndar;

	/**
	 * Create the panel.
	 */
	public CadastrarSala() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("100px"),
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
		
		
		JLabel lblPorVavorEntre = new JLabel("Por favor, entre com as informações da sala que deseja cadastrar:");
		add(lblPorVavorEntre, "4, 4, 7, 1, left, top");
		
		JLabel lblSala = new JLabel("Número da sala");
		add(lblSala, "6, 6");
		
		txtSala = new JTextField();
		add(txtSala, "8, 6, left, default");
		txtSala.setColumns(10);
		
		JLabel lblAndar = new JLabel("Andar");
		add(lblAndar, "6, 8");
		
		txtAndar = new JTextField();
		add(txtAndar, "8, 8, left, default");
		txtAndar.setColumns(10);
		
		lblAndar = new JLabel("Bloco");
		add(lblAndar, "6, 10");
		
		txtBloco = new JTextField();
		add(txtBloco, "8, 10, left, default");
		txtBloco.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "8, 18, left, default");

	}
	
	
	public String getSala() {
		return txtSala.getText();
	}
	
	public String getAndar() {
		return txtAndar.getText();
	}
	
	public String getBloco() {
		return txtBloco.getText();
	}
	
	
	
	
	public JButton getBotao() {
		return btnCadastrar;
	}
	
	public void limpaCampos() {
		txtSala.setText("");
		txtAndar.setText("");
		txtBloco.setText("");
	}
}
