package mazerunner;

import Viewer.Maze;
import Viewer.Mazeframe;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import sun.swing.SwingAccessor;

public class MapCastle {

    ImageIcon Map = new ImageIcon("start-here-icon.png");
    ImageIcon Castle = new ImageIcon("Castle-icon.png");
    public int MapX;
    public int MapY;
    public int CasX;
    public int CasY;
    public static Point LT = new Point(), LB = new Point(), RT = new Point(), RB = new Point();
    public static Point CLT = new Point(), CLB = new Point(), CRT = new Point(), CRB = new Point();
    public static int Counter = 0;
    boolean CF = true, MF = true;
    public static boolean endtime = true;
    public static boolean GameStop = true;

    Random num = new Random();

    public void CastleRandomize(char[][] maze) {
        int i = 0;
        int k;

        boolean found = false;

        while (!found) {
            boolean foundInCoins = false;
            boolean foundInRings = false;
            boolean foundInBomb1 = false;
            boolean foundInBombs2 = false;
            CasX = num.nextInt(18);
            CasY = num.nextInt(16);
            if (MazeStatic.maze[CasX][CasY] == '0') {
                for (k = 0; k < Coins.coinposi.size(); k++) {
                    if (CasX == Integer.parseInt(Rings.ringposj.get(k))
                            && CasY == Integer.parseInt((Rings.ringposi.get(k)))) {
                        foundInRings = true;
                        break;

                    }
                }
                for (k = 0; k < Rings.ringposi.size(); k++) {
                    if (CasX == Integer.parseInt(Coins.coinposj.get(i))
                            && CasY == Integer.parseInt((Coins.coinposi.get(i)))) {
                        foundInCoins = true;
                        break;
                    }
                }
                for (k = 0; k < Bomb1.x.size(); k++) {
                    if (CasX == Integer.parseInt(Bomb1.x.get(i))
                            && CasY == Integer.parseInt((Bomb1.y.get(i)))) {
                        foundInBomb1 = true;
                        break;
                    }
                }
                for (k = 0; k < Bomb2.y.size(); k++) {
                    if (CasX == Integer.parseInt(Bomb2.x.get(i))
                            && CasY == Integer.parseInt((Bomb2.y.get(i)))) {
                        foundInBombs2 = true;
                        break;
                    }
                }
                found = (!foundInRings && !foundInCoins && !foundInBomb1 && !foundInBombs2);
            }
        }
    }

    /* if (maze[CasX][CasY] == '0') {
     while (i < Rings.ringposi.size()) {
     if (CasX == Integer.parseInt(Rings.ringposj.get(i)) && CasY == Integer.parseInt((Rings.ringposi.get(i)))) {
     CastleRandomize(maze);
     //  i=0;
     }
     i++;
     }
     i = 0;
     while (i < Coins.coinposi.size()) {
     if (CasX == Integer.parseInt(Coins.coinposj.get(i)) && CasY == Integer.parseInt((Coins.coinposi.get(i)))) {
     CastleRandomize(maze);

     // i=0;
     }
     i++;
     }
     i = 0;
     while (i < Bomb1.x.size()) {
     if (CasX == Integer.parseInt(Bomb1.x.get(i)) && CasY == Integer.parseInt((Bomb1.y.get(i)))) {
     CastleRandomize(maze);

     // i=0;
     }
     i++;
     }

     i = 0;
     while (i < Bomb2.x.size()) {
     if (CasX == Integer.parseInt(Bomb2.x.get(i)) && CasY == Integer.parseInt((Bomb2.y.get(i)))) {
     CastleRandomize(maze);

     // i=0;
     }
     i++;
     }

     } else {
     CastleRandomize(maze);
     }*/
    public void Castle(Graphics g) {

        g.drawImage(Castle.getImage(), CasX * MazeStatic.Size, CasY * MazeStatic.Size, null);
        CLT.x = CasX;
        CLT.y = CRT.y = CasY;
        CRT.x = CasX + 1;
        CLB.x = CasX;
        CLB.y = CRB.y = CasY + 1;
        CRB.x = CasX + 1;

    }

