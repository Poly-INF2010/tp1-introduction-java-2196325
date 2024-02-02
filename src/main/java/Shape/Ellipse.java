package Shape;

import Point.Point2d;

import java.util.Collection;

public class Ellipse extends BaseShape {
    /** TODO
     * Create a filled Ellipse that is centered on (0, 0)
     * @param widthDiameter Width of the Ellipse
     * @param heightDiameter Height of the Ellipse
     */
    public Ellipse(Double widthDiameter, Double heightDiameter) {
        for ( double i = -widthDiameter/2; i< widthDiameter/2;i = i + 0.5 ){
            for ( double j = -heightDiameter/2; j < heightDiameter/2; j = j + 1) {
                if ( ((Math.pow(i,2.00) / Math.pow(widthDiameter/2,2)) + (Math.pow(j,2.00) / Math.pow(heightDiameter/2,2))) <=1 ) {
                    this.add(new Point2d(i,j));
                }
            }
        }
    }

    /** TODO
     * Create a filled Ellipse that is centered on (0,0)
     * @param dimensions 2D point containing the width and height of the Ellipse
     */
    public Ellipse(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
    }

    /**
     * Create an Ellipse from a given collection of 2D points
     * @param coords Collection of 2D points
     */
    private Ellipse(Collection<Point2d> coords) {
        Ellipse e = new Ellipse(coords);
        Point2d p = e.getMaxCoord();
        for ( double i = -Math.abs(p.X()); i< Math.abs(p.X());i = i + 0.5 ){
            for ( double j = -Math.abs(p.Y()); j < Math.abs(p.Y()); j = j + 0.5) {
                if ( ((Math.pow(i,2.00) / Math.pow(p.X(),2)) +(Math.pow(j,2.00) / Math.pow(p.Y(),2)))==1){
                    this.add(new Point2d(i,j));
                }
            }
        }
    }

    /**
     * // TODO appliquer la translation sur la forme.
     *     @Override
     *     public Ellipse translate(Point2d point) {
     *         return new Ellipse(translateAll(point));
     *     }
     *
     *     // TODO appliquer la rotation sur la forme.
     *     @Override
     *     public Ellipse rotate(Double angle) {
     *         return new Ellipse(rotateAll(angle));
     *     }
     */


    /** TODO
     * @return Deep Copy of the Ellipse
     */
    @Override
    public Ellipse clone() {
        return new Ellipse(this.getCoords());
    }
}
