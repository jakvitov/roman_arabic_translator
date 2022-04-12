import GUIs.ArabicTranslatorGUI;
import GUIs.RomanTranslatorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This is the main class from where the application is launched, other classes are devided into GUI
 * and actual translators
 * .
 *The whole translator works for years betweeen 1 and 3000
 * There is basic input protection againist the wrong inputs
 *
 */
public class RomanArabic implements ActionListener{
    JLabel header;
    JLabel text;
    JButton rightButton;
    JButton leftButton;
    RomanArabic(){

        JFrame jfrm = new JFrame("Number translator");
        jfrm.setSize(1000,300);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setVisible(true);
        ImageIcon img = new ImageIcon("./icon.png");
        jfrm.setIconImage(img.getImage());

        //We create the header
        header = new JLabel("Wellcome to the number translator!");
        jfrm.add(header);
        jfrm.setLayout(new FlowLayout());
        header.setVisible(true);
        //The middle label
        text = new JLabel("Chose one of the options");
        jfrm.add(text);
        text.setVisible(true);
        //We create the buttons
        rightButton = new JButton("Roman numbers to arabic");
        leftButton = new JButton("Arabic numbers to roman");
        jfrm.add(rightButton);
        jfrm.add(leftButton);
        jfrm.setLayout(new FlowLayout());
        leftButton.setVisible(true);
        rightButton.setVisible(true);

        leftButton.setPreferredSize(new Dimension(600, 70));
        rightButton.setPreferredSize(new Dimension(600, 70));

        leftButton.addActionListener(this);
        rightButton.addActionListener(this);


        header.setFont(new Font("SERIF", Font.PLAIN, 35));
        text.setFont(new Font("SERIF", Font.PLAIN, 35));
        rightButton.setFont(new Font("SERIF", Font.PLAIN, 25));
        leftButton.setFont(new Font("SERIF", Font.PLAIN, 25));
    }

    @Override
    public void actionPerformed(ActionEvent ev){
        if (ev.getActionCommand().contains("Roman numbers to arabic")){
            ArabicTranslatorGUI arab = new ArabicTranslatorGUI();
        }
        else {
            RomanTranslatorGUI rim = new RomanTranslatorGUI();
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while loading the GUI!");
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RomanArabic();
            }
        });

    }
}

