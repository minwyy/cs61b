/** creat a Body class
*/
public class Body {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static double consG = 6.67e-11;
	/** first constructor to create an object with given arguments */
	public Body(double xP, double yP, double xV, 
					double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	/** second constructor to create an object identiy to a given object of Body */
	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}
	/** create object helper to get distance between bodies */
	public double calcDistance(Body other) {
		double xx = square(xxPos - other.xxPos);
		double yy = square(yyPos - other.yyPos);
		double dt = sqRoot(xx + yy);
		return dt;
	}
	
	/** create a square root helper for calculating distance */
	public static double sqRoot(double number) {
		double temp;

		double sr = number / 2;

		do {
			temp = sr;
			sr = (temp + (number / temp)) / 2;
		} while ((temp - sr) != 0);

		return sr;
    }
    /** create a square helper */
    public static double square(double number) {
    	double sq = number * number;
    	return sq;
    }
	/** create a method to calculate exerted force on the specific body */
	public double calcForceExertedBy(Body other) {
		double force = consG * mass * other.mass / square((calcDistance(other)));
		return force;
	}
	/** a method to get force exerted in the X directions */
	public double calcForceExertedByX(Body other) {
		double forceX = calcForceExertedBy(other) * (other.xxPos - xxPos) / calcDistance(other);
		return forceX;
	}
	/** a method to get force exerted in the Y directions */
	public double calcForceExertedByY(Body other) {
	double forceY = calcForceExertedBy(other) * (other.yyPos - yyPos) / calcDistance(other);
	return forceY;
	}
	/** a method to calculate net force exerted in the X direction by an ararry of bodies */
	public double calcNetForceExertedByX(Body[] bodies) {
		double netForceX = 0;
		for (Body s: bodies) {
			if (!equals(s)) {
				netForceX += calcForceExertedByX(s);
			}
		}
		return netForceX;
	}

	/** a method to calculate net force exerted in the Y direction by an ararry of bodies */
	public double calcNetForceExertedByY(Body[] bodies) {
		double netForceY = 0;
		for (Body s: bodies) {
			if (!equals(s)) {
				netForceY += calcForceExertedByY(s);
			}
		}
		return netForceY;
	}


}