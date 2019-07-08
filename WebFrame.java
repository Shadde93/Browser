/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webb;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author shadmana
 */
public class WebFrame extends JFrame{
    private JPanel panel;
   
    private JEditorPane editorPane;
    private JButton goButton;
    private JButton closeButton;
    
    private JTextField textField;
    
    private JScrollPane scrollPane;

    public WebFrame(String title, Webb webb) throws HeadlessException {
        super(title);
        
        this.setPreferredSize(new Dimension(2000,1000));/*dimensioner*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /*avsluta programmet när framen stängs */
    
         // Skapar Panelen
        panel = new JPanel();
        this.add(BorderLayout.NORTH,panel);
        
                
        // Skapar grafiskt gränssnitt
        textField(webb);
        goButton(webb);
        closeButton(webb);
        
        editorPane(webb);
        scrollPane();
        
        this.pack();
        this.setVisible(true);
    }
    
    
        /**
     * Skapar adressfältet
    */
    public void textField(Webb webb){
        textField = new JTextField(150); // 150(int) är textfältets bredd i columner.
        textField.addActionListener(webb);
        panel.add(textField);
    }
    
    /**
     * Skapar sök knapp
    */
    public void goButton(Webb webb){
        goButton = new JButton("Gå till");
        goButton.addActionListener(webb);
        goButton.setVisible(true);
        panel.add(goButton);
    }
    
    /**
    * Skapar close-knapp 
    */
    public void closeButton(Webb webb){
        closeButton = new JButton("Stäng");
        closeButton.addActionListener(webb);
        closeButton.setVisible(true);
        panel.add(closeButton);
    }
    
    
                /**
      Kör Url koden för webbplatsen
     **/
    public void goTo(String URL) throws IOException{
        editorPane.setPage(URL);
    }
    
    
    /** 
     * Skapar ett visningsfönster 
     där en hemsida specifierad i addressinmatningsrutan visas.
    */
    public void editorPane(Webb webb){
    try{
        editorPane = new JEditorPane("http://www.google.se"); /* försök med google annars ger error(startsida */
        editorPane.setEditable(false);  
        editorPane.addHyperlinkListener(webb);
    }
    catch(IOException e){}
    }
    
    /**
     * skapar rull-list(scroll) om inte hela webbsidan kan visas 
     */
    public void scrollPane(){
        scrollPane = new JScrollPane(editorPane);
        this.add(scrollPane);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JEditorPane getEditorPane() {
        return editorPane;
    }

    public JButton getGoButton() {
        return goButton;
    }

    public JButton getCloseButton() {
        return closeButton;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JTextField getTextField() {
        return textField;
    }
    
    
    
}
