package com.alex.development.tools.project.builder.gui.service;

import com.alex.development.tools.project.builder.core.crud.settings.SettingsService;
import com.alex.development.tools.project.builder.core.crud.step.StepService;
import com.alex.development.tools.project.builder.gui.util.FacesContextUtil;
import com.alex.development.tools.project.builder.gui.util.NavigationUtil;
import com.alex.development.tools.project.builder.gui.model.ButtonType;
import com.alex.development.tools.project.builder.model.entity.Settings;
import com.alex.development.tools.project.builder.model.entity.Step;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StepButtonService {

    @Autowired
    private StepService service;
    
    @Autowired
    private SettingsService settingsService;
    
    public void handle(String currentUrl, ButtonType direction) throws IOException {
        String targetUrl = null;
        
        Step step = this.service.get(currentUrl);
        Settings settings = this.settingsService.getCurrentSettings();

        switch (direction) {
            case NEXT:
                targetUrl = step.getNextView();
                break;                
            case PREVIOUS:
                targetUrl = step.getPreviousView();
                break;            
            case FINISH:
                targetUrl = settings.getFinishStepUrl();
                break;
            case CANCELL:
                targetUrl = settings.getCancellStepUrl();
                break;
            default:
                throw new UnsupportedOperationException(direction.toString());
        }
        
        FacesContextUtil.addMessage("Готово");
        NavigationUtil.redirect(targetUrl);
    }

}
