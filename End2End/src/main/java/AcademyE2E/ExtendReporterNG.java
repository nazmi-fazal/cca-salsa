package AcademyE2E;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {
	static ExtentReports extent;
	
	public static ExtentReports getReport()
	{
		
		String path=System.getProperty("user.dir")+"\\Reports\\index.html";

      ExtentSparkReporter reporter = new ExtentSparkReporter(path);
      reporter.config().setReportName("AcademyE2E Web Automation Results");
      reporter.config().setDocumentTitle("Final Test Results");
      

     extent =new ExtentReports();
      extent.attachReporter(reporter);
      extent.setSystemInfo("Tester", "Nazmi Fazal");
     return extent;

	}

}
