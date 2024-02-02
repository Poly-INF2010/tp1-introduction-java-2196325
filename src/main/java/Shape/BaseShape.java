package Shape;

import Interface.Transform;
import Point.Point2d;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape extends Transform implements Cloneable {
    private final Collection<Point2d> coords;

    //helper function to clone a list of points
    public Collection<Point2d> cloneCoords(Collection<Point2d> coords) {
        return coords.stream().map(Point2d::clone).collect(Collectors.toList());
    }

    /** TODO
     * Create a BaseShape with empty coordinades
     */
    public BaseShape() {
        this.coords = new ArrayList<Point2d>();
    }

    /** TODO
     * Create a BaseShape from a collection of 2D points
     * @param coords The collection of 2D points
     */
    public BaseShape(Collection<Point2d> coords) {
        this();
        for (Point2d i: coords) {
            this.coords.add(i.clone());
        }
    }

    /** TODO
     * Add a deep copy of the 2D point to the Shape
     * @param coord 2D point to add
     * @return Updated BaseShape
     */
    public BaseShape add(Point2d coord) {
        this.coords.add(coord.clone());
        return this;
    }

    /** TODO
     * Add a deep copy of the 2D points of the shape to the current shape
     * @param shape Shape to add to the current shape
     * @return Updated BaseShape
     */
    public BaseShape add(BaseShape shape) {
        for (Point2d i: shape.coords )
        {
            this.add(i);
        }
        return this;
    }

    /** TODO
     * Add a deep copy of the points in the collection to the shape
     * @param coords Collections of point to add
     * @return Updated BaseShape
     */
    public BaseShape addAll(Collection<Point2d> coords) {
        for (Point2d i:coords) {
            this.coords.add(i.clone());
        }
        return this;
    }

    /** TODO
     * Remove the 2D point from the shape
     * @param coord Point to remove
     * @return Updated BaseShape
     */
    public BaseShape remove(Point2d coord) {
        coords.remove(coord);
        return this;
    }

    /** TODO
     * Remove the 2D points in the shape from the current shape
     * @param shape Shape containing the points to remove
     * @return Updated BaseShape
     */
    public BaseShape remove(BaseShape shape) {
        for (Point2d i: shape.coords ) {
            if(this.coords.contains(i)){
                coords.remove(i);
            }
        }
        return this;
    }

    /** TODO
     * Remove the 2D points in the collection from the current shape
     * @param coords Collection of 2D points to remove
     * @return Updated BaseShape
     */
    public BaseShape removeAll(Collection<Point2d> coords) {
        for (Point2d i: coords ) {
            if(this.coords.contains(i)){
                this.remove(i);
            }
        }
        return this;
    }

    /** TODO
     *  Replace all the coords in a shape with new ones
     * @param newCoords new coords to replace the old one
     * @return Updated BaseShape
     * */
    public BaseShape replaceAll(Collection<Point2d> newCoords) {
        this.coords.clear(); // Clear current coordinates
        this.addAll(newCoords); // Add new coordinates
        return this;
    }

    /** TODO
     * Return a shallow copy of the coordinates of the shape
     * @return Shallow copy of all coordinates contained by this BaseShape
     */
    public Collection<Point2d> getCoords() {
        Collection<Point2d> copy = new ArrayList<>(this.coords);
        return copy;
    }

    /** TODO
     * Create and return a deep copy of the coordinates of the shape
     * @return Deep copy of all coordinates contained by this BaseShape
     */
    public Collection<Point2d> cloneCoords() {
        //return coords.stream().map(Point2d::clone).collect(Collectors.toList());
        Collection<Point2d> copyCoords = new ArrayList<Point2d>();
        for (Point2d i: this.coords ) {
            copyCoords.add(i.clone());
        }
        return copyCoords;
    }

    /** TODO
     * @return Maximum X coordinate of the shape
     */
    public Double getMaxX() {
        //return Collections.max(this.coords, Comparator.comparing(Point2d::X)).X();
        double pointX= - Double.MAX_VALUE ;
        for (Point2d i: this.coords) {
            if(i.X() >pointX){
                pointX = i.X();
            }
        }
        return pointX;
    }

    /** TODO
     * @return Maximum Y coordinate of the shape
     */
    public Double getMaxY() {
        Double pointY=-Double.MAX_VALUE;
        for (Point2d i: this.coords) {
            if(i.Y() >pointY){
                pointY = i.Y();
            }
        }
        return pointY;
    }

    /** TODO
     * @return 2D Point containing the maximum X and Y coordinates of the shape
     */
    public Point2d getMaxCoord() {
        return new Point2d(getMaxX(),getMaxY());
    }

    /** TODO
     * @return Minimum X coordinate of the shape
     */
    public Double getMinX() {
        double pointX=  Double.MAX_VALUE ;
        for (Point2d i: this.coords) {
            if(i.X() < pointX){
                pointX = i.X();
            }
        }
        return pointX;
    }

    /** TODO
     * @return Minimum Y coordinate of the shape
     */
    public Double getMinY() {
        Double pointY=Double.MAX_VALUE;
        for (Point2d i: this.coords) {
            if(i.Y() < pointY){
                pointY = i.Y();
            }
        }
        return pointY;
    }

    /** TODO
     * @return 2D point containing the minimum X and Y coordinate of the shape
     */
    public Point2d getMinCoord() {
        return new Point2d(getMinX(),getMinY());
    }


    public BaseShape translate(Point2d translation) {
        Collection<Point2d> translatedCoords = new ArrayList<>();
        for (Point2d point : this.coords) {
            translatedCoords.add(point.translate(translation));
        }
        return new BaseShape(translatedCoords);
    }

    public BaseShape rotate(Double angle) {
        Collection<Point2d> rotatedCoords = new ArrayList<>();
        for (Point2d point : this.coords) {
            rotatedCoords.add(point.rotate(angle));
        }
        return new BaseShape(rotatedCoords);
    }



    /** TODO
     * @return Deep copy of the current shape
     */
    public BaseShape clone() {
        return new BaseShape(this.coords);
    }
}
