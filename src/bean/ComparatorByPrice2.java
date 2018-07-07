package bean;

import java.util.Comparator;

public class ComparatorByPrice2 implements Comparator<Furniture> {

	@Override
	public int compare(Furniture o1, Furniture o2) {
		if(o1.getPrice()<o2.getPrice())
		    return 1;
		else if(o1.getPrice()>o2.getPrice())
			return -1;
		else
			return 0;
	}

}
