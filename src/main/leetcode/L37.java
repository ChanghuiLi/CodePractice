import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class L37 {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
    public void solveSudoku(char[][] board) {
        dfs(board,0,0);
    }
    private void dfs(char[][] board, int row, int col) {
        for (int k = col; k < board[0].length; k++) {
            if (board[row][k] == '.') {
                for (int num = 1; num <= 9; num++) {
                    if (numOK(board,row,k,num)) {
                        board[row][k] = (char)num;
                        dfs(board,row,k);
                        board[row][k] = '.';
                    }
                }
            }
        }
        for (int i = row+1; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (int num = 1; num <= 9; num++) {
                        if (numOK(board,i,j,num)) {
                            board[i][j] = (char)num;
                            dfs(board,i,j);
                            board[i][j] = '.';
                        }
                    }
                }
            }
        }
        return;
    }

    private boolean numOK(char[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) { // 判断行里是否重复
            if (board[row][i] == num) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) { // 判断列里是否重复
            if (board[j][col] == num) {
                return false;
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) { // 判断9方格里是否重复
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num ) {
                    return false;
                }
            }
        }
        return true;
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        if (rowIndex == 1) return res;
        res.add(1);
        if (rowIndex == 2) return res;
        for (int i = 3; i <= rowIndex; i++) {
            int temp = 1;
            for(int j = 1; j < i-1; j++) {
                int val = temp + res.get(j);
                temp = res.get(j);
                res.set(j,val);
            }
            res.add(1);
        }
        return res;
    }
}
