package thompson.zopa.loans;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import thompson.zopa.loans.entities.Lender;
import thompson.zopa.loans.entities.Loan;

public class LoanManagerTest {
	
	private Loan bestOneThousandFiveHundredLoan;
	private Loan bestOneThousandTwoHundredLoan;
	private Loan bestOneThousandLoan;
	private Loan bestSevenHundredLoan;
	private Loan bestFiveHundredLoan;
	private Loan invalidLoan;
	private LoanManager loanManager;
	private ArrayList<Lender> lenders;
	
	@Before
	public void setup(){
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
		
		buildLoans();
	}
	
	private void buildLoans(){
		List<Lender> topOneThousandFiveHundredLenders = new ArrayList<Lender>();
		topOneThousandFiveHundredLenders.add(lenders.get(0));
		topOneThousandFiveHundredLenders.add(lenders.get(1));
		topOneThousandFiveHundredLenders.add(lenders.get(2));
		topOneThousandFiveHundredLenders.add(lenders.get(3));
		
		bestOneThousandFiveHundredLoan = new Loan();
		bestOneThousandFiveHundredLoan.setLenders(topOneThousandFiveHundredLenders);
		
		List<Lender> topOneThousandTwoHundredLenders = new ArrayList<Lender>();
		topOneThousandTwoHundredLenders.add(lenders.get(1));
		topOneThousandTwoHundredLenders.add(lenders.get(2));
		topOneThousandTwoHundredLenders.add(lenders.get(3));
		
		bestOneThousandTwoHundredLoan = new Loan();
		bestOneThousandTwoHundredLoan.setLenders(topOneThousandTwoHundredLenders);
		
		List<Lender> topOneThousandLenders = new ArrayList<Lender>();
		topOneThousandLenders.add(lenders.get(1));
		topOneThousandLenders.add(lenders.get(2));
		
		bestOneThousandLoan = new Loan();
		bestOneThousandLoan.setLenders(topOneThousandLenders);
		
		List<Lender> topSevenHundredLenders = new ArrayList<Lender>();
		topSevenHundredLenders.add(lenders.get(1));
		topSevenHundredLenders.add(lenders.get(4));
		
		bestSevenHundredLoan = new Loan();
		bestSevenHundredLoan.setLenders(topSevenHundredLenders);
		
		List<Lender> topFiveHundredLenders = new ArrayList<Lender>();
		topFiveHundredLenders.add(lenders.get(1));
		
		bestFiveHundredLoan = new Loan();
		bestFiveHundredLoan.setLenders(topFiveHundredLenders);
		
		invalidLoan = new Loan();
	}
	
	@Test
	public void findValidBestLoanForOneThousandFiveHundredTest(){
		Loan testLoan = loanManager.findLoan("1500");
		Assert.assertEquals(bestOneThousandLoan.getTotalRate(), testLoan.getTotalRate(), 0.0f);
		Assert.assertEquals(bestOneThousandLoan.getTotalAmount(), testLoan.getTotalAmount());
		Assert.assertEquals(bestOneThousandLoan, testLoan);
	}
	
	@Test
	public void findValidBestLoanForOneThousandTwoHundredTest(){
		Loan testLoan = loanManager.findLoan("1200");
		Assert.assertEquals(bestOneThousandLoan.getTotalRate(), testLoan.getTotalRate(), 0.0f);
		Assert.assertEquals(bestOneThousandLoan.getTotalAmount(), testLoan.getTotalAmount());
		Assert.assertEquals(bestOneThousandLoan, testLoan);
	}

	@Test
	public void findValidBestLoanForOneThousandTest(){
		Loan testLoan = loanManager.findLoan("1000");
		Assert.assertEquals(bestOneThousandLoan.getTotalRate(), testLoan.getTotalRate(), 0.0f);
		Assert.assertEquals(bestOneThousandLoan.getTotalAmount(), testLoan.getTotalAmount());
		Assert.assertEquals(bestOneThousandLoan, testLoan);
	}
	
	@Test
	public void findValidBestLoanForSevenHundredTest(){
		Loan testLoan = loanManager.findLoan("700");
		Assert.assertEquals(bestSevenHundredLoan.getTotalRate(), testLoan.getTotalRate(), 0.0f);
		Assert.assertEquals(bestSevenHundredLoan.getTotalAmount(), testLoan.getTotalAmount());
		Assert.assertEquals(bestSevenHundredLoan, testLoan);
	}

	@Test
	public void findValidBestLoanForFiveHundredTest(){
		Loan testLoan = loanManager.findLoan("500");
		Assert.assertEquals(bestFiveHundredLoan.getTotalRate(), testLoan.getTotalRate(), 0.0f);
		Assert.assertEquals(bestFiveHundredLoan.getTotalAmount(), testLoan.getTotalAmount());
		Assert.assertEquals(bestFiveHundredLoan, testLoan);
	}
	
	@Test
	public void findInvalidLoan(){
		Loan testLoan = loanManager.findLoan("5000");
		Assert.assertEquals(invalidLoan.getTotalRate(), testLoan.getTotalRate(), 0.0f);
		Assert.assertEquals(invalidLoan.getTotalAmount(), testLoan.getTotalAmount());
		Assert.assertEquals(invalidLoan.getLenders().size(), testLoan.getLenders().size());
	}
	
}
