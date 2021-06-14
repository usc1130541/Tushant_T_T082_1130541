/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import Viewer.Maze;

public class Timer {

    private long startTime;
    private long endTime;
    private long minutes;
    private long seconds;
    //private long centiseconds;
    

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public Timer() {
        this.startTime = System.currentTimeMillis();
    }

    public void start() {
        if (Maze.starttime == true) {
            startTime = System.currentTimeMillis();
        }
    }

    public void stop() {
        if (MapCastle.endtime == true) {
            endTime = System.currentTimeMillis();
        }
    }

    public long getElapsedTime() {
        return endTime - startTime;
        
    }

    public String convertMillis(long millis) {    
        seconds = millis / 1000;
        minutes = seconds / 60;
        seconds = seconds % 60;
        minutes = minutes % 60;
        //centiseconds=seconds*1000;
        //centiseconds=millis % centiseconds;
        //centiseconds=centiseconds/100;
        return  + minutes + ":" + seconds ;//+ ":" + centiseconds;

    }

    /**
     * @return the minutes
     */
    public long getMinutes() {
        return minutes;
    }

    /**
     * @param minutes the minutes to set
     */
    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    /**
     * @return the seconds
     */
    public long getSeconds() {
        return seconds;
    }

    /**
     * @param seconds the seconds to set
     */
    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    /**
     * @return the centiseconds
     */
   // public long getCentiseconds() {
     //   return centiseconds;
    //}

    /**
     * @param centiseconds the centiseconds to set
     */
   // public void setCentiseconds(long centiseconds) {
     //   this.centiseconds = centiseconds;
    //}

}
