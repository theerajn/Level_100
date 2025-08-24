public abstract class Filter {
    protected Filter next;

    public void setNext(Filter next) {
        this.next = next;
    }

    public abstract void handle(Email email);
}
