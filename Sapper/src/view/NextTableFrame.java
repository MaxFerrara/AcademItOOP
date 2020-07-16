package view;

public interface NextTableFrame {
    void addNextTableListener(NextTableListener l);

    void removeNextTableListener(NextTableListener l);

    NextTableListener[] getNextTableListeners();

    void setVisible(boolean val);
}
