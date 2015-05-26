package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class Cadastrar extends JPanel {
	
	public abstract JButton getBotao();
	
	
	public void comErro(String mensagem) {}
	public void semErro() {}
	
	public void addIdTurma(int id) {}
	public int getIdTurma(int id) {return -1;}
	public void limpaIdTurma() {}
	
	public void addIdAluno(int id) {}
	public int getIdAluno(int id) {return -1;}
	public void limpaIdAluno() {}
}
