package controller;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import model.AlunosModel;
import model.Model;
import view.AlunoConsultas;
import view.Cadastrar;
import view.CadastrarFuncionario;
import view.FuncionarioConsultas;
import view.ListarFuncionarios;
import view.LogadoAluno;
import view.LogadoFuncionario;
import view.LogadoProfessor;
import view.ProfessorConsultas;
import view.View;
import dados.Aluno;

public class ProfessoresController {
	
	ListaController listaController;
    private Model model;
    private View view;
    private JTabbedPane tabbedPane;
    
	public ProfessoresController(Model model, View view){
        this.model = model;
        this.view = view;
    	
        LogadoProfessor l = (LogadoProfessor) view.getPanel();
    	
        this.tabbedPane = l.getTabbedPane();
        this.listaController = new ListaController(model, view);
    }

	public void init() {
		
		ProfessorConsultas abaConsultas = (ProfessorConsultas) getAba(tabbedPane, "Consultas");
    	JTabbedPane consultasTabbedPane = abaConsultas.getTabbedPane();
    	
    	
    	consultasTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	listaController.autualizaListaConsultas(consultasTabbedPane);
            }
        });
    	
    	// ao mudar a aba de cima (Inicio | Consultas)
    	tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	int abaNum = tabbedPane.getSelectedIndex();
            	String aba = tabbedPane.getTitleAt(abaNum);
            	
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

}
