import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class TaskManagerApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        

        boolean exit = false;
        while (!exit) {
        	
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println("\nTask Manager Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter due date (dd/MM/yyyy): ");
                    String dueDateString = scanner.nextLine();
                    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dueDate = LocalDate.parse(dueDateString, formatter1);
                    System.out.print("Enter priority (1-5): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    Task task = new Task(name, dueDate, priority);
                    taskManager.addTask(task);
                    break;
                case 2:
                    taskManager.printTasks();
                    System.out.print("Enter the index of the task to edit: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    if (editIndex > 0 && editIndex <= taskManager.getTasks().size()) {
                        Task taskToEdit = taskManager.getTasks().get(editIndex - 1);
                        System.out.print("Enter new task name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new due date (dd/MM/yyyy): ");
                        String newDueDateString = scanner.nextLine();
                        LocalDate newDueDate = LocalDate.parse(newDueDateString, formatter);
                        System.out.print("Enter new priority (1-5): ");
                        int newPriority = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        Task updatedTask = new Task(newName, newDueDate, newPriority);
                        taskManager.editTask(editIndex - 1, updatedTask);
                    } else {
                        System.out.println("Invalid task index!");
                    }
                    break;
                case 3:
                    taskManager.printTasks();
                    System.out.print("Enter the index of the task to delete: ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    if (deleteIndex > 0 && deleteIndex <= taskManager.getTasks().size()) {
                        taskManager.deleteTask(deleteIndex - 1);
                    } else {
                        System.out.println("Invalid task index!");
                    }
                    break;
                case 4:
                    taskManager.printTasks();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting Task Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
