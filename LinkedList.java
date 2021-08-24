public class LinkedList implements List {
    
    private Node head;
    private Node last;
    private int size;
    
    // inner node class
    class Node {
        public Card card;
        public Node next;
        
        public Node() {
            card = null;
            next = null;
        }
        
        public Node(Card c) {
            card = c;
            next = null;
        }
        
        public Node(Card c, Node n) {
            card = c;
            next = n;
        }
    }
    
    
    
    LinkedList() {
        head = new Node();
        head.card = null;
        last = new Node();
        head.next = last;
        last.card = head.card;
        last.next = null;
    }
    
    
    /**
     * Adds the object x to the end of the list.
     * @param x the element to be added to this list
     * @return true
     */
    public boolean add(Card x) {
        Node holdNode = new Node();
        if (head.card == null) {
            head.card = x;
        } else {
            for (Node i = head; i.next != null ; i = i.next) {
                holdNode = i;
            }
            Node insertNode = new Node(x, last);
            holdNode.next = insertNode;
        }
        size++;
        return true;
    }
    
    /**
     * Adds the object x at the specified position
     * @param index the position to add the element
     * @param x the element to be added to the list
     * @return true if the operation succeeded, false otherwise
     * @throws IllegalArgumentException if index is invalid
     */
    public boolean add(int index, Card x) {
        Node holdNode = new Node();
        int indexTracker = 0;
        if (head.card == null || index > size - 1) {
            throw new IllegalArgumentException("invalid index: " + index);
        } else {
            for (Node i = head; i.next != null; i = i.next) {
                if (indexTracker == index - 1) {
                    holdNode = i;
                }
                if (indexTracker == index) {
                    Node insertNode = new Node(x, i);
                    holdNode.next = insertNode;
                    
                }
                indexTracker++;
            }
        }
        size++;
        return true;
    }
    
    /**
     * Returns the number of elements in this list
     * @return the number of elements in this list
     */
    public int size() {
        return size; 
    }
    
    /**
     * Returns the element with the specified position in this list
     * @param index the position of the element
     * @return the element at the specified position in this list
     * @throws IllegalArgumentException if index is invalid
     */
    public Card get(int index) {
        Node indexedNode = new Node();
        int indexTracker = 0;
        if (head.card == null || index > size - 1) {
            throw new IllegalArgumentException("invalid index: " + index);
        } else if (head.card != null) {
            for (Node i = head; i.next != null; i = i.next) {
                if (indexTracker == index) {
                    indexedNode = i;
                    break;
                }
                indexTracker++;
            }
        }
        return indexedNode.card; 
    }
    
    /**
     * Replaces the object at the specified position
     * @param index the position to replace
     * @param x the element to be stored
     * @return the previous value of the element at index
     * @throws IllegalArgumentException if index is invalid
     */
    public Card set(int index, Card x) {
        int indexTracker = 0;
        Node holdNode = new Node();
        Node removedNode = new Node();
        if (head.card == null || index > size - 1) {
            throw new IllegalArgumentException("invalid index: " + index);
        } else if (head.card != null) {
            for (Node i = head; i.next != null; i = i.next) {
                if (indexTracker == index - 1) {
                    holdNode = i;
                }
                if (indexTracker == index) {
                    if (indexTracker == 0) {
                        removedNode = new Node(i.card, i.next);
                        head = removedNode.next;
                        i.next = null;
                        i.card = null;
                        break;
                    } else {
                        removedNode = i;
                        Node insertNode = new Node(x, i.next);
                        holdNode.next = insertNode;
                        i.card = null;
                        i.next = null;
                        break;
                    }
                }
                indexTracker++;
            }
        }
        return removedNode.card;
    }
    
    
    /**
     * Removes the object at the specified position
     * @param index the position to remove
     * @return the object that was removed
     * @throws IllegalArgumentException if index is invalid
     */
    public Card remove(int index) {
        int indexTracker = 0;
        Node holdNode = new Node();
        Node removedNode = new Node();
        if (head.card == null || index > size - 1) {
            throw new IllegalArgumentException("invalid index: " + index);
        } else if (head.card != null) {
            for (Node i = head; i.next != null; i = i.next) {
                if (indexTracker == index - 1) {
                    holdNode = i;
                }
                if (indexTracker == index) {
                    if (indexTracker == 0) {
                        removedNode = new Node(i.card, i.next);
                        head = removedNode.next;
                        i.next = null;
                        i.card = null;
                        break;
                    } else {
                        removedNode = new Node(i.card, i.next);
                        holdNode.next = i.next;
                        i.next = null;
                        i.card = null;
                        break;
                    }
                }
                indexTracker++;
            }
        }
        size--;
        return removedNode.card;
    }
    
    /**
     * Tests if this list has no elements.
     * @return  <tt>true</tt> if this list has no elements;
     *          <tt>false</tt> otherwise.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false; 
        }
    }
    
    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param element element whose presence in this List is to be tested.
     * @return  <code>true</code> if the specified element is present;
     *  <code>false</code> otherwise.
     */
    public boolean contains(Card element) {
        for (Node i = head; i.next != null; i = i.next) {
            if (i.card == element) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns the index of the specified element
     *
     * @param element the element we're looking for
     * @return the index of the element in the list, or -1 if it is not contained within the list
     */
    public int indexOf(Card element) {
        int indexTracker = 0;
        for (Node i = head; i.next != null; i = i.next) {
            if (i.card == element) {
                return indexTracker;
            }
            indexTracker++;
        }
        return -1; 
    }
    
    
    
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        Card test = new Card(Card.ACE, Card.SPADES);
        l.add(test);
        l.add(new Card(2, Card.DIAMONDS));
        l.add(new Card(3, Card.HEARTS));
        l.add(new Card(4, Card.CLUBS));
        
        for (int i = 3; i >= 0; i--) {
            System.out.println(l.get(i));
        }    
    }   
    
}