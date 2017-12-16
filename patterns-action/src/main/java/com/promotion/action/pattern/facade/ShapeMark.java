package com.promotion.action.pattern.facade;

public class ShapeMark {

    private Shape rectangle;

    private Shape square;

    public ShapeMark() {
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }

}
