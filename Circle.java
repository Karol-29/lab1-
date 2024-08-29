import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0.  (15 July 2000) 
 */

public class Circle{

    public static final double PI=3.1416;
    
    private int diameter;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    private Random random;

    public Circle(){
        diameter = 30;
        xPosition = 20;
        yPosition = 15;
        color = "blue";
        isVisible = false;
        random = new Random();
    }
    public Circle(int diameter, int xPosition, int yPosition, String color, boolean isVisible) {
        this.diameter = diameter;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
        this.isVisible = isVisible;
        this.random = new Random();
        if (isVisible) {
            draw();
        }    
    }
    /**
     * Calculate the area of ​​the circle
     */    
    public double area(){
        double radius = diameter / 2.0;
        double area = PI * radius * radius;
        return area;
    }
    /**
     * Performs operations with the current area as appropriate the operation
     */
    public double change(char operador, int value) {
        double radius = diameter / 2.0;
        double area = PI * radius * radius;
        double newArea;
    
        switch (operador) {
            case '+':
                newArea = area + value;
                break;
            case '-':
                newArea = area - value;
                break;
            case '*':
                newArea = area * value;
                break;
            case '/':
                if (value != 0) {
                    newArea = area / value;
                } else {
                    return Double.NaN;
                }
                break;
            default:
                return Double.NaN;
        }
    
        return newArea;
    }

       
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    public void roll(int times, int maxDistance) {
        for (int i = 0; i < times; i++) {
            int distance = random.nextInt(maxDistance);
            int angle = random.nextInt(90); 
            double radians = Math.toRadians(angle);
            int deltaX = (int) (distance * Math.cos(radians));
            int deltaY = (int) (distance * Math.sin(radians));
            moveHorizontal(deltaX);
            moveVertical(deltaY);
        }
    }

    public void makeInvisible(){
        erase();
        isVisible = false;
    }

    private void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, 
                new Ellipse2D.Double(xPosition, yPosition, 
                diameter, diameter));
            canvas.wait(10);
        }
    }

    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    /**
     * Calculate the perimeter of the circle
     */
    public double perimeter() {
    return diameter * PI;
    }
    /**
     * Move the circle a few pixels to the rightt.
     */
    public void moveRight(){
        moveHorizontal(20);
    }

    /**
     * Move the circle a few pixels to the left.
     */
    public void moveLeft(){
        moveHorizontal(-20);
    }

    /**
     * Move the circle a few pixels up.
     */
    public void moveUp(){
        moveVertical(-20);
    }

    /**
     * Move the circle a few pixels down.
     */
    public void moveDown(){
        moveVertical(20);
    }

    /**
     * Move the circle horizontally.
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance){
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the circle vertically.
     * @param distance the desired distance in pixels
     */
    public void moveVertical(int distance){
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the circle horizontally.
     * @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the circle vertically
     * @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        }else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size.
     * @param newDiameter the new size (in pixels). Size must be >=0.
     */
    public void changeSize(int newDiameter){
        erase();
        diameter = newDiameter;
        draw();
    }

    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        color = newColor;
        draw();
    }



}
