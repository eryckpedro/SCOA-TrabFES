package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class Lancar extends JPanel {
	
	public abstract JButton getBotao();
	
	public abstract void semTurmas();
	public abstract void comTurmas();
	
	public abstract void addIdTurma(int id);
	public abstract int getIdTurma(int id);
	public abstract void limpaIdTurma();
}
