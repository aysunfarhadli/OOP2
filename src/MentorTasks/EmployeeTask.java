package MentorTasks;

public class EmployeeTask {

    interface Workable {
        void work();
    }

    interface Trainable {
        void attendTraining();
    }

    abstract static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        abstract void printInfo();
    }

    static class Employee extends Person
            implements Workable, Trainable {

        Employee(String name, int age) {
            super(name, age);
        }

        @Override
        void printInfo() {
            System.out.println("Employee: " + name + ", Age: " + age);
        }

        @Override
        public void work() {
            System.out.println(name + " is working.");
        }

        @Override
        public void attendTraining() {
            System.out.println(name + " attends training.");
        }
    }

    public static void main(String[] args) {
        Employee emp = new Employee("Ali", 25);
        emp.printInfo();
        emp.work();
        emp.attendTraining();
    }
}