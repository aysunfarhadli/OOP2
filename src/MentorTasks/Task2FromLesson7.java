package MentorTasks;

public class Task2FromLesson7 {

    // Inner Book Class
    class Book {

        private String name;
        private String author;
        private int pageCount;

        // Constructor
        public Book(String name, String author, int pageCount) {
            this.name = name;
            this.author = author;
            this.pageCount = pageCount;
        }

        // Getters
        public String getName() {
            return name;
        }

        public String getAuthor() {
            return author;
        }

        public int getPageCount() {
            return pageCount;
        }

        // Setters
        public void setName(String name) {
            this.name = name;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }
    }

    public static void main(String[] args) {

        Task2FromLesson7 task = new Task2FromLesson7();

        Book b1 = task.new Book("Java 101", "James Gosling", 250);

        System.out.println("Book: " + b1.getName());

        // Update data
        b1.setName("Java Programming Language");
        b1.setPageCount(350);

        System.out.println("Updated Book: " + b1.getName() +
                ", Pages: " + b1.getPageCount());
    }
}
