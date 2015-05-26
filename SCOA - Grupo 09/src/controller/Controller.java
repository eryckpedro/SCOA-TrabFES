package controller;

import model.Model;
import view.View;

public class Controller {

    private Model model;
    private View view;
    
    LoginController loginController;
    
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        
        LoginController loginController = new LoginController(model, view);
        loginController.init();
        
        //loginController.testeRapido();          // logar automaticamente no admin, para testes mais rápidos
        //loginController.testeRapidoAluno();     // logar automaticamente no aluno
        //loginController.testeRapidoProfessor(); // logar automaticamente no professor
    }
    
    
}