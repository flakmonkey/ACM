package tshirtsizedistribution;

/**
 * @author flak
 */
public class TShirtOrder {
	private int[] prevOrder;
	private int projAttend;
	private int[] newOrder;
	
	public TShirtOrder(int[] input) {
		//translate input to previousOrder array
		prevOrder = prevOrderSubArray(input);
		projAttend = input[7];
		//use previousOrder to find new order
		newOrder = calcNewOrder(prevOrder, projAttend);
	}
	
	public void printOrder() {
		for(int i : newOrder)
			System.out.print(i + " ");
		System.out.println();
	}
	
	private int[] prevOrderSubArray(int[] input) {
		int[] result = new int[7];
		for(int i=0; i<7; i++)
			result[i] = input[i];
		return result;
	}
	
	private int[] calcNewOrder(int[] prevOrder, int projAttend) {
		int[] newOrder = new int[8];
		int s;
		newOrder = projFormula(prevOrder, projAttend);
		s = projAttend - sumArray(newOrder);
		if(s > 0) {
			while(hasEmpty(newOrder))
				fillEmpty(newOrder);
		}
		while(s > 0) {
			newOrder = addXL(newOrder);
                        s = projAttend - sumArray(newOrder);
                }
		return newOrder;
	}
	
	private int[] projFormula(int[] prevOrder, int projAttend) {
		int[] result = new int[7];
		int sum = sumArray(prevOrder);
		for(int i=0; i<prevOrder.length; i++)
			result[i] = (projAttend*prevOrder[i])/sum;
		return result;
	}
	
	private int[] fillEmpty(int[] newOrder) {
		if(hasEmpty(newOrder)) {
			int empty = firstEmpty(newOrder);
			newOrder[empty] += 1;
		}
		return newOrder;
	}
	
	private int[] addXL(int[] order) {
		order[4] += 1;
		return order;
	}
	
	private boolean hasEmpty(int[] order) {
		boolean empty = false;
		if(firstEmpty(order) >= 0)
			empty = true;
		return empty;
	}
	
	private int firstEmpty(int[] order) {
		int empty = -1;
		for(int i=0; i<order.length; i++) {
			if(order[i] == 0) {
				empty = i;
				break;
			}
		}
		return empty;
	}
	
	private int sumArray(int[] order) {
		int sum = 0;
		for(int i : order)
			sum += i;
		return sum;
	}
	
	
}