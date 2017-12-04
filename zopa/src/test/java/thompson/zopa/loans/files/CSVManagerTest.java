package thompson.zopa.loans.files;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import thompson.zopa.loans.entities.Lender;

public class CSVManagerTest {
	
	private CSVManager manager;
	private File invalidCsv;
	private File invalidHeadersCsv;
	private File validCsv;
	private ByteArrayOutputStream output;
	private List<Lender> lenders;
	
	@Before
	public void setup(){
		manager = new CSVManager();
		
		ClassLoader classLoader = getClass().getClassLoader();
		invalidCsv = new File(classLoader.getResource("TestInvalidCsv").getFile());
		invalidHeadersCsv = new File(classLoader.getResource("TestInvalidHeadersCsv").getFile());
		validCsv = new File(classLoader.getResource("TestValidCsv").getFile());
		
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		lenders = new ArrayList<Lender>();
		
		Lender lenderA = new Lender();
		lenderA.setName("Bob");
		lenderA.setAmount(260);
		lenderA.setRate(0.068f);
		lenders.add(lenderA);
		
		Lender lenderB = new Lender();
		lenderB.setName("Jim");
		lenderB.setAmount(600);
		lenderB.setRate(0.082f);
		lenders.add(lenderB);
		
		Lender lenderC = new Lender();
		lenderC.setName("Sal");
		lenderC.setAmount(400);
		lenderC.setRate(0.074f);
		lenders.add(lenderC);
		
		Lender lenderD = new Lender();
		lenderD.setName("Mary");
		lenderD.setAmount(250);
		lenderD.setRate(0.058f);
		lenders.add(lenderD);

		Lender lenderE = new Lender();
		lenderE.setName("Alex");
		lenderE.setAmount(120);
		lenderE.setRate(0.023f);
		lenders.add(lenderE);
	}
	
	@Test
	public void invalidDataTest(){
		manager.readData(invalidCsv);
		Assert.assertEquals("The CSV file used has invalid or currpted data, please check the file and try again.", output);
	}
	
	@Test
	public void invalidDataHeadersTest(){
		manager.readData(invalidHeadersCsv);
		Assert.assertEquals("The CSV file used has invalid or currpted data, please check the file and try again.", output);
	}
	
	@Test
	public void validDataTest(){
		List<Lender> localLenders = manager.readData(validCsv);
		Assert.assertNotEquals("The CSV file used has invalid or currpted data, please check the file and try again.", output);
		Assert.assertNotNull(localLenders);
		Assert.assertEquals(lenders, localLenders);
	}
	
}
