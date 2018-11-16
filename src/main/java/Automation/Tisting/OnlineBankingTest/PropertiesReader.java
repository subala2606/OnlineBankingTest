package Automation.Tisting.OnlineBankingTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	public Properties getProperty() throws IOException  {
		FileReader f1=new FileReader("seleniumproperties.properties");
		BufferedReader reader=new BufferedReader(f1);
		Properties p=new Properties();
		p.load(reader);
		return p;

	}

}
