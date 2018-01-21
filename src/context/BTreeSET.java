package context;

public class BTreeSET<Key extends Comparable<Key>> {

	private Page root = new Page(true);
	
	public BTreeSET(Key sentinel) {
		add(root, sentinel);
	}
	
	public boolean contains(Key key) {
		return contains(root, key);
	}
	
	public boolean contains(Page h, Key key) {
		if (h.isExternal()) {
			return h.contains(key);
		}
		return contains(h.next(key), key);
	}
	
	public void add(Key key) {
		add(root, key);
		if (root.isFull()) {
			Page lefthalf = root;
			Page righthalf = root.split();
			root = new Page(false);
			root.add(lefthalf);
			root.add(righthalf);
		}
	}
	
	public void add(Page h, Key key) {
		if (h.isExternal()) {
			h.add(key);
			return ;
		}
		Page next = h.next(key);
		add(next, key);
		if (next.isFull()) {
			h.add(next.split());
		}
		next.close();
	}
	
	private class Page<Key> {
		//create and open a page
		public Page(boolean bottom) {
		}
		//close a page
		public void close() {
		}
		//put key into the (external) page
		public void add(Key key) {
		}
		//open p and put an entry into this (internal) page
		//that associates the smallest key in p with p
		public void add(Page p) {
		}
		//is this page external
		public boolean isExternal() {
			return false;
		}
		//is key in ths page?
		public boolean contains(Key key) {
			return false;
		}
		//the subtree that could contain the key
		public Page next(Key key) {
			return null;
		}
		
		//has the page overflowed?
		public boolean isFull() {
			return false;
		}
		//move the highest-ranking half of the keys in the page to a new page
		public Page split() {
			return null;
		}
	}
}
