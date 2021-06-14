package mazerunner;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Playerssets {

    public static BufferedImage StL;
    public static BufferedImage StR;
    public static BufferedImage StB;
    public static BufferedImage StF;
    public static BufferedImage[] Left= new BufferedImage[7];
    public static BufferedImage[] Right=new BufferedImage[7];
    public static BufferedImage[] Backward=new BufferedImage[7];
    public static BufferedImage[] Forward=new BufferedImage[7 ];

    public static final int Width = 37, Hight = 37;

    public static void init() throws IOException {
        BufferedImage Sp = null;
        try {
            Sp = ImageIO.read(new File("spritesheet1.png"));
           // System.out.println(Sp);
        } catch (IOException ex) {
            Logger.getLogger(Playerssets.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(Sp==null)
        {
            //System.out.println("NULL");
        }
        else
        {
            //System.out.println("Nourhan");
        }
        Spritesheet sheet = new Spritesheet(Sp);

        StF = Forward[0] = sheet.Crop(0, 0, Width, Hight);
        Forward[1] = sheet.Crop(Width, 0, Width, Hight);
        Forward[2] = sheet.Crop(Width * 2, 0, Width, Hight);
        Forward[3] = sheet.Crop(Width * 3, 0, Width, Hight);
        Forward[4] = sheet.Crop(0, Hight, Width, Hight);
        Forward[5] = sheet.Crop(Width, Hight, Width, Hight);
        StB = Backward[0] = sheet.Crop(Width * 2, Hight, Width, Hight);
        Backward[1] = sheet.Crop(Width * 3, Hight, Width, Hight);
        Backward[2] = sheet.Crop(Width * 4, Hight, Width, Hight);
        Backward[3] = sheet.Crop(0, Hight * 2, Width, Hight);
        Backward[4] = sheet.Crop(Width, Hight * 2, Width, Hight);
        Backward[5] = sheet.Crop(Width * 2, Hight * 2, Width, Hight);
        Backward[6] = sheet.Crop(Width * 3, Hight * 2, Width, Hight);
        StL = Left[0] = sheet.Crop(Width * 4, Hight * 2, Width, Hight);
        Left[1] = sheet.Crop(0, Hight * 3, Width, Hight);
        Left[2] = sheet.Crop(Width, Hight * 3, Width, Hight);
        Left[3] = sheet.Crop(Width * 2, Hight * 3, Width, Hight);
        Left[4] = sheet.Crop(Width * 3, Hight * 3, Width, Hight);
        Left[5] = sheet.Crop(Width * 4, Hight * 3, Width, Hight);
        Left[6] = sheet.Crop(0, Hight * 4, Width, Hight);
        StR = Right[0] = sheet.Crop(Width, Hight * 4, Width, Hight);
        Right[1] = sheet.Crop(Width * 2, Hight * 4, Width, Hight);
        Right[2] = sheet.Crop(Width * 3, Hight * 4, Width, Hight);
        Right[3] = sheet.Crop(Width * 4, Hight * 4, Width, Hight);
        Right[4] = sheet.Crop(0, Hight * 5, Width, Hight);
        Right[5] = sheet.Crop(Width, Hight * 5, Width, Hight);
        Right[6] = sheet.Crop(Width * 2, Hight * 5, Width, Hight);
        //System.out.println(Left.length+"MM"+Right.length+"MM"+Forward.length+"MM"+Backward.length);

    }

}
