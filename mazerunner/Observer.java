
package mazerunner;


public class Observer {
    
    public Long Update()
    {
     return MazeStatic.FinalScore;
    }
    
    public String setLabel()
            
    {
        String Message;
        if(Bomb.lives==0)
        {
             Message="You Lost!"+"\n"+MazeStatic.FinalScore+"";
        }
        else
        {
             Message="You WON! \n"+"Congrats!"+"\n"+MazeStatic.FinalScore+"";
        }
        
        return Message;
        
    }
    
    public static long updatescore()
    {
        return MazeStatic.FinalScore;
    }
    
    public static int updatelives()
    {
        return Bomb.lives;
    }
    public static int updateweapons()
    {
        return MazeStatic.weapons;
    }
    
    
}
