package thompson.zopa.loans.entities;

import java.util.Comparator;

public class RatingComparator implements Comparator<Lender> {

	public int compare(Lender l1, Lender l2) {
		return Float.compare(l1.getRating(), l2.getRating());
	}
}
