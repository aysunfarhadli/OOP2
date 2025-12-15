package MentorTasks;

public class UniversityTask {

    interface ExamParticipant {
        void takeExam();
    }

    interface Payable {
        void receiveSalary();
    }

    abstract static class User {
        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        abstract void getDetails();
    }

    static class Student extends User
            implements ExamParticipant {

        Student(int id, String name) {
            super(id, name);
        }

        @Override
        void getDetails() {
            System.out.println("Student: " + name);
        }

        @Override
        public void takeExam() {
            System.out.println(name + " takes exam.");
        }
    }

    static class Teacher extends User
            implements ExamParticipant, Payable {

        Teacher(int id, String name) {
            super(id, name);
        }

        @Override
        void getDetails() {
            System.out.println("Teacher: " + name);
        }

        @Override
        public void takeExam() {
            System.out.println(name + " supervises exam.");
        }

        @Override
        public void receiveSalary() {
            System.out.println(name + " received salary.");
        }
    }

    public static void main(String[] args) {
        Student s = new Student(1, "Leyla");
        Teacher t = new Teacher(2, "Kamal");

        s.getDetails();
        s.takeExam();

        t.getDetails();
        t.takeExam();
        t.receiveSalary();
    }
}