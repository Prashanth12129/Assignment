package TestProperty;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import Constants.ApplicationConstants;





public class FetchProperties {



	public static String getPropertyValueByKey(String key) throws Exception {
		String value = null ;

		Properties pop = new Properties();

		try {
			FileInputStream ff = new FileInputStream(ApplicationConstants.FILE_PATH);
			pop.load(ff);
			try {
				value = pop.get(key).toString();
			} catch (Exception e) {
			
				e.printStackTrace();
			}	
			if(StringUtils.isEmpty(value)) {
				throw new Exception("Value is not Specified for key "+key+ "In Pro File");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
			
			
			
			
		} catch (IOException e) {
			System.out.println(e.toString());
			
		}
		return value;
	}
}







