package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import model.*;
import view.*;

public class Controller {

    private Model model;
    private View view;
    
    private boolean logado = false;
    LoginController loginController;
    
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        
        LoginController loginController = new LoginController(model, view);
        loginController.init();
        
        // logar automaticamente no admin, para testes mais rápidos
        loginController.testeRapido();
    }
    
    
}