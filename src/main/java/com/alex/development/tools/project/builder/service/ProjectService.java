package com.alex.development.tools.project.builder.service;

import com.alex.development.tools.project.builder.common.lib.FileUtil;
import com.alex.development.tools.project.builder.common.lib.SystemUtil;
import com.alex.development.tools.project.builder.model.project.Project;
import com.alex.development.tools.project.builder.model.project.Content;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProjectService {
    
    //TODO
    public void create(Project project) throws IOException{
        String projectDir = project.getProjectDir();
        Content content = project.getContent();
        
        this.createDir(projectDir);
        
        String pomFile = projectDir + SystemUtil.pathSeparator + "pom.xml";
        String pomText = content.getPom().getDefinition();
        this.createFile(pomFile, pomText);
    }
    
    private void createDir(String dir) throws IOException{
        FileUtil.createDir(dir);
    }
    
    private void createFile(String pomFile, String pomText) throws IOException{
        FileUtil.writeStringToFile(pomFile, pomText);
    }
    
}
