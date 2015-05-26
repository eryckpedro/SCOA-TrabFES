package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import model.AlunosModel;
import model.Model;
import view.AlunoConsultas;
import view.Cadastrar;
import view.CadastrarFuncionario;
import view.CadastrarPauta;
import view.CadastrarTurma;
import view.FuncionarioConsultas;
import view.LancarFrequencia;
import view.LancarMedia;
import view.ListarFuncionarios;
import view.LogadoAluno;
import view.LogadoFuncionario;
import view.LogadoProfessor;
import view.ProfessorCadastros;
import view.ProfessorConsultas;
import view.ProfessorLancamentos;
import view.View;
import dados.Aluno;

public class ProfessoresController {
	
	ListaController listaController;
	CadastroController cadastroController;
    private Model model;
    private View view;
    private JTabbedPane tabbedPane;
    private int idProfLogado;
    
	public ProfessoresController(Model model, View view, int id){
        this.model = model;
        this.view = view;
        this.idProfLogado = id;
    	
        LogadoProfessor l = (LogadoProfessor) view.getPanel();
    	
        this.tabbedPane = l.getTabbedPane();
        this.listaController = new ListaController(model, view);
        this.cadastroController = new CadastroController(model, view);
    }

	public void init() {
		
    	ProfessorCadastros abaCadastros = (ProfessorCadastros) getAba(tabbedPane, "Cadastros");
    	JTabbedPane cadastrosTabbedPane = abaCadastros.getTabbedPane();
    	
		ProfessorConsultas abaConsultas = (ProfessorConsultas) getAba(tabbedPane, "Consultas");
    	JTabbedPane consultasTabbedPane = abaConsultas.getTabbedPane();
    	
    	ProfessorLancamentos abaLancamentos = (ProfessorLancamentos) getAba(tabbedPane, "Lançamentos");
    	JTabbedPane lancamentosTabbedPane = abaLancamentos.getTabbedPane();
    	
    	
    	// lista de disciplinas no combo box do cadastro de pauta de aula
    	
    	CadastrarPauta cadastrarPauta = (CadastrarPauta) getAba(cadastrosTabbedPane, "Pauta de aula");
		JComboBox cb = cadastrarPauta.getComboBox();
		listaController.listaTurmasProfComboBox(cb, cadastrarPauta, idProfLogado);
		//cadastrarPauta.limpaCampos();
		
		
		
		
		// lista de disciplinas no combo box do lançamento de fequencia
		LancarFrequencia lancarFrequencia = (LancarFrequencia) getAba(lancamentosTabbedPane, "Frequência");
		JComboBox cb1 = lancarFrequencia.getComboBoxTurmas();
		JComboBox cb2 = lancarFrequencia.getComboBoxAlunos();
		listaController.listaTurmasProfComboBox(cb1, lancarFrequencia, idProfLogado);
		lancarFrequencia.limpaCampos();
		
		// ao mudar a turma selecionada
		cb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	listaController.listaAlunosLancamentos(cb1, cb2, lancarFrequencia, idProfLogado);
            	lancarFrequencia.limpaCampoAluno();
            }
    	});
		
		
		
		
		// lista de disciplinas no combo box do lançamento de media
		LancarMedia lancarMedia = (LancarMedia) getAba(lancamentosTabbedPane, "Média final");
		JComboBox cb1b = lancarMedia.getComboBoxTurmas();
		JComboBox cb2b = lancarMedia.getComboBoxAlunos();
		listaController.listaTurmasProfComboBox(cb1b, lancarMedia, idProfLogado);
		lancarMedia.limpaCampos();
		
		// ao mudar a turma selecionada
		cb1b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	listaController.listaAlunosLancamentos(cb1b, cb2b, lancarMedia, idProfLogado);
            	lancarMedia.limpaCampoAluno();
            }
    	});
		
		
		
		
		// listeners dos botões de submeter os formulários de cadastro
    	getAbaBotao(cadastrosTabbedPane, "Pauta de aula").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	cadastroController.adicionaPauta(getAba(cadastrosTabbedPane, "Pauta de aula"));
            }
    	});
    	
    	getAbaBotao(lancamentosTabbedPane, "Frequência").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	cadastroController.adicionaFrequencia(getAba(lancamentosTabbedPane, "Frequência"));
            }
    	});
    	
    	getAbaBotao(lancamentosTabbedPane, "Média final").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	cadastroController.adicionaMedia(getAba(lancamentosTabbedPane, "Média final"));
            }
    	});
    	

    	
    	// ao mudar a aba dentro de "Cadastros"
    	cadastrosTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	int abaNum = cadastrosTabbedPane.getSelectedIndex();
            	String aba = cadastrosTabbedPane.getTitleAt(abaNum);
            	
            	Cadastrar c = (Cadastrar) cadastrosTabbedPane.getComponent(abaNum);
            	c.getRootPane().setDefaultButton(c.getBotao());
            }
        });
    	
    	// ao mudar a aba dentro de "Lançamentos"
    	lancamentosTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	int abaNum = lancamentosTabbedPane.getSelectedIndex();
            	String aba = lancamentosTabbedPane.getTitleAt(abaNum);
            	
            	Cadastrar c = (Cadastrar) lancamentosTabbedPane.getComponent(abaNum);
            	c.getRootPane().setDefaultButton(c.getBotao());
            }
        });
    	
    	// ao mudar a aba dentro de "Consultas"
    	consultasTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	listaController.autualizaListaConsultas(consultasTabbedPane);
            }
        });
    	
    	
    	
    	// ao mudar a aba de cima (Inicio | Cadastros | Lançamentos | Consultas)
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
            	else if(aba.equals("Lançamentos")) {
            		int abaLancamentos = lancamentosTabbedPane.getSelectedIndex();
            		
            		// botão padrão é o da aba selecionada
            		// (vendo a aba que tá, não é sempre a primeira! (caso: Inicio -> Consultas -> Cadastro))
                	Cadastrar c = (Cadastrar) lancamentosTabbedPane.getComponent(abaLancamentos);
                	c.getRootPane().setDefaultButton(c.getBotao());
                	return;
            	}
            	else {
            		tabbedPane.getRootPane().setDefaultButton(null);
            	}
            	
            	
            	if(aba.equals("Consultas")) {
            		// atualizar lista da aba selecionada
            		listaController.autualizaListaConsultas(consultasTabbedPane);
            	}
            }
        });
	}
	
	public Component getAba(JTabbedPane tp, String aba) {
    	
		for(int i = 0; i < tp.getTabCount(); i++) {
			if(tp.getTitleAt(i).equals(aba))
				return tp.getComponent(i);
		}
		
		return null;
	}
	
	public JButton getAbaBotao(JTabbedPane tp, String aba) {
    	
		for(int i = 0; i < tp.getTabCount(); i++) {
			if(tp.getTitleAt(i).equals(aba)) {
				return ((Cadastrar)tp.getComponent(i)).getBotao();
			}
		}
		
		return null;
	}

}
