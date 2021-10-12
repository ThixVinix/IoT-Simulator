package br.ucsal.iot.runners;

import javax.swing.JProgressBar;

import br.ucsal.iot.popups.PopUpCarregamento;

public class TemporizadorCarregamento extends Thread{

    private int DELAY = 1000;
    
    public PopUpCarregamento viewCarregamento = new PopUpCarregamento();
    
    public static JProgressBar progressBar;
    
    @Override
    public void run() {
        viewCarregamento.initialize(); 
        
        int minimum = 0;
            int maximum = 10;
            int value = minimum;
           
            for (int i = minimum; i < maximum; i++) {
              try {
                 value = progressBar.getValue();
                Thread.sleep(DELAY);
                progressBar.setValue(value + 1);
              } catch (InterruptedException ignoredException) {
              ignoredException.getStackTrace();
              }
            
          }
        PopUpCarregamento.frmCarregamento.dispose();
    }
}