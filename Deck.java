
public class Deck {
    
    private LinkedList deck;
    
    public Deck() {
        deck = new LinkedList();
    }
    
    
    public void add(Card x) {
        deck.add(x);
    }
    
    public Card draw() {
        if (deck.isEmpty()) {
            return null;
        }
        return deck.remove(0);
    }
    
    public void fill() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++) {
                deck.add(new Card(j, i));
            }
        }
    }
    
    public boolean isEmpty() {
        return deck.isEmpty();
    }
    
    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            Card c = draw();
            int random = (int) (Math.random()*(deck.size()-2) + 1);
            deck.add(random, c);
        }
        Card end = deck.get(deck.size() - 1);
        deck.remove(deck.size()-1);
        int randomEnd = (int) (Math.random()*(deck.size()-2) + 1);
        deck.add(randomEnd, end);
    }
    
    public int size() {
        return deck.size();
    }
    
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.fill();
        deck.shuffle();
        deck.add(new Card(Card.ACE, Card.SPADES)); // add a duplicate ace of spades as the last card
        while(!deck.isEmpty()) {            
            System.out.println(deck.draw());
        }
    }
}