package Array2;

/*Follow up:
Also solve it in place and remember that the board needs to be updated at the same time and you cannot update some cells first and then use their updated values to update other cells. 
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. 
How would you address these problem
Source Link: https://leetcode.com/problems/game-of-life/
 -------------------------------------------------------------------------------------------------------
    Time complexity : o(m*n)
    space complexity: o(1) as we are mutating the same matrix
    Did this code run successfully in leetcode : yes
    problems faces : no
    
*/

public class GameOfLife {

    public void gameOfLife(int[][] board) {

        if(board == null || board.length == 0 || board[0].length == 0)
            {
            return;
            }
       // change live to dead   1 ->0 to 3
       //  change dead to live  0 -> 1 to 2

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                //calculate total live around the index [i],[j]
                int lives = countLives(board, i, j);

                if(board[i][j] == 1 && (lives<2 || lives >3))
                {
                    board[i][j] = 3;
                }

               if(board[i][j] == 0 && lives == 3)
               {
                   board[i][j] = 2;
               }
            }
        }


        //new state without 2 and 3
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j] == 2)
                {
                    board[i][j] =  1;

                } 
                if(board[i][j] == 3)
                {
                    board[i][j] = 0;
                }
            }
        }

}

    private int countLives(int[][] board, int i, int j)
    { 
        //directions array    right left   down   up     topright     bottomRight   topleft   bottomleft  
        int[][] directions = {{0,1},{0,-1},{1,0}, {-1,0},{-1,1},     {1,1},        {-1,-1},  {1,-1}};

        int lives = 0;
        for(int[] dir : directions)
        {
            int r = i+dir[0];
            int c = j+dir[1];
            //boundcheck
            if(r>=0 && r <board.length && c>=0 && c<board[0].length &&
                    (board[r][c] == 1 || board[r][c] ==3))
            {
                   lives++;
            }

        } 

        return lives;
    }
}