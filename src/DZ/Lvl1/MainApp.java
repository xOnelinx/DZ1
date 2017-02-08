package DZ.Lvl1;


public class MainApp {



    private void getEmpiouer(Emplouer[] emps){              // task 4

        for (int i = 0; i <emps.length ; i++) {
        if (emps[i].getAge()>40) System.out.println(emps[i].toString());
        }
    }
    private void setSalariEmpiouers(Emplouer[] emps){           // task 5

        for (int i = 0; i <emps.length ; i++) {
            System.out.println(emps[i].getName()+" - "+emps[i].getAge()+" years"+" ,current salary - "+ emps[i].getSalary());
            if (emps[i].getAge()>45) emps[i].setSalary(emps[i].getSalary()+5000);
            System.out.println(emps[i].getName()+" - new salary - "+ emps[i].getSalary());
            System.out.println();

        }

    }
    private void averageAge(Emplouer[] emps){                   // task 6.1
        int allAge=0;
        for (int i = 0; i <emps.length ; i++) {
            allAge += emps[i].getAge();
        }
        System.out.println("average age of employers:"+allAge/emps.length);
    }
    private void averageSalari (Emplouer[] emps){               // task 6.2
        int allSalary=0;
        for (int i = 0; i <emps.length ; i++) {
            allSalary += emps[i].getSalary();
        }
        System.out.println("average age of employers:"+allSalary/emps.length);
    }




    public static void main(String[] args) {
        Emplouer [] emplouers = new Emplouer[5];
        MainApp apps = new MainApp();

        emplouers[0]= new Emplouer("Сергей Степанович Куницин", "Мэр города","564654654","фыы@афывфывв",55000,51);
        emplouers[1]= new Emplouer("Анатолий Афанасивич Глыба", "Коллектор","056747541","шлю@рьаптапт",35000,40);
        emplouers[2]= new Emplouer("Светалан Ивановна Степан", "Секретарь","6857465465","нь@тпи ув",25000,45);
        emplouers[3]= new Emplouer("Тимофей Павлович Удар", "НАчальник СБ","007","иеи@епиепи",25000,36);
        emplouers[4]= new Emplouer("Серафима Генадьевна Зря", "Верховный жрец","001","камкамк@ам",155000,64);
        System.out.println("task 4");
        apps.getEmpiouer(emplouers);
        System.out.println("task 5");
        apps.setSalariEmpiouers(emplouers);
        System.out.println("task 6.1");
        apps.averageAge(emplouers);
        System.out.println("task 6.2");
        apps.averageSalari(emplouers);


    }
}
