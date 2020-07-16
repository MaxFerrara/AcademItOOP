package name.max_ferrara.mines_weeper.model;

public class FieldMatrix {
    public int matrix[][];

    public FieldMatrix(int columnsQuantity, int rowsQuantity) {
        matrix = new int[columnsQuantity][rowsQuantity];
    }
}