    public void MapRandomize(char[][] maze) {
        int i = 0;
        MapX = num.nextInt(10) + 10;
        MapY = num.nextInt(8) + 8;

        if (maze[MapX][MapY] == '0') {
            while (i < Rings.ringposi.size()) {
                if (MapX == Integer.parseInt(Rings.ringposj.get(i)) && MapY == Integer.parseInt((Rings.ringposi.get(i)))) {
                    MapRandomize(maze);
                    // i=0;
                }
                i++;
            }

            i = 0;
            while (i < Coins.coinposi.size()) {
                if (MapX == Integer.parseInt(Coins.coinposj.get(i)) && MapY == Integer.parseInt((Coins.coinposi.get(i)))) {
                    MapRandomize(maze);
                    // i=0;
                }
                i++;
            }

            i = 0;
            while (i < Bomb1.x.size()) {
                if (MapX == Integer.parseInt(Bomb1.x.get(i)) && MapY == Integer.parseInt((Bomb1.y.get(i)))) {
                    MapRandomize(maze);

                    // i=0;
                }
                i++;
            }

            i = 0;
            while (i < Bomb2.x.size()) {
                if (MapX == Integer.parseInt(Bomb2.x.get(i)) && MapY == Integer.parseInt((Bomb2.y.get(i)))) {
                    MapRandomize(maze);

                    // i=0;
                }
                i++;
            }

        } else {
            MapRandomize(maze);
        }
    }

    public void Map(Graphics g) {
        g.drawImage(Map.getImage(), MapX * MazeStatic.Size, MapY * MazeStatic.Size, null);
        LT.x = MapX;
        LT.y = RT.y = MapY;
        RT.x = MapX + 1;
        LB.x = MapX;
        LB.y = RB.y = MapY + 1;
        RB.x = MapX + 1;

    }

