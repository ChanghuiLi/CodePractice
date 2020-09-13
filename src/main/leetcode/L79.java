public class L79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (process(board,visited,word,0,i,j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean process(char[][] board, boolean[][] visited, String word,int wordSearch, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || visited[row][col] == true || wordSearch > word.length()
                || board[row][col] != word.charAt(wordSearch)){
            return false;
        }
        if (wordSearch == word.length()-1 && word.charAt(wordSearch) == board[row][col]) {
            return true;
        }
        visited[row][col] = true;
        boolean res = process(board,visited,word,wordSearch+1,row+1,col) ||
                process(board,visited,word,wordSearch+1,row,col+1) ||
                process(board,visited,word,wordSearch+1,row,col-1) ||
                process(board,visited,word,wordSearch+1,row-1,col);
        visited[row][col] = false;
        return res;
    }
}
