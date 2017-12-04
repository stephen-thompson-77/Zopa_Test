package thompson.zopa.loans.files;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileManagerTest {
	
	private ManagerFactory manager;
	private ByteArrayOutputStream output;
	
	@Before
	public void setup(){
		manager = new ManagerFactory();	
		
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
	}
	
	@Test
	public void FileNotFoundTest(){
		manager.getFile("NonExistingTestFile.csv");
		Assert.assertEquals("The requested File could not be found. Please check name and extention and try again.", output);
	}
	
	@Test
	public void unsupportedFileTypeTest(){
		manager.getFile("TestFile.unsupported");
		Assert.assertEquals("The requested File type is not supported. Please check name and extention and try again.", output);
	}
	
	@Test
	public void successfulReadTest() throws IOException{
		File testFile = manager.getFile("TestValid.csv");
		ClassLoader classLoader = getClass().getClassLoader();
		File validCsv = new File(classLoader.getResource("TestValidCsv").getFile());
		Assert.assertTrue(FileUtils.contentEquals(validCsv, testFile));
	}

}
