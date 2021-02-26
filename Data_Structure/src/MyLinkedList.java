
public class MyLinkedList<K> {

	public INode<K> head;
	public INode<K> tail;

	
	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}


	public void add(INode<K> newNode) {
		if (this.tail == null) {
			this.tail = newNode;
		}
		if (this.head == null) {
			this.head = newNode;
		} else {
			INode<K> tempNode = this.head;
			this.head = newNode;
			this.head.setNext(tempNode);
		}
	}


	public void append(INode<K> myNode) {
		if (this.head == null) {
			this.head = myNode;
		}
		if (this.tail == null) {
			this.tail = myNode;
		} else {
			this.tail.setNext(myNode);
			this.tail = myNode;
		}
	}


	public void insert(INode<K> myNode, INode<K> newNode) {
		INode<K> tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}


	public INode<K> pop() {
		INode<K> tempNode = this.head;
		this.head = head.getNext();
		return tempNode;
	}

	
	public INode<K> search(K key) {
		INode<K> tempNode = head;
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().equals(key)) {
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		return null;
	}


	public void printMyNode() {
		StringBuffer myNodes = new StringBuffer("My Nodes: ");
		INode<K> tempNode = head;
		while (tempNode.getNext() != null) {
			myNodes.append(tempNode.getKey());
			if (!tempNode.equals(tail))
				myNodes.append("->");
			tempNode = tempNode.getNext();
		}
		myNodes.append(tempNode.getKey());
		System.out.println(myNodes);
	}

	@Override
	public String toString() {
		return "MyLinkedListNodes{" + head + '}';
	}
}