package DZ.Lvl_2.Lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Денис on 06.03.2017.
 */
public class ChatWindow extends JFrame {
    private final int W_WIGHT =400;
    private final int W_HEIGHT =500;

    ChatWindow (){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat");
        setLocation(100,100);
        setVisible(true);
        setSize(W_WIGHT,W_HEIGHT);

        JTextArea chat = new JTextArea();
        add(chat,BorderLayout.CENTER);

        JPanel pInesrt = new JPanel();
        pInesrt.setLayout(new GridLayout(1,2));
        add(pInesrt,BorderLayout.SOUTH);

        JTextField field = new JTextField();
        pInesrt.add(field);
        JButton send = new JButton("Send");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chat.append(field.getText());

            }
        });
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chat.append(field.getText());
            }
        });



        pInesrt.add(send);




    }

    public static void main(String[] args) {
        new ChatWindow();
    }

}
