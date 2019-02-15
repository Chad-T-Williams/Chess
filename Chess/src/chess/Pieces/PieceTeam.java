/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.Pieces;

/**
 *
 * @author chadw
 */
public enum PieceTeam {
    White("White"), 
    Black("Black"), 
    NoTeam("No Team");
    private String pieceTeam;
    
    private PieceTeam(String pt)
    {
        pieceTeam = pt;
    }
    
    public String toString()
    {
        return pieceTeam;
    }
}
