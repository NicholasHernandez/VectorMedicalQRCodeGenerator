import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import net.glxn.qrgen.javase.QRCode;

public class QRCodeCreator {
	
	public void CreateQRCode(String name, String encode){
		File f1 = new File(System.getProperty("user.dir")+"/"+name+".png");
		System.out.println(System.getProperty("user.dir"));
		FileOutputStream out;
		try {
			out = new FileOutputStream(f1);
			QRCode.from(encode).writeTo(out);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
			
		}
	}
}
