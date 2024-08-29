
import java.util.Stack;

public class Tower {
    private int xPosition;
    private int yPosition;
    private Stack<Rectangle> stack;
    private boolean isVisible;

    // Constructor
    public Tower(int numberOfDisks, int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.stack = new Stack<>();
        this.isVisible = false;

        // Crear y apilar los discos como Rectángulos
        for (int i = 0; i < numberOfDisks; i++) {
            int width = 20 + (numberOfDisks - i) * 20; // Ajusta el tamaño del disco
            int height = 10; // Altura fija para cada disco
            // El disco más grande debe estar en la parte inferior
            Rectangle disk = new Rectangle(xPosition, yPosition + (numberOfDisks - i - 1) * height, width, height,"blue");
            stack.push(disk);
        }
    }

    // Métodos para manejar la visibilidad
    public void makeVisible() {
        isVisible = true;
        draw();
    }
    private void draw() {
        if(isVisible) {
            for (Rectangle disk : stack) {
                disk.makeVisible(); // Hacer visible y dibujar cada disco en la pila
            }
        }
    }

    // Otros métodos pueden ser añadidos aquí...
}

