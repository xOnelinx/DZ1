package DZ.Lvl_2.Lesson4;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by DENIS on 06.03.2017.
 */
public class ChatWindow extends JFrame{

    private final int W_WIGHT= 400;
    private final int W_HEIGHT= 500;

    JTextArea fieldMsg;
    JTextArea chat;

    ChatWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(100,100);
        setSize(W_WIGHT,W_HEIGHT);

        fieldMsg = new JTextArea();
        fieldMsg.setLineWrap(true);
        JScrollPane jspMsg = new JScrollPane(fieldMsg);
        JButton send = new JButton("Send");

        JPanel pBottom = new JPanel(new BorderLayout());
        pBottom.add(send,BorderLayout.EAST);
        pBottom.add(jspMsg,BorderLayout.CENTER);
        add(pBottom,BorderLayout.SOUTH);

        chat = new JTextArea();
        chat.setEditable(false);
        chat.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(chat);
        add(jsp,BorderLayout.CENTER);

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });

        fieldMsg.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_ENTER){
                   if (fieldMsg.getText().trim().length() >0)
                    sendMsg();
                }
            }
        });
        pBottom.setPreferredSize(new Dimension(1,100));
        setVisible(true);
        fieldMsg.grabFocus();
    }


    void sendMsg(){
        String str = fieldMsg.getText();
        fieldMsg.setText(" ");
        chat.append(str + "\n");
        fieldMsg.grabFocus();
    }


    public static void main(String[] args) {
        new ChatWindow();
    }
}
