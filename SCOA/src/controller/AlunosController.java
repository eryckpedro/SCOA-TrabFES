package controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import dados.Aluno;
import model.AlunosModel;
import model.Model;
import view.CadastrarFuncionario;
import view.LogadoFuncionario;
import view.VerFuncionarios;
import view.View;

public class AlunosController {
	
    private AlunosModel model;
    private View view;
    private JTabbedPane tabbedPane;
    
    VerFuncionarios aba1;
    CadastrarFuncionario aba2;

	public AlunosController(Model model, View view){
        this.model = model.getAlunosModel();
        this.view = view;
    	
        LogadoFuncionario l = (LogadoFuncionario) view.getPanel(); // TODO criar view LogadoAluno e editar aqui
    	
        this.tabbedPane = l.getTabbedPane();
        this.aba1 = (VerFuncionarios) tabbedPane.getComponent(0);
        this.aba2 = (CadastrarFuncionario) tabbedPane.getComponent(1);
    }

	public void mostra() {
		
		ArrayList<Aluno> lista_alunos = model.lista();  
		
		DefaultTableModel tableModel = (DefaultTableModel) aba1.getTabela().getModel();
		
		
		while(tableModel.getRowCount() > 0)
			tableModel.removeRow(0);
				
		for(Aluno aluno : lista_alunos) {
			String nome      = aluno.nome;
			String matricula = aluno.matricula;
			float cr         = aluno.cr;
			int idFuncCad    = aluno.idFuncCad;
			tableModel.addRow(new Object[]{nome, matricula, cr, idFuncCad});
		}
		
	}

}
