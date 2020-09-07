package com.Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Pojo 
{
	
private String config_filePath="./config.properties";
private String baseUrl ="";


public Pojo() throws IOException
{
	FileInputStream file = new FileInputStream(config_filePath);
	
	Properties prop = new Properties();
	
	prop.load(file);
	
	file.close();
	
	baseUrl=prop.getProperty("baseUrl");
	
}


public String getConfig_filePath() {
	return config_filePath.toString();
}


public void setConfig_filePath(String config_filePath) {
	this.config_filePath = config_filePath;
}


public String getBaseUrl() {
	
	return baseUrl.toString();
}


public void setBaseUrl(String baseUrl) {
	this.baseUrl = baseUrl;
}

}
