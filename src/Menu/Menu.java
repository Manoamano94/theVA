/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author Gunness
 */
public class Menu extends JFrame implements ActionListener{
      
    private final JFrame fenetremenu; // declaration d'une fenetre pour le menu
    private JPanel panelmenu; //declaration d'un panneau menu
    private final JButton OnlineNutton;   //Bouton online
    private JButton OfflineNutton;  //bouton offline 
    private final JLabel titre; // declaration du titre

    
    public Menu() throws IOException 
    {
       
        fenetremenu=new JFrame();//creation d'une fenetre pour le menu
        fenetremenu.setTitle("Menu Hopital 102"); // titre de la fenetre
        fenetremenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
      
        panelmenu = new JPanel();//creation d'un panneau menu
        
        panelmenu = setImage(fenetremenu, new File("hop1.png"));
        panelmenu.setLayout(null);
        OnlineNutton = new JButton("Connexion Online");
        OfflineNutton = new JButton("Connexion Offline");
         String texttitre="Bienvenue dans le Menu d'Hopital 102";
        titre = new JLabel(texttitre,JLabel.CENTER );

       
        titre.setBounds(175,20,300,100);
       
        OnlineNutton.setBounds(220,295,200,50);
        OnlineNutton.addActionListener(this);
        OfflineNutton.setBounds(220,225,200,50);
        OfflineNutton.addActionListener(this);
        
        panelmenu.add(OnlineNutton);
        panelmenu.add(OfflineNutton);
        panelmenu.add(titre);

        
        fenetremenu.pack();
        fenetremenu.setResizable(true);
        fenetremenu.setSize(700, 700);
        fenetremenu.setLocationRelativeTo(null);
        fenetremenu.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent tada) 
    {
     if(tada.getSource()==OnlineNutton)
     {
         try {
             Accueil acucu =new Accueil();
         } catch (IOException ex) {
             Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     if(tada.getSource()==OfflineNutton)
     {
     }
    }
    
    /**
     *
     * @param frame
     * @param fichierimage
     * @return
     * @throws IOException
     */
    public static JPanel setImage(JFrame frame, final File fichierimage) throws IOException {
        
        JPanel panel = new JPanel() {
            private static final long serialVersionUID = 1;
            private final BufferedImage buf = ImageIO.read(fichierimage);

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(buf, 0, 0, null);
            }
        };

        frame.setContentPane(panel);

        return panel;
    }
}
