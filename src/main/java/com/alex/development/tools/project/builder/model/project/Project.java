package com.alex.development.tools.project.builder.model.project;

import com.alex.development.tools.project.builder.common.lib.SystemUtil;
import java.io.Serializable;
import lombok.Data;

@Data
public class Project implements Serializable{
    
    public static final String DEFAULT_GROUP_ID = "com.example";
    
    public static final String DEFAULT_ARTIFACT_ID = "new-project";
    
    public static final String DEFAULT_VERSION = "0.1-SNAPSHOT";
    
    private String name;
    
    private String location;
    
    private Coordinates coordinates = new Coordinates(DEFAULT_GROUP_ID, DEFAULT_ARTIFACT_ID, DEFAULT_VERSION);
    
    private Content content = new Content();
    
    public Project(){
        this.init();
    }
    
    public Project(Coordinates coordinates){
        this();
        this.coordinates = coordinates;
    }
    
    private void init(){
    }
    
    public String getProjectDir() {
        String result = this.location + SystemUtil.pathSeparator + this.name;
        return result;
    }
    
}
