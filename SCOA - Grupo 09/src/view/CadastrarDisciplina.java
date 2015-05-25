package view;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JList;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.Sizes;

public class CadastrarDisciplina extends Cadastrar {
	private JTextField txtNome;
	private JButton btnCadastrar;
	private CheckBoxList lista;
	
	private ArrayList<Integer> idsDisciplinas;
	
	
	/**
	 * Create the panel.
	 */
	public CadastrarDisciplina() {
		
		idsDisciplinas = new ArrayList<>();
		
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("110px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("70dlu", true), Sizes.constant("100dlu", true)), 1),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("max(4dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				new RowSpec(RowSpec.TOP, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("60dlu", false), Sizes.constant("60dlu", false)), 0),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		JLabel lblPorVavorEntre = new JLabel("Por favor, entre com as informações da disciplina que deseja cadastrar:");
		add(lblPorVavorEntre, "4, 4, 5, 1, left, top");
		
		JLabel lblNome = new JLabel("Nome");
		add(lblNome, "6, 6");
		
		txtNome = new JTextField();
		add(txtNome, "8, 6, left, default");
		txtNome.setColumns(10);
		
		JLabel lblPrrequisitos = new JLabel("Pré-requisitos");
		lblPrrequisitos.setVerticalAlignment(SwingConstants.TOP);
		add(lblPrrequisitos, "6, 8, default, top");
		
		lista = new CheckBoxList();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(lista);
		
		
		add(scrollPane, "8, 8, fill, top");
		

		
		btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "8, 12, left, default");

	}
	
	
	public String getNome() {
		return txtNome.getText();
	}
	
	public JButton getBotao() {
		return btnCadastrar;
	}
	
	public void limpaCampos() {
		txtNome.setText("");
		
		
		int prereqs = lista.getModel().getSize();
		
		ArrayList<Integer> idDisciplinas = new ArrayList<>();

		for(int i = 0; i < prereqs; i++) {
			JCheckBox checkbox = (JCheckBox) lista.getModel().getElementAt(i);
			if(checkbox.isSelected())
				checkbox.setSelected(!checkbox.isSelected());
		}
		
		repaint();
	}
	
	public CheckBoxList getCheckBoxList() {
		return lista;
	}
	
	
	public void addIdDisciplina(int id) {
		this.idsDisciplinas.add(id);
	}

	public int getIdDisciplina(int id) {
		return this.idsDisciplinas.get(id);
	}

	public void limpaIdDisciplina() {
		this.idsDisciplinas.clear();
		this.lista.setSelectedIndex(-1);
	}
	
	
	public void alert(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
}
