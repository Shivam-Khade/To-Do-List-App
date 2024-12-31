import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String choice, todoName, todoDesc;
        int id = 1;
        int inputId;
        do {
            System.out.println();
            System.out.println("Enter choice:");
            System.out.println("a -> add todo,\nr -> remove todo,\nm -> mark todo as complete,\np -> print todos,\ne " +
                    "-> exit program");
            System.out.println();
            choice = sc.next().substring(0, 1).toLowerCase();
            switch (choice) {
                case "a":
                    System.out.println("Enter todo name:");
                    sc.nextLine();
                    todoName = sc.nextLine();
                    System.out.println("Enter todo description:");
                    todoDesc = sc.nextLine();
                    if (todoList.add(id, new Todo(todoName, todoDesc))) {
                        id++;
                    }
                    break;
                case "r":
                    System.out.println("Enter todo id to remove:");
                    inputId = sc.nextInt();
                    todoList.remove(inputId);
                    break;
                case "m":
                    System.out.println("Enter todo id to mark as complete:");
                    inputId = sc.nextInt();
                    todoList.markComplete(inputId);
                    break;
                case "p":
                    System.out.println("\nTodo List");
                    System.out.println("-".repeat(30));
                    todoList.print();
                    break;
                case "e":
                    flag = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } while (flag);
        sc.close();
    }
}
