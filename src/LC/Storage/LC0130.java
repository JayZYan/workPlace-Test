package LC;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC0130 {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        if (rows == 1 || cols == 1) {
            return;
        }

        for (int i = 0; i < cols - 1; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'Y';
                BFS(board, 0, i);
            }
        }
        for (int j = 0; j < rows - 1; j++) {
            if (board[j][cols - 1] == 'O') {
                board[j][cols - 1] = 'Y';
                BFS(board, j, cols - 1);
            }
        }
        for (int i = cols - 1; i > 0; i-- ) {
            if (board[rows - 1][i] == 'O') {
                board[rows - 1][i] = 'Y';
                BFS(board, rows - 1, i);
            }
        }
        for (int j = rows - 1; j > 0; j--) {
            if (board[j][0] == 'O') {
                board[j][0] = 'Y';
                BFS(board, j, 0);
            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private static void BFS(char[][] board, int i, int j) {
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int rows = board.length;
        int cols = board[0].length;
        int[] head = {i,j};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(head);

        while(!queue.isEmpty()) {
            int[] curHead = queue.poll();
            for (int[] dir : directions) {
                int newI = curHead[0] + dir[0];
                int newJ = curHead[1] + dir[1];
                if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && board[newI][newJ] == 'O') {
                    board[newI][newJ] = 'Y';
                    int[] newHead = {newI, newJ};
                    queue.add(newHead);
                }
            }
        }
    }
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        for (char[] path : board) {
            System.out.println(Arrays.toString(path));
        }
    }
}
