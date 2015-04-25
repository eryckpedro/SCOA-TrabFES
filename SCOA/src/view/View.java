package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {

    private JFrame frame;
    private JTable tabela;
    private JPanel panel;
    

    
    public View(){
    	this.panel = new Login(); // inicia com a página de login

    	add(this.panel);
		setSize(640,480);
		setVisible(true);
		
    }
    
    
    public JPanel getPanel() {
    	return panel;
    }
    
    
    public void substituiPanel(JPanel panel) {
    	this.panel = panel;
    	
    	Container c = this.getContentPane();

    	c.removeAll();
    	c.add(this.panel);
    	c.validate();
    	c.repaint();
    }
}