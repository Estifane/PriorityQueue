import java.util.PriorityQueue;
import java.util.Scanner;

 class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(); // Min-heap implementation

        int choice;
        do {
            System.out.println("\nTask Prioritizer Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Highest Priority Task");
            System.out.println("3. Remove Highest Priority Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter urgency level (integer, lower is more urgent): ");
                    int urgency = scanner.nextInt();
                    taskQueue.add(new Task(description, urgency));
                    break;
                case 2:
                    if (taskQueue.isEmpty()) {
                        System.out.println("No tasks in the queue.");
                    } else {
                        System.out.println("Highest Priority Task: " + taskQueue.peek());
                    }
                    break;
                case 3:
                    if (taskQueue.isEmpty()) {
                        System.out.println("No tasks in the queue.");
                    } else {
                        System.out.println("Removed task: " + taskQueue.poll());
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }
}

class Task implements Comparable<Task> {
    String description;
    int urgency;

    public Task(String description, int urgency) {
        this.description = description;
        this.urgency = urgency;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.urgency, other.urgency); // Min-heap: lower urgency first
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", urgency=" + urgency +
                '}';
    }
}