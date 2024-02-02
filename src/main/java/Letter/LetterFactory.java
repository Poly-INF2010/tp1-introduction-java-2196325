package Letter;

import Point.Point2d;
import Shape.BaseShape;
import Shape.Rectangle;
import Shape.Ellipse;

public final class LetterFactory {

    final static Double maxHeight = 150.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;

    final static double barVerticalHeight = 120;
    final static double barVerticalWidth = 16;
    final static double barHorizontalHeight = 16;
    final static double barHorizontalWidth = 60;
    final static double ObliqueBarHeight = 120;
    final static double ObliqueBarWidth = 10;


    public static Rectangle newBarHorizontal() {
        return new Rectangle(barHorizontalWidth, barHorizontalHeight);
    }
    public static Rectangle newBarVertical() {
        return new Rectangle(barVerticalWidth, barVerticalHeight);
    }

    public static Rectangle newBarOblique(Rectangle obliqueBar, Double angle){
        return obliqueBar.rotate(angle);
    }

    public static BaseShape create_A()  {
        Rectangle horizontalBar = newBarHorizontal();
        Rectangle leftVerticalBar = newBarVertical();
        Rectangle rightVerticalBar = newBarVertical();

        // Translation et rotation du leftVerticalBar
        leftVerticalBar = leftVerticalBar.rotate(Math.PI / 12);
        leftVerticalBar = (Rectangle) leftVerticalBar.add(horizontalBar).translate(leftVerticalBar.cloneCoords(), new Point2d(-(barHorizontalWidth / 2.5 - barVerticalWidth / 2), 30.0));

        /**
         leftVerticalBar = leftVerticalBar.add(horizontalBar.clone().translate(new Point2d(-(barHorizontalWidth / 2.5 - barVerticalWidth / 2), 30.0)));
         rightVerticalBar = rightVerticalBar.add(horizontalBar.clone().translate(new Point2d((barHorizontalWidth / 2.5 - barVerticalWidth / 2), 30.0)));

         */
        // Translation et rotation du rightVerticalBar
        rightVerticalBar = rightVerticalBar.rotate(-Math.PI / 12);
        rightVerticalBar = (Rectangle) rightVerticalBar.add(horizontalBar).translate(rightVerticalBar.cloneCoords(), new Point2d((barHorizontalWidth / 2.5 - barVerticalWidth / 2), 30.0));

        return horizontalBar.add(leftVerticalBar).add(rightVerticalBar);
    }

    public static BaseShape create_B() {
        BaseShape createB = create_H();
        Rectangle leftVerticalBar = newBarVertical();
        Rectangle rightVerticalBar = newBarVertical();

        // Translation et rotation du leftVerticalBar
        leftVerticalBar = leftVerticalBar.rotate(Math.PI / 12);
        leftVerticalBar = (Rectangle) leftVerticalBar.add(createB).translate(leftVerticalBar.cloneCoords(),new Point2d(-(barHorizontalWidth / 2.5 - barVerticalWidth / 2), 30.0));

        // Translation et rotation du rightVerticalBar
        rightVerticalBar = rightVerticalBar.rotate(-Math.PI / 12);
        rightVerticalBar = (Rectangle) rightVerticalBar.add(createB).translate(rightVerticalBar.cloneCoords(), new Point2d((barHorizontalWidth / 2.5 - barVerticalWidth / 2), 30.0));

        createB.add(leftVerticalBar).add(rightVerticalBar);
        return createB;
    }

    public static BaseShape create_C() {
        BaseShape OEllipse = create_O();
        Rectangle barHorizontalMiddle = newBarOblique(newBarHorizontal(), Math.PI / 2);

        // Translation du barHorizontalMiddle
        barHorizontalMiddle =(Rectangle) barHorizontalMiddle.translate(barHorizontalMiddle.cloneCoords(), new Point2d((barHorizontalWidth / 2 - barVerticalWidth / 2), 0.0));



        return OEllipse.remove(barHorizontalMiddle);
    }

    public static BaseShape create_E() {
        Double degrees90 = Math.toRadians(90);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness / 2, spacing);
        BaseShape middleStripe = mainStripe.rotate(degrees90).translate(new Point2d(0.0, 0.0));

        BaseShape outsideEllipse =  new Ellipse(spacing , halfMaxHeight);
        for(Point2d point: outsideEllipse.getCoords()){
            if ((point.X() > 0.0) && (point.Y() > 0) && (point.Y() < 50))
                outsideEllipse.remove(point);
        }

        BaseShape insideEllipse =  new Ellipse(spacing -2 , halfMaxHeight - 5);
        for(Point2d point: insideEllipse.getCoords()){
            if ((point.X() > 0.0) && (point.Y() > 0.0) && (point.Y() < 50))
                insideEllipse.remove(point);
        }

        middleStripe.add(insideEllipse);
        middleStripe.add(outsideEllipse);
        return middleStripe;
    }

    public static BaseShape create_H() {
        Double degrees90 = Math.toRadians(90);
        Double spacing = stripeThickness * 4;
        BaseShape mainStripe = new Rectangle(stripeThickness / 2, halfMaxHeight);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-spacing / 2, 0.0));
        BaseShape middleStripe = new Rectangle(stripeThickness / 2, spacing / 2).rotate(degrees90).translate(new Point2d(0.0, 0.0));
        BaseShape rightStripe = mainStripe.translate(new Point2d(spacing / 2, 0.0));
        leftStripe.add(middleStripe);
        leftStripe.add(rightStripe);
        return leftStripe;
    }

    public static BaseShape create_N() {
        BaseShape createH = create_H();
        Rectangle barOblique = newBarOblique(newBarVertical(), -Math.PI / 12);

        // Translate et ajoute la barre oblique
        createH.add(barOblique.translate(new Point2d(0.0, -halfMaxHeight + barVerticalHeight / 2)));

        return createH;
    }

    public static BaseShape create_O() {
        BaseShape mainStripe = new Ellipse(stripeThickness * 3, halfMaxHeight);
        BaseShape insideStripe = new Ellipse(stripeThickness * 3 - 7, halfMaxHeight - 7);
        BaseShape secondInsideStripe = new Ellipse(stripeThickness * 3 - 14, halfMaxHeight - 14);
        mainStripe.add(insideStripe);
        mainStripe.add(secondInsideStripe);
        return mainStripe;
    }
}
