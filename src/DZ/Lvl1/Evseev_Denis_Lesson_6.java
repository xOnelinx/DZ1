package DZ.Lvl1;


import java.io.*;


public class Evseev_Denis_Lesson_6 {


    private static void textWriter (String s) throws IOException    {
        FileOutputStream fos;
        fos =new FileOutputStream("text2.txt");
        fos.write(s.getBytes());
        fos.flush();
        fos.close();
    }

    private  static  void copyFiles (FileOutputStream fos,FileInputStream fis) throws IOException{
        int i;
        do {
            i = fis.read();
            if (i!=-1) fos.write(i);
        }while (i!=-1);
    }
    private static void glue (String a,String b)throws IOException{
        FileInputStream fin = new FileInputStream(a);
        FileOutputStream fout = new FileOutputStream("text1+2.txt");
        copyFiles(fout,fin);
        fin = new FileInputStream(b);
        fout = new FileOutputStream("text1+2.txt",true);
        copyFiles(fout,fin);
        fin.close();
        fout.flush();
        fout.close();
    }
    private static StringBuilder reader (String s)throws IOException{

        FileInputStream fin = new FileInputStream(s);

        int i;
        StringBuilder sb = new StringBuilder();

         do{
            i = fin.read();
             sb.append((char) i);

        } while (i!=-1);
        fin.close();
        return sb;
    }

    private static boolean find (StringBuilder sb,String kye)throws IOException{
        char [] ckye = kye.toCharArray();
        boolean flag = true;
        for (int i = 0; i <sb.length()-ckye.length ; i++) {
            for (int j = 0; j <ckye.length ; j++) {
                if (sb.charAt(i+j)==ckye[j]) flag &= true;
                else {flag &=false; j = ckye.length;}
            }
            if (flag) return true;
            flag = true;
        }
        return false;
    }



    public static void main(String[] args) {

        String s1 = "A mutable sequence of characters. This class provides an API compatible with StringBuffer, but with no" +
                " guarantee of synchronization. This class is designed for use as a drop-in replacement for StringBuffer in places" +
                " where the string buffer was being used by a single thread (as is generally the case). Where possible, it is recommended " +
                "that this class be used in preference to StringBuffer as it will be faster under most implementations.";
        String s2 = "The principal operations on a StringBuilder are the append and insert methods, which are overloaded so as to accept " +
                "data of any type. Each effectively converts a given datum to a string and then appends or inserts the characters of that string " +
                "to the string builder. The append method always adds these characters at the end of the builder; the insert method adds the " +
                "characters at a specified point.";

        try {
         textWriter(s1);
         textWriter(s2);
         glue("text1.txt","text2.txt");

           // System.out.println(find(reader("text1+2.txt"),"synchronization"));                   //мощное колдунство чтобы оценить результат




        }catch (IOException e){
            e.getStackTrace();
            System.out.println("?"+e.getMessage());
        }
    }
}
