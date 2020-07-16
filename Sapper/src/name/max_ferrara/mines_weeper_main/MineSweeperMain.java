package name.max_ferrara.mines_weeper_main;

import name.max_ferrara.mines_weeper.view.FieldCell;
import name.max_ferrara.mines_weeper.view.GameField;
import name.max_ferrara.mines_weeper.view.GameField_v1;

public class MineSweeperMain {
    public static void main(String[] args) {
        //new GameField();
        new GameField_v1();
        /*FieldCell fieldCell = FieldCell.NUM8;
        System.out.println(fieldCell.ordinal());

        FieldCell[] uiEl = FieldCell.values();

        for(FieldCell element: uiEl) {
            System.out.print(element + ", ");
        } */
    }
}
