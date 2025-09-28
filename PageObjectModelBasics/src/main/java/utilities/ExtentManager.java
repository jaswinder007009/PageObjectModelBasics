package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		
		if (extent == null) {
			
			String reportPath = System.getProperty("user.dir") 
					+ "/target/surefire-reports/html/extent.html";
			
			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

			// Load external XML config
			String configPath = System.getProperty("user.dir") 
					+ "/src/test/resources/com/Ex2/extentconfig/ReportsConfig.xml";
			
			try {
				spark.loadXMLConfig(new File(configPath));
			} catch (Exception e) {
				e.printStackTrace();
			}

			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
		
		return extent;
	}
}
