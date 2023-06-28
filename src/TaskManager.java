import java.util.ArrayList;
import java.util.List;

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added: " + task.getName());
    }

    public void editTask(int index, Task updatedTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, updatedTask);
            System.out.println("Task updated: " + updatedTask.getName());
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task removedTask = tasks.remove(index);
            System.out.println("Task deleted: " + removedTask.getName());
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
    public List<Task> getTasks() {
		return tasks;
	}
}
