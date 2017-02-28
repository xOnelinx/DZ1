package DZ.Lvl_2.Lesson2;

/**
 * домашка 2го урока 25.02.17
 */
public class Les2MainClass {

    static int toIntSum(String[][] sArr)throws MyArrayDataException,MyArraySizeException {

        int sum =0;

             if (sArr.length!=4 ) throw new MyArraySizeException();
             for (String[] sAr:sArr
                  ) {
                 if (sAr.length!=4) throw new MyArraySizeException();
             }


        for (int i = 0; i <sArr.length ; i++) {
            for (int j = 0; j <sArr[i].length ; j++) {
                try {
                    sum += Integer.parseInt(sArr[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        try {
        //System.out.println(toIntSum(new String[][]{{"1","2","3"},{"2","3"},{"4","5"}}));
            System.out.println(toIntSum(new String[][]{{"2","а","4","5"},{"4","5","4","5"},
                    {"4","5","4","5"},{"4","5","4","5"}}));
        }catch (MyArraySizeException  e ){
        System.out.println("массив неправильного размера");
        e.printStackTrace();
        }catch (MyArrayDataException e){
             e.printStackTrace();
        }
    }
}
