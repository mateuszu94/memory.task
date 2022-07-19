import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        while (true){

        System.out.println("Pres s to start,Press e to end");
        String se = scanner.nextLine();
        if (se.equals("e")) {
            System.out.println("closing game");
        break;}

            else if (se.equals("s")) {
                System.out.println("please select level difficulty pres e to sele ect eazy pres h to secect hard");
            String eh = scanner.nextLine();
           if (eh.equals("e")) {
               boardEasy myBoard = new boardEasy();
               myBoard.shuffleCards();
               myBoard.printFirstBoard();
               myBoard.printBoard();
               myBoard.checkInput();
           }else if(eh.equals("h")){boardHard myBoard = new boardHard();
               myBoard.shuffleCards();
               myBoard.printFirstBoard();
               myBoard.printBoard();
               myBoard.checkInput();}
        else{
            System.out.println("invalid character");
        }}
else{
        System.out.println("invalid character");}
}
        }}