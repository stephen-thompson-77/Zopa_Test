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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lenders == null) ? 0 : lenders.hashCode());
		result = prime * result + totalAmount;
		result = prime * result + Float.floatToIntBits(totalRate);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Loan other = (Loan) obj;
		if (lenders == null) {
			if (other.lenders != null) {
				return false;
			}
		} else if (!lenders.equals(other.lenders)) {
			return false;
		}
		if (totalAmount != other.totalAmount) {
			return false;
		}
		if (Float.floatToIntBits(totalRate) != Float.floatToIntBits(other.totalRate)) {
			return false;
		}
		return true;
	}
	
	
}
