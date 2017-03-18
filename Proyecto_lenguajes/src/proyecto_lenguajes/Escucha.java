package proyecto_lenguajes;


import javax.speech.*;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;
import javax.swing.JOptionPane;

public class Escucha extends ResultAdapter {

    static Recognizer recognizer;
    String gst;
    String devolver="";
    
    @Override
    public void resultAccepted(ResultEvent re) {
        try {
            Result res = (Result) (re.getSource());
            ResultToken tokens[] = res.getBestTokens();

            String args[] = new String[1];
            args[0] = "";
            for (int i = 0; i < tokens.length; i++) {
                gst = tokens[i].getSpokenText();
                devolver += gst + " ";
                args[0] += gst + " ";
                System.out.print(gst + " ");
            }
            System.out.println();
            
            /*} else {
                recognizer.suspend();
                //Lee.main(args);
                //recognizer.resume();
                recognizer.deallocate();
                recognizer = null;
            }*/
        } catch (Exception ex) {
            System.out.println("Ha ocurrido algo inesperado " + ex);
        }
        
    }
   /* public void m() {
        try {
            recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
            recognizer.allocate();

            FileReader grammar1 = new FileReader("./SimpleGrammarES2.txt");

            RuleGrammar rg = recognizer.loadJSGF(grammar1);
            rg.setEnabled(true);
            
            recognizer.addResultListener(new Escucha());

            System.out.println("Empieze Dictado");
            recognizer.commitChanges();

            recognizer.requestFocus();
            recognizer.resume();
            
            
        } catch (Exception e) {
            System.out.println("Exception en " + e.toString());
            e.printStackTrace();
            System.exit(0);
        }
        
    }*/
}
