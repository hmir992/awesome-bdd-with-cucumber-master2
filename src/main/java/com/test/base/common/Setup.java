package com.test.base.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Setup {
    public String separator = File.separator;
    public FileInputStream inputStream;
    public String usedBrowser;
    public String ieDriver;
    public String chromeDriver;
    public String firefoxDriver;
    public String firefoxPath;
    private String configFileLocation = File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config.properties";
    private String resourcesFolderLocation = File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;

    public boolean folderExists(String folderName) {
        File dir = new File(folderName);
        return dir.exists();
    }

    public void getConfigPropValues() throws IOException {

        try {
            Properties prop = new Properties();

            String userDir = System.getProperty("user.dir");
            String propFileName = userDir + this.configFileLocation;

            inputStream = new FileInputStream(propFileName);
            prop.load(inputStream);


            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            chromeDriver = prop.getProperty("CHROME_DRIVER");
            ieDriver = prop.getProperty("IE_DRIVER");
            firefoxDriver = prop.getProperty("GECKO_DRIVER");
            firefoxPath = prop.getProperty("FIREFOX_PATH");
            usedBrowser = prop.getProperty("USED_BROWSER");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }


    }

}
