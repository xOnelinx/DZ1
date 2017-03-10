package DZ.Lvl_2.Lesson6.Client;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * client
 */
public class MainClient {
    public static void main(String[] args) {


        try (Socket socket = new Socket("localhost", 8189)){
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            while (true){

                String str = sc.nextLine();
                System.out.println("from server: "+ in.readUTF());
                if (str.equals("end"))break;
                out.writeUTF(str);


            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}
