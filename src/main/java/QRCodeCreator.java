import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.glxn.qrgen.javase.QRCode;

public class QRCodeCreator {

	public void CreateQRCode(String name, String encode, String des) {
		File f1 = new File(System.getProperty("user.dir") + "/" + name + ".png");
		System.out.println(System.getProperty("user.dir"));
		FileOutputStream out;
		try {
			out = new FileOutputStream(f1);
			QRCode.from(encode).writeTo(out);
			addText(f1, des);
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}
	}

	public void addText(File path, String text) {
		BufferedImage image;
		try {
			image = ImageIO.read(path);
			Graphics g = image.getGraphics();
			g.setFont(g.getFont().deriveFont(10f));
			g.setColor(Color.BLACK);
			FontMetrics metrics = g.getFontMetrics(g.getFont().deriveFont(10f));
			int x = (metrics.stringWidth(text)) / 2;
			if(x>=60){
				g.setFont(g.getFont().deriveFont(8f));
				metrics = g.getFontMetrics(g.getFont().deriveFont(8f));
				x = (metrics.stringWidth(text)) / 2;
			}
			g.drawString(text, 60-x, 120);
			g.dispose();

			ImageIO.write(image, "png", path);
			
		} catch (IOException e) {
			System.out.println("didnt work");
			e.printStackTrace();
		}

	}
}
