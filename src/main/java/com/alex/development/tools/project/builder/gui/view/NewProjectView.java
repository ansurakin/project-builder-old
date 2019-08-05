package com.alex.development.tools.project.builder.gui.view;

import com.alex.development.tools.project.builder.common.lib.SystemUtil;
import com.alex.development.tools.project.builder.model.project.Project;
import com.alex.development.tools.project.builder.gui.view.component.button.IStepbuttonGroup;
import com.alex.development.tools.project.builder.gui.view.component.button.StepButtonGroupVc;
import com.alex.development.tools.project.builder.model.project.Coordinates;
import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Slf4j
@SessionScope
@Component("newProject")
public class NewProjectView implements IStepbuttonGroup {

    @Getter
    @Setter
    private String name = Project.DEFAULT_ARTIFACT_ID;

    @Getter
    @Setter
    private String location = SystemUtil.getCurrentDir() + SystemUtil.pathSeparator + "tmp";

    @Getter
    @Setter
    private String groupId = Project.DEFAULT_GROUP_ID;

    @Getter
    @Setter
    private String artifactId = Project.DEFAULT_ARTIFACT_ID;

    @Getter
    @Setter
    private String version = Project.DEFAULT_VERSION;

    @Getter
    @Setter
    private String packageName;
    
    @Autowired
    private Project project;

    @Autowired
    private StepButtonGroupVc stepButtonGroupVc;

    @PostConstruct
    public void init() {
        this.packageName = this.groupId + "." + this.artifactId;
        this.stepButtonGroupVc.setListener(this);
    }

    @Override
    public void previousButtonAction() {
        applyProperties();
    }

    @Override
    public void nextButtonAction() {
        applyProperties();
    }

    @Override
    public void finishButtonAction() {
        applyProperties();
    }

    @Override
    public void cancellButtonAction() {

    }

    private void applyProperties() {
        Coordinates coordinates = new Coordinates(this.groupId, this.artifactId, this.version);
        this.project.setName(this.name);
        this.project.setCoordinates(coordinates);
        this.project.setLocation(this.location);
    }

}
