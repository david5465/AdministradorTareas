import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class Task {
    private String name;
    private LocalDate dueDate;
    private int priority;

    public Task(String name, LocalDate dueDate, int priority) {
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Name: " + name + ", Due Date: " + dueDate.format(formatter) + ", Priority: " + priority;
    }
}


