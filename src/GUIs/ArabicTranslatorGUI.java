package GUIs;

import Translators.arabicTranslator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The GUI for the Arabic number translation, basically the same as the Roman Translator
 * This class uses the Translators.arabicTranslator class for the actual translation
*/
public class ArabicTranslatorGUI implements ActionListener{
    JLabel header;
    JLabel output;
    JTextField inputBar;
    JButton confirmButton;
    public ArabicTranslatorGUI(){
        //The main container
        JFrame frame = new JFrame("Number translator");
        frame.setSize(1000, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        ImageIcon img = new ImageIcon("./icon.png");
        frame.setIconImage(img.getImage());


        header = new JLabel("Please insert the roman number for conversion:");
        frame.add(header);
        header.setVisible(true);
        header.setFont(new Font("SERIF", Font.PLAIN, 35));

        //Input Field
        inputBar = new JTextField();
        frame.add(inputBar);
        inputBar.setVisible(true);
        inputBar.setPreferredSize(new Dimension(600, 70));
        inputBar.setFont(new Font("SERIF", Font.PLAIN, 35));
        inputBar.addActionListener(this);

        //The confirmation button
        confirmButton = new JButton("Submit");
        frame.add(confirmButton);
        confirmButton.setVisible(true);
        confirmButton.setFont(new Font("SERIF", Font.PLAIN, 20));
        confirmButton.setPreferredSize(new Dimension(150, 70));
        confirmButton.addActionListener(this);

        //Output
        output = new JLabel("");
        output.setFont(new Font("SERIF", Font.PLAIN, 35));
        output.setPreferredSize(new Dimension(600, 70));
        frame.add(output);
        output.setVisible(false);
    }

    public void actionPerformed(ActionEvent event){
        String inputString = inputBar.getText();
        inputBar.setText("");
        arabicTranslator transl = new arabicTranslator();
        arabicTranslator.roman = inputString;
        output.setVisible(true);
        int result = transl.Roman();
        //If the result is smaller than 0 than we ran into a mistake
        if (result < 0 || transl.checkRoman() == false){
            output.setText("Given number is not roman!");
        }
        else {
            output.setText("Result: " + result);
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
            System.out.println("Error while loading the GUI");
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArabicTranslatorGUI();
            }
        });
    }
}
