package com.alex.development.tools.project.builder.common.lib;

import com.alex.development.tools.project.builder.BaseTest;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

@Slf4j
@Ignore
public class FileUtilTest extends BaseTest {

    private static final String TMP_DIR_NAME = "tmp_test";

    private static final String EXTENSION = "txt";

    private String projectName;
    
    private String currentDir;

    private String content;

    private final String placeholder;

    public FileUtilTest() {
        this.placeholder = String.valueOf(TimeUtil.currentMillis());
        this.projectName = "test-project" + this.placeholder;
        this.content = this.placeholder;
        this.currentDir = SystemUtil.getCurrentDir();
    }

    @Test
    public void testNormalWrite() throws Exception {
        String fullname = this.currentDir
                + SystemUtil.pathSeparator + TMP_DIR_NAME
                + SystemUtil.pathSeparator + this.projectName + "." + EXTENSION;

        FileUtil.writeStringToFile(fullname, content);
        
//        this.clearTmpDir();
    }
    
    private void clearTmpDir() throws IOException{
        String dir = this.currentDir
                + SystemUtil.pathSeparator + TMP_DIR_NAME;
        
        FileUtil.cleanDirectory(dir);
    }

}
