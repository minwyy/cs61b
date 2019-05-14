/** simulator */
public class NBody {
	public static double readRadius(String filepath) {
		In in = new In(filepath);

		/* Obtain radius from the given txt file. */
		in.readInt();
		double radius = in.readDouble();
		return radius;
	}	
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


}

