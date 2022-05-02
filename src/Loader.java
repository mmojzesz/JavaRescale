import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Loader {

    DataManager dm;

    Loader(DataManager dm){

        this.dm = dm;

    }

    void loadFiles(){

        File file = new File(dm.path);

        dm.files = file.listFiles();
        System.out.println("" + dm.files.length);

    }

    void rescale(int i){

        BufferedImage inImg = null;
        try {
            inImg = ImageIO.read(dm.files[i]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedImage outImg = new BufferedImage((int)(inImg.getWidth() * dm.scaleFactor), (int)(inImg.getHeight() * dm.scaleFactor), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = outImg.createGraphics();

        g2.drawImage(inImg, 0, 0, (int)(inImg.getWidth() * dm.scaleFactor), (int)(inImg.getHeight() * dm.scaleFactor), null);



        try {
            ImageIO.write(outImg, "PNG", new File("output/" + i + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        g2.dispose();

    }

}
