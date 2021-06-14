/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import java.awt.Graphics;

public interface Giftsinterface {
    public void randomizecoins(char[][] maze);
    public void viewcoins(Graphics g);
    public void collectCoins(String Position);
    public void randomizerings(char [][] maze);
    public void viewrings(Graphics g);
    public void collectRings(String Position);
}
