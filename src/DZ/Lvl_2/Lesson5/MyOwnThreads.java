package DZ.Lvl_2.Lesson5;

/**
 * Created by Денис on 08.03.2017.
 */
public class MyOwnThreads {
    static void get1ThreadTime(){
        final int size = 10000000;
        long a = System.currentTimeMillis();
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.print("time - ");
        System.out.println(System.currentTimeMillis()-a);
    }

    static void get2ThreadTime(){
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        long startTime = System.currentTimeMillis();
        float a1 [] = new float[h];
        float a2 [] = new float[h];
        System.arraycopy(arr,0,a1,0,h);
        System.arraycopy(arr,h,a2,0,h);
        long time1 = System.currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) *
                            Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        }).start();
        long calcTime1 = System.currentTimeMillis();
         new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) *
                            Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        }).start();
        long calcTime2 = System.currentTimeMillis();
        System.arraycopy(a1,0,arr,0,h);
        System.arraycopy(a2,0,arr,h,h);
        long a1_a2 = System.currentTimeMillis();
        System.out.println("2 потока");
        System.out.print(" разбивка - "+(time1-startTime)+
                "\n 1 рассчет "+(calcTime1-time1)
                +"\n 2 рассчет "+(calcTime2-calcTime1)+
                "\n склейка "+(a1_a2-calcTime2)+
                "\n вобщем "+(a1_a2-startTime));
    }

    public static void main(String[] args) {
        get1ThreadTime();
        get2ThreadTime();
    }
}
