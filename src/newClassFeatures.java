
import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.features2d.*;
class FeatureExtractor {
	  public void run() {
		    File imagefile = new File("src/main/resources/lena.png");
		    String imageString = imagefile.getAbsolutePath();
			
			
		    //File file = new File("src/main/resources/lena.png");
		    //String tempStr = file.getAbsolutePath();
		    System.out.println(imageString);
			Mat image_1 = Imgcodecs.imread(imageString);
			//Mat image_2 = Imgcodecs.imread(tempStr);
			//int minHessian = 400;
			FeatureDetector detector = FeatureDetector.create(FeatureDetector.SURF);
			//GFTTDetector temp;
			//temp=temp.create(100,);
	  }
	}
public class newClassFeatures {

	public static void main(String[] args) {


	    System.out.println("Hello, OpenCV");
	    // Load the native library.
	    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	    new FeatureExtractor().run();
		
		

	}

}
