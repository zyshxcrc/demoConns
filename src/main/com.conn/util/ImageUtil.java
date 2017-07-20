package util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2017/7/20.
 */
public class ImageUtil {
    public static void resizeImg(Image img,int width, int height,String fileName) throws Exception{
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        bufferedImage.getGraphics().drawImage(img,0,0,width,height,null);
        FileOutputStream outputStream = new FileOutputStream(fileName);
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
        encoder.encode(bufferedImage);
        outputStream.flush();
        outputStream.close();
    }
}
