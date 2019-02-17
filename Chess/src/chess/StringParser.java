/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author chadw
 */
public class StringParser {
    
    public static int[] getCoordinates(String s) throws IllegalArgumentException
    {
        s = s.replace("-", "");
        if(s.length() != 4)
        {
            throw new IllegalArgumentException("The size of the input is incorrect");
        }
        s = s.toLowerCase();
        int[] coords = new int[4];
        // Only need to Iterate Twice.
        for (int i = 0; i < 4; i = i+2)
        {
            // Split into two substrings like e2-e4
            // -96 from ASCII to get letter's position in alphabet. E.g 97(A) - 96 = 1.

            int colNum = s.charAt(i) - 96;
            if (colNum < 1 || colNum > 8)
            {
                throw new IllegalArgumentException("All Letter's must be between A and E");
            }
            int rowNum = s.charAt(i+1) - '0';
            if (rowNum < 1 || rowNum > 8)
            {
                throw new IllegalArgumentException("All Numbers must be between values 1 and 8");
            }
            coords[i] = colNum - 1; // Columns go 0 - 8
            coords[i+1] = 8 - rowNum; // Rows go 8-0
            System.out.println("ColNum: " + colNum + ". RowNum: " + rowNum);
        }
        return coords;
    }
    
}
