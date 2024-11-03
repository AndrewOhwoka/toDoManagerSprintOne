public class TaskList {
    private Node head;

    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markTaskAsCompleted(String description) {
        Node current = head;
        while (current != null) {
            if (current.task.getDescription().equals(description)) {
                current.task.markAsCompleted();
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    public void printTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
}
