package com.wbs;

/**
 * VerticalMovement is a class implementing AssetBehavior to control the asset
 * @author Matthew Bowman
 * @version 28.02.2023
 */

public class VerticalMovement implements AssetBehaviour {
    /*************** FIELDS ***************/
    // DECLARE a float for the lowest x position, call it _lowerX:
    private float _lowerX;

    // DECLARE a float for the highest x position, call it _upperX:
    private float _upperX;

    // DECLARE a float for the lowest y position, call it _lowerY:
    private float _lowerY;

    // DECLARE a float for the highest y position, call it _upperY:
    private float _upperY;

    // DECLARE a float for the x position, call it _xPosition:
    private float _xPosition;

    // DECLARE a float for the y position, call it _yPosition:
    private float _yPosition;

    // DECLARE a float for the movement speed, call it _speed:
    private float _speed;

    // DECLARE an Oscillator for the movement control, call it _oscillator:
    private Oscillator _oscillator;

    /*************** CONSTRUCTORS ***************/
    /**
     * VerticalMovement constructor
     * @param xPosition holds the x position in 2d space
     * @param yPosition holds the y position in 2d space
     * @param lowerY holds the lower y bound
     * @param upperY holds the upper y bound
     * @param speed hold the speed the coordinates should increment
     */
    public VerticalMovement(float xPosition, float yPosition, float lowerY, float upperY, float speed) {
        // ASSIGN parameters to fields:
        _lowerY = lowerY;
        _upperY = upperY;
        _xPosition = xPosition;
        _yPosition = yPosition;
        _speed = speed;

        // INSTANTIATE Oscillator:
        _oscillator = new Oscillator(Oscillator._directions.RIGHT, _yPosition, _speed, _lowerY, _upperY);
    }

    /*************** PUBLIC METHODS ***************/
    /**
     * METHOD: updates the state of the object
     */
    public void update() {
        // ASSIGN _xPosition to updated Oscillator:
        _yPosition = _oscillator.update();
    }

    /**
     * METHOD: A simple getter for the x float
     * @return the x coordinate
     */
    public float getXPosition() {
        return _xPosition;
    }

    /**
     * METHOD: A simple getter for the y float
     * @return the y coordinate
     */
    public float getYPosition() {
        return _yPosition;
    }

    /**
     * METHOD: A simple getter for the direction of movement
     * @return the direction either -1 for decrementing or 1 for incrementing
     */
    public int getDirection() {
        return 1;
    }

    /*************** PRIVATE METHODS ***************/
}
