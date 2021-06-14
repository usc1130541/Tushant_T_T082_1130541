/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import javax.swing.ImageIcon;

public class FlamePosition {
    
    
    /** The x position on the screen of the normalized vector (x,y) */
private int x;
/** The y position on the screen of the normalize vector (x,y) */
private int y;
/** This creates a vector setting the (x,y) position
* to the values provided.
*
* @param i the x position of the normalized vector (x,y)
* @param j the y position of the normalized vector (x,y)
*/
public FlamePosition(int i, int j) {
x = i;
y = j;
}
public int getX() {
return x;
}
public void setX(int x) {
this.x = x;
}
public int getY() {
return y;
}
public void setY(int y) {
this.y = y;
}
/**
* Adds the vector components provided to the current vector
*
* @param vector2 a normalized vector to be added
*/
public void add(FlamePosition vector2) {
x = x + vector2.getX();
y = y + vector2.getY();
}


    
    
    
}


