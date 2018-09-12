
public class Gameplay{

    public void compareCards(String player, String computer, Player humanPlayer, CpuPlayer cpuPlayer){
        //Utilize if statements to compare human move and player move

        /*Rock beats Scissors
        * Paper beats Rock
        * Scissors beats Paper
        * Same cards is a tie
        * */

        System.out.println("Player chose "+humanPlayer.currentCard+"! Cpu chose "+cpuPlayer.currentCard+"!");
        if(player=="Rock" && computer=="Rock"){
            //tie function
            tie(humanPlayer, cpuPlayer);
        }
        else if(player=="Rock" && computer=="Paper"){
            cpuPlayer.wins+=1;
            System.out.println("Cpu wins!");
            bothDraw(humanPlayer, cpuPlayer);
        }
        else if(player=="Rock" && computer=="Scissors"){
            humanPlayer.wins+=1;
            System.out.println("Player wins!");
            bothDraw(humanPlayer, cpuPlayer);
        }
        else if(player=="Paper" && computer=="Rock"){
            humanPlayer.wins+=1;
            System.out.println("Player wins!");
            bothDraw(humanPlayer, cpuPlayer);
        }
        else if(player=="Paper" && computer=="Paper"){
            //tie function
            tie(humanPlayer, cpuPlayer);
        }
        else if(player=="Paper" && computer=="Scissors"){
            cpuPlayer.wins+=1;
            System.out.println("Cpu wins!");
            bothDraw(humanPlayer, cpuPlayer);
        }
        else if(player=="Scissors" && computer=="Rock"){
            cpuPlayer.wins+=1;
            System.out.println("Cpu wins!");
            bothDraw(humanPlayer, cpuPlayer);
        }
        else if(player=="Scissors" && computer=="Paper"){
            humanPlayer.wins+=1;
            System.out.println("Player wins!");
            bothDraw(humanPlayer, cpuPlayer);
        }
        else if(player=="Scissors" && computer=="Scissors"){
            //tie function
            tie(humanPlayer, cpuPlayer);
        }
    }
    private void bothDraw(Player humanPlayer, CpuPlayer cpuPlayer){
        // Simple function that calls drawCard function for both human and cpu
        humanPlayer.drawCard();
        cpuPlayer.drawCard();
    }
    private void tie(Player humanPlayer, CpuPlayer cpuPlayer){
        // In the case of a tie, the card played by both human and cpu is discarded.
        // Both draw again and play another card.
        System.out.println("Tie! Choose another card!");
        bothDraw(humanPlayer, cpuPlayer);
        humanPlayer.playerMove();
        cpuPlayer.cpuMove();
        compareCards(humanPlayer.currentCard, cpuPlayer.currentCard, humanPlayer, cpuPlayer);
    }
    private void cardShop(){
        // Win points is in game currency. Can be used to purchase random card or specific card.
        // 1pt : random
        // 2pt : specific card
    }

    public void game(){
        //Main control of the TexasRPS game
        Player player = new Player();       //Created Player object
        CpuPlayer cpu = new CpuPlayer();    //Created Cpu object
        //Starting hand, draw 3 from own deck
        player.start();
        cpu.start();

        for(int i=0;i<3;i++){       //Set at best of 3
            player.playerMove();    //Player chooses
            cpu.cpuMove();          //Cpu chooses
            compareCards(player.currentCard, cpu.currentCard, player, cpu);
            //System.out.println("Rock: "+player.deck.get("Rock"));
            //System.out.println("Paper: "+player.deck.get("Paper"));
            //System.out.println("Scissors: " +player.deck.get("Scissors"));
        }
        //Print out wins on each side
        System.out.println("Player wins: "+player.wins+"\tCpu wins: "+cpu.wins);

    }
}
