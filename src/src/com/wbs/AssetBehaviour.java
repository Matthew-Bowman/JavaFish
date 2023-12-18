package com.wbs;

/**
 * AssetBehaviour Interface for the Assets
 * @author Matthew Bowman
 * @version 28.02.2023
 */

public interface AssetBehaviour {
    /**
     * METHOD: updates the state of the behaviour
     */
    public void update();

    /**
     * METHOD: gets the current x position
     * @return the current x position
     */
    public float getXPosition();

    /**
     * METHOD: gets the current y position
     * @return the current y position
     */
    public float getYPosition();

    /**
     * METHOD: returns the direction of movement
     * @return the direction of movement, -1 for Left and 1 for Right
     */
    public int getDirection();
}
