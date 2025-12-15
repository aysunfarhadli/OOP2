package MentorTasks;

public class HomeTaskFitness {

    // ===== Interface =====
    interface GoalTrackable {
        boolean isGoalReached(int goalMinutes);
    }

    // ===== Base Class =====
    static class Activity {
        private String name;
        private int durationMinutes;
        private double calorieFactor;

        public Activity(String name, int durationMinutes, double calorieFactor) {
            this.name = name;
            this.durationMinutes = durationMinutes;
            this.calorieFactor = calorieFactor;
        }

        public int getDurationMinutes() {
            return durationMinutes;
        }

        public double calculateCalories() {
            return durationMinutes * calorieFactor;
        }

        public void showInfo() {
            System.out.println(
                    "Activity: " + name +
                            ", Duration: " + durationMinutes +
                            " minutes, Calories: " + calculateCalories()
            );
        }
    }

    // ===== Running Class =====
    static class Running extends Activity implements GoalTrackable {
        private double distanceKM;

        public Running(int durationMinutes, double distanceKM) {
            super("Running", durationMinutes, 10.0);
            this.distanceKM = distanceKM;
        }

        @Override
        public void showInfo() {
            System.out.println(
                    "Running: " + getDurationMinutes() +
                            " minutes, " + distanceKM +
                            " KM, Calories: " + calculateCalories()
            );
        }

        @Override
        public boolean isGoalReached(int goalMinutes) {
            return getDurationMinutes() >= goalMinutes;
        }
    }

    // ===== Yoga Class =====
    static class Yoga extends Activity implements GoalTrackable {
        private String type;

        public Yoga(int durationMinutes, String type) {
            super("Yoga", durationMinutes, 4.0);
            this.type = type;
        }

        @Override
        public void showInfo() {
            System.out.println(
                    "Yoga (" + type + "): " +
                            getDurationMinutes() +
                            " minutes, Calories: " + calculateCalories()
            );
        }

        @Override
        public boolean isGoalReached(int goalMinutes) {
            return getDurationMinutes() >= goalMinutes;
        }
    }

    // ===== Fitness Tracker =====
    static class FitnessTracker {

        void logActivity(Activity activity) {
            activity.showInfo();

            if (activity.calculateCalories() > 100) {
                System.out.println("Congratulations! High-intensity activity!");
            } else {
                System.out.println("Keep going, you're doing great!");
            }
        }

        void checkGoal(GoalTrackable activity, int goalMinutes) {
            boolean reached = activity.isGoalReached(goalMinutes);
            System.out.println(
                    "Goal: " + goalMinutes +
                            " minutes. Reached: " + reached
            );
        }
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        Running running = new Running(45, 5.0);
        Yoga yoga = new Yoga(60, "Vinyasa");
        Activity walking = new Activity("Walking", 30, 3.0);

        System.out.println("--- Activities ---");
        running.showInfo();
        yoga.showInfo();
        walking.showInfo();

        FitnessTracker tracker = new FitnessTracker();

        System.out.println("\n--- Log Activities ---");
        tracker.logActivity(running);
        tracker.logActivity(yoga);
        tracker.logActivity(walking);

        System.out.println("\n--- Goal Check ---");
        tracker.checkGoal(running, 30);
        tracker.checkGoal(running, 60);
        tracker.checkGoal(yoga, 45);
        tracker.checkGoal(yoga, 70);

        // walking -> GoalTrackable deyil (compile-time error olardı)
    }
}