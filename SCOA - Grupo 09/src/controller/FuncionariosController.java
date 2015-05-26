package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Model;
import view.Cadastrar;
import view.CadastrarDisciplina;
import view.CadastrarTurma;
import view.CheckBoxList;
import view.FuncionarioCadastros;
import view.FuncionarioConsultas;
import view.Listar;
import view.LogadoFuncionario;
import view.View;

public class FuncionariosController {
	
    CadastroController cadastroController;
    ListaController listaController;
    private Model model;
    private View view;
    private JTabbedPane tabbedPane;
    private int idFuncLogado;

	public FuncionariosController(Model model, View view, int id){
        this.model = model;
        this.view = view;
        this.idFuncLogado = id;
        
        model.getFuncionariosModel();
        this.cadastroController = new CadastroController(model, view);
        this.listaController = new ListaController(model, view);
        
        
        LogadoFuncionario l = (LogadoFuncionario) view.getPanel();
    	
        this.tabbedPane = l.getTabbedPane();
    }

	public JButton getAbaBotao(JTabbedPane tp, String aba) {
    	
		for(int i = 0; i < tp.getTabCount(); i++) {
			if(tp.getTitleAt(i).equals(aba)) {
				return ((Cadastrar)tp.getComponent(i)).getBotao();
			}
		}
		
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
		
		FuncionarioCadastros abaCadastros = (FuncionarioCadastros) getAba(tabbedPane, "Cadastros");
    	JTabbedPane cadastrosTabbedPane = abaCadastros.getTabbedPane();
		
    	FuncionarioConsultas abaConsultas = (FuncionarioConsultas) getAba(tabbedPane, "Buscas");
    	JTabbedPane consultasTabbedPane = abaConsultas.getTabbedPane();
    	
    	
		
		// listeners dos botões de submeter os formulários de cadastro
		
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
    	
    	getAbaBotao(cadastrosTabbedPane, "Turma").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	cadastroController.adicionaTurma(getAba(cadastrosTabbedPane, "Turma"), idFuncLogado);
            }
    	});
    	
    	
    	// mudar o botao padrão (botao do enter) ao mudar de aba
    	// temos que redefinir a cada mudança de aba
    	cadastrosTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	int abaNum = cadastrosTabbedPane.getSelectedIndex();
            	String aba = cadastrosTabbedPane.getTitleAt(abaNum);
            	
            	Cadastrar c = (Cadastrar)cadastrosTabbedPane.getComponent(abaNum);
            	c.getRootPane().setDefaultButton(c.getBotao());
            	
            	
            	if(aba.equals("Disciplina")) {
            		CadastrarDisciplina cadastrarDisciplina = (CadastrarDisciplina) c;
            		
            		CheckBoxList cb = cadastrarDisciplina.getCheckBoxList();
            		listaController.listaDisciplinasCheckBoxList(cb, cadastrarDisciplina);
            		
            		cadastrarDisciplina.limpaCampos();
            	}
            	
            	if(aba.equals("Turma")) {
            		CadastrarTurma cadastrarTurma = (CadastrarTurma) c;
            		
            		JComboBox cb1 = cadastrarTurma.getComboBox(1);
            		JComboBox cb2 = cadastrarTurma.getComboBox(2);
            		JComboBox cb3 = cadastrarTurma.getComboBox(3);
            		listaController.listaDisciplinasComboBox(cb1, cadastrarTurma);
            		listaController.listaProfessoresComboBox(cb2, cadastrarTurma);
            		listaController.listaSalasComboBox(cb3, cadastrarTurma);
            		
            		cadastrarTurma.limpaCampos();
            	}
            }
        });
    	
    	
    	
    	
    	consultasTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	listaController.autualizaListaConsultas(consultasTabbedPane);
            }
        });
    	
    	

    	
		
    	// ao mudar a aba de cima (Inicio | Cadastros | Consultas)
    	// e verificar em qual subaba tá, quando mudar de aba aqui, e atualizar de acordo
    	// (porque não tá sempre na primeira, fica na última que tava)
    	tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	int abaNum = tabbedPane.getSelectedIndex();
            	String aba = tabbedPane.getTitleAt(abaNum);
                
            	if(aba.equals("Cadastros")) {
            		int abaCadastros = cadastrosTabbedPane.getSelectedIndex();
            		
            		// botão padrão é o da aba selecionada
            		// (vendo a aba que tá, não é sempre a primeira! (caso: Inicio -> Consultas -> Cadastro))
                	Cadastrar c = (Cadastrar) cadastrosTabbedPane.getComponent(abaCadastros);
                	c.getRootPane().setDefaultButton(c.getBotao());
                	return;
            	}
            	
            	else {
            		tabbedPane.getRootPane().setDefaultButton(null);
            	}
            	
            	
            	if(aba.equals("Buscas")) {
            		// atualizar lista da aba selecionada
            		listaController.autualizaListaConsultas(consultasTabbedPane);
            	}
            }
        });
    	
	}
	
	public void alert(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
