package main.java.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.intuit.ipp.security.OAuthAuthorizer;

public class ApplicationQBOConfig {
	public static final String REQUEST_TOKEN_URL = "https://oauth.intuit.com/oauth/v1/get_request_token";
	public static final String ACCESS_TOKEN_URL = "https://oauth.intuit.com/oauth/v1/get_access_token";
	public static final String AUTHORIZE_URL = "https://appcenter.intuit.com/connect/begin";
	
	Properties prop;
	OAuthAuthorizer auth;
	public ApplicationQBOConfig(){
		this.loadProperties();
		//auth=new OAuthAuthorizer(consumerKey, consumerSecret, accessToken, accessTokenSecret);
	}
	private void loadProperties() {
		prop = new Properties();
		try {
			InputStream in = getClass().getResourceAsStream(
					"/main/resources/intuit.properties");
			if (in != null) {
				prop.load(in);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
