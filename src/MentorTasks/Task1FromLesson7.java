package MentorTasks;

public class Task1FromLesson7 {

    // Inner Student Class
    class Student {
        String name;
        int age;
        int schoolNumber;

        // Constructor
        public Student(String name, int age, int schoolNumber) {
            this.name = name;
            this.age = age;
            this.schoolNumber = schoolNumber;
        }

        // Method to print info
        public void showInfo() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("School No: " + schoolNumber);
            System.out.println("---------");
        }
    }

    public static void main(String[] args) {

        Task1FromLesson7 task = new Task1FromLesson7();

        Student s1 = task.new Student("Murad", 17, 777);
        Student s2 = task.new Student("Aygun", 16, 444);

        s1.showInfo();
        s2.showInfo();
    }
}
