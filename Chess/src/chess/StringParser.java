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
        int[] coords = new int[4];
        for (int i = 0; i< coords.length; i++)
        {
            int val = s.charAt(i) - '0';
            if (val < 1 || val > 8)
            {
                throw new IllegalArgumentException("All Numbers must be between values 1 and 8");
            }
            coords[i] = val;
        }
        return coords;
    }
    
}
