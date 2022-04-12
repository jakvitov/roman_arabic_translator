package GUIs;

import Translators.romanTranslator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The GUI for the Roman number translation, basically the same as the Arabic Translator
 * This class uses the Translators.romanTranslator class for the actual translation
 */
public class RomanTranslatorGUI implements ActionListener {

    JLabel header;
    JLabel output;
    JTextField inputBar;
    JButton confirmButton;
    public RomanTranslatorGUI(){

        JFrame frame = new JFrame("Number translator: ");
        frame.setSize(1000, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        ImageIcon img = new ImageIcon("./icon.png");
        frame.setIconImage(img.getImage());


        header = new JLabel("Please insert the arabic number for conversion:");
        frame.add(header);
        header.setVisible(true);
        header.setFont(new Font("SERIF", Font.PLAIN, 35));


        inputBar = new JTextField();
        frame.add(inputBar);
        inputBar.setVisible(true);
        inputBar.setPreferredSize(new Dimension(600, 70));
        inputBar.setFont(new Font("SERIF", Font.PLAIN, 35));
        inputBar.addActionListener(this);

        confirmButton = new JButton("Submit");
        frame.add(confirmButton);
        confirmButton.setVisible(true);
        confirmButton.setFont(new Font("SERIF", Font.PLAIN, 20));
        confirmButton.setPreferredSize(new Dimension(150, 70));
        confirmButton.addActionListener(this);

        output = new JLabel("");
        output.setFont(new Font("SERIF", Font.PLAIN, 35));
        output.setPreferredSize(new Dimension(600, 70));
        frame.add(output);
        output.setVisible(false);
    }

    public void actionPerformed(ActionEvent event){
        String inputString = inputBar.getText();
        inputBar.setText("");
        int input;
        try {
            input = Integer.parseInt(inputString);
        }
        catch (Exception e){
            output.setVisible(true);
            output.setText("This is not an integer!");
            return;
        }
        if (input < 0){
            output.setVisible(true);
            output.setText("This is not an integer!");
            return;
        }
        romanTranslator transl = new romanTranslator(input);
        output.setVisible(true);
        output.setText("Result: " + transl.intToRoman());
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
            System.out.println("Error while loading the GUI.");
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RomanTranslatorGUI();
            }
        });
    }
}
