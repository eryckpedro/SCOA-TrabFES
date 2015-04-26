package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import dados.Funcionario;
import model.FuncionariosModel;
import model.Model;
import view.Cadastrar;
import view.CadastrarFuncionario;
import view.CadastrarTurma;
import view.FuncionarioCadastros;
import view.FuncionarioConsultas;
import view.Listar;
import view.LogadoFuncionario;
import view.Login;
import view.ListarFuncionarios;
import view.View;

public class FuncionariosController {
	
    private FuncionariosModel funcionariosModel;
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
        
        this.funcionariosModel = model.getFuncionariosModel();
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
		
		LogadoFuncionario panel = (LogadoFuncionario) view.getPanel();

		
		FuncionarioCadastros abaCadastros = (FuncionarioCadastros) getAba(tabbedPane, "Cadastros");
    	JTabbedPane cadastrosTabbedPane = abaCadastros.getTabbedPane();
		
    	FuncionarioConsultas abaConsultas = (FuncionarioConsultas) getAba(tabbedPane, "Consultas");
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
            	String aba = consultasTabbedPane.getTitleAt(abaNum);
            	
            	Cadastrar c = (Cadastrar)cadastrosTabbedPane.getComponent(abaNum);
            	c.getRootPane().setDefaultButton(c.getBotao());
            	
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
            	int abaNum = consultasTabbedPane.getSelectedIndex();
            	String aba = consultasTabbedPane.getTitleAt(abaNum);
            	
            	Listar l = (Listar) consultasTabbedPane.getComponent(abaNum);
            	
            	if(aba.equals("Funcionário"))     listaController.listaFuncionarios(l);
            	else if(aba.equals("Aluno"))      listaController.listaAlunos(l);
            	else if(aba.equals("Professor"))  listaController.listaProfessores(l);
            	else if(aba.equals("Disciplina")) listaController.listaDisciplinas(l);
            	else if(aba.equals("Sala"))       listaController.listaSalas(l);
            	else if(aba.equals("Turma"))      listaController.listaTurmas(l);
            }
        });
    	
    	

    	
		
    	// ao mudar a aba de cima (Inicio | Cadastros | Consultas)
    	// TODO verificar em qual subaba tá, quando mudar de aba aqui, e atualizar de acordo (porque não tá sempre na primeira, fica na última que tava)
    	tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	int abaNum = tabbedPane.getSelectedIndex();
            	String aba = tabbedPane.getTitleAt(abaNum);
                
            	if(aba.equals("Cadastros")) {
            		// primeiro botão padrão é o da primeira aba
            		// TODO tem que ver a aba que tá, não é sempre a primeira! (caso: Inicio -> Consultas -> Cadastro)
                	Cadastrar c = (Cadastrar) cadastrosTabbedPane.getComponent(0);
                	c.getRootPane().setDefaultButton(c.getBotao());
                	return;
            	}
            	
            	else {
            		tabbedPane.getRootPane().setDefaultButton(null);
            	}
            	
            	
            	if(aba.equals("Consultas")) {
            		// primeira lista é a de funcionários (primeira aba)
            		// TODO tem que ver a aba que tá, não é sempre a primeira! (caso: Inicio -> Cadastro -> Consultas)
	            	Listar l = (Listar) consultasTabbedPane.getComponent(0);
	            	listaController.listaFuncionarios(l);
            	}
            }
        });
    	
	}
	
	public void alert(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
