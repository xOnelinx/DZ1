package DZ.Lvl_2.Lesson6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * server
 */
public class MainClassS {
    public static void main(String[] args) {


        ServerSocket serv = null;
        Socket socket = null;

        try {
            serv = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения");
            socket = serv.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            while (true){

                String str = sc.nextLine();
                System.out.println(in.readUTF());
                if (str.equals("end"))break;
                out.writeUTF(str);


            }
        } catch (IOException e) {
            System.out.println("Ошибка подключения сервера");
            e.printStackTrace();
        }
        finally {
            try {
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
