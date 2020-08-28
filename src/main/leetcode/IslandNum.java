public class IslandNum {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j <grid[0].length; j++){
                if (grid[i][j] == '1') {
                    count++;
                    dfsGrid(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfsGrid(char[][] grid,int i,int j){
        // 上下左右四个方向进行判定
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1'){
            grid[i][j] = '0';
            dfsGrid(grid,i-1,j);
            dfsGrid(grid,i,j-1);
            dfsGrid(grid,i+1,j);
            dfsGrid(grid,i,j+1);
        }
    }
}
