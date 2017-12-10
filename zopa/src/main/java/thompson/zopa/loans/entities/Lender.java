package thompson.zopa.loans.entities;

public class Lender {
	
	private String name;
	private float rate;
	private int amount;
	private float rating;
	
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
	
	public float getRating(){
		if(this.rating == 0.0f){
			this.rating = amount / (rate * 100);
		}
		return this.rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(rate);
		result = prime * result + Float.floatToIntBits(rating);
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
		Lender other = (Lender) obj;
		if (amount != other.amount) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (Float.floatToIntBits(rate) != Float.floatToIntBits(other.rate)) {
			return false;
		}
		if (Float.floatToIntBits(rating) != Float.floatToIntBits(other.rating)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Lender [name=" + getName() + ", rate=" + getRate() + ", amount=" + getAmount() + ", rating=" + getRating() + "]";
	}
}
