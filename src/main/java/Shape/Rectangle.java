package Shape;

import Point.Point2d;

import java.util.Collection;

public class Rectangle extends BaseShape {
    /** TODO
     * Create a filled rectangle centered on (0, 0)
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     */
    public Rectangle(Double width, Double height) {
        for(Double i = -width/2; i <= width/2;i +=0.5){
            for(Double j = -height/2; j <= height/2;j +=0.5){
                this.add(new Point2d(i,j));
            }
        }
    }

    /** TODO
     * Create a filled rectangle centered on (0, 0)
     * @param dimensions 2D point containing the width and height of the rectangle
     */
    public Rectangle(Point2d dimensions) {
        /** super();
         for (Double x = -dimensions.X(); x <= dimensions.X(); x += 0.5){
         for (Double y = -dimensions.Y(); y <= dimensions.Y(); y += 0.2) {
         add(new Point2d(new Double(x), new Double(y)));
         }
         }*/
        this(dimensions.X(), dimensions.Y());
    }

    /**
     * Create a rectangle from a given collection of Points
     * @param coords The collection of 2D points
     */
    private Rectangle(Collection<Point2d> coords) {
        super(coords); //constructeur classe mere
    }
    /**
     // TODO appliquer la translation sur la forme.
     @Override
     public Rectangle translate(Point2d point) {
     return new Rectangle(translateAll(point));
     }

     // TODO appliquer la rotation sur la forme.
     @Override
     public Rectangle rotate(Double angle) {
     return new Rectangle(rotateAll(angle));
     }*/


    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d translation) {
        return new Rectangle(super.translate(translation).getCoords());
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle) {
        return new Rectangle(super.rotate(angle).getCoords());
    }


    /** TODO
     * @return Deep copy of the rectangle
     */
    @Override
    public Rectangle clone() {
        return new Rectangle(this.getCoords());
    }


}
