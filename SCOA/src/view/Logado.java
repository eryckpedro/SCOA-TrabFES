package view;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class Logado extends JPanel {
	
	public abstract JButton getBotaoLogout();
	public abstract void setNome(String nome);
}