    public void checkMAP(String Position) {
        //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");

        //System.out.println(MazeStatic.P.PRT+"MMMMM"+LT);
        if (Position.equalsIgnoreCase("Right")) {

            if ((MazeStatic.P.PRT.x >= (LT.x * MazeStatic.Size)
                    && MazeStatic.P.PRT.x <= (RT.x * MazeStatic.Size)
                    & MazeStatic.P.PRT.y <= (LT.y * MazeStatic.Size)
                    && MazeStatic.P.PRB.y >= (LB.y * MazeStatic.Size))
                    || (MazeStatic.P.PRT.y >= (LT.y * MazeStatic.Size)
                    && MazeStatic.P.PRT.y <= (LB.y * MazeStatic.Size)
                    && MazeStatic.P.PRT.x <= (RT.x * MazeStatic.Size)
                    && MazeStatic.P.PRT.x >= (LT.x * MazeStatic.Size))
                    || (MazeStatic.P.PRB.y >= (LT.y * MazeStatic.Size)
                    && MazeStatic.P.PRB.y <= (LB.y * MazeStatic.Size)
                    && MazeStatic.P.PRB.x <= (RT.x * MazeStatic.Size)
                    && MazeStatic.P.PRB.x >= (LT.x * MazeStatic.Size))) {
                //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");

                Maze.Mfound = true;
                Counter = 1;
            }
        } else if (Position.equalsIgnoreCase("left")) {
            if ((MazeStatic.P.PLT.x <= (RT.x * MazeStatic.Size)
                    && MazeStatic.P.PLT.x >= (LT.x * MazeStatic.Size)
                    && MazeStatic.P.PLT.y <= (RT.y * MazeStatic.Size)
                    && MazeStatic.P.PLB.y >= (RB.y * MazeStatic.Size))
                    || (MazeStatic.P.PLT.y <= (RB.y * MazeStatic.Size)
                    && MazeStatic.P.PLT.y >= (RT.y * MazeStatic.Size)
                    && MazeStatic.P.PLT.x >= (LT.x * MazeStatic.Size)
                    && MazeStatic.P.PLT.x <= (RT.x * MazeStatic.Size))
                    || (MazeStatic.P.PLB.y >= (RT.y * MazeStatic.Size)
                    && MazeStatic.P.PLB.y <= (RB.y * MazeStatic.Size)
                    && MazeStatic.P.PLB.x >= (LT.x * MazeStatic.Size)
                    && MazeStatic.P.PLB.x <= (RT.x * MazeStatic.Size))) {

                //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
                Maze.Mfound = true;
                Counter = 1;
            }
        } else if (Position.equalsIgnoreCase("Forward")) {
            if ((MazeStatic.P.PLB.y >= (LT.y * MazeStatic.Size)
                    && MazeStatic.P.PLB.y <= (LB.y * MazeStatic.Size)
                    && MazeStatic.P.PLB.x <= (MazeStatic.Size * LT.x)
                    && MazeStatic.P.PRB.x >= (RT.x * MazeStatic.Size))
                    || (MazeStatic.P.PLB.x >= (LT.x * MazeStatic.Size)
                    && MazeStatic.P.PLB.x <= (RT.x * MazeStatic.Size)
                    && MazeStatic.P.PLB.y >= (LT.y * MazeStatic.Size)
                    && MazeStatic.P.PLB.y <= (LB.y * MazeStatic.Size))
                    || (MazeStatic.P.PRB.x >= (LT.x * MazeStatic.Size)
                    && MazeStatic.P.PRB.x <= (RT.x * MazeStatic.Size)
                    && MazeStatic.P.PRB.y >= (LT.y * MazeStatic.Size)
                    && MazeStatic.P.PRB.y <= (LB.y * MazeStatic.Size))) {
                //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");

                Maze.Mfound = true;
                Counter = 1;
            }
        } else if (Position.equalsIgnoreCase("Backward")) {
            if ((MazeStatic.P.PLT.y <= (LT.y * MazeStatic.Size)
                    && MazeStatic.P.PLT.y >= (LB.y * MazeStatic.Size)
                    && MazeStatic.P.PLT.x <= (LB.x * MazeStatic.Size)
                    && MazeStatic.P.PRT.x >= (MazeStatic.Size * LB.x))
                    || (MazeStatic.P.PLT.x >= (LT.x * MazeStatic.Size)
                    && MazeStatic.P.PLT.x <= (RT.x * MazeStatic.Size)
                    && MazeStatic.P.PLT.y <= (LB.y * MazeStatic.Size)
                    && MazeStatic.P.PLT.y >= (LT.y * MazeStatic.Size))
                    || (MazeStatic.P.PRT.x >= (LB.x * MazeStatic.Size)
                    && MazeStatic.P.PRT.x <= (RB.x * MazeStatic.Size)
                    && MazeStatic.P.PRT.y >= (LT.y * MazeStatic.Size)
                    && MazeStatic.P.PRT.y <= (LB.y * MazeStatic.Size))) {
                //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");

                Maze.Mfound = true;
                Counter = 1;
            }
        }
    }

