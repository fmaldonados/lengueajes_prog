package proyecto_lenguajes;

import javax.swing.JLabel;

public class cronometro extends Thread {

    private JLabel hora;
    private boolean avanzar;
    private boolean reiniciar;

    public cronometro(JLabel hora) {
        super();
        this.hora = hora;
        avanzar = false;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }

    public void setReiniciar(boolean reiniciar) {
        this.reiniciar = reiniciar;
    }

    @Override
    public void run() {
        int nuMin = 0;
        int nuSeg = 0;
        int nuHora = 0;
        try {
            while (true) {
                if (avanzar) {
                    if (nuSeg != 59) {
                        nuSeg++;
                    } else {
                        if (nuMin != 59) {
                            nuSeg = 0;
                            nuMin++;
                        } else {
                            nuHora++;
                            nuMin = 0;
                            nuSeg = 0;
                        }
                    }
                    hora.setText(nuHora + ":" + nuMin + ":" + nuSeg);
                    sleep(900);
                }else{
                    nuMin = 0;
                    nuSeg = 0;
                    nuHora = 0;
                    hora.setText(nuHora + ":" + nuMin + ":" + nuSeg);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
