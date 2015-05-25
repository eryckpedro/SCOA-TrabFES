package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class LogadoAluno extends Logado {

    private JFrame frame;
    private JTable tabela;
    private JTabbedPane tabbedPane;
    JLabel lblBemVindo;
    JButton btnLogout;

    
    public LogadoAluno(){
    	setLayout(new BorderLayout(0, 0));
    	
    	Color headerFundo = new Color(185, 207, 194);
    	
    	
    	lblBemVindo = new JLabel("Bem vindo!");
    	JLabel lblAreaDoFuncionario = new JLabel("<html><div style='font-size: 16px; border-bottom: 2px solid black; padding: 0 2px; margin-bottom: 10px;'>Área do aluno</div></html>");
    	btnLogout = new JButton("Logout");
    	
    	lblBemVindo.setBorder(new EmptyBorder(0, 3, 7, 3) );

    	
    	JPanel header = new JPanel();
    	header.setBackground(headerFundo);
    	header.setBorder(new EmptyBorder(10, 10, 10, 10) );
    	header.setLayout(new BorderLayout(0, 0));
    	
    	
    	JPanel headerLogout = new JPanel();
    	headerLogout.setLayout(new BorderLayout(0, 0));
    	headerLogout.add(btnLogout, BorderLayout.NORTH);
    	headerLogout.setBackground(headerFundo);
    	
    	JPanel headerTopo = new JPanel();    	
    	headerTopo.setLayout(new BorderLayout(0, 0));
    	headerTopo.add(lblAreaDoFuncionario, BorderLayout.WEST);
    	headerTopo.add(headerLogout, BorderLayout.EAST);
    	headerTopo.setBackground(headerFundo);
    	
    	header.add(headerTopo, BorderLayout.NORTH);
    	header.add(lblBemVindo, BorderLayout.SOUTH);
    	

    	
    	add(header, BorderLayout.NORTH);
    	
    	UIManager.put("TabbedPane.borderColor", Color.RED);
    	
    	Border borda = BorderFactory.createEmptyBorder();
    	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    	tabbedPane.setUI(new AquaBarTabbedPaneUI());
    	
    	
    	tabbedPane.addTab("Início", new AlunoInicio());
    	tabbedPane.addTab("Inscrições", new InscricaoTurma());    
    	tabbedPane.addTab("Consultas", new AlunoConsultas());    	
    	
    	add(tabbedPane);

    }
    
    public JTabbedPane getTabbedPane() {
    	return tabbedPane;
    }
    
    public void setNome(String nome) {
    	lblBemVindo.setText("Logado como " + nome);
    }
    
    public JButton getBotaoLogout() {
    	return btnLogout;
    }
}