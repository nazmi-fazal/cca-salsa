package AcademyE2E;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Webscrape extends Base{
	

	MongoClient mongoClient = null;
	MongoDatabase db = null;
	
@BeforeTest
	
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("DB_url"));
	}
@BeforeClass
public void beforeClass() {
	try {
		// STEP 1: Connect to database
		mongoClient = new MongoClient("localhost", 27017);
		db = mongoClient.getDatabase("Students");
		System.out.println("Connect to database successfully");
	} catch (Exception e)
	{
		System.err.println(e.getClass().getName() + ": " + e.getMessage());
	}
}

@Test

public void WebScrape()
{
	MongoCollection<Document> table = db.getCollection("StudentInfo");
	String url=driver.getCurrentUrl();
	String  title=driver.getTitle();
	
	Document d1=new Document();
	d1.append("url", url);
	d1.append("title", title);
	
	List<Document> doclist =new ArrayList<Document>();
	doclist.add(d1);
	
	table.insertMany(doclist);
	FindIterable<Document> cursor = table.find();
	
	// STEP 4: Iterate over data
	for (Document obj : cursor) {
		System.out.println(obj.toString());
		System.out.println("*************************");
	
		
	}
}

	
	



 @AfterTest
 
 public void Teardown()
 {
	driver.quit(); 
 }
 
 }


