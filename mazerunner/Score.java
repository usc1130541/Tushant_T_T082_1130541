/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import javax.swing.JLabel;

public class Score {
    

    
    public void CalculateScore() {
        if (MazeStatic.minutes == 0 && MazeStatic.seconds <= 44 ){//&& MazeStatic.centiseconds >= 0) {
            MazeStatic.FinalScore = MazeStatic.FinalScore + 500;
            //Mazeframe.setScoreLabel.setText("Score : "+ MazeStatic.FinalScore);
        } else if (MazeStatic.minutes == 0 && MazeStatic.seconds <= 59 ){//&& MazeStatic.centiseconds >= 0) {
            MazeStatic.FinalScore = MazeStatic.FinalScore + 400;
            //ScoreLabel.setText("Score : "+ MazeStatic.FinalScore);
        }else if (MazeStatic.minutes == 1 && MazeStatic.seconds <= 29 ){//&& MazeStatic.centiseconds >= 0) {
            MazeStatic.FinalScore = MazeStatic.FinalScore + 300;
           // ScoreLabel.setText("Score : "+ MazeStatic.FinalScore);
        }else if (MazeStatic.minutes == 1 && MazeStatic.seconds <= 59 ){//&& MazeStatic.centiseconds >= 0) {
            MazeStatic.FinalScore = MazeStatic.FinalScore + 200;
//            ScoreLabel.setText("Score : "+ MazeStatic.FinalScore);
        }else if (MazeStatic.minutes == 2 && MazeStatic.seconds <= 29 ){//&& MazeStatic.centiseconds >= 0) {
            MazeStatic.FinalScore = MazeStatic.FinalScore + 100;
//            ScoreLabel.setText("Score : "+ MazeStatic.FinalScore);
        }else if (MazeStatic.minutes == 2 && MazeStatic.seconds <= 59 ){//&& MazeStatic.centiseconds >= 0) {
            MazeStatic.FinalScore = MazeStatic.FinalScore + 50;
//            ScoreLabel.setText("Score : "+ MazeStatic.FinalScore);
        }else if (MazeStatic.minutes == 3 && MazeStatic.seconds <= 29 ){//&& MazeStatic.centiseconds >= 0) {
            MazeStatic.FinalScore = MazeStatic.FinalScore + 25;
////            ScoreLabel.setText("Score : "+ MazeStatic.FinalScore);
        }else if(MazeStatic.minutes>=4&&MazeStatic.seconds>=0){//&&MazeStatic.centiseconds>=0){
            MazeStatic.FinalScore=MazeStatic.FinalScore+0;
//            ScoreLabel.setText("Score : "+ MazeStatic.FinalScore);
        }
            
    }
}
