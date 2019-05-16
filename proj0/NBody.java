/** simulator */
public class NBody {
	/** read radius from file. */
	public static String imageToDraw = "./images/starfield.jpg";
	public static double readRadius(String filepath) {
		In in = new In(filepath);

		/* Obtain radius from the given txt file. */
		in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	/** get a array of bodies from file. */	
	public static Body[] readBodies(String filepath) {
		In in = new In(filepath);
		int bodyNumber = in.readInt();
		Body[] bodies = new Body[bodyNumber];
		in.readDouble();
		for (int i = 0; i < bodyNumber; i++) {
			bodies[i] = new Body(in.readDouble(), in.readDouble(), in.readDouble(), 
				in.readDouble(), in.readDouble(), in.readString());
		}
		return bodies;
	}

	/** main method to the simulation work */
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("need 3 arugments");
		}			
		double t = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Body[] bodies = readBodies(filename); 
		/** Stick a copy of the image with specified universe radius. */
		/** Enables double buffering.
		  * A animation technique where all drawing takes place on the offscreen canvas.
		  * Only when you call show() does your drawing get copied from the
		  * offscreen canvas to the onscreen canvas, where it is displayed
		  * in the standard drawing window. */
		// StdDraw.enableDoubleBuffering();

		/** Sets up the universe so it goes from
		  * -radius to radius */
		double size = radius;
		StdDraw.setScale(-size, size);

		/* Clears the drawing window. */
		// StdDraw.clear();

		/* Stamps the copy of starfield.jpg with upscaled size. */
		StdDraw.picture(0, 0, imageToDraw, size*2, size*2);
		/* Draw planets in this universe. */
		for (Body s: bodies) {
			s.draw();
		}		
		/* Shows the drawing to the screen, and waits 2000 milliseconds. */
		// StdDraw.show();
		// StdDraw.pause(2000);
	}
}