    public void checkCAS(String Position) {
        //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");

        //System.out.println(MazeStatic.P.PRT+"MMMMM"+LT);
        if (Position.equalsIgnoreCase("Right")) {
            if (GameStop) {
                if ((MazeStatic.P.PRT.x >= (CLT.x * MazeStatic.Size)
                        && MazeStatic.P.PRT.x <= (CRT.x * MazeStatic.Size)
                        & MazeStatic.P.PRT.y <= (CLT.y * MazeStatic.Size)
                        && MazeStatic.P.PRB.y >= (CLB.y * MazeStatic.Size))
                        || (MazeStatic.P.PRT.y >= (CLT.y * MazeStatic.Size)
                        && MazeStatic.P.PRT.y <= (CLB.y * MazeStatic.Size)
                        && MazeStatic.P.PRT.x <= (CRT.x * MazeStatic.Size)
                        && MazeStatic.P.PRT.x >= (CLT.x * MazeStatic.Size))
                        || (MazeStatic.P.PRB.y >= (CLT.y * MazeStatic.Size)
                        && MazeStatic.P.PRB.y <= (CLB.y * MazeStatic.Size)
                        && MazeStatic.P.PRB.x <= (CRT.x * MazeStatic.Size)
                        && MazeStatic.P.PRB.x >= (CLT.x * MazeStatic.Size))) {

                    Castle = new ImageIcon("medal-icon.png");
                    ((Mazeframe) SwingUtilities.getWindowAncestor(MazeStatic.m)).countdownTimer.stop();
                    ZeroCasPt();
                    MazeStatic.t.stop();
                    endtime = false;
                    MazeStatic.ElapsedTime = MazeStatic.t.getElapsedTime();
                    MazeStatic.t.convertMillis(MazeStatic.ElapsedTime);
                    MazeStatic.minutes = MazeStatic.t.getMinutes();
                    MazeStatic.seconds = MazeStatic.t.getSeconds();
//                    MazeStatic.centiseconds = MazeStatic.t.getCentiseconds();
                    System.out.println("Elapsed Time " + MazeStatic.t.convertMillis(MazeStatic.ElapsedTime));
                    MazeStatic.s.CalculateScore();
                    System.out.println("Final Score right isssssss " + MazeStatic.FinalScore);
                }
            }
        } else if (Position.equalsIgnoreCase("left")) {
            if (GameStop) {
                if ((MazeStatic.P.PLT.x <= (CRT.x * MazeStatic.Size)
                        && MazeStatic.P.PLT.x >= (CLT.x * MazeStatic.Size)
                        && MazeStatic.P.PLT.y <= (CRT.y * MazeStatic.Size)
                        && MazeStatic.P.PLB.y >= (CRB.y * MazeStatic.Size))
                        || (MazeStatic.P.PLT.y <= (CRB.y * MazeStatic.Size)
                        && MazeStatic.P.PLT.y >= (CRT.y * MazeStatic.Size)
                        && MazeStatic.P.PLT.x >= (CLB.x * MazeStatic.Size)
                        && MazeStatic.P.PLT.x <= (CRB.x * MazeStatic.Size))
                        || (MazeStatic.P.PLB.y >= (CRT.y * MazeStatic.Size)
                        && MazeStatic.P.PLB.y <= (CRB.y * MazeStatic.Size)
                        && MazeStatic.P.PLB.x >= (CLT.x * MazeStatic.Size)
                        && MazeStatic.P.PLB.x <= (CRT.x * MazeStatic.Size))) {
                    Castle = new ImageIcon("medal-icon.png");
                    ((Mazeframe) SwingUtilities.getWindowAncestor(MazeStatic.m)).countdownTimer.stop();
                    ZeroCasPt();
                    MazeStatic.t.stop();
                    endtime = false;
                    MazeStatic.ElapsedTime = MazeStatic.t.getElapsedTime();
                    MazeStatic.t.convertMillis(MazeStatic.ElapsedTime);
                    MazeStatic.minutes = MazeStatic.t.getMinutes();
                    MazeStatic.seconds = MazeStatic.t.getSeconds();
//                    MazeStatic.centiseconds = MazeStatic.t.getCentiseconds();
                    System.out.println("Elapsed Time " + MazeStatic.t.convertMillis(MazeStatic.ElapsedTime));
                    MazeStatic.s.CalculateScore();
                    System.out.println("Final Score left isssssss " + MazeStatic.FinalScore);
                }
            }
        } else if (Position.equalsIgnoreCase("Forward")) {
            if (GameStop) {
                if ((MazeStatic.P.PLB.y >= (CLT.y * MazeStatic.Size)
                        && MazeStatic.P.PLB.y <= (CLB.y * MazeStatic.Size)
                        && MazeStatic.P.PLB.x <= (MazeStatic.Size * CLT.x)
                        && MazeStatic.P.PRB.x >= (CRT.x * MazeStatic.Size))
                        || (MazeStatic.P.PLB.x >= (CLT.x * MazeStatic.Size)
                        && MazeStatic.P.PLB.x <= (CRT.x * MazeStatic.Size)
                        && MazeStatic.P.PLB.y >= (CLT.y * MazeStatic.Size)
                        && MazeStatic.P.PLB.y <= (CRB.y * MazeStatic.Size))
                        || (MazeStatic.P.PRB.x >= (CLT.x * MazeStatic.Size)
                        && MazeStatic.P.PRB.x <= (CRT.x * MazeStatic.Size)
                        && MazeStatic.P.PRB.y >= (CLT.y * MazeStatic.Size)
                        && MazeStatic.P.PRB.y <= (CLB.y * MazeStatic.Size))) {
                    Castle = new ImageIcon("medal-icon.png");
                    ((Mazeframe) SwingUtilities.getWindowAncestor(MazeStatic.m)).countdownTimer.stop();
                    ZeroCasPt();
                    MazeStatic.t.stop();
                    endtime = false;
                    MazeStatic.ElapsedTime = MazeStatic.t.getElapsedTime();
                    MazeStatic.t.convertMillis(MazeStatic.ElapsedTime);
                    MazeStatic.minutes = MazeStatic.t.getMinutes();
                    MazeStatic.seconds = MazeStatic.t.getSeconds();
//                    MazeStatic.centiseconds = MazeStatic.t.getCentiseconds();
                    System.out.println("Elapsed Time " + MazeStatic.t.convertMillis(MazeStatic.ElapsedTime));
                    MazeStatic.s.CalculateScore();
                    System.out.println("Final Score  f isssssss " + MazeStatic.FinalScore);
                }
            }
        } else if (Position.equalsIgnoreCase("Backward")) {
            if (GameStop) {
                if ((MazeStatic.P.PLT.y <= (CLT.y * MazeStatic.Size)
                        && MazeStatic.P.PLT.y >= (CLB.y * MazeStatic.Size)
                        && MazeStatic.P.PLT.x <= (CLB.x * MazeStatic.Size)
                        && MazeStatic.P.PRT.x >= (MazeStatic.Size * CLB.x))
                        || (MazeStatic.P.PLT.x >= (CLT.x * MazeStatic.Size)
                        && MazeStatic.P.PLT.x <= (CRT.x * MazeStatic.Size)
                        && MazeStatic.P.PLT.y <= (CLB.y * MazeStatic.Size)
                        && MazeStatic.P.PLT.y >= (CLT.y * MazeStatic.Size))
                        || (MazeStatic.P.PRT.x >= (CLB.x * MazeStatic.Size)
                        && MazeStatic.P.PRT.x <= (CRB.x * MazeStatic.Size)
                        && MazeStatic.P.PRT.y >= (CLT.y * MazeStatic.Size)
                        && MazeStatic.P.PRT.y <= (CLB.y * MazeStatic.Size))) {
                    Castle = new ImageIcon("medal-icon.png");
                    ((Mazeframe) SwingUtilities.getWindowAncestor(MazeStatic.m)).countdownTimer.stop();
                    ZeroCasPt();
                    MazeStatic.t.stop();
                    endtime = false;
                    MazeStatic.ElapsedTime = MazeStatic.t.getElapsedTime();
                    MazeStatic.t.convertMillis(MazeStatic.ElapsedTime);
                    MazeStatic.minutes = MazeStatic.t.getMinutes();
                    MazeStatic.seconds = MazeStatic.t.getSeconds();
                    System.out.println("Elapsed Time " + MazeStatic.t.convertMillis(MazeStatic.ElapsedTime));
                    MazeStatic.s.CalculateScore();
                    System.out.println("Final Score b isssssss " + MazeStatic.FinalScore);
                }
            }
        }
    }

    public void ZeroCasPt() {
        CLB.x = CLB.y = CRB.x = CRB.y = CLT.x = CLT.y = CRT.y = CRT.x = 0;
        GameStop = false;
    }

}
