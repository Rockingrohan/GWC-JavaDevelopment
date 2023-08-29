import java.util.Scanner;

public class TicTacToe {

    public static final char PLAYER_1 = 'X';
    public static final char PLAYER_2 = 'O';

    public static char[][] board = new char[3][3];
    public static int currentPlayer = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the board with dashes.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // Play the game until there is a winner or a tie.
        while (true) {
            // Display the board.
            printBoard();

            // Get the player's move.
            int row = -1, col = -1;
            do {
                System.out.print("Player " + (currentPlayer == 1 ? "1" : "2") + "'s move (row, col): ");
                row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!isValidMove(row, col));

            // Make the move.
            board[row][col] = (currentPlayer == 1 ? PLAYER_1 : PLAYER_2);

            // Check if the game is over.
            if (isWinner(row, col)) {
                // The current player wins.
                System.out.println("Player " + (currentPlayer == 1 ? "1" : "2") + " wins!");
                break;
            } else if (isFull()) {
                // The game is a tie.
                System.out.println("Tie!");
                break;
            }

            // Switch players.
            currentPlayer = currentPlayer == 1 ? 2 : 1;
        }
    }

    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    public static boolean isWinner(int row, int col) {
        // Check if the current player has three in a row.
        return (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != '-')
                || (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != '-')
                || (board[row][0] == board[1][1] && board[1][1] == board[2][2] && board[row][0] != '-')
                || (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-');
    }

    public static boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
