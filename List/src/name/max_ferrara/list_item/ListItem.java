package name.max_ferrara.list_item;

public class ListItem<T> {
    private T element;
    private ListItem<T> nextElement;

    public ListItem(T element) {
        this.element = element;
    }

    public ListItem(T element, ListItem<T> nextElement) {
        this.element = element;
        this.nextElement = nextElement;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public ListItem<T> getNextElement() {
        return nextElement;
    }

    public void setNextElement(ListItem<T> nextElement) {
        this.nextElement = nextElement;
    }
}

