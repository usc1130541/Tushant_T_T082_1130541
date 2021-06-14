package mazerunner;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class Coins extends Gifts implements Giftsinterface{

    public Coins() {

    }

    ImageIcon coins = new ImageIcon("coin-icon.png");
    Random numb = new Random();
    public static int score;
//    int m = 5;
    //Mazegenerate m = new Mazegenerate();
    public static ArrayList<String> coinposi = new ArrayList<String>();
    public static ArrayList<String> coinposj = new ArrayList<String>();

    @Override
    public void randomizecoins(char[][] maze) {
        //     for(int i=0;i<5;i++)
        //   {
        Gifts.setRandi(numb.nextInt(13) + 2);
        Gifts.setRandj(numb.nextInt(20));
        if (maze[Gifts.getRandj()][Gifts.getRandi()] == '0') {

            coinposi.add(Integer.toString(Gifts.getRandi()));
            coinposj.add(Integer.toString(Gifts.getRandj()));
        } else {
            randomizecoins(maze);
        }
        //  }
    }

    @Override
    public void viewcoins(Graphics g) {

        for (int i = 0; i < coinposi.size(); i++) {
            g.drawImage(coins.getImage(), Integer.parseInt(Coins.coinposj.get(i)) * MazeStatic.Size, Integer.parseInt(Coins.coinposi.get(i)) * MazeStatic.Size, null);
        }
    }

    @Override
    public void collectCoins(String Position) {
        for (int k = 0; k < Coins.coinposi.size(); k++) {
            if (Position.equalsIgnoreCase("Right")) {

                if (MazeStatic.P.PRT.x >= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.x <= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRT.y <= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.y >= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PRT.y >= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.y <= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRT.x <= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRT.x >= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size
                        || (MazeStatic.P.PRB.y >= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.y <= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRB.x <= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRB.x >= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size))) {
                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
//                    m--;
                    Coins.coinposi.remove(k);
                    Coins.coinposj.remove(k);
                    score++;
                    MazeStatic.FinalScore = MazeStatic.FinalScore + 100;
                    System.out.println("Final Score iiiiisssssss   " + MazeStatic.FinalScore);
                }
            } else if (Position.equalsIgnoreCase("left")) {

                if (MazeStatic.P.PLT.x <= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size+ MazeStatic.Size
                        && MazeStatic.P.PLT.x >= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size 
                        && MazeStatic.P.PLT.y <= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.y >= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PLT.y <= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLT.y >= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLT.x >= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLT.x <= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PLB.y >= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.y <= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLB.x >= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.x <= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size + MazeStatic.Size))) {

                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
//                        m--;
                    Coins.coinposi.remove(k);
                    Coins.coinposj.remove(k);
                    score++;
                    MazeStatic.FinalScore = MazeStatic.FinalScore + 100;
                    System.out.println("Final Score iiiiisssssss   " + MazeStatic.FinalScore);
                }
            } else if (Position.equalsIgnoreCase("Forward")) {

                if (MazeStatic.P.PLB.y >= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.y <= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLB.x <= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.x >= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PLB.x >= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.x <= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLB.y >= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.y <= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PRB.x >= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.x <= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRB.y >= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.y <= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size + MazeStatic.Size))) //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
                {
                    // m--;

                    Coins.coinposi.remove(k);
                    Coins.coinposj.remove(k);
                    score++;
                    MazeStatic.FinalScore = MazeStatic.FinalScore + 100;
                    System.out.println("Final Score iiiiisssssss   " + MazeStatic.FinalScore);
                }
            } else if (Position.equalsIgnoreCase("Backward")) {
                if (MazeStatic.P.PLT.y <= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLT.y >= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLT.x <= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.x >= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size
                        || (MazeStatic.P.PLT.x >= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLT.x <= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLT.y <= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLT.y >= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size
                        || (MazeStatic.P.PRT.x >= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.x <= Integer.parseInt(Coins.coinposj.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRT.y >= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.y <= Integer.parseInt(Coins.coinposi.get(k)) * MazeStatic.Size + MazeStatic.Size))) {
                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
//                    m--;
                    Coins.coinposi.remove(k);
                    Coins.coinposj.remove(k);
                    score++;
                    MazeStatic.FinalScore = MazeStatic.FinalScore + 100;
                    System.out.println("Final Score iiiiisssssss   " + MazeStatic.FinalScore);
                }
            }
        }
    }

    @Override
    public void randomizerings(char[][] maze) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewrings(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void collectRings(String Position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
