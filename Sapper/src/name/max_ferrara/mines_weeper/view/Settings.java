package name.max_ferrara.mines_weeper.view;

public class Settings {
    private int filedSideSize = 9;
    private int minesQuantity = 10;

    public int getFiledSideSize() {
        return filedSideSize;
    }

    public int getMinesQuantity() {
        return minesQuantity;
    }

    public void setFiledSideSize(int filedSideSize) {
        this.filedSideSize = filedSideSize;
    }


    public void setMinesQuantity(int minesQuantity) {
        this.minesQuantity = minesQuantity;
    }
}
