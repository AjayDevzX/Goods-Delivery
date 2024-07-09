package GoodsDeliver;

import java.awt.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class HomePage extends JFrame implements ActionListener {
    JLabel titlelabel, welcomelabel,emptyLabel, nameLabel, roleLabel;
    JButton loginbutton, registerbutton;
   // SessionData sessionData = SessionManagerMain.loadUserFromFile();

    public HomePage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        welcomelabel = new JLabel("GoodsDeliver Application");
        welcomelabel.setFont(new Font("Serif", Font.BOLD, 24));
        welcomelabel.setBorder(new EmptyBorder(16, 0, 37, 0));// top,left,bottom,right
        welcomelabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        emptyLabel = new JLabel("");
        emptyLabel.setBorder(new EmptyBorder(0, 0, 20, 0));


        MenuBar menu = new MenuBar();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.add(panel);
        panel.add(welcomelabel);

        panel.add(emptyLabel);
  
        setJMenuBar(menu);


        this.setTitle("Delivery Application");
        this.setSize(800, 500);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub


    }

}