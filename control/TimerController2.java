/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.Timer;
import mazerunner.Bomb1;
import mazerunner.Bomb2;
import mazerunner.FlamePosition;
import mazerunner.MazeStatic;
import mazerunner.Monster;
import mazerunner.Monster1;
import mazerunner.ReusablePool;
import mazerunner.Weapons;

public class TimerController2 extends JFrame implements ActionListener, KeyListener {
//public Weapons w = new Weapons();
    Timer t;
    public static FlamePosition F1 = new FlamePosition(0, 0);
    public static FlamePosition F2 = new FlamePosition(0, 0);
    public static  String Direction;
    public static boolean flag = false;
    boolean firstpress = true;
    Weapons temp;
    BufferedImage Sp = null;

    public TimerController2() {
        t = new Timer(80, this);
        t.start();
        setFocusable(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
        
        if(MazeStatic.fire)
        {
            
//                
         MazeStatic.m.repaint();
         System.out.println("String Recieved:mmmm " + Direction);
         MazeStatic.w.getFlameDirection(Direction);
         
         
         
         if ((F1.getX()/46)<20 &&(F1.getX()/46)>=0 && (F1.getY()/46)<16 &&  (F1.getY()/46)>=0){
         if (MazeStatic.maze[(F1.getX()) / 46][(F1.getY()) / 46] != '0' )
         {
                MazeStatic.maze[(F1.getX()) / 46][(F1.getY()) / 46] = '0';
                System.out.println("Wall Detected");
                MazeStatic.fire = false;
                
                
         }
         }
         
         
         
         for (int m = 0; m < Monster.position.size(); m++) {
             
             //if ((F1.getX() - 18) / 40 == Monster.position.get(m).random_j
             //&& (F1.getY() - 18) / 40 == Monster.position.get(m).random_i) {
            // System.out.println(Direction);
             if (Direction.equalsIgnoreCase("Right")) {

                if (F1.getX() >= (Monster.position.get(m).monsterx)
                        && F1.getX() <=(Monster.position.get(m).monsterx) + MazeStatic.Size
                        && F1.getY() <= (Monster.position.get(m).monstery)
                        && F1.getY() >= (Monster.position.get(m).monstery) + MazeStatic.Size
                        || (F1.getY() >= (Monster.position.get(m).monstery)
                        && F1.getY() <= (Monster.position.get(m).monstery) + MazeStatic.Size
                        && F1.getX() <= (Monster.position.get(m).monsterx)  + MazeStatic.Size
                        && F1.getX() >=(Monster.position.get(m).monsterx) 
                        || (F1.getY() >=(Monster.position.get(m).monstery) 
                        && F1.getY() <= (Monster.position.get(m).monstery)  + MazeStatic.Size
                        && F1.getX() <= (Monster.position.get(m).monsterx)  + MazeStatic.Size
                        && F1.getX() >= (Monster.position.get(m).monsterx) ))) {
             
            Monster.position.get(m).isdied = true;
             MazeStatic.fire = false;
            MazeStatic.FinalScore +=300;
             
              
             
             if (MazeStatic.FinalScore%1000==0)
             {
             ReusablePool.getInstance().release(temp);
             }
             
             }
             
             }
                else if (Direction.equalsIgnoreCase("left")) {

                if (F1.getX() <= (Monster.position.get(m).monsterx) + MazeStatic.Size
                        && F1.getX() >=(Monster.position.get(m).monsterx)  
                        && F1.getY() <= (Monster.position.get(m).monstery) 
                        && F1.getY() >= (Monster.position.get(m).monstery)  + MazeStatic.Size
                        || (F1.getY() <= (Monster.position.get(m).monstery) + MazeStatic.Size
                        && F1.getY() >= (Monster.position.get(m).monstery) 
                        && F1.getX() >= (Monster.position.get(m).monsterx) 
                        && F1.getX() <= (Monster.position.get(m).monsterx)  + MazeStatic.Size
                        || (F1.getY() >= (Monster.position.get(m).monstery)
                        && F1.getY() <= (Monster.position.get(m).monstery)  + MazeStatic.Size
                        && F1.getX() >= (Monster.position.get(m).monsterx) 
                        && F1.getX() <= (Monster.position.get(m).monsterx)  + MazeStatic.Size)))
                {
                   // Monster.position.remove(m);
                    Monster.position.get(m).isdied = true;
             MazeStatic.fire = false;
              MazeStatic.FinalScore +=300;
              
             
             if (MazeStatic.FinalScore%1000==0)
             {
             ReusablePool.getInstance().release(temp);
             }
             
             
                }
             
             
         }
             else if (Direction.equalsIgnoreCase("Forward")) {

                if (F1.getY() >= (Monster.position.get(m).monstery) 
                        && F1.getY() <= (Monster.position.get(m).monstery)  + MazeStatic.Size
                        && F1.getX() <= (Monster.position.get(m).monsterx) 
                        && F1.getX() >= (Monster.position.get(m).monsterx)  + MazeStatic.Size
                        || (F1.getX() >= (Monster.position.get(m).monsterx) 
                        && F1.getX() <= (Monster.position.get(m).monsterx)  + MazeStatic.Size
                        && F1.getY() >= (Monster.position.get(m).monstery) 
                        && F1.getY() <= (Monster.position.get(m).monstery)  + MazeStatic.Size
                        || (F1.getX() >=(Monster.position.get(m).monsterx)
                        && F1.getX() <= (Monster.position.get(m).monsterx) + MazeStatic.Size
                        && F1.getY() >= (Monster.position.get(m).monstery) 
                        && F1.getY() <= (Monster.position.get(m).monstery)  + MazeStatic.Size)))
                {
                    //Monster.position.remove(m);
                    Monster.position.get(m).isdied = true;
             MazeStatic.fire = false; 
              MazeStatic.FinalScore +=300;
             
              
             
             if (MazeStatic.FinalScore%1000==0)
             {
             ReusablePool.getInstance().release(temp);
             }
             
             
                }
             
             }
             
             else if (Direction.equalsIgnoreCase("Backward")) {
                if (F1.getY() <= (Monster.position.get(m).monstery) 
                        && F1.getY() >=(Monster.position.get(m).monstery)  + MazeStatic.Size
                        && F1.getX() <= (Monster.position.get(m).monsterx)
                        && F1.getX() >= (Monster.position.get(m).monsterx) 
                        || (F1.getX() >= (Monster.position.get(m).monsterx) 
                        && F1.getX() <= (Monster.position.get(m).monsterx)  + MazeStatic.Size
                        && F1.getY() <= (Monster.position.get(m).monstery)  + MazeStatic.Size
                        && F1.getY()>= (Monster.position.get(m).monstery) 
                        || (F1.getX() >=(Monster.position.get(m).monsterx) 
                        && F1.getX() <= (Monster.position.get(m).monsterx)  + MazeStatic.Size
                        && F1.getY() >= (Monster.position.get(m).monstery) 
                        && F1.getY() <= (Monster.position.get(m).monstery)  + MazeStatic.Size))) {
               
                //Monster.position.remove(m);
                    Monster.position.get(m).isdied = true;
             MazeStatic.fire = false; 
              MazeStatic.FinalScore +=300;
             
             
             
             if (MazeStatic.FinalScore%1000==0)
             {
             ReusablePool.getInstance().release(temp);
             }
             
             
                
                }
                }
             
         }
         
         for (int k = 0; k < Monster1.position1.size(); k++) {
           //  if ((F1.getX() - 18) / 40 == Monster1.position1.get(k).random_j
             //&& (F1.getY() - 18) / 40 == Monster1.position1.get(k).random_i) {
             if (Direction.equalsIgnoreCase("Right")) {

                if (F1.getX() >= (Monster1.position1.get(k).monsterx) 
                        && F1.getX() <=(Monster1.position1.get(k).monsterx)  + MazeStatic.Size
                        && F1.getY() <= (Monster1.position1.get(k).monstery) 
                        && F1.getY() >= (Monster1.position1.get(k).monstery)  + MazeStatic.Size
                        || (F1.getY() >= (Monster1.position1.get(k).monstery) 
                        && F1.getY() <= (Monster1.position1.get(k).monstery) + MazeStatic.Size
                        && F1.getX() <= (Monster1.position1.get(k).monsterx)  + MazeStatic.Size
                        && F1.getX() >=(Monster1.position1.get(k).monsterx) 
                        || (F1.getY() >=(Monster1.position1.get(k).monstery) 
                        && F1.getY() <= (Monster1.position1.get(k).monstery)  + MazeStatic.Size
                        && F1.getX() <= (Monster1.position1.get(k).monsterx)  + MazeStatic.Size
                        && F1.getX() >= (Monster1.position1.get(k).monsterx) ))){
             //Monster1.position1.remove(k);
                    Monster1.position1.get(k).isdied = true;
             MazeStatic.fire = false;
              MazeStatic.FinalScore +=300;
             
              
             
             if (MazeStatic.FinalScore%1000==0)
             {
             ReusablePool.getInstance().release(temp);
             }
             
             
                }
             }
             
             else if (Direction.equalsIgnoreCase("left")) {

                if (F1.getX() <= (Monster1.position1.get(k).monsterx) + MazeStatic.Size
                        && F1.getX() >=(Monster1.position1.get(k).monsterx)  
                        && F1.getY() <= (Monster1.position1.get(k).monstery)
                        && F1.getY() >= (Monster1.position1.get(k).monstery) + MazeStatic.Size
                        || (F1.getY() <= (Monster1.position1.get(k).monstery) + MazeStatic.Size
                        && F1.getY() >= (Monster1.position1.get(k).monstery) 
                        && F1.getX() >= (Monster1.position1.get(k).monsterx) 
                        && F1.getX() <= (Monster1.position1.get(k).monsterx)  + MazeStatic.Size
                        || (F1.getY() >= (Monster1.position1.get(k).monstery)
                        && F1.getY() <= (Monster1.position1.get(k).monstery)  + MazeStatic.Size
                        && F1.getX() >= (Monster1.position1.get(k).monsterx) 
                        && F1.getX() <= (Monster1.position1.get(k).monsterx)  + MazeStatic.Size)))
                {
                    //Monster1.position1.remove(k);
                    Monster1.position1.get(k).isdied = true;
             MazeStatic.fire = false;
              MazeStatic.FinalScore +=300;
             
              
             
             if (MazeStatic.FinalScore%1000==0)
             {
             ReusablePool.getInstance().release(temp);
             }
             
             
                
                }
             
             
             }
             
              else if (Direction.equalsIgnoreCase("Forward")) {

                if (F1.getY() >= (Monster1.position1.get(k).monstery) 
                        && F1.getY() <= (Monster1.position1.get(k).monstery)  + MazeStatic.Size
                        && F1.getX() <= (Monster1.position1.get(k).monsterx) 
                        && F1.getX() >= (Monster1.position1.get(k).monsterx)  + MazeStatic.Size
                        || (F1.getX() >= (Monster1.position1.get(k).monsterx)
                        && F1.getX() <= (Monster1.position1.get(k).monsterx)  + MazeStatic.Size
                        && F1.getY() >= (Monster1.position1.get(k).monstery) 
                        && F1.getY() <= (Monster1.position1.get(k).monstery) + MazeStatic.Size
                        || (F1.getX() >=(Monster1.position1.get(k).monsterx) 
                        && F1.getX() <= (Monster1.position1.get(k).monsterx)  + MazeStatic.Size
                        && F1.getY() >= (Monster1.position1.get(k).monstery) 
                        && F1.getY() <= (Monster1.position1.get(k).monstery)  + MazeStatic.Size)))
                {
                    //Monster1.position1.remove(k);
                    Monster1.position1.get(k).isdied = true;
             MazeStatic.fire = false; 
              MazeStatic.FinalScore +=300;
             
              
             
             if (MazeStatic.FinalScore%1000==0)
             {
             ReusablePool.getInstance().release(temp);
             }
             
             
                }
              }
             
              else if (Direction.equalsIgnoreCase("Backward")) {
                if (F1.getY() <= (Monster1.position1.get(k).monstery) 
                        && F1.getY() >=(Monster1.position1.get(k).monstery)  + MazeStatic.Size
                        && F1.getX() <= (Monster1.position1.get(k).monsterx) 
                        && F1.getX() >= (Monster1.position1.get(k).monsterx)
                        || (F1.getX() >= (Monster1.position1.get(k).monsterx) 
                        && F1.getX() <= (Monster1.position1.get(k).monsterx)  + MazeStatic.Size
                        && F1.getY() <= (Monster1.position1.get(k).monstery)  + MazeStatic.Size
                        && F1.getY()>= (Monster1.position1.get(k).monstery) 
                        || (F1.getX() >=(Monster1.position1.get(k).monsterx) 
                        && F1.getX() <= (Monster1.position1.get(k).monsterx)  + MazeStatic.Size
                        && F1.getY() >= (Monster1.position1.get(k).monstery) 
                        && F1.getY() <= (Monster1.position1.get(k).monstery)  + MazeStatic.Size))) {
               
                //Monster.position.remove(k);
                    Monster1.position1.get(k).isdied = true;
             MazeStatic.fire = false; 
              MazeStatic.FinalScore +=300;
             
              
             
             if (MazeStatic.FinalScore%1000==0)
             {
             ReusablePool.getInstance().release(temp);
             }
             
             
                
                }
                }
             

         }
         
         
         for (int k = 0; k < Bomb1.x.size(); k++) {
            if (Direction.equalsIgnoreCase("Right")) {

                if (F1.getX() >= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size
                        && F1.getX() <= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getY() <= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size
                        && F1.getY() >= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (F1.getY() >= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size
                        && F1.getY() <= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getX() <= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getX() >= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size
                        || (F1.getY() >= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size
                        && F1.getY() <= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getX() <= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getX() >= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size))) {
                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");

                    Bomb1.x.remove(k);
                    Bomb1.y.remove(k);
                    MazeStatic.fire = false; 
                   

                    }

                }
             else if (Direction.equalsIgnoreCase("left")) {
                if (F1.getX() <= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getX() >= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size
                        && F1.getY() <= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size
                        && F1.getY() >= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (F1.getY() <= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getY() >= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size
                        && F1.getX() >= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size
                        && F1.getX() <= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (F1.getY() >= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size
                        && F1.getY() <= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getX() >= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size
                        && F1.getX() <= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size + MazeStatic.Size))) {

                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
                    Bomb1.x.remove(k);
                    Bomb1.y.remove(k);
                    MazeStatic.fire = false; 
                  

                    }
                }
            else if (Direction.equalsIgnoreCase("Forward")) {
                    if (F1.getY() >= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size
                            && F1.getY() <= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                            && F1.getX() <= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size
                            && F1.getX() >= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                            || (F1.getX() >= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size
                            && F1.getX() <= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                            && F1.getY() >= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size
                            && F1.getY() <= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                            || (F1.getX() >= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size
                            && F1.getX() <= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                            && F1.getY() >= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size
                            && F1.getY() <= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size + MazeStatic.Size))) {
                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");

                        Bomb1.x.remove(k);
                        Bomb1.y.remove(k);
                        MazeStatic.fire = false; 
                        
                        }
                    }
                
                     else if (Direction.equalsIgnoreCase("Backward")) {
                        if (F1.getY() <= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size
                                && F1.getY() >= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                                && F1.getX() <= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size
                                && F1.getX() >= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size
                                || (F1.getX() >= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size
                                && F1.getX() <= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                                && F1.getY() <= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                                && F1.getY() >= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size
                                || (F1.getX() >= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size
                                && F1.getX() <= Integer.parseInt(Bomb1.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                                && F1.getY() >= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size
                                && F1.getY() <= Integer.parseInt(Bomb1.y.get(k)) * MazeStatic.Size + MazeStatic.Size))) {
                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");

                            Bomb1.x.remove(k);
                            Bomb1.y.remove(k);
                            MazeStatic.fire = false; 
                         

                            }
                        }
                    }
         
         for (int k = 0; k < Bomb2.x.size(); k++) {
            if (Direction.equalsIgnoreCase("Right")) {

                if (F1.getX() >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        && F1.getX() <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getY() <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && F1.getY() >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (F1.getY() >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && F1.getY() <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getX() <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getX() >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        || (F1.getY() >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && F1.getY() <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getX() <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getX() >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size))) {
                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");

                    Bomb2.x.remove(k);
                    Bomb2.y.remove(k);
                    MazeStatic.fire = false; 
                   

                    }

                }
             else if (Direction.equalsIgnoreCase("left")) {
                if (F1.getX() <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getX() >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        && F1.getY() <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && F1.getY() >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (F1.getY() <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getY() >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && F1.getX() >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        && F1.getX() <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (F1.getY() >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && F1.getY() <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && F1.getX() >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        && F1.getX() <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size))) {

                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
                    Bomb2.x.remove(k);
                    Bomb2.y.remove(k);
                    MazeStatic.fire = false; 
                  

                    }
                }
            else if (Direction.equalsIgnoreCase("Forward")) {
                    if (F1.getY() >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                            && F1.getY() <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                            && F1.getX() <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                            && F1.getX() >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                            || (F1.getX() >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                            && F1.getX() <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                            && F1.getY() >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                            && F1.getY() <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                            || (F1.getX() >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                            && F1.getX() <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                            && F1.getY() >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                            && F1.getY() <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size))) {
                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");

                        Bomb2.x.remove(k);
                        Bomb2.y.remove(k);
                        MazeStatic.fire = false; 
                        
                        }
                    }
                
                     else if (Direction.equalsIgnoreCase("Backward")) {
                        if (F1.getY() <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                                && F1.getY() >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                                && F1.getX() <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                                && F1.getX() >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                                || (F1.getX() >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                                && F1.getX() <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                                && F1.getY() <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                                && F1.getY() >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                                || (F1.getX() >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                                && F1.getX() <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                                && F1.getY() >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                                && F1.getY() <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size))) {
                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");

                            Bomb2.x.remove(k);
                            Bomb2.y.remove(k);
                            MazeStatic.fire = false; 
                         

                            }
                        }
                    }

        
        }
    }
        
    

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println("weapons");
        
        if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
           
            
            if (firstpress)
            {
                 ReusablePool.getInstance().setMaxPoolSize(10);
                
                firstpress = false;
            }

           if (!(ReusablePool.getInstance().isEmptyfreeList())){
            //System.out.println("weaponsaaaaaaaaaaaaaaaaaaaaaa");
            MazeStatic.fire = true;}
                   
            if (!flag)
            {
                F1.setX(46+7);
            F1.setY(46+7);
                
                
            }
            else {
            F1.setX(MazeStatic.P.PLT.x+15);
            F1.setY(MazeStatic.P.PLT.y+18);}
            
            
            temp=ReusablePool.getInstance().acquire();

            Direction = RunController.Position2;
            System.out.println("String Recieved:nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn " + Direction);
}
}
             

        
    

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

    



