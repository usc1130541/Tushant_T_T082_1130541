/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import java.util.ArrayList;
import mazerunner.MazeStatic;

public class ReusablePool {  

public ArrayList <Weapons> freeList;
public ArrayList<Weapons> usedList;
private int size;
private static ReusablePool instance;



private ReusablePool()
{
    freeList = new ArrayList <Weapons>();
    usedList = new ArrayList <Weapons>();
    
}



public static ReusablePool getInstance()
{
    if (instance ==null)
        instance = new ReusablePool();
    return instance;
}





public Weapons acquire ()
{
    if (!freeList.isEmpty())
    {
        Weapons weap = freeList.remove(0);
        weap.x=MazeStatic.t2.F1.getX();
        weap.y = MazeStatic.t2.F1.getY();
        usedList.add (weap);
        return weap;
    }
    else return null;
}




public void release (Weapons weap){

if (usedList.remove(weap))
{
    weap.x = 0;
    weap.y = 0;
    freeList.add(weap);
}
else
    System.err.println("Error, no such object in the pool");


}

    

public void setMaxPoolSize (int size){

this.size = size;

for (int i=0;i<size;i++)
freeList.add(new Weapons());


}

public boolean isEmptyfreeList()
{
    if (freeList.isEmpty())
    {
        return true;
    }
    else return false;
}

public int freelistsize()
{
    return freeList.size();
}

public void freelistclear()
{
    freeList.clear();
}

}
