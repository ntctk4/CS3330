/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntctk4wordfinder;

/**
 *
 * @author Nathan
 */
public class LocationHolder {
    public String letter;
    public final int x;
    public final int y;
    
    LocationHolder(int x, int y, String letter)
    {
        this.letter = letter;
        this.x = x;
        this.y = y;
    }
}
