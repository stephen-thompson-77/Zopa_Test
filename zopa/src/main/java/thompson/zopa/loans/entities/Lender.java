package thompson.zopa.loans.entities;

public class Lender {
	
	private String name;
	private float rate;
	private int amount;
	
	public Lender(){
	}
	
	public Lender(String name, float rate, int amount){
		this.name = name;
		this.rate = rate;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
