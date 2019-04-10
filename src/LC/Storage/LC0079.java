package LC;

//time: O(m*n*(4^k))
public class LC0079 {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(dfs(board, word, i, j, 0, visited)){     //find the first char of the word
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean dfs(char[][] board, String word, int i, int j, int idx, boolean[][] visited){
        int rows = board.length;
        int cols = board[0].length;
        if(idx == word.length()){
            return true;
        }
        if(i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != word.charAt(idx) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if(dfs(board, word, i - 1, j, idx + 1, visited)){
            return true;
        }
        if(dfs(board, word, i + 1, j, idx + 1, visited)){
            return true;
        }
        if(dfs(board, word, i, j - 1, idx + 1, visited)){
            return true;
        }
        if(dfs(board, word, i, j + 1, idx + 1, visited)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "BCCED";

        System.out.print(exist(board, word));

    }
}
