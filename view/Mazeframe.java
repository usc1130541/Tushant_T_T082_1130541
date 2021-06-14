/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Controller.RunController;
import Controller.TimerController2;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import mazerunner.Bomb;
import mazerunner.MapCastle;
import mazerunner.MazeStatic;
import mazerunner.Monster;
import mazerunner.Observer;
import mazerunner.Player;
import static mazerunner.Monster.position;
import mazerunner.Monster1;
import static mazerunner.Monster1.position1;
import mazerunner.ReusablePool;

public class Mazeframe extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form Mazeframe
     */
    Graphics g;
    Player P;
    int i = 0;
    String Position;
    BufferedImage[] PSS;
    public static boolean RUN = true;
    public javax.swing.Timer countdownTimer;
    int seconds = 0;
    int minutes = 0;
    int C = 0;

    Random r = new Random();
    int rand0, rand1, rand2;
    int ran0, ran1, ran2;
    int flag = 0;
    

    public Mazeframe() {
       // if (Startmenu.begin == true)
        //{
        initComponents();
        g = getGraphics();

        this.setSize(1300, 1000);

        P = Player.getInstance();
        addKeyListener(P);
        Thread th = new Thread(this);
        th.start();
        Maze m = MazeStatic.m;
        this.setVisible(true);
        jPanel1.add(m);
        m.paintComponent(g);
        //repaint();
        ScoreLabel.setText("Score : " + MazeStatic.FinalScore);
        LivesLabel.setText("Remaining Lives : " + Bomb.lives);
        weapons.setText("Remaining Weapons : 10" );
        //TimeLabel.setText(String.valueOf(MazeStatic.d.+":"+sec));
        countdownTimer = new javax.swing.Timer(1000, new CountdownTimerListener());
        countdownTimer.start();
        TimerController2 fire = new TimerController2();
        addKeyListener (fire);
      //  }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ScoreLabel = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        LivesLabel = new javax.swing.JLabel();
        weapons = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        ScoreLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        ScoreLabel.setForeground(new java.awt.Color(0, 0, 153));
        ScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 4));

        timerLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        timerLabel.setForeground(new java.awt.Color(0, 0, 153));
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setText("00:00");
        timerLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 5));

        LivesLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        LivesLabel.setForeground(new java.awt.Color(0, 0, 153));
        LivesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LivesLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 4));

        weapons.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        weapons.setForeground(new java.awt.Color(0, 0, 153));
        weapons.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weapons.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 4));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(824, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LivesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(weapons, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(ScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LivesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(weapons, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(413, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mazeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mazeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mazeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mazeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mazeframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LivesLabel;
    private javax.swing.JLabel ScoreLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JLabel weapons;
    // End of variables declaration//GEN-END:variables
//

    class CountdownTimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            seconds++;
            if (seconds == 60) {
                minutes++;
                seconds = 0;
            }
            String min, sec;
            min = minutes + "";
            sec = seconds + "";
            if (sec.length() == 1) {
                sec = "0" + sec;
            }
            if (min.length() == 1) {
                min = "0" + min;
            }
            timerLabel.setText(String.valueOf(min + ":" + sec));

        }
    }

    @Override
    public void run() {

        END();
        

        RunController.init();

        while (RUN) {
            weapons.setText("Remaining Weapons : " + ReusablePool.getInstance().freelistsize());
            END();
            if (MazeStatic.left == true) {

                MazeStatic.rc.LeftAction(g);
                MazeStatic.left = false;
                CasEnd();
                updateLabel();
                updateLives();
            } else if (MazeStatic.right == true) {
                MazeStatic.rc.Rightaction(g);
                MazeStatic.right = false;
                CasEnd();
                updateLabel();
                updateLives();
            } else if (MazeStatic.up == true) {

                MazeStatic.rc.Backwardaction(g);
                MazeStatic.up = false;
                CasEnd();
                updateLabel();
                updateLives();
            } else if (MazeStatic.down == true) {
                MazeStatic.rc.ForwardAction(g);
                MazeStatic.down = false;

                CasEnd();
                updateLabel();
                updateLives();
            }
            //System.out.println("Coins " + Coins.score);
            //System.out.println("Rings " + Monster.position.size());
            // Get Random Motion
            if (flag == 1) {
               rand0 = detect(0, rand0);
                rand1 = detect(1, rand1);
                rand2 = detect(2, rand2);
                ran0 = detect1(0, ran0);
                ran1 = detect1(1, ran1);
                ran2 = detect1(2, ran2);
               }
            if (flag == 0) {
                rand0 = getrandom(0);
                rand1 = getrandom(1);
                rand2 = getrandom(2);
                ran0 = getrandom1(0);
                ran1 = getrandom1(1);
                ran2 = getrandom1(2);
                flag = 1;
            }
            
            // Monster Type 1
            if (rand0 == 0) {
             Monster.position.get(0).monstery--;
             } else if (rand0 == 1) {
             Monster.position.get(0).monstery++;
             } else if (rand0 == 2) {
             Monster.position.get(0).monsterx--;
             } else if (rand0 == 3) {
             Monster.position.get(0).monsterx++;
             }

             if (rand1 == 0) {
             Monster.position.get(1).monstery--;
             } else if (rand1 == 1) {
             Monster.position.get(1).monstery++;
             } else if (rand1 == 2) {
             Monster.position.get(1).monsterx--;
             } else if (rand1 == 3) {
             Monster.position.get(1).monsterx++;
             }

             if (rand2 == 0) {
             Monster.position.get(2).monstery--;
             } else if (rand2 == 1) {
             Monster.position.get(2).monstery++;
             } else if (rand2 == 2) {
             Monster.position.get(2).monsterx--;
             } else if (rand2 == 3) {
             Monster.position.get(2).monsterx++;
             }
             // Monster Type 2 
            if (ran0 == 0) {
             Monster1.position1.get(0).monstery--;
             } else if (ran0 == 1) {
             Monster1.position1.get(0).monstery++;
             } else if (ran0 == 2) {
             Monster1.position1.get(0).monsterx--;
             } else if (ran0 == 3) {
             Monster1.position1.get(0).monsterx++;
             }

             if (ran1 == 0) {
             Monster1.position1.get(1).monstery--;
             } else if (ran1 == 1) {
             Monster1.position1.get(1).monstery++;
             } else if (ran1 == 2) {
             Monster1.position1.get(1).monsterx--;
             } else if (ran1 == 3) {
             Monster1.position1.get(1).monsterx++;
             }

             if (ran2 == 0) {
             Monster1.position1.get(2).monstery--;
             } else if (ran2 == 1) {
             Monster1.position1.get(2).monstery++;
             } else if (ran2 == 2) {
             Monster1.position1.get(2).monsterx--;
             } else if (ran2 == 3) {
             Monster1.position1.get(2).monsterx++;
             }

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void updateLabel() {
        ScoreLabel.setText("Score : " + Observer.updatescore());
    }

    public void updateLives() {
        LivesLabel.setText("Remaining Lives : " + Observer.updatelives());
    }

    public void CasEnd() {
        if (MapCastle.endtime == false) {
            // this.setVisible(false);
            // new EndFrame().setVisible(true);
        }
    }

    public void END() {
        if (MapCastle.endtime == false || Bomb.lives == 0) {
            //System.out.println(MapCastle.endtime+"mmmmmmmm");

            this.setVisible(false);
            RUN = false;
            if (C == 0) {
                ENDframe x = new ENDframe();
                x.setVisible(true);
                x.setLocation(500, 0);
                MazeStatic.t.stop();
                MazeStatic.ElapsedTime = MazeStatic.t.getElapsedTime();
                MazeStatic.t.convertMillis(MazeStatic.ElapsedTime);
                MazeStatic.minutes = MazeStatic.t.getMinutes();
                MazeStatic.seconds = MazeStatic.t.getSeconds();

                C++;
            }

        }

    }

    // Get Random Motion
    public int getrandom(int x) {
        int ra = r.nextInt(4);
        if (((position.get(x).monstery - 5) / 46) > 0 &&
                MazeStatic.maze[position.get(x).monsterx / 46][((position.get(x).monstery - 5) / 46)] == '0' && ra == 0){
            return ra;
        } else if ( ((position.get(x).monstery + 40) / 46) < 16 && 
                MazeStatic.maze[position.get(x).monsterx / 46][((position.get(x).monstery + 40) / 46)] == '0' && ra == 1){
            return ra;
        } else if ( ((position.get(x).monsterx - 5) / 46) > 0 && 
                MazeStatic.maze[(position.get(x).monsterx - 5) / 46][(position.get(x).monstery / 46)] == '0' && ra == 2){
            return ra;
        } else if ( ((position.get(x).monsterx - 5) / 46) < 23 &&
                MazeStatic.maze[(position.get(x).monsterx + 40) / 46][(position.get(x).monstery / 46)] == '0' && ra == 3){
            return ra;
        } else {
            return getrandom(x);
        }
    }

    public int getrandom1(int x) {
        int ra = r.nextInt(4);
        if (((position1.get(x).monstery - 5) / 46) > 0 &&
                MazeStatic.maze[position1.get(x).monsterx / 46][((position1.get(x).monstery - 5) / 46)] == '0' && ra == 0) {
            return ra;
        } else if (((position1.get(x).monstery + 40) / 46) < 16 &&
                MazeStatic.maze[position1.get(x).monsterx / 46][((position1.get(x).monstery + 40) / 46)] == '0' && ra == 1 ) {
            return ra;
        } else if ( ((position1.get(x).monsterx - 5) / 46) > 0 &&
                MazeStatic.maze[(position1.get(x).monsterx - 5) / 46][(position1.get(x).monstery / 46)] == '0' && ra == 2 ) {
            return ra;
        } else if ( ((position1.get(x).monsterx +40) / 46) < 23 &&
                MazeStatic.maze[(position1.get(x).monsterx + 40) / 46][(position1.get(x).monstery / 46)] == '0' && ra == 3 ) {
            return ra;
        } else {
            return getrandom(x);
        }
    }

    // Detect Walls
    public int detect(int x, int r) {
        int num = r;
        if ((MazeStatic.maze[position.get(x).monsterx / 46][((position.get(x).monstery - 5) / 46)] == '1' && r == 0)
                || (((position.get(x).monstery - 5) / 46) == 0)) {
            num = getrandom(x);
        } else if ((MazeStatic.maze[position.get(x).monsterx / 46][((position.get(x).monstery + 40) / 46)] == '1' && r == 1)
                || (((position.get(x).monstery + 40) / 46) == 16)) {
            num = getrandom(x);
        } else if ((MazeStatic.maze[(position.get(x).monsterx - 5) / 46][(position.get(x).monstery / 46)] == '1' && r == 2)
                || (((position.get(x).monsterx - 5) / 46) == 0)) {
            num = getrandom(x);
        } else if ((MazeStatic.maze[(position.get(x).monsterx + 40) / 46][(position.get(x).monstery / 46)] == '1' && r == 3)
                || (((position.get(x).monsterx + 40) / 46) == 23)) {
            num = getrandom(x);
        }
        return num;
    }

    public int detect1(int x, int r) {
        int num = r;
        if ((MazeStatic.maze[position1.get(x).monsterx / 46][((position1.get(x).monstery - 5) / 46)] == '1' && r == 0)
                || (((position1.get(x).monstery - 5) / 46) == 0)) {
            num = getrandom1(x);
        } else if ((MazeStatic.maze[position1.get(x).monsterx / 46][((position1.get(x).monstery + 40) / 46)] == '1' && r == 1)
                || (((position1.get(x).monstery + 40) / 46) == 16)) {
            num = getrandom1(x);
        } else if ((MazeStatic.maze[(position1.get(x).monsterx - 5) / 46][(position1.get(x).monstery / 46)] == '1' && r == 2)
                || (((position1.get(x).monsterx - 5) / 46) == 0)) {
            num = getrandom1(x);
        } else if ((MazeStatic.maze[(position1.get(x).monsterx + 40) / 46][(position1.get(x).monstery / 46)] == '1' && r == 3)
                || (((position1.get(x).monsterx + 40) / 46) == 23)) {
            num = getrandom1(x);
        }
        return num;
    }

}
