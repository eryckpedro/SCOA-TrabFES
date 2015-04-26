package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
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
    	
    	
    	defineFonte();

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
    
    public void defineFonte() {
    	Font font = new Font("Arial", Font.BOLD, 12);
    	UIManager.put("Button.font", font);
    	UIManager.put("ToggleButton.font", font);
    	UIManager.put("RadioButton.font", font);
    	UIManager.put("CheckBox.font", font);
    	UIManager.put("ColorChooser.font", font);
    	UIManager.put("ComboBox.font", font);
    	UIManager.put("Label.font", font);
    	UIManager.put("List.font", font);
    	UIManager.put("MenuBar.font", font);
    	UIManager.put("MenuItem.font", font);
    	UIManager.put("RadioButtonMenuItem.font", font);
    	UIManager.put("CheckBoxMenuItem.font", font);
    	UIManager.put("Menu.font", font);
    	UIManager.put("PopupMenu.font", font);
    	UIManager.put("OptionPane.font", font);
    	UIManager.put("Panel.font", font);
    	UIManager.put("ProgressBar.font", font);
    	UIManager.put("ScrollPane.font", font);
    	UIManager.put("Viewport.font", font);
    	UIManager.put("TabbedPane.font", font);
    	UIManager.put("Table.font", font);
    	UIManager.put("TableHeader.font", font);
    	UIManager.put("TextField.font", font);
    	UIManager.put("PasswordField.font", font);
    	UIManager.put("TextArea.font", font);
    	UIManager.put("TextPane.font", font);
    	UIManager.put("EditorPane.font", font);
    	UIManager.put("TitledBorder.font", font);
    	UIManager.put("ToolBar.font", font);
    	UIManager.put("ToolTip.font", font);
    	UIManager.put("Tree.font", font);
    }
}