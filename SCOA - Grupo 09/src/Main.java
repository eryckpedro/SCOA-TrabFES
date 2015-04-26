import javax.swing.SwingUtilities;

import model.Model;
import view.View;
import controller.Controller;

public class Main {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {         
                Model model = new Model(); // banco de dados
                View view = new View(); // GUI
                
                Controller controller = new Controller(model,view);
            }
        });  
	}
}
