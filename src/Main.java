import java.util.*;
import board.Board;


public class Main {
    public static void main(String[] args) {
        HashMap<Boolean, String> possibleSymbol = new HashMap<>();
        boolean symbolTurn = true;
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        int countMoves = 0;
        possibleSymbol.put(true, "X");
        possibleSymbol.put(false, "O");
        board.setBoard();
        System.out.println("This is Tic-Tac-Toe game.\nInstruction:\n1. First move is for X\n2. When game started enter position like '1 2'\n3. When you want end the game during game enter 'end'");
        while (true) {
            if (board.checkWin(possibleSymbol.get(!symbolTurn))) {
                System.out.println(possibleSymbol.get(!symbolTurn) + " win");
                break;
            }

            if (countMoves == 9) {
                System.out.println("It is draw");
                break;
            }

            String newPosition = scanner.nextLine();

            if (Objects.equals(newPosition, "end")) {
                break;
            }

            if (!newPosition.matches("[1-3] [1-3]")) {
                System.out.println("You entered wrong symbol coordinates, do it again");
                continue;
            }

            String[] position = newPosition.split(" ");

            if (board.moveIsPossible(position)) {
                System.out.println("You entered used coordinates, do it again");
                continue;
            }

            board.makeMove(possibleSymbol.get(symbolTurn), position);
            countMoves++;
            board.printBoard();
            symbolTurn = !symbolTurn;
        }
    }
}