/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

public class Giftsfactory {
    
    public static Gifts getgift(String gifttype)
    {
        if(gifttype == null)
        {
            return null;
        }
        else if (gifttype.equalsIgnoreCase("Coins"))
        {
            return new Coins();
        }
        else if (gifttype.equalsIgnoreCase("Rings"))
        {
            return new Rings();
        }
        return null;
    }
    
}
