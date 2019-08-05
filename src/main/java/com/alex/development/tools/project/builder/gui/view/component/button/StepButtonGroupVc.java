package com.alex.development.tools.project.builder.gui.view.component.button;

import com.alex.development.tools.project.builder.gui.model.ButtonType;
import com.alex.development.tools.project.builder.gui.service.StepButtonService;
import com.alex.development.tools.project.builder.gui.util.FacesContextUtil;
import java.io.IOException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class StepButtonGroupVc {

    @Autowired
    private StepButtonService stepButtonService;

    @Getter
    @Setter
    private IStepbuttonGroup listener;

    public void previousButtonAction() throws IOException {
        this.listener.previousButtonAction();
        buttonHandler(ButtonType.PREVIOUS);
    }

    public void nextButtonAction() throws IOException {
        this.listener.nextButtonAction();
        buttonHandler(ButtonType.NEXT);
    }

    public void finishButtonAction() throws IOException {
        this.listener.finishButtonAction();
        buttonHandler(ButtonType.FINISH);
    }

    public void cancellButtonAction() throws IOException {
        this.listener.cancellButtonAction();
        buttonHandler(ButtonType.CANCELL);
    }

    private void buttonHandler(ButtonType buttonType) throws IOException {
        String currentUrl = FacesContextUtil.getCurrentJsfUrl();
        this.stepButtonService.handle(currentUrl, buttonType);
    }

}
