/** creat a Body class
*/
public class Body {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
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





}