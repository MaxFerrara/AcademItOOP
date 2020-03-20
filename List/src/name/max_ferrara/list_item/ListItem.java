package name.max_ferrara.list_item;

public class ListItem<T> {
    private T listItem;
    private ListItem<T> nextListItem;

    public ListItem(T listItem) {
        this.listItem = listItem;
    }

    public ListItem(T listItem, ListItem<T> nextListItem) {
        this.listItem = listItem;
        this.nextListItem = nextListItem;
    }

    public T getListItem() {
        return listItem;
    }

    public void setListItem(T element) {
        this.listItem = element;
    }

    public ListItem<T> getNextListItem() {
        return nextListItem;
    }

    public void setNextListItem(ListItem<T> nextListItem) {
        this.nextListItem = nextListItem;
    }

    @Override
    public String toString() {
        return ""+ listItem;
    }
}

