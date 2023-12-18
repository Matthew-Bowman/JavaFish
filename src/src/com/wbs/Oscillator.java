package com.wbs;

/**
 * A class to oscillate between two values
 *
 * @author Matthew Bowman
 * @version 13.11.2022
 */

public class Oscillator {
    /*************** MEMBER VARIABLES ***************/

    // DECLARE an enum to store the different directions the Oscillator can move, call it _directions:
    public enum _directions {
        LEFT(-1),
        RIGHT(1);
        _directions(int v) {
            value = v;
        }
        private int value;

        private int getValue() {
            return value;
        }
    }

    // DECLARE an int to hold the current direction of oscillation, call it _direction:
    private int _direction;

    // DECLARE a float to hold the current position, call it _position:
    private float _position;

    // DECLARE a float to hold the step amount, call it _step:
    private float _step;

    // DECLARE a float to hold the lower bound of the oscillation, call it _lower:
    private float _lower;

    // DECLARE a float to hold the upper bound of the oscillation, call it _upper:
    private float _upper;

    /*************** CONSTRUCTORS ***************/

    /**
     * A Class constructor to prepare the fields once instantiated
     * @param direction holds either -1 or 1 to control the direction
     * @param position holds the current position
     * @param step holds the value of how much to increment/decrement the position each call
     * @param lower holds the lowest possible position
     * @param upper holds the largest possible position
     */
    public Oscillator(_directions direction, float position, float step, float lower, float upper) {
        // ASSIGN direction to _direction:
        _direction = direction.getValue();

        // ASSIGN position to _position:
        _position = position;

        // ASSIGN step to _step:
        _step = step;

        // ASSIGN lower to _lower:
        _lower = lower;

        // ASSIGN upper to _upper:
        _upper = upper;
    }

    /*************** PUBLIC METHODS ***************/

    /**
     * METHOD: Increments/Decrements the position by step depending on the direction
     * @return the position of the oscillation
     */
    public float update() {
        // DECLARE a float called projectedPosition and set it to the next calculated position:
        float projectedPosition = _position + (_step * _direction);

        // CHECK if the projected position exceeds the bounds and flip the direction if true:
        if(projectedPosition < _lower || projectedPosition > _upper)
            _direction *= -1;

        // ASSIGN _position to the next position float:
        _position = _position + (_step * _direction);

        // RETURN the position:
        return _position;
    }

    /**
     * METHOD: returns the direction the oscillator is moving
     * @return an integer either -1 (Decrementing) or 1 (Incrementing)
     */
    public int getDirection() {
        return _direction;
    }
}
