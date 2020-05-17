package name.max_ferrara.temperature_v2.view;

import java.awt.event.ActionListener;

public interface TemperatureView {
    void initView();

    void addResetActionListener(ActionListener listener);

    void addConvertActionListener(ActionListener listener);

    void resetScaleFields();
}
