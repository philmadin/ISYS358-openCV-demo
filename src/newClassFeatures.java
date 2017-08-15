
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;
import java.util.stream.Stream;

import javax.imageio.IIOException;

import org.opencv.core.Core;
import org.opencv.core.KeyPoint;
import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.features2d.*;
import org.opencv.objdetect.*;

class FeatureExtractor {
	public void run() {
		final File folder = new File("src/main/resources/Photos");
		Vector<Mat> imageArray = new Vector<Mat>();
		
		for (File tempFile : folder.listFiles()){
			Mat image_1 = Imgcodecs.imread(tempFile.toString());
			imageArray.add(image_1);
		}
		System.out.println("Images all read");
		int eye=0;

		Vector<MatOfKeyPoint> temper = new Vector<MatOfKeyPoint>();
		FeatureDetector detectoro = FeatureDetector.create(FeatureDetector.ORB);
		detectoro.detect(imageArray, temper);
		System.out.println(temper.size());
		CascadeClassifier classifier = new CascadeClassifier();
		classifier.
		for (MatOfKeyPoint tempo: temper){
			KeyPoint[] tempas = tempo.toArray();
			for(int i=0;i<=tempas.length-1;i=i+2){
				Imgproc.rectangle(imageArray.get(eye), tempas[i].pt, tempas[i+1].pt, new Scalar(0, 255, 0, 255));				
			}
			String filename = "faceDetection"+eye+".png";
			System.out.println(String.format("Writing %s", filename));
			Imgcodecs.imwrite(filename, imageArray.get(eye));
			eye++;
		}
		//try (Stream<Path> paths = Files.walk(Paths.get("src/main/resources/Photos"))) {

			//paths
			//.filter(Files::isRegularFile)
			//.forEach();
		//}catch (IOException e1) {
		//	e1.printStackTrace();
		//}
		/*File imagefile = new File("src/main/resources/lena.png");
		String imageString = imagefile.getAbsolutePath();
		Mat image_1 = Imgcodecs.imread(imageString);
		FeatureDetector detector = FeatureDetector.create(FeatureDetector.ORB);
		MatOfKeyPoint temp = new MatOfKeyPoint();
		detector.detect(image_1, temp);
		KeyPoint[] tempo = temp.toArray();
		System.out.println(tempo.length);
		System.out.println(tempo[0].pt+" TO "+tempo[1].pt);
		for(int i=0;i<=tempo.length-1;i=i+2){
			Imgproc.rectangle(image_1, tempo[i].pt, tempo[i+1].pt, new Scalar(0, 255, 0, 255));				
		}
		String filename = "faceDetection.png";
		System.out.println(String.format("Writing %s", filename));
		Imgcodecs.imwrite(filename, image_1);
		//detector.
		//FeatureDetector detector = FeatureDetector.create(FeatureDetector.SURF);
		//GFTTDetector temp;
		//temp=temp.create(100,);
		 * 
		 */
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
