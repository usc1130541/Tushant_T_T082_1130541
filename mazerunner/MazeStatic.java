package mazerunner;

import Viewer.Maze;
import Controller.RunController;
import Controller.TimerController2;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class MazeStatic {

    // Mazegenerate m1=new Mazegenerate();
    public static char[][] maze;
    public static int x_start, y_start, x_pos, y_pos, x_posl, y_posl;
    public static PlayerState PS;
    public static Maze m = new Maze();
    public static Timer t = new Timer();
    public static long ElapsedTime = MazeStatic.t.getElapsedTime();
    public static long seconds;
    public static long minutes;
    //public static long centiseconds;
    public static long FinalScore = 0;
    public static int weapons = 10;
    public static Score s = new Score();
    public static boolean moveup, movedown, moveleft, moveright;
    public static boolean up, down, left, right;
    public static BufferedImage w1, w2;
    public static Player P = Player.getInstance();
    public static MapCastle Map = new MapCastle();
    public static Giftsfactory gift = new Giftsfactory();
    public static Coins c = (Coins) gift.getgift("Coins");
    public static Rings r = (Rings) gift.getgift("Rings");
    public static RunController rc = new RunController();
    public static int Size = 46;
    public static Bomb1 b1 = new Bomb1();
    public static Bomb2 b2 = new Bomb2();
    public static Weapons w = new Weapons();
    public static TimerController2 t2 = new TimerController2();
    public static boolean fire = false;

    //public static Pmonster mon = new Pmonster();
    public static Monster mo = new Monster();
    public static Monster1 mo1 = new Monster1();

    //public static void MazeStatic(){
    //  m1.randomize();
    //  MazeStatic.maze=m1.getMaze();
//}
}
