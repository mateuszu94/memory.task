import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class boardEasy {
    public static String[][] board = new String[2][4];
    public static String[][] cards = new String[2][4];
    public static Scanner scanner = new Scanner(System.in);

    // get a words
    public void printLevel() {
        System.out.println("                   level Easy      ");
    }

    //set the dimensions for the bord
    public void printFirstBoard() {
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 4; j++) {
                board[i][j] = "    _    ";
            }

    }

    // print a current board
    public void printBoard() {
        printLevel();
        for (int i = 0; i < 2; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < 4; i++) {
            int c = i + 1;
            System.out.print("     " + c +" "+"A"+"  ");
        }
        System.out.println(" ");
        for (int i = 0; i < 2; i++) {
            int r = i + 1;
            System.out.print("B" + r + " |");
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }
    //check if user pass the level
    public void playAgain(int guess) throws IOException {
        if (guess < 10) {
            System.out.println("you pass lvl easy ");
            System.out.println("Do u want to play again y/n ??");
            scanner.nextLine();
            String yn = scanner.nextLine();
            if (yn.equals("y")) {
                shuffleCards();
                printFirstBoard();
                printBoard();
                checkInput();
            } else if (yn.equals("n")) {
                System.exit(1);
            }
        } else {
            System.out.println("Sadly you are out of guesses");
            System.out.println("Do u want to play again y/n ??");
            scanner.nextLine();
            String yn = scanner.nextLine();
            if (yn.equals("y")) {
                shuffleCards();
                printFirstBoard();
                printBoard();
                checkInput();
            } else if (yn.equals("n")) {
                System.exit(1);
            }
        }
    }// pick 4 random words
 private static ArrayList<String> takeWords(ArrayList<String> list){
        ArrayList<String> result = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<4; i++){
            result.add(list.get(random.nextInt(list.size())));


        }
     return result;
 }
    //organizes the board
    public static void shuffleCards() throws IOException {
        Random random = new Random();
        BufferedReader bufReader = new BufferedReader(new FileReader("Words.txt"));
        ArrayList<String> listOfLines = new ArrayList<>();
        String line = bufReader.readLine();
        while (line != null){
        listOfLines.add(line);
        line = bufReader.readLine();
        } bufReader.close();
// clone words
        ArrayList<String> db = takeWords(listOfLines);
        ArrayList arrayListClone = (ArrayList)db.clone();
        db.addAll(arrayListClone);



        int index;
        for(int i=0; i<2; i++){
            for(int j=0; j<4; j++){
                index = random.nextInt(db.size());
                cards[i][j] = db.get(index);
                db.remove(index);
            }}}
// user input and check if valid time and guess
    public void checkInput() throws IOException {
        long start = System.nanoTime();
        int guess = 0;
        while(guess<10) {
            if (!gameOver()) {
                System.out.println("Row: (1-2)");
                int row1 = scanner.nextInt();

                if (row1 > 2) {
                    System.out.println("It hes to be 1-2");
                    System.out.println();
                    printBoard();
                    continue;
                }
                System.out.println("Column: (1-4)");
                int column1 = scanner.nextInt();

                if (column1 > 4) {
                    System.out.println("It has to be 1-4");
                    System.out.println();
                    printBoard();
                    continue;
                }
                if (!board[row1 - 1][column1 - 1].equals("    _    ")
                ) {
                    System.out.println("Already Entered");
                    System.out.println();

                    printBoard();
                    continue;
                } else {
                    board[row1 - 1][column1 - 1] = " " + cards
                            [row1 - 1][column1 - 1] + " ";
                    printBoard();
                }
                System.out.println("Row: (1-2)");
                int row2 = scanner.nextInt();

                if (row2 > 2) {
                    System.out.println("It hes to be 1-2");
                    System.out.println();
                    printBoard();
                    continue;
                }
                System.out.println("Column: (1-4)");
                int column2 = scanner.nextInt();

                if (column2 > 4) {
                    System.out.println("It hes to be 1=4");
                    System.out.println();
                    printBoard();
                    continue;
                }
                if (!board[row2 - 1][column2 - 1].equals("    _    ")
                ) {
                    System.out.println("Already Entered");
                    board[row1 - 1][column1 - 1] = "    _    ";
                    System.out.println();

                    printBoard();
                    continue;
                } else {
                    board[row2 - 1][column2 - 1] = " " + cards[row2 - 1][column2 - 1] + " ";
                    if (board[row1 - 1][column1 - 1].equals(board[row2 - 1][column2 - 1])) {
                        printBoard();
                        System.out.println("Correct!!");
                    } else {
                        printBoard();
                        System.out.println("False!");
                        board[row1 - 1][column1 - 1] = "    _    ";
                        board[row2 - 1][column2 - 1] = "    _    ";
                        printBoard();
                    }
                }
                guess++;
            } else {
                long finish = System.nanoTime();
                long timeElapsed = finish- start;
                System.out.println("You solved the memory game after " + guess + " chances. It took you "+timeElapsed/1000000000 +" seconds");
                break;
            }
        }
        playAgain(guess);
    }
    // check if game over
    public boolean gameOver(){
        for (int i =0; i<2; i++){
            for(int j = 0; j<4; j++){
                if(board[i][j].equals("    _    ")){
                    return false;
                }
            }
        }
        return true;
    }
}














