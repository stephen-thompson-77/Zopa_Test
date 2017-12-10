package thompson.zopa.loans;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import thompson.zopa.loans.entities.Lender;
import thompson.zopa.loans.entities.Loan;
import thompson.zopa.loans.entities.RatingComparator;
import thompson.zopa.loans.files.FileManager;

public class LoanManager {
	
	private FileManager fileManager;
	private File file;
	private String INVALID_AMOUNT = "The amount requested was not in the correct form. "
			+ "Please check that the amount requested is a number between 100 and 15000 in intervals of 100.";
	
	public LoanManager(FileManager fileManager, File file){
		this.fileManager = fileManager;
		this.file = file;
	}
	
	public Loan findLoan(String amount){
		List<Lender> lenders = fileManager.readData(file);
		
		if(lenders == null || lenders.size() == 0){
			return null;
		}
		
		int amountInt;
		
		try {
			amountInt = Integer.valueOf(amount);
			findLoanValueWithRate(lenders, amountInt);
		} catch(NumberFormatException e){
			System.out.println(INVALID_AMOUNT);
			e.printStackTrace();
		}
		
		return null;
	}
	
	private void findLoanValueWithRate(List<Lender> lenders, int amount){
		
		//take list of lenders
		
		int totalAvailable = 0;
		
		for(Lender l : lenders){
			totalAvailable += l.getAmount();
		}
		//check to see if the total of lenders is enough to cover requested amount
			//if not print out so and return
		if(totalAvailable < amount){
			System.out.println("The amount requested is not available from our pool of lenders.");
			return;
		}
		
		//find best rate from combination of them
		
		//Sorts worst rate 0 to best list.size()
		lenders.sort(new RatingComparator());
		
		//go down the list to check if the amount is attainable through one lender
		
		Lender bestSingle = null;
		
		for(int i = lenders.size(); i >= 0; i--){
			System.out.println(lenders.get(i).toString());
		}
		
		Collections.reverse(lenders);
		
		for(Lender l : lenders){
			if(l.getAmount() > amount){
				bestSingle = l;
				break;
			}
		}
		
		if(bestSingle == null){
			
		} else {
			
		}
		
		String temp;
		
			//if amount is within largest and lowest lenders amounts
				//sort valid lenders list by rate
				//look at one with the best rate
			//check to see if lowest rates available (not nescessarily with the requested amount)
				//if the combination of the two rates beats the single rate of the origional lender
				//check to see if a rate and amount is available using a combination of lenders
		
	}
	
	private void printResult(List<Lender> lenders){
		
		if(lenders.size() == 0){
			return;
		}
		
	}
	
}
