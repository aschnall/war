
public class WarGame {
    
    private Deck myDeck;
    private Deck cpuDeck;
    private Deck fullDeck;
    private Deck warDeck; //pot where we put the cards if there is a war
    private static boolean play = true;
    
    
    public static void main(String[] args) {
        Deck fullDeck = new Deck();
        Deck myDeck = new Deck();
        Deck cpuDeck = new Deck();
        Deck warDeck = new Deck();
        fullDeck.fill();
        fullDeck.shuffle();
        for (int i = 0; i < 26; i++) {
            myDeck.add(fullDeck.draw());
        }
        cpuDeck = fullDeck;
        System.out.println("It's a war of cards!");
        System.out.println("Deck sizes: " + myDeck.size() + " (yours) " + "v.s. " + cpuDeck.size() + " (computer's)");
        System.out.println("Press 'ENTER' to fight another battle or 'S' to shuffle your deck!");
        while (play) {
            if (StdDraw.hasNextKeyTyped()) {
                System.out.println("Press 'ENTER' to fight another battle or 'S' to shuffle your deck!");
                char key = StdDraw.nextKeyTyped();
                if (key == '\n') {
                    Card myDrawnCard = myDeck.draw();
                    Card cpuDrawnCard = cpuDeck.draw();
                    System.out.println("You drew a " + myDrawnCard);
                    System.out.println("The computer drew a " + cpuDrawnCard);
                    if (myDrawnCard.getRank() > cpuDrawnCard.getRank()) {
                        myDeck.add(myDrawnCard);
                        myDeck.add(cpuDrawnCard);
                        System.out.println("You won 2 cards! Deck sizes: " + myDeck.size() + " (yours)" + " v.s. " + cpuDeck.size() + " (computer's)");
                        System.out.println();
                        System.out.println("Press 'ENTER' to fight another battle or 'S' to shuffle your deck!");
                    } else if (cpuDrawnCard.getRank() > myDrawnCard.getRank()) {
                        cpuDeck.add(myDrawnCard);
                        cpuDeck.add(cpuDrawnCard);
                        System.out.println("The computer won 2 cards! Deck sizes: " + myDeck.size() + " (yours)" + " v.s. " + cpuDeck.size() + " (computer's)");
                        System.out.println();
                        System.out.println("Press 'ENTER' to fight another battle or 'S' to shuffle your deck!");
                    } else if (cpuDrawnCard.getRank() == myDrawnCard.getRank()) {
                        System.out.println("It's a tie! Battle again!");
                        System.out.println("You and the computer each lay down 3 cards");
                        warDeck.add(cpuDrawnCard);
                        warDeck.add(myDrawnCard);
                        for (int i = 0; i < 3; i++) {
                            warDeck.add(myDeck.draw());
                            warDeck.add(cpuDeck.draw());
                        }
                        cpuDrawnCard = cpuDeck.draw();
                        myDrawnCard = myDeck.draw();
                        System.out.println("You drew a " + myDrawnCard);
                        System.out.println("The computer drew a " + cpuDrawnCard);
                        if (myDrawnCard.getRank() > cpuDrawnCard.getRank()) {
                            myDeck.add(myDrawnCard);
                            myDeck.add(cpuDrawnCard);
                            for (int j = 0; j < 8; j++) {
                                myDeck.add(warDeck.draw());
                            }
                            System.out.println("You won 10 cards! Deck sizes: " + myDeck.size() + " (yours)" + " v.s. " + cpuDeck.size() + " (computer's)");
                        } else if (cpuDrawnCard.getRank() > myDrawnCard.getRank()) {
                            cpuDeck.add(myDrawnCard);
                            cpuDeck.add(cpuDrawnCard);
                            for (int k = 0; k < 8; k++) {
                                cpuDeck.add(warDeck.draw());
                            }
                            System.out.println("The computer won 10 cards! Deck sizes: " + myDeck.size() + " (yours)" + " v.s. " + cpuDeck.size() + " (computer's)");
                        }
                        System.out.println();
                        System.out.println("Press 'ENTER' to fight another battle or 'S' to shuffle your deck!");
                    }
                }
                if (key == 's') {
                    myDeck.shuffle();
                    System.out.println("Your deck has been shuffled");
                    System.out.println();
                    System.out.println("Press 'ENTER' to fight another battle or 'S' to shuffle your deck!");
                }
            }
        }
        
    }
}