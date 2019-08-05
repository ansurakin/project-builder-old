package com.alex.development.tools.project.builder.model.project.content.pom;

import com.alex.development.tools.project.builder.model.common.Property;
import com.alex.development.tools.project.builder.model.project.Coordinates;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Pom {

    public static String DEFAULT_MODEL_VERSION = "4.0.0";

    public static String DEFAULT_PAKAGING = "jar";

    private final String projectTemplate 
            = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n"
            + "    {0}\n"
            + "</project>";

    private final String propertiesTemplate
            = "<properties>\n"
            + "        {0}"
            + "</properties>";

    private String modelVersion = DEFAULT_MODEL_VERSION;

    private Coordinates coordinates;

    private String packaging = DEFAULT_PAKAGING;

    List<Property> properties = new ArrayList<>();

    public Pom(Coordinates coordinates) {
        this.coordinates = coordinates;
        init();
    }

    public String getDefinition() {
        String result = "";
        
        StringBuilder content = new StringBuilder();
        content
                .append(MessageFormat.format("\n", ""))
                .append(MessageFormat.format("<modelVersion>{0}</modelVersion>", this.modelVersion))
                .append(MessageFormat.format("\n", ""))
                .append(MessageFormat.format("<groupId>{0}</groupId>", this.coordinates.getGroupId()))
                .append(MessageFormat.format("\n", ""))
                .append(MessageFormat.format("<artifactId>{0}</artifactId>", this.coordinates.getArtifactId()))
                .append(MessageFormat.format("\n", ""))
                .append(MessageFormat.format("<version>{0}</version>", this.coordinates.getVersion()))
                .append(MessageFormat.format("\n", ""))
                .append(MessageFormat.format("<packaging>{0}</packaging>", this.packaging));

        StringBuilder propertyItems = new StringBuilder();
        for (Property property : this.properties) {
            propertyItems
                    .append(MessageFormat.format("\n", ""))
                    .append(MessageFormat.format("<{0}>{1}</{0}>", property.getKey(), property.getValue()));
        }
        content
                .append(MessageFormat.format("\n", ""))
                .append(MessageFormat.format(this.propertiesTemplate, propertyItems.toString()));

        result = MessageFormat.format(this.projectTemplate, content.toString());
        return result;
    }

    private void init() {
        fillMinimalProperties();
    }

    private void fillMinimalProperties() {
        Property projectBuildSourceEncoding = new Property() {
            @Override
            public String getKey() {
                return "project.build.sourceEncoding";
            }

            @Override
            public String getValue() {
                return "UTF-8";
            }
        };
        this.properties.add(projectBuildSourceEncoding);

        Property mavenCompilerSource = new Property() {
            @Override
            public String getKey() {
                return "maven.compiler.source";
            }

            @Override
            public String getValue() {
                return "1.8";
            }
        };
        this.properties.add(mavenCompilerSource);

        Property mavenCompilerTarget = new Property() {
            @Override
            public String getKey() {
                return "maven.compiler.target";
            }

            @Override
            public String getValue() {
                return "1.8";
            }
        };
        this.properties.add(mavenCompilerTarget);
    }

}
