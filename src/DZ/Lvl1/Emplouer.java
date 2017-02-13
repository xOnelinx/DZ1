package DZ.Lvl1;

/**
 * // task 1
 */
public class Emplouer {         // task 2
    private String name;
    private String position;
    private String phone;
    private String email;
    private int salary;
    private int age;

    int getAge() {
        return age;
    }

    int getSalary() {
        return salary;
    }

        void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Emplouer(String name, String position, String phone, String email, int salary, int age) {
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {                                                              // task 3
        return this.name +", age - "+this.age+", current position - "+ this.position +
                " ,tell:"+this.phone+", email:"+this.email+" ,current salary - "+this.salary ;
    }
}
