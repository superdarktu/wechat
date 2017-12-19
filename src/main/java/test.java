import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;


public class test {

	public static void main(String[] args) throws Exception {
		
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
	//	InputStream inputstream = new FileInputStream();
		
		ImageInputStream iis = ImageIO.createImageInputStream(new File(Thread.currentThread().getContextClassLoader().getResource("").toString().replace("file:/", "")+"a.jpg"));
		Iterator readers = ImageIO.getImageReaders(iis);
		
		System.out.println(iis.length());
		
		ImageReader reader = (ImageReader)readers.next();
		reader.setInput(iis);
		
		System.out.println(reader.toString());
		System.out.println(reader.getHeight(0));
		System.out.println(reader.getWidth(0));
	}
}
