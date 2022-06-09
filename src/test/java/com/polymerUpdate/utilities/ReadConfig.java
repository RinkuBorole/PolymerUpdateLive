package com.polymerUpdate.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	//read properties file from configuration folder.
	// Then base class read data through this readconfig class
		
	Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String username = pro.getProperty("Username");
		return username;
	}
	
	public String getPassword() {
		String password = pro.getProperty("Password");
		return password;
	}
	
	public String getChromepath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}	
	
	public String getIEpath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
	
	public String getFireforxpath() {
		String fireforxpath = pro.getProperty("fireforxpath");
		return fireforxpath;
	}
	
	public String getLoginUsrname() {
		String usrsname = pro.getProperty("usrname");
		return usrsname;
	}
	
	public String getLoginPassword() {
		String pswd = pro.getProperty("pswrd");
		return pswd;
	}
	

}
