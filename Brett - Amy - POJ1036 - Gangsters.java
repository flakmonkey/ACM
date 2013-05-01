package gangsters;

import java.util.*;

class Tree {
    private Gangster root;

    public Tree(Gangster root) {
        this.root = root;
        this.root.prosperity = 0;
        this.root.stoutness = 0;
        this.root.children = new ArrayList<Gangster>();
    }
    
    public void insert(Gangster child, Gangster parent) {
    	if(child.isReachable(parent)) {
    		parent.children.add(child);
    		child.parent = parent;
    	}
    }
    
}

class Gangster {
	public int time;
    public int stoutness;
    public int prosperity;
    public Gangster parent;
    public List<Gangster> children;
    
    public boolean isReachable(Gangster homie) {
    	int timeDif = homie.time - time;
    	if(timeDif >= homie.stoutness)
    		return true;
    	else
    		return false;
    }
}

class Gangsters {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Tree gangsterFamily = new Tree(new Gangster());
		ArrayList<Gangster> listGangsters = new ArrayList<Gangster>();
		
		int numbGangsters = scan.nextInt();
		int maxStoutness = scan.nextInt();
		int time = scan.nextInt();
		
		for(int i=0; i<numbGangsters; i++) {
			listGangsters.add(new Gangster());
			listGangsters.get(i).time = scan.nextInt();
		}
		for(int i=0; i<numbGangsters; i++) {
			listGangsters.get(i).prosperity = scan.nextInt();
		}
		for(int i=0; i<numbGangsters; i++) {
			listGangsters.get(i).stoutness = scan.nextInt();
		}
		
		
	}
}
