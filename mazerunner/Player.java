package mazerunner;

import Controller.RunController;
import Controller.TimerController2;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Player implements KeyListener {

    public static Player instance;
    public BufferedImage P1 = Playerssets.StR;
    public int x, y;
    public Point PLT = new Point(), PLB = new Point(), PRT = new Point(), PRB = new Point();

    /* public int x_start,y_start,x_pos,y_pos;
     public Image offscreen;
     boolean moveup,movedown,moveleft,moveright = true;
     public Graphics d;
     boolean up,down,left,right;
     public BufferedImage w1,w2;*/
    private Player() {

        try {
            Playerssets.init();
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }

        PLT.x = PLB.x = MazeStatic.x_start;
        PLT.y = PRT.y = MazeStatic.y_start;
        PRT.x = PLT.x + 37;
        PLB.y = PLT.y + 37;
        PRB.x = PRT.x;
        PRB.y = PRT.y + 37;

       // System.out.println(PLT.x+"Positionnnnn ");
        UPPosition(MazeStatic.x_start, MazeStatic.y_start);

    }

    public static Player getInstance() {

        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
            
            RunController.Position2= "Right";
            TimerController2.flag = true;
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT){
            
            RunController.Position2= "Left";
            TimerController2.flag = true;
        
        }
        if (ke.getKeyCode()== KeyEvent.VK_UP)
        {
             
            RunController.Position2= "Backward";
            TimerController2.flag = true;
        }
        
        
        
         if (ke.getKeyCode()== KeyEvent.VK_DOWN)
        {
             
            RunController.Position2= "Forward";
            TimerController2.flag = true;
        }
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            // System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");
            MazeStatic.moveright = canright();
            //System.out.println(MazeStatic.moveright);
            if (MazeStatic.moveright == true) {
                MazeStatic.right = true;
            } else {
                MazeStatic.right = false;
            }
        } else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            MazeStatic.moveleft = canleft();
            if (MazeStatic.moveleft == true) {
                MazeStatic.left = true;
            } else {
                MazeStatic.left = false;
            }
        } else if (ke.getKeyCode() == KeyEvent.VK_UP) {
            MazeStatic.moveup = canup();
            if (MazeStatic.moveup == true) {
                MazeStatic.up = true;
            } else {
                MazeStatic.up = false;
            }
        } else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            MazeStatic.movedown = candown();
            if (MazeStatic.movedown == true) {
                MazeStatic.down = true;
            } else {
                MazeStatic.down = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            
            
             RunController.Position2= "Right";
            TimerController2.flag = true;

            MazeStatic.right = false;
            MazeStatic.PS = new RightState();
            MazeStatic.P.P1 = MazeStatic.PS.getStop();
        } else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            
             RunController.Position2= "Left";
            TimerController2.flag = true;
            MazeStatic.left = false;
            MazeStatic.PS = new LeftState();
            MazeStatic.P.P1 = MazeStatic.PS.getStop();
        } else if (ke.getKeyCode() == KeyEvent.VK_UP) {
            
             RunController.Position2= "Backward";
            TimerController2.flag = true;
            MazeStatic.up = false;
            MazeStatic.PS = new BackwardState();
            MazeStatic.P.P1 = MazeStatic.PS.getStop();
        } else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            
             RunController.Position2= "Forward";
            TimerController2.flag = true;
            MazeStatic.down = false;
            MazeStatic.PS = new ForwardState();
            MazeStatic.P.P1 = MazeStatic.PS.getStop();
        }
    }

    public boolean canright() {
        MazeStatic.x_pos = (MazeStatic.x_start + 40) / MazeStatic.Size;
        MazeStatic.y_pos = MazeStatic.y_start / MazeStatic.Size;
        MazeStatic.x_posl = MazeStatic.x_pos;
        MazeStatic.y_posl = (MazeStatic.y_start + 37) / MazeStatic.Size;
        if (MazeStatic.x_pos < 20 && MazeStatic.maze[MazeStatic.x_pos][MazeStatic.y_pos] == '0'
                && MazeStatic.maze[MazeStatic.x_posl][MazeStatic.y_posl] == '0') {
            return true;
        } else {
            return false;
        }
    }

    public boolean canleft() {
        MazeStatic.x_pos = (MazeStatic.x_start - 3) / MazeStatic.Size;
        MazeStatic.y_pos = MazeStatic.y_start / MazeStatic.Size;
        MazeStatic.x_posl = MazeStatic.x_pos;
        MazeStatic.y_posl = (MazeStatic.y_start + 37) / MazeStatic.Size;
        if (MazeStatic.x_pos >= 0 && MazeStatic.maze[MazeStatic.x_pos][MazeStatic.y_pos] == '0'
                && MazeStatic.maze[MazeStatic.x_posl][MazeStatic.y_posl] == '0') {
            return true;
        } else {
            return false;
        }
    }

    public boolean canup() {
        MazeStatic.x_pos = MazeStatic.x_start / MazeStatic.Size;
        MazeStatic.y_pos = (MazeStatic.y_start - 3) / MazeStatic.Size;
        MazeStatic.x_posl = (MazeStatic.x_start + 37) / MazeStatic.Size;
        MazeStatic.y_posl = MazeStatic.y_pos;
        if (MazeStatic.y_pos >= 0 && MazeStatic.maze[MazeStatic.x_pos][MazeStatic.y_pos] == '0'
                && MazeStatic.maze[MazeStatic.x_posl][MazeStatic.y_posl] == '0') {
            return true;
        } else {
            return false;
        }
    }

    public boolean candown() {
        MazeStatic.x_pos = MazeStatic.x_start / MazeStatic.Size;
        MazeStatic.y_pos = (MazeStatic.y_start + 40) / MazeStatic.Size;
        MazeStatic.x_posl = (MazeStatic.x_start + 37) / MazeStatic.Size;
        MazeStatic.y_posl = MazeStatic.y_pos;
        if (MazeStatic.y_pos < 16 && MazeStatic.maze[MazeStatic.x_pos][MazeStatic.y_pos] == '0'
                && MazeStatic.maze[MazeStatic.x_posl][MazeStatic.y_posl] == '0') {
            return true;
        } else {
            return false;
        }
    }

    public void UPPosition(int PositionX, int PositionY) {
        PLT.x = PLB.x = PositionX;
        PLT.y = PRT.y = PositionY;
        PRT.x = PLT.x + 37;
        PLB.y = PLT.y + 37;
        PRB.x = PRT.x;
        PRB.y = PRT.y + 37;
        //System.out.println(PLT.x+"Positionnnnn "+PLT.y);
    }

}
