package Menu;

import javax.swing.JFrame;
import pelotas.Marco;
public class Menu {
    public static void main(String [] args){
        Marco marco=new Marco();
        marco.setSize(500,500);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
        marco.setLocationRelativeTo(null);
        marco.setTitle("Pelotas");
    }
    
}
