package thompson.zopa.loans.entities;

import java.util.Comparator;

public class AmountComparator implements Comparator<Lender> {

	public int compare(Lender l1, Lender l2) {
		return Integer.compare(l1.getAmount(), l2.getAmount());
	}
}
