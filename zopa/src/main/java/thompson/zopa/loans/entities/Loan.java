package thompson.zopa.loans.entities;

import java.util.ArrayList;
import java.util.List;

public class Loan {
	
	private List<Lender> lenders;
	private float totalRate;
	private int totalAmount;
	
	public Loan(){
		this.lenders = new ArrayList<Lender>();
	}

	public Loan(List<Lender> lenders){
		this.lenders = lenders;
	}
	
	public List<Lender> getLenders() {
		return lenders;
	}
	public void setLenders(List<Lender> lenders) {
		this.lenders = lenders;
	}
	
	public float getTotalRate() {
		if(totalRate == 0.0f){
			for(Lender l : lenders){
				totalRate += l.getRate();
			}
		}
		return totalRate;
	}
	
	public int getTotalAmount() {
		if(totalAmount == 0){
			for(Lender l : lenders){
				totalAmount += l.getAmount();
			}
		}
		return totalAmount;
	}
}
