package bean;

import java.util.Comparator;

public class ComparatorBySalevolume implements Comparator<Furniture> {

	@Override
	public int compare(Furniture o1, Furniture o2) {
		if(o1.getSalevolume()<o2.getSalevolume())
		    return -1;
		else if(o1.getSalevolume()>o2.getSalevolume())
			return 1;
		else
			return 0;
	}

}
