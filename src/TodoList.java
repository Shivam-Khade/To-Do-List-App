import java.util.LinkedHashMap;

public class TodoList {
    private LinkedHashMap<Integer, Todo> todos;

    public TodoList() {
        todos = new LinkedHashMap<>();
    }

    public boolean add(int id, Todo todo) {
        if (!todos.containsKey(id)) {
            todos.put(id, todo);  // Add the todo to the map
            System.out.println("Todo: " + todo + " added successfully...");
            return true;
        } else {
            System.out.println("Todo: " + todo + " failed to add...");
            return false;
        }
    }

    public boolean markComplete(int id) {
        if (todos.containsKey(id)) {
            Todo todo = todos.get(id);  // Retrieve the todo by id
            todos.put(id, new Todo(todo.name(), todo.desc(), true));  // Update completion status
            System.out.println("Todo: " + todo + " completed !!!");
            return true;
        }
        System.out.println("Todo with ID " + id + " incomplete or does not exist...");
        return false;
    }

    public boolean remove(int id) {
        if (todos.containsKey(id)) {
            Todo todo = todos.remove(id);  // Remove the todo by id
            System.out.println("Todo: " + todo + " removed successfully...");
            return true;
        }
        System.out.println("Todo with ID " + id + " does not exist. Failed to remove...");
        return false;
    }

    public void print() {
        if (todos.isEmpty()) {
            System.out.println("TodoList is empty...");
            return;
        }
        System.out.printf("%-5s %-20s %-30s %-10s%n", "ID", "Name", "Description", "Status");
        System.out.println("-".repeat(70));
        for (var entry : todos.entrySet()) {
            int id = entry.getKey();
            Todo todo = entry.getValue();
            System.out.printf("%-5d %-20s %-30s %-10b%n", id, todo.name(), todo.desc(), todo.isComplete());
        }
        System.out.println("TodoList Ended...");
    }
}
