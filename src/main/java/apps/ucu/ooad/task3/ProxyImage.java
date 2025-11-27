package apps.ucu.ooad.task3;

import java.util.function.Function;

public class ProxyImage implements MyImage {
	private final String filename;
	private final Function<String, MyImage> imageFactory;
	private MyImage realImage;

	public ProxyImage(String filename) {
		this(filename, RealImage::new);
	}

	ProxyImage(String filename, Function<String, MyImage> imageFactory) {
		this.filename = filename;
		this.imageFactory = imageFactory;
	}

	@Override
	public void display() {
		if (realImage == null) {
			realImage = imageFactory.apply(filename);
		}
		realImage.display();
	}
}
