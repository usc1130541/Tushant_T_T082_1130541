/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class Rings extends Gifts implements Giftsinterface{

    ImageIcon rings = new ImageIcon("Ring-icon.png");
    Random numb = new Random();
    int i;
    //int n=5;
    public static int score = 0;
    // Mazegenerate m = new Mazegenerate();
    public static ArrayList<String> ringposi = new ArrayList<String>();
    public static ArrayList<String> ringposj = new ArrayList<String>();

    public Rings() {

    }

    public void randomizerings(char[][] maze) {

        i = 0;
        int k;
        boolean found = false;

        while (!found) {
            boolean foundInCoins = false;

            Gifts.setRandi(numb.nextInt(13) + 2);
            Gifts.setRandj(numb.nextInt(20));
            if (MazeStatic.maze[getRandj()][getRandi()] == '0') {
                for (k = 0; k < Coins.coinposi.size(); k++) {
                    if (getRandj() == Integer.parseInt(Coins.coinposj.get(k))
                            && getRandi() == Integer.parseInt((Coins.coinposi.get(k)))) {
                        foundInCoins = true;
                        break;

                    }
                }
                found = !foundInCoins;

            }
        }
        Rings.ringposi.add(Integer.toString(getRandi()));
        Rings.ringposj.add(Integer.toString(getRandj()));
    }

    public void viewrings(Graphics g) {
        for (int k = 0; k < Rings.ringposi.size(); k++) {
            g.drawImage(rings.getImage(), Integer.parseInt(Rings.ringposj.get(k)) * 46,
                    Integer.parseInt(Rings.ringposi.get(k)) * 46, null);
        }
    }

    public void collectRings(String Position) {
        for (int k = 0; k < Rings.ringposi.size(); k++) {
            if (Position.equalsIgnoreCase("Right")) {

                if (MazeStatic.P.PRT.x >= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.x <= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRT.y <= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.y >= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PRT.y >= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.y <= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRT.x <= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRT.x >= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size
                        || (MazeStatic.P.PRB.y >= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.y <= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRB.x <= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRB.x >= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size))) {
                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
//                    n--;
                    Rings.ringposi.remove(k);
                    Rings.ringposj.remove(k);
                    score++;
                    MazeStatic.FinalScore = MazeStatic.FinalScore + 200;
                    System.out.println("Final Score iiiiisssssss   " + MazeStatic.FinalScore);
                }
            } else if (Position.equalsIgnoreCase("left")) {
                if (MazeStatic.P.PLT.x <= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLT.x >= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLT.y <= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.y >= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PLT.y <= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLT.y >= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLT.x >= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLT.x <= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PLB.y >= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.y <= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLB.x >= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.x <= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size + MazeStatic.Size))) {

                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
//                    n--;
                    Rings.ringposi.remove(k);
                    Rings.ringposj.remove(k);
                    score++;
                    MazeStatic.FinalScore = MazeStatic.FinalScore + 200;
                    System.out.println("Final Score iiiiisssssss   " + MazeStatic.FinalScore);
                }
            } else if (Position.equalsIgnoreCase("Forward")) {
                if (MazeStatic.P.PLB.y >= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.y <= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLB.x <= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.x >= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PLB.x >= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.x <= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLB.y >= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.y <= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PRB.x >= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.x <= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRB.y >= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.y <= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size + MazeStatic.Size))) {
                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
//                    n--;
                    Rings.ringposi.remove(k);
                    Rings.ringposj.remove(k);
                    score++;
                    MazeStatic.FinalScore = MazeStatic.FinalScore + 200;
                    System.out.println("Final Score iiiiisssssss   " + MazeStatic.FinalScore);
                }
            } else if (Position.equalsIgnoreCase("Backward")) {
                if (MazeStatic.P.PLT.y <= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLT.y >= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLT.x <= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.x >= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size
                        || (MazeStatic.P.PLT.x >= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLT.x <= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLT.y <= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLT.y >= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size
                        || (MazeStatic.P.PRT.x >= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.x <= Integer.parseInt(Rings.ringposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRT.y >= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.y <= Integer.parseInt(Rings.ringposi.get(k)) * MazeStatic.Size + MazeStatic.Size))) {
                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
//                    n--;
                    Rings.ringposi.remove(k);
                    Rings.ringposj.remove(k);
                    score++;
                    MazeStatic.FinalScore = MazeStatic.FinalScore + 200;
                    System.out.println("Final Score iiiiisssssss   " + MazeStatic.FinalScore);
                }
            }
        }
    }

    @Override
    public void randomizecoins(char[][] maze) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewcoins(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void collectCoins(String Position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
