public record Todo(String name, String desc, boolean isComplete) {
    public Todo(String name, String desc) {
        this(name, desc, false);
    }

    @Override
    public String toString() {
        return String.format("'%s'", name);
    }
}