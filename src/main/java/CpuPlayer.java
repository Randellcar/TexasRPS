import java.util.ArrayList;
import java.util.HashMap;

public class CpuPlayer extends Player{

    public Integer cpuMove(){
        Integer choice;
        boolean stratFlag = false;

        //---Opponent card analysis algorithm here---//

        //---Opponent card analysis algorithm here---//

        if(!stratFlag){
            //  Random algorithm for choosing card in cpu hand if there are no advantages
            choice=random();
        }
        else{
            choice =1;
        }

        switch (choice) {
            case 0:
                cardChoice = 0;
                break;
            case 1:
                cardChoice = 1;
                break;
            case 2:
                cardChoice = 2;
                break;
            default:
                System.out.println("Choice out of range.");
        }
        currentCard=hand.get(cardChoice);
        hand.remove(choice);
        return choice;
    }
}
