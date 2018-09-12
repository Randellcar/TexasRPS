import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;


public class Player{

        protected HashMap<String, Integer> deck = new HashMap<String, Integer>();
        protected ArrayList<String> hand = new ArrayList<String>();
        public Integer wins = new Integer(0); //Point system
        public int cardChoice;
        protected String currentCard;

        Scanner choice = new Scanner(System.in);
    protected int random(){
        //formula from https://www.mkyong.com/java/java-generate-random-integers-in-a-range/
        int randnum = (int)(Math.random() * ((3 - 1) + 1)) + 1;
        return randnum-1;
    }
    public void start() {
        //Draws three beginning cards, starting hand
        int card;
        //5 of each card in a single deck
        deck.put("Rock", 3);
        deck.put("Paper", 3);
        deck.put("Scissors", 3);
        for (int i = 0; i < 3; i++) {
            //Random number 1-3, if 1 draw Rock, if 2 draw Paper, if 3 draw Scissors
            card = random();
            switch (card) {
                //Add to hand, subtract from deck
                case 0:
                    card = 0;
                    hand.add("Rock");
                    deck.put("Rock", deck.get("Rock") - 1);
                    break;
                case 1:
                    card = 1;
                    hand.add("Paper");
                    deck.put("Paper", deck.get("Paper") - 1);
                    break;
                case 2:
                    card = 2;
                    hand.add("Scissors");
                    deck.put("Scissors", deck.get("Scissors") - 1);
                    break;
            }
        }
    }

    public void drawCard() {
        int randDraw;
        boolean drawSuccessful = false;
        while (!drawSuccessful){
            randDraw = random();
            switch (randDraw) {
                //Add to hand, subtract from deck
                //If statements to check if anymore instances of that card in deck
                case 0:
                    if (deck.get("Rock") != 0) {
                        hand.add(cardChoice,"Rock");
                        deck.put("Rock", deck.get("Rock") - 1);
                        drawSuccessful=true;
                    }
                    break;
                case 1:
                    if (deck.get("Paper") != 0) {
                        hand.add(cardChoice,"Paper");
                        deck.put("Paper", deck.get("Paper") - 1);
                        drawSuccessful=true;
                    }
                    break;
                case 2:
                    if (deck.get("Scissors") != 0) {
                        hand.add(cardChoice,"Scissors");
                        deck.put("Scissors", deck.get("Scissors") - 1);
                        drawSuccessful=true;
                    }
                    break;
                default:
                    drawSuccessful = false;
            }


        }
    }
    public void playerMove(){
        //Function to interpret player input and convert to choice from hand
        boolean withinRange = false;
        while(!withinRange) {
            Integer choice = playerInput();
            switch (choice) {
                case 1:
                    cardChoice = 0;
                    withinRange = true;
                    break;
                case 2:
                    cardChoice = 1;
                    withinRange = true;
                    break;
                case 3:
                    cardChoice = 2;
                    withinRange = true;
                    break;
                default:
                    System.out.println("Choice out of range.");
                    withinRange = false;
            }
        }
        currentCard=hand.get(cardChoice);   /*Plays card chosen, sets as current card*/
        hand.remove(cardChoice);            /*Once card is in play, it is removed from hand*/


    }
    public int playerInput(){
        //Simple function to take in player input
        int n;
        for(int i=0;i<3;i++){
            //Lists out content of hand Array
            System.out.print(hand.get(i)+" ");
        }
        System.out.println("\nChoose a card!");

        n= choice.nextInt();

        return n;
    }


}


