/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import java.awt.Graphics;

public abstract class Bomb {

    public Bomb() {

    }

    public abstract void draw(Graphics g);

    public abstract void randomizebombs(char[][] maze);

    public abstract void bombaction(String Position);
    public static int lives = 3;
    
}
