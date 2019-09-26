
/**
 * Write a description of class BattleShip here.
 * 
 * @author (John Opeyemi) 
 * @date(September 15th, 2019)
 */
import java.util.*;

public class BattleShip {
    static int hitcounter = 0;
    static int playerHit1, playerHit2 = 0;
    public static void main (String [] args)
    {
        String[][] board = new String[10][10];
        createBoard(board);
        showBoard(board);
        createShip(board);
        playerTurn(board);
        showBoard(board);
    }

    //Method to create the board 10 x 10
    public static void createBoard(String[][] board)
    {
        for (int row = 0; row < board.length; row++)
        {
            for (int cols = 0; cols < board[0].length; cols++)
            {
                board[row][cols] = "-";
                //System.out.print(" "+ board[row][cols]);
            }
            //System.out.println();

        }
    }

    //Displays the empty board
    public static void showBoard(String[][] board)
    {
        for (int row = 0; row < board.length; row++)
        {
            for (int cols = 0; cols < board[0].length; cols++)
            {
                System.out.print(" "+ board[row][cols]);
            }
            System.out.println();
        }
        
    }

    //Method to create the ships
    public static void createShip(String[][]board)
    {
        //Carrier Ship
        final boolean SHIP = true;
        if(SHIP)
        {
            int col = (int) (Math.random()*4);
            System.out.println("Col position:  "+col);
            int row = (int) (Math.random()*9);
            for (int i = 0; i < 5; i++)
            {
                board[row][col + i] = "C";
            }
        }
        else
        {
            int col = (int) (Math.random()*9);
            int row = (int) (Math.random()*4);
            System.out.println("Row position:  "+row);
            for (int i = 0; i < 5; i++)
            {
                board[row+i][col] = "C";
            }
        }

        //BattleShip
        if(SHIP)
        {
            int col = (int) (Math.random()*4);
            System.out.println("Col position:  "+col);
            int row = (int) (Math.random()*9);
            for (int i = 0; i < 4; i++)
            {
                board[row][col + i] = "B";
            }
        }
        else
        {
            int col = (int) (Math.random()*9);
            int row = (int) (Math.random()*4);
            System.out.println("Row position:  "+row);
            for (int i = 0; i < 4; i++)
            {
                board[row+i][col] = "B";
            }
        }

        //Submarine Ship
        if(SHIP)
        {
            int col = (int) (Math.random()*4);
            System.out.println("Col position:  "+col);
            int row = (int) (Math.random()*9);
            for (int i = 0; i < 3; i++)
            {
                board[row][col + i] = "M";
            }
        }
        else
        {
            int col = (int) (Math.random()*9);
            int row = (int) (Math.random()*4);
            System.out.println("Row position:  "+row);
            for (int i = 0; i < 3; i++)
            {
                board[row+i][col] = "M";
            }
        }

        //Cruiser
        if(SHIP)
        {
            int col = (int) (Math.random()*4);
            System.out.println("Col position:  "+col);
            int row = (int) (Math.random()*9);
            for (int i = 0; i < 2; i++)
            {
                board[row][col + i] = "R";
            }
        }
        else
        {
            int col = (int) (Math.random()*9);
            int row = (int) (Math.random()*4);
            System.out.println("Row position:  "+row);
            for (int i = 0; i < 2; i++)
            {
                board[row+i][col] = "R";
            }
        }

        //Patrol

        if(SHIP)
        {
            int col = (int) (Math.random()*4);
            System.out.println("Col position:  "+col);
            int row = (int) (Math.random()*9);
            for (int i = 0; i < 4; i++)
            {
                board[row][col + i] = "P";
            }
        }
        else
        {
            int col = (int) (Math.random()*9);
            int row = (int) (Math.random()*4);
            System.out.println("Row position:  "+row);
            for (int i = 0; i < 4; i++)
            {
                board[row+i][col] = "P";
            }
        }
    }

    //Method to check if the player hits a ship or missed
    public static void playBattle(String[][] board)
    {
        int row, col;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the row to fire: ");
        row = scanner.nextInt();
        while (row > 9 || row < 0)
        {
            System.out.println("Select between [0-9]");
            row = scanner.nextInt();

        }
        System.out.println("Select the column to fire: ");
        col = scanner.nextInt();
        while (col > 9 || col < 0)
        {
            System.out.print("Select between [0-9]");
            col = scanner.nextInt();
        }
        if(board[row][col].equalsIgnoreCase("S")||
        (board[row][col].equalsIgnoreCase("C")) ||
        (board[row][col].equalsIgnoreCase("M")) ||
        (board[row][col].equalsIgnoreCase("P")) ||
        (board[row][col].equalsIgnoreCase("R")))
        {
            System.out.println("You HIT a SHIP!!");
            board[row][col] = "H";
            hitcounter++;
        }
        else
        {
            System.out.println("You MISSED!!");
            board[row][col] = "+";
        }
    }

    //Keeping track of player turn
    public static void playerTurn(String[][]board)
    {
        while(hitcounter < 5)
        {
            System.out.println("Get Ready PLAYERS");
            System.out.println("Your turn player 1 ------>");
            playBattle(board);
            showBoard(board);
            if(hitcounter >= 3)
            {
                System.out.println("Player 1 Wins");
                System.out.println("Number of Hits: " + hitcounter);
                System.exit(0);
            }
            //playerHit1 = hitcounter;

            System.out.println("Your turn player 2 ------>");
            playBattle(board);
            showBoard(board);
            if(hitcounter >= 3)
            {
                System.out.println("Player 2 Wins. Number of HITS:" + hitcounter);
                System.out.println("Number of Hits: " + hitcounter);
                System.exit(0);
            }
        }

    }

    
}

