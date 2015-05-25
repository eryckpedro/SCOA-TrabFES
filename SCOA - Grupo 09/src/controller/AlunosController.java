package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import model.AlunosModel;
import model.Model;
import view.AlunoConsultas;
import view.AlunoInscricoes;
import view.Cadastrar;
import view.CadastrarFuncionario;
import view.FuncionarioConsultas;
import view.InscricaoTurma;
import view.Listar;
import view.ListarFuncionarios;
import view.LogadoAluno;
import view.LogadoFuncionario;
import view.View;
import dados.Aluno;

public class AlunosController {
	
	ListaController listaController;
	CadastroController cadastroController;
    private Model model;
    private View view;
    private JTabbedPane tabbedPane;
    private int idAlunoLogado;
    
	public AlunosController(Model model, View view, int id){
        this.model = model;
        this.view = view;
        this.idAlunoLogado = id;
    	
        LogadoAluno l = (LogadoAluno) view.getPanel();
    	
        this.tabbedPane = l.getTabbedPane();
        this.listaController = new ListaController(model, view);
        this.cadastroController = new CadastroController(model, view);
    }

	public void init() {
		
		AlunoConsultas abaConsultas = (AlunoConsultas) getAba(tabbedPane, "Consultas");
    	JTabbedPane consultasTabbedPane = abaConsultas.getTabbedPane();
    	
    	
    	consultasTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	listaController.autualizaListaConsultasAluno(consultasTabbedPane, idAlunoLogado);
            }
        });
    	
    	// ao mudar a aba de cima (Inicio | Consultas)
    	tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	int abaNum = tabbedPane.getSelectedIndex();
            	String aba = tabbedPane.getTitleAt(abaNum);
            	
            	if(aba.equals("Inscrições")) {
            		Listar abaInscricoes = (Listar) tabbedPane.getComponent(abaNum);
            		listaController.listaTurmasTabela(abaInscricoes);
            		
            		((InscricaoTurma) abaInscricoes).getBotao().addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent actionEvent) {
                        	cadastroController.adicionaInscricaoEmTurma((InscricaoTurma) abaInscricoes, idAlunoLogado);
                        }
                	});
            	}
            	else if(aba.equals("Consultas")) {
            		// atualizar lista da aba selecionada
            		listaController.autualizaListaConsultasAluno(consultasTabbedPane, idAlunoLogado);
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
