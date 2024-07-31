package board;

import java.util.Objects;

public class Board {
    private String[][] board;
    public void setBoard() {
        this.board = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    }

    public void makeMove(String symbol, String[] position) {
        int positionRow = Integer.parseInt(position[0]) - 1;
        int positionColumn = Integer.parseInt(position[1]) - 1;
        board[positionRow][positionColumn] = symbol;
    }

    public Boolean moveIsPossible(String[] position) {
        int positionRow = Integer.parseInt(position[0]) - 1;
        int positionColumn = Integer.parseInt(position[1]) - 1;
        return Objects.equals(board[positionRow][positionColumn], "X") || Objects.equals(board[positionRow][positionColumn], "O");
    }

    public Boolean checkWin(String symbol) {
        int countSymbolDiagonalFromStart = 0;
        int countSymbolDiagonalFromEnd = 0;
        for (int i = 0; i < board.length; i++) {
            int countSymbolRow = 0;
            int countSymbolColumn = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (Objects.equals(board[i][j], symbol)) {
                    countSymbolRow++;
                }
                if (Objects.equals(board[j][i], symbol)) {
                    countSymbolColumn++;
                }
            }
            if (Objects.equals(board[i][i], symbol)) {
                countSymbolDiagonalFromStart++;
            }

            if (Objects.equals(board[i][board.length - 1 - i], symbol)) {
                countSymbolDiagonalFromEnd++;
            }

            if (countSymbolRow == 3 || countSymbolColumn == 3) {
                return true;
            }
        }
        return countSymbolDiagonalFromStart == 3 || countSymbolDiagonalFromEnd == 3;
    }
    

    public void printBoard() {
        for (String[] strings : board) {
            System.out.println("-------------");
            for (String field : strings) {
                System.out.print("| ");
                System.out.print(field + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-------------");
    }
}
