package de.atomfrede.jenkins.properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class JenkinsProperties {

	public static final String apiRoot = "jenkins.apiroot";
	public static final String username = "jenkins.user";
	public static final String password = "jenkins.password";
	public static final String metricsJob = "metrics.job";
	
    private static JenkinsProperties instance = null;
    
    private JenkinsProperties() {}
    
    public static JenkinsProperties getInstance() {
    	if(instance == null) {
    		instance = new JenkinsProperties();
    		instance.init();
    	}
    	return instance;
    }
    
	private boolean isInitialized = false;
	
	private Configuration config = null;
	
	public void init() {
		try {
			config = new PropertiesConfiguration(JenkinsProperties.class.getResource("jenkins.properties"));
			isInitialized = true;
		} catch(ConfigurationException cfe) {
			System.out.println("Config is wrong! "+cfe);
			isInitialized = false;
		}
	}
	
	public String getApiRoot() {
		return config.getString(apiRoot);
	}
	
	public String getUsername() {
		return config.getString(username);
	}
	
	public String getPassword() {
		return config.getString(password);
	}
	
	public String getMetricsJob() {
		return config.getString(metricsJob);
	}
	
	public String getAuthHeader() {
		//Benutzername:Passwort as base64 encoded string
		String auth = getUsername()+":"+getPassword();
		return Base64.encodeBase64String(auth.getBytes());
	}
}
