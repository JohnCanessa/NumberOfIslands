import java.util.Arrays;
import java.util.Scanner;

/**
 * 200. Number of Islands https://leetcode.com/problems/number-of-islands/
 */
public class Solution {


    /**
     * Return index of '1' in the specified character array.
     * Execution O(m)
     * !!! NOT USED IN SOLUTION !!!
     */
    static int indexOfOne(char[] ca) {

        // // **** ****
        // String str = new String(ca);

        // // **** ****
        // int index = str.indexOf('1');

        // // **** ****
        // return index;

        // **** one liner ****
        return new String(ca).indexOf('1');
    }


    /**
     * Visit the entire island.
     * Recursive call.
     * Execution O(n * m)
     */
    static void visitIsland(char[][] grid, int r, int c) {

        // **** base condition ****
        if (grid[r][c] == '0' || grid[r][c] == 'x')
            return;

        // **** flag as visited ****
        grid[r][c] = 'x';

        // **** recurse right ****
        if (c < grid[r].length - 1)
            visitIsland(grid, r, c + 1);

        // **** recurse down ****
        if (r < grid.length - 1)
            visitIsland(grid, r + 1, c);

        // **** recurse left ****
        if (c > 0)
            visitIsland(grid, r, c - 1);

        // **** recurse up ****
        if (r > 0)
            visitIsland(grid, r - 1, c);
    }


    /**
     * Given a 2d grid map of '1's (land) and '0's (water),
     * count the number of islands.
     * Runtime: 3 ms, faster than 31.96% of Java online submissions.
     * Memory Usage: 44.3 MB, less than 20.73% of Java online submissions.
     * Execution O(n * m)
     */
    static int numIslands(char[][] grid) {
        
        // **** sanity check(s) ****
        if ((grid == null) || (grid.length == 0))
            return 0;

        // **** initialize variable(s) ****
        int num = 0;
        // int c = 0;


        // // **** loop once per row ****
        // for (int r = 0; r < grid.length; r++) {

        //     // **** loop while an unvisited island ****
        //     while ((c = new String(grid[r]).indexOf('1')) != -1) {

        //         // **** visit adjacent cells ****
        //         visitIsland(grid, r, c);

        //         // **** count this island ****
        //         num++;
        //     }
        // }

        // **** loop once per row ****
        for (int r = 0; r < grid.length; r++) {

            // **** loop through each column ****
            for (int c = 0; c < grid[r].length; c++) {

                // **** visit cell (if on land) ****
                if (grid[r][c] == '1') {

                    // **** visit adjacent cells ****
                    visitIsland(grid, r, c);

                    // **** count this island ****
                    num++;
                }
      
            }
        }


        // **** return number of islands ****
        return num;
    }


    /**
     * Test scaffolding
     */
    public static void main(String[] args) {

        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read line with row and column counts ****
        String[] rn = sc.nextLine().split(",");
        int R = Integer.parseInt(rn[0]);
        // int C = Integer.parseInt(rn[1]);

        // **** create an empty grid ****
        char[][] grid = new char[R][];

        // **** loop reading a row of values at a time ****
        for (int r = 0; r < R; r++) {

            // **** read the next row of data ****
            String data = sc.nextLine();

            // **** remove all '"'s ****
            data = data.replaceAll("\"", "");

            // **** remove all '','s ****
            data = data.replaceAll(",", "");

            // **** populate this row ****
            grid[r] = data.toCharArray();
        }

        // **** close scanner ****
        sc.close();

        // ???? ????
        System.out.println("main <<< grid:");
        for (int r = 0; r < grid.length; r++)
            System.out.println(Arrays.toString(grid[r]));

        // **** count and display the number of islands ****
        System.out.println("main <<< numIslands: " + numIslands(grid));

        // ???? ????
        System.out.println("main <<< grid:");
        for (int r = 0; r < grid.length; r++)
            System.out.println(Arrays.toString(grid[r]));
    }

 }