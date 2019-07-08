
package webb;


import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
    * Klass som skapar en webbläsare med adressfält samt sök/avstängingsknapp 
    * @author walidaj
 */
public class Webb implements ActionListener, HyperlinkListener {
    private WebFrame frame;
    

   
    
    /**
     * Implementerar webbläsare med textfält och avstängingsknapp
    */
    
    public Webb(){
        // Skapar Framen för webbläsare
        frame = new WebFrame("Våran Webbläsare", this);

       
 
        
    }

    
        /**
      Kör Url koden för webbplatsen
     **/
    public void goTo(String URL) throws IOException{
        frame.goTo(URL);
    }
    
    /**
     * går till inskriven webbplats och utför "action" när knapparna trycks 
     */
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == frame.getGoButton() || e.getSource()== frame.getTextField()){
            goTo(frame.getTextField().getText());
        }
        if(e.getSource() == frame.getCloseButton()){
            frame.dispose();
        }
        
        } catch (IOException ex) {}
    }
    
    /**
     * kör funktionen goTo när hyperlänkar klickas 
     */
    
   public void hyperlinkUpdate(HyperlinkEvent e){
       try {
           HyperlinkEvent.EventType eventType = e.getEventType();
           
           if (eventType == HyperlinkEvent.EventType.ACTIVATED){
               goTo(e.getURL().toString());
           }
           
       } catch (IOException ex){}
   } 


    public static void main(String[] args) {
    new Webb();
    }
    
    
}

