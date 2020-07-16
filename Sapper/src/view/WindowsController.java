package view;

import java.util.ArrayList;
import java.util.List;

public class WindowsController implements NextTableListener {
    private final List<NextTableFrame> wins = new ArrayList<NextTableFrame>();

    public void addFrame(NextTableFrame f) {
        wins.add(f);
        f.addNextTableListener(this);
    }

    public void addFrame(int i, NextTableFrame f) {
        wins.add(i, f);
        f.addNextTableListener(this);
    }

    public void removeFrame(NextTableFrame f) {
        int idx = wins.indexOf(f);

        if (idx >= 0) {
            wins.remove(idx).removeNextTableListener(this);
        }
    }

    public void show(int idx) {
        for (int i = 0; i < wins.size(); i++) {
            wins.get(i).setVisible(i == idx);
        }
    }

    public void show(NextTableFrame frame) {
        for (NextTableFrame f : wins) {
            f.setVisible(f == frame);
        }
    }

    public void prevWin(NextTableFrame f) {
        int idx = wins.indexOf(f);

        if (idx == 0) {
            show(wins.size() - 1);
        } else if (idx > 0) {
            show(--idx);
        }
    }

    public void nextWin(NextTableFrame f) {
        int idx = wins.indexOf(f);

        if (idx == wins.size() - 1) {
            show(0);
        } else if (idx > -1) {
            show(++idx);
        }
    }
}
