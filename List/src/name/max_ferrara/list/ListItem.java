package name.max_ferrara.list;

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

    @Override
    public String toString() {
        return listItem + "";
    }

    public T getListItem() {
        return listItem;
    }

    public void setListItem(T listItem) {
        this.listItem = listItem;
    }

    public ListItem<T> getNextListItem() {
        return nextListItem;
    }

    public void setNextListItem(ListItem<T> nextListItem) {
        this.nextListItem = nextListItem;
    }
}

