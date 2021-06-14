package Controller;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mazerunner.BackwardState;
import mazerunner.ForwardState;
import mazerunner.LeftState;
import Viewer.Maze;
import mazerunner.MazeStatic;
import Viewer.Mazeframe;
import mazerunner.Playerssets;
import mazerunner.RightState;

public class RunController extends JFrame {

    static int i;
    static String Position;
    static BufferedImage[] PSS;
    static Maze m;
    public static String Position2="Right";

    public RunController() {
        m = MazeStatic.m;
    }

    public static void init() {
        try {
            Playerssets.init();
        } catch (IOException ex) {
            Logger.getLogger(Mazeframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        MazeStatic.moveup = MazeStatic.movedown = MazeStatic.moveleft = MazeStatic.moveright = true;
        MazeStatic.x_pos = MazeStatic.y_pos = 0;
        MazeStatic.x_posl = MazeStatic.y_posl = 0;
        MazeStatic.x_start = MazeStatic.Size + 1;
        MazeStatic.y_start = MazeStatic.Size + 1;
        MazeStatic.PS = new RightState();
        MazeStatic.P.P1 = MazeStatic.PS.getStop();
    }

    public void LeftAction(Graphics g) {
        Position = "Left";
        Position2="Left";
        MazeStatic.x_start -= 3;
        MazeStatic.P.UPPosition(MazeStatic.x_start, MazeStatic.y_start);
        MazeStatic.Map.checkMAP(Position);
        MazeStatic.mo.check_position(Position);
        MazeStatic.mo1.check_position1(Position);
        MazeStatic.c.collectCoins(Position);
        MazeStatic.r.collectRings(Position);
        MazeStatic.Map.checkCAS(Position);
        MazeStatic.b1.bombaction(Position);
        MazeStatic.b2.bombaction(Position);

        MazeStatic.PS = new LeftState();
        PSS = MazeStatic.PS.getState();
        MazeStatic.P.P1 = PSS[i % 7];
        i++;
        if (i == 7) {
            i = 0;
        }

        repaint();
    }

    public void Rightaction(Graphics g) {
        Position = "right";
        Position2 = "right";
        //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
        MazeStatic.x_start += 3;
        MazeStatic.P.UPPosition(MazeStatic.x_start, MazeStatic.y_start);
        MazeStatic.Map.checkMAP(Position);
        MazeStatic.mo.check_position(Position);
        MazeStatic.mo1.check_position1(Position);
        MazeStatic.c.collectCoins(Position);
        MazeStatic.r.collectRings(Position);
        MazeStatic.Map.checkCAS(Position);
        MazeStatic.b1.bombaction(Position);
        MazeStatic.b2.bombaction(Position);

        MazeStatic.PS = new RightState();
        PSS = MazeStatic.PS.getState();
        MazeStatic.P.P1 = PSS[i % 7];
        i++;
        if (i == 7) {
            i = 0;
        }

        repaint();
    }

    public void Backwardaction(Graphics g) {
        Position = "Backward";
        Position2 = "Backward";
        //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
        MazeStatic.y_start -= 3;
        MazeStatic.P.UPPosition(MazeStatic.x_start, MazeStatic.y_start);
        MazeStatic.Map.checkMAP(Position);
        MazeStatic.mo.check_position(Position);
        MazeStatic.mo1.check_position1(Position);
        MazeStatic.c.collectCoins(Position);
        MazeStatic.r.collectRings(Position);
        MazeStatic.Map.checkCAS(Position);
        MazeStatic.b1.bombaction(Position);
        MazeStatic.b2.bombaction(Position);

        MazeStatic.PS = new BackwardState();
        PSS = MazeStatic.PS.getState();
        MazeStatic.P.P1 = PSS[i % 7];

        // MazeStatic.P.P1=Playerssets.Backward[i%7];
        i++;
        if (i == 7) {
            i = 0;
        }
        repaint();
    }

    public void ForwardAction(Graphics g) {
        Position = "Forward";
        Position2 = "Forward";
        //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
        MazeStatic.y_start += 3;
        MazeStatic.P.UPPosition(MazeStatic.x_start, MazeStatic.y_start);
        MazeStatic.Map.checkMAP(Position);
        MazeStatic.mo.check_position(Position);
        MazeStatic.mo1.check_position1(Position);
        MazeStatic.c.collectCoins(Position);
        MazeStatic.r.collectRings(Position);
        MazeStatic.Map.checkCAS(Position);
        MazeStatic.b1.bombaction(Position);
        MazeStatic.b2.bombaction(Position);
        //m=MazeStatic.m;
        //m.paintComponent(g);
        repaint();

        MazeStatic.PS = new ForwardState();
        PSS = MazeStatic.PS.getState();
        MazeStatic.P.P1 = PSS[i % 7];

        //MazeStatic.P.P1=Playerssets.Forward[i%7];
        i++;
        if (i == 7) {
            i = 0;
        }
    }
    
    public void update()
    {
        repaint();
    }

}
