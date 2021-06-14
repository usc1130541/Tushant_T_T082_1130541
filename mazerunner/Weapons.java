/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import Controller.TimerController2;
import javax.swing.ImageIcon;

public class Weapons {

    int x; int y;
    public ImageIcon fireball = new ImageIcon("fireball.png");
    
    public Weapons()
    {
       // x=0;
        //y=0;
        
    }
       
    public void getFlameDirection(String Position)
{
    if ( Position.equalsIgnoreCase("Left"))
    {
        //F2 = new FlamePosition( -40 ,0 );
         TimerController2.F2.setX(-30);
       
         TimerController2.F2.setY(0);
         TimerController2.F1.add( TimerController2.F2);
        //Maze.g.drawImage(fireball.getImage(), F1.getX(), F1.getY(), null);
        
    }
    else if (Position.equalsIgnoreCase("Right"))
    {
         //F2 = new FlamePosition( 40 ,0 );
          TimerController2.F2.setX(30);
          TimerController2.F2.setY(0);
         TimerController2.F1.add( TimerController2.F2);
        //Maze.g.drawImage(fireball.getImage(), F1.getX(), F1.getY(), null);
        
    }
    else if (Position.equalsIgnoreCase("Backward"))
    {
         //F2 = new FlamePosition( 0 ,-40 );
          TimerController2.F2.setX(0);
          TimerController2.F2.setY(-30);
         TimerController2.F1.add( TimerController2.F2);
        //Maze.g.drawImage(fireball.getImage(), F1.getX(), F1.getY(), null);
    }
    else if (Position.equalsIgnoreCase("Forward"))
    {
         //F2 = new FlamePosition( 0 ,40 );
          TimerController2.F2.setX(0);
          TimerController2.F2.setY(30);
         TimerController2.F1.add( TimerController2.F2);
        //Maze.g.drawImage(fireball.getImage(), F1.getX(), F1.getY(), null);
        
    }
}
    
    
    
}
