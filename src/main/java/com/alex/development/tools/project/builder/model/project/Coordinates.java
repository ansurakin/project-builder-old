package com.alex.development.tools.project.builder.model.project;

import java.io.Serializable;
import lombok.Data;

@Data
public class Coordinates  implements Serializable{
    
    private String groupId;
    
    private String artifactId;    
    
    private String version;
    
    public Coordinates(String groupId, String artifactId, String version) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }
    
}
