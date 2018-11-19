package terning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception
    {
        Dice dice = new Dice(); //Make an instance of Dice.
        Scanner keyboard = new Scanner(System.in); //Make an instance of Scanner.

        String fileName = "./Texts/FieldTexts.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName)); //read from file


        String[] fieldTexts = new String[13]; //Declaration of fieldTexts array
        String lineContents = reader.readLine(); //
        int iterator = 0;
        while (lineContents != null) //fill fieldTexts array up with lines from textfile.
        {
            fieldTexts[iterator] = lineContents;

            lineContents = reader.readLine();
            iterator++;
        }

//        for (String fText: fieldTexts)
//        {
//            System.out.println(fText);
//        }

        System.out.println();
        System.out.println("--- Welcome to the DiceGame! ---");
        System.out.println();
        System.out.println("How many players are you?");
        System.out.print("Enter number of players: ");
        int playerCount = keyboard.nextInt(); //Read integer

        System.out.println();
        System.out.println("What are your names?");
        System.out.println("Enter name of players: ");

        Player[] thePlayers = new Player[playerCount]; //Declaration of 'thePlayers' array holding player objects.
        for (int i = 0; i < playerCount; i++) //For loop to create player objects for each player.
        {
            System.out.print("Player "+(i+1)+": ");
            Player player = new Player(keyboard.next(), 1000,0); //Creation of player object. Name entered by users, score default at 0.
            thePlayers[i] = player;
        }


        System.out.print("Players: ");
        int pIndex = 0;
        for (Player Player: thePlayers) //For each loop to print each name in playerNames array.
        {

            if (pIndex++ < thePlayers.length-1) //all players, but last
            {
                System.out.print(Player.getName() + ", "); //print all names seperated by ",", but last
            }
            else //prints last player
            {
                System.out.println(Player.getName() + "."); //print last name with "."
            }
        }


        //commented out, because dice sides are fixed atm.
        /*System.out.println();
        System.out.println();
        System.out.println("How many sides should the dice have?");
        System.out.print("Enter number of sides: ");
        int sides = keyboard.nextInt(); //Read integer*/



        System.out.println();
        System.out.println("What is the amount of points to win?");
        System.out.print("Enter amount of points: ");
        int winPoints = keyboard.nextInt(); //Read integer


        //creation of field objects
        Field field0 = new Field(0,"Village", 0);
        Field field1 = new Field(1,"Forest", -69);
        Field field2 = new Field(2,"Tower", 250);
        Field field3 = new Field(3,"Crater", -100);
        Field field4 = new Field(4,"Palace gates", 100);
        Field field5 = new Field(5,"Cold Desert", -20);
        Field field6 = new Field(6,"Walled city", 180);
        Field field7 = new Field(7,"Monastery", 0);
        Field field8 = new Field(8,"Black cave", -70);
        Field field9 = new Field(9,"Huts in the mountain", 60);
        Field field10 = new Field(10,"The Werewall", -80); //+ ekstra tur
        Field field11 = new Field(11,"The pit", -50);
        Field field12 = new Field(12,"Goldmine", 650);

        //creation of field object array, + assigning object elements
        Field[] board = new Field[13];
        board[0] = field0;
        board[1] = field1;
        board[2] = field2;
        board[3] = field3;
        board[4] = field4;
        board[5] = field5;
        board[6] = field6;
        board[7] = field7;
        board[8] = field8;
        board[9] = field9;
        board[10] = field10;
        board[11] = field11;
        board[12] = field12;



        System.out.println();
        boolean gameWon = false;
        int turnCount = 0;


        //main Game Logic
        do //rolls for each player, while no one has won.
        {

//            String turnShift = keyboard.nextLine();
//            if (turnShift.equals("Exit"))
//            {
//                break;
//            }
//            else {
            turnCount++;
            System.out.println("--- Turn " + turnCount + " ---");

            for (Player Player : thePlayers) //roll dice for each player, add to score, print roll and score
            {
                String turnShift = keyboard.nextLine();
                if (turnShift.equals("Exit"))
                {
                    break;
                }
                else {
                    int rollResult;
                    int preScore;
                    int postScore;
                    int fieldEffect;
                    int playerPos;
                    int prePos;
                    //playerplacement=(playerplacement+D1.roll()+D2.roll())%13;

                    do {
                        prePos = Player.getPosition();
                        preScore = Player.getScore();

                        rollResult = dice.roll(6) + dice.roll(6);

                        playerPos = (Player.getPosition()+rollResult)%13;
                        Player.setPosition(playerPos);

                        fieldEffect = board[playerPos].getFieldEffect();
                        postScore = preScore + fieldEffect;
                        Player.setScore(postScore);

                        if (Player.getScore() < 0) {
                            Player.setScore(0);
                        }


                        if (Player.getScore() < winPoints) //to determine if a player has under max amount of points.
                        {
                            gameWon = false;
                            System.out.println(fieldTexts[playerPos]);
                            System.out.println(Player.getName()+ " Stands on field: "+ prePos + ", rolls: " + rollResult + " and lands on field: "+ playerPos +" and has total score of: " + preScore + " + " + fieldEffect + " = " + Player.getScore()); //usual roll message
                            //System.out.println(fieldTexts[playerPos]);
                        } else //player won game, setting gameWon true and breaking out of loop. Therefore remaining players won't get to roll this turn.
                        {
                            gameWon = true;
                            System.out.println(fieldTexts[playerPos]);
                            System.out.println(Player.getName()+ " Stands on field:" + prePos + ", rolls: " + rollResult + " and wins with score of: " + preScore + " + " + fieldEffect + " = " + Player.getScore()); //if player won message
                            //System.out.println(fieldTexts[playerPos]);
                            break;
                        }

                    } while (board[playerPos].getFieldID() == 10);

                }
                if (gameWon == true) //player won game, setting gameWon true and breaking out of loop. Therefore remaining players won't get to roll this turn.
                    break;


            }
//            }

            System.out.println(); //blank line to seperate turns apart

        } while (gameWon == false); //while no one has won.



        System.out.println();
        System.out.println("Player won, end of game");
        keyboard.close();
    }
}
