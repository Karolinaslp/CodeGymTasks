package big_task3608_mvc_design_pattern.view;

import big_task3608_mvc_design_pattern.controller.Controller;
import big_task3608_mvc_design_pattern.model.DataModel;

public interface View {
    void refresh(DataModel dataModel);
    void setController(Controller controller);
}
