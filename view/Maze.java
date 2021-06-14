package Viewer;

import Viewer.Mazeframe;
import Controller.Mazegenerate;
import Controller.TimerController2;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import mazerunner.Bomb1;
import mazerunner.Bomb2;
import mazerunner.Gifts;
import mazerunner.MapCastle;
import mazerunner.MazeStatic;
import mazerunner.Monster;
import mazerunner.Monster1;
import mazerunner.Player;
import mazerunner.Pwall;
import mazerunner.Wall1;
import mazerunner.Wall2;

public class Maze extends JPanel {

    ImageIcon player = new ImageIcon("timmy turner maze.png");
    //ImageIcon img3 = new ImageIcon("timmy turner maze.gif");
    Monster m = new Monster();
    Monster1 mons = new Monster1();
    public static boolean starttime = true;
    Wall1 wall = new Wall1();
    Wall2 wall2 = new Wall2();
    Pwall w = new Pwall();
    public int[][] wallarray;

    public int startj = 1;
    public int starti = 1;
    private int flag;
    public static int mazeflag = 0;

    public static boolean Mfound = false;
    Bomb1 b1 = new Bomb1();
    Bomb2 b2 = new Bomb2();
    Random rn = new Random();
    public static Graphics g;
    Player Pl = Player.getInstance();

    public char[][] maze;
    Mazegenerate m1 = Mazegenerate.getinstance();
    ImageIcon dead = new ImageIcon("Death-icon.png");

    public Maze() {

    }

    @Override
    public void paintComponent(Graphics g) {

        int I = 0, J = 0;
        super.paintComponent(g);
        setBackground(Color.WHITE);
        setSize(1012, 1000);
        //System.out.println("Entered Successfully!!");
        flag = rn.nextInt(2);
        if (mazeflag == 0) {
            m1.randomize();
            MazeStatic.maze = maze = m1.getMaze();
            MazeStatic.Map.CastleRandomize(maze);
            MazeStatic.Map.MapRandomize(maze);
            for (int l = 0; l < Bomb1.countb1; l++) {
                b1.randomizebombs(maze);
            }
            for (int l = 0; l < Bomb2.counter2; l++) {
                b2.randomizebombs(maze);
            }
            for (int i = 0; i < Gifts.counter; i++) {
                MazeStatic.c.randomizecoins(maze);
            }
            for (int i = 0; i < Gifts.counter; i++) {
                MazeStatic.r.randomizerings(maze);
            }

            w.random_wall();
            for (int i = 0; i < 3; i++) {
                m.random_mons(g, maze);
            }
            for (int i = 0; i < 3; i++) {
                mons.random_mons(g, maze);
            }

            mazeflag = 1;
        }

        wallarray = w.getRand_wall();
        wall.Draw_wall(g, maze, wallarray);
        wall2.Draw_wall(g, maze, wallarray);

        if (Mazeframe.RUN) {
            g.drawImage(MazeStatic.P.P1, MazeStatic.x_start, MazeStatic.y_start, null);
        } else {
            g.drawImage(dead.getImage(), MazeStatic.P.PLT.x, MazeStatic.P.PLT.y, null);
            ((Mazeframe) SwingUtilities.getWindowAncestor(MazeStatic.m)).countdownTimer.stop();

        }
        // for (int i = 0; i < 10; i++) {
        m.drawmonster(g, maze);
        mons.drawmonster(g, maze);
        // }
        //for(int k=0;k < 5;k++)
        //{
        MazeStatic.c.viewcoins(g);
        //}
        //for(int l=0;l < 5;l++)
        //{
        MazeStatic.r.viewrings(g);
        b1.draw(g);
        b2.draw(g);
        //}
        /*for (int k = 0; k < 2; k++) {
         b1.draw(g, maze);
         }
         for (int l=0;l<3;l++)
         {
         b2.draw(g, maze);
         }*/
        if (Mfound == false) {
            MazeStatic.Map.Map(g);
        }

        if (MapCastle.Counter == 1) {
            MazeStatic.Map.Castle(g);
        }

        for (I = 0; I < 16; I++) {
            //System.out.println(I+"mmmmmmmm");
            for (J = 0; J < 20; J++) {
                if (maze[J][I] == '0') {
                    break;
                }
            }
            if (J < 20) {
                break;
            }
        }

        // g.drawImage(Pl.P1, 40*J, 40*I, null);
        MazeStatic.P.x = J;
        MazeStatic.P.x = I;
        MazeStatic.t.start();
        starttime = false;
        
        if (MazeStatic.fire)
            g.drawImage(MazeStatic.w.fireball.getImage(), TimerController2.F1.getX(), TimerController2.F1.getY(), null);

    }

    public static void drawChar() {

    }

}
