package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import model.FuncionariosModel;
import model.Model;
import view.Cadastrar;
import view.CadastrarFuncionario;
import view.FuncionarioCadastros;
import view.LogadoFuncionario;
import view.Login;
import view.VerFuncionarios;
import view.View;

public class FuncionariosController {
	
    private FuncionariosModel funcionariosModel;
    CadastroController cadastroController;
    private Model model;
    private View view;
    private JTabbedPane tabbedPane;
    private int idFuncLogado;

	public FuncionariosController(Model model, View view, int id){
        this.model = model;
        this.view = view;
        this.idFuncLogado = id;
        
        this.funcionariosModel = model.getFuncionariosModel();
        this.cadastroController = new CadastroController(model, view);
        
        
        LogadoFuncionario l = (LogadoFuncionario) view.getPanel();
    	
        this.tabbedPane = l.getTabbedPane();
    }

	public JButton getAbaBotao(JTabbedPane tp, String aba) {
    	
		for(int i = 0; i < tp.getTabCount(); i++)
			if(tp.getTitleAt(i).equals(aba))
				return ((Cadastrar)tp.getComponent(i)).getBotao();
		
		return null;
	}
	
	public Component getAba(JTabbedPane tp, String aba) {
    	
		for(int i = 0; i < tp.getTabCount(); i++) {
			if(tp.getTitleAt(i).equals(aba))
				return tp.getComponent(i);
		}
		
		return null;
	}
	
	
	public void init() {
		
		LogadoFuncionario panel = (LogadoFuncionario) view.getPanel();

		
		
		// listeners dos botões de submeter o formulário
		
		FuncionarioCadastros abaCadastros = (FuncionarioCadastros) getAba(tabbedPane, "Cadastros");
    	JTabbedPane cadastrosTabbedPane = abaCadastros.getTabbedPane();
    	
    	getAbaBotao(cadastrosTabbedPane, "Funcionário").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	cadastroController.adicionaFuncionario(getAba(cadastrosTabbedPane, "Funcionário"), idFuncLogado);
            }
    	});
    	
    	getAbaBotao(cadastrosTabbedPane, "Aluno").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	cadastroController.adicionaAluno(getAba(cadastrosTabbedPane, "Aluno"), idFuncLogado);
            }
    	});
    	
    	getAbaBotao(cadastrosTabbedPane, "Professor").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	cadastroController.adicionaProfessor(getAba(cadastrosTabbedPane, "Professor"), idFuncLogado);
            }
    	});
    	
    	getAbaBotao(cadastrosTabbedPane, "Disciplina").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	cadastroController.adicionaDisciplina(getAba(cadastrosTabbedPane, "Disciplina"), idFuncLogado);
            }
    	});
    	
    	getAbaBotao(cadastrosTabbedPane, "Sala").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	cadastroController.adicionaSala(getAba(cadastrosTabbedPane, "Sala"), idFuncLogado);
            }
    	});
    	
    	
    	
		
    	// ao mudar a aba
    	tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	int abaNum = tabbedPane.getSelectedIndex();
                
            	if(tabbedPane.getTitleAt(abaNum).equals("Cadastros")) {

            	}
                	
            	/*
            	cadastrosTabbedPane.addChangeListener(new ChangeListener() {
            		
                    public void stateChanged(ChangeEvent e) {
                    	
                    	int abaSel2 = tabbedPane.getSelectedIndex();
                        if(abasCadastro[abaSel2] == "Funcionario") {
                        	
                        }
                    	
                        if(abaSel2 == 0) mostraFuncionario();
                    }
                });
                
                */

            }
        });
    	
    	/*
    	// ao mudar a aba
    	tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	int abaSelecionada = tabbedPane.getSelectedIndex();
                
                if(abaSelecionada == 0) mostraFuncionario();
            }
        });
    	
    	// botao Cadastrar da segunda aba
    	tab.getBotao().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {                  
            	adicionaFuncionario();
            }
    	});
    	
    	mostraFuncionario();
    	*/
	}
	
	public void mostraFuncionario(Cadastrar c) {
		
		/*
		LinkedHashMap<String, String> lista_funcionarios = funcionariosModel.lista();  
		
		DefaultTableModel tableModel = (DefaultTableModel) c.getTabela().getModel();
		
		
		while(tableModel.getRowCount() > 0)
			tableModel.removeRow(0);
				
		for(Map.Entry<String, String> elemento : lista_funcionarios.entrySet()) {
			String nome = elemento.getKey();
			String setor = elemento.getValue();
			tableModel.addRow(new Object[]{nome, setor});
		}
		*/
		
	}
	public void alert(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
