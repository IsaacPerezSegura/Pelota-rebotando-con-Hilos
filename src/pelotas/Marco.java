package pelotas;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Marco extends JFrame implements Runnable{
    private Panel panel;
    private JPanel botonesL;
    private Thread hilo;
    private JComboBox pelotas;
    private int cont=0;
    private ArrayList <Thread> listaHilos;
    public Marco(){
        panel=new Panel();
        add(panel,BorderLayout.CENTER);
        botonesL=new JPanel();
        ponerBoton(botonesL, "Comenzar", new ActionListener(){
            public void actionPerformed(ActionEvent evento){
               comienza_el_juego();
            }
        });
        ponerBoton(botonesL, "Salir", new ActionListener(){
            public void actionPerformed(ActionEvent evento){	
                    System.exit(0);	
            }
	});
        ponerBoton(botonesL, "Detener", new ActionListener(){
            public void actionPerformed(ActionEvent evento){	
                    detener();	
            }
	});
        add(botonesL, BorderLayout.SOUTH);
        hilo=new Thread(this);
        
        listaHilos=new <Thread> ArrayList();
        
        pelotas=new JComboBox();
        botonesL.add(pelotas);
        pelotas.addItem("Selecciona pelota");
        botonesL.validate();    }
    public void ponerBoton(Container c, String titulo, ActionListener oyente){
        JButton boton=new JButton(titulo);
        c.add(boton);
        boton.addActionListener(oyente);
    }
    public void comienza_el_juego (){
        listaHilos.add(hilo=new Thread(this));
        listaHilos.get(cont).setName(String.valueOf(cont));
        pelotas.addItem("Pelota "+(cont+1));
        listaHilos.get(cont).start();
        cont=cont+1;
    }
    public void detener(){
        /*Metodo absoleto
        hilo.stop();*/
        try{
        listaHilos.get((pelotas.getSelectedIndex())-1).interrupt();
        }catch(Exception e){System.out.println("Selecciona una pelota");}
    }
    public void run(){
        Pelota pelota=new Pelota();
        panel.add(pelota);
        while(!Thread.currentThread().isInterrupted()){
                pelota.mueve_pelota(panel.getBounds());
                panel.paint(panel.getGraphics());
                try{
                    Thread.sleep(7);
                }catch(Exception e){
                    Thread.currentThread().interrupt();
                }
                repaint();
        }
    }
}
