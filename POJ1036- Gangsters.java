package probs;

import java.util.*;

class Tree {
	public Gangster root;
	ArrayDeque<Gangster> traversalStack = new ArrayDeque<Gangster>(); //which path are you on now
	ArrayList<Integer> prosperity = new ArrayList<Integer>();
	int[] prevSums; //keeps track of best path prosperity for each gangster
	int maxP;

	public Tree(Gangster root, int numbGangsters) {
		this.root = root;
		this.root.prosperity = 0;
		this.root.ndxInInputList = -1;
		this.root.stoutness = 0;
		this.root.children = new ArrayList<Gangster>();
		prevSums = new int[numbGangsters];
		maxP = 0;
	}

	public Gangster insert(Gangster child, Gangster parent) {
		Gangster newGang = new Gangster(); //so we don't use gangsters in arraylist... we're making a copy
		newGang.time = child.time;
		newGang.ndxInInputList = child.ndxInInputList;
		newGang.prosperity = child.prosperity;
		newGang.stoutness = child.stoutness;
		if (child.isReachable(parent)) {
			parent.children.add(newGang);
			parent.visited = true;
			traversalStack.push(parent);
			prevPathMax(child);
			newGang.parent = parent;
			return newGang;
		} else {
			if (parent.ndxInInputList == -1) //if it's the root (has no parent)... you can never reach that gangster
				return parent;
			if (child.isReachable(parent.parent)) {
				if(prevPathMax(child)) { //check if you want to make another branch. Only make it if it might make a larger prosperity(makes runtime shorter)
					parent.parent.children.add(newGang);
					newGang.parent = parent.parent;
					return parent;
				}
			}
		}
		return parent;
	}


	//sums up new prosperity. Also returns true if it's larger.
	private boolean prevPathMax(Gangster child) {
		int curPrevSum = 0;
		//sum prosperity of path already traversed + new one to add
		Iterator<Gangster> iterator = traversalStack.iterator();
		while(iterator.hasNext())
			curPrevSum += iterator.next().prosperity;
		curPrevSum += child.prosperity;
		if (curPrevSum > prevSums[child.ndxInInputList]) {
			prevSums[child.ndxInInputList] = curPrevSum;
			return true;
		}
		return false;
	}

	//for going to the next unvisited node
	public Gangster traverse() {
		Gangster newGang = null, parent;
		while (!traversalStack.isEmpty() & newGang == null) {
			parent = traversalStack.pop();
			for (int i = 0; i < parent.children.size(); i++) {
				if (!parent.children.get(i).visited) {//find a child who isn't visited
					newGang = parent.children.get(i);
					newGang.visited = true;
					traversalStack.push(parent);
					break;
				}
			}
		}
		return newGang;
	}

	public int returnBestPath() {
		int maxP = 0;
		
		for (int i = 0; i < prevSums.length; i++) {
			if (prevSums[i] > maxP)
				maxP = prevSums[i];
		}
		return maxP;
	}

//	//go thru all paths and find largest prosperity
//	public int sumTraversal(Gangster curGang) {
//		int sumP = 0;
//		prosperity.add(curGang.prosperity);
//		if (curGang.children.isEmpty()) { //you're done with a path
//			for (int i = 0; i < prosperity.size(); i++) {
//				sumP += prosperity.get(i);
//			}
//			prosperity.remove(prosperity.size() - 1);
//			if (sumP > maxP)
//				maxP = sumP;
//		} else {
//			for (int i = 0; i < curGang.children.size(); i++) {
//				sumTraversal(curGang.children.get(i)); //go down paths of each child
//			}
//			if (!prosperity.isEmpty())
//				prosperity.remove(prosperity.size() - 1);
//		}
//		return maxP;
//	}

}

class Gangster {
	public int time;
	public int maxPrevSum;
	public int stoutness;
	public int prosperity;
	public int ndxInInputList;
	public boolean visited;
	public Gangster parent;
	public List<Gangster> children = new ArrayList<Gangster>();;

	public boolean isReachable(Gangster homie) {
		int timeDif = Math.abs(homie.time - time);
		int stoutDiff = Math.abs(homie.stoutness - stoutness);
		if (timeDif >= stoutDiff)
			return true;
		else
			return false;
	}
}

class p1036 {

	public static void main(String[] args) {
		Gangster curGang, tempGang;
		int maxP;
		boolean notdone = true;
		Scanner scan = new Scanner(System.in);

		
		ArrayList<Gangster> listGangsters = new ArrayList<Gangster>();

		int numbGangsters = scan.nextInt();
		int maxStoutness = scan.nextInt();
		int time = scan.nextInt();
		
		Tree gangsterFamily = new Tree(new Gangster(), numbGangsters);

		for (int i = 0; i < numbGangsters; i++) {
			listGangsters.add(new Gangster());
			listGangsters.get(i).time = scan.nextInt();
		}
		for (int i = 0; i < numbGangsters; i++) {
			listGangsters.get(i).prosperity = scan.nextInt();
		}
		for (int i = 0; i < numbGangsters; i++) {
			listGangsters.get(i).stoutness = scan.nextInt();
		}

		//sort the gangsters by time
		for (int i = 1; i < listGangsters.size(); i++) {
			for (int j = 0; j < listGangsters.size(); j++)
				if (listGangsters.get(i).time <= listGangsters.get(j).time) {
					tempGang = listGangsters.get(i);
					listGangsters.remove(i);
					listGangsters.add(j, tempGang);
				}
		}

		for (int i = 0; i < listGangsters.size(); i++) {
			listGangsters.get(i).ndxInInputList = i;
		}

		//put 'em in a tree
		curGang = gangsterFamily.root;
		while (notdone) {
			for (int i = curGang.ndxInInputList + 1; i < listGangsters.size(); i++) {
				tempGang = listGangsters.get(i);
				curGang = gangsterFamily.insert(tempGang, curGang);
			}
			//traverse tree to another unvisited node and finish it's path. If no unvisited, we're done!
			curGang = gangsterFamily.traverse();
			if (curGang == null)
				notdone = false;
		}

		
//		maxP = gangsterFamily.sumTraversal(gangsterFamily.root);
		maxP = gangsterFamily.returnBestPath();
		System.out.println(maxP);
	}
}
