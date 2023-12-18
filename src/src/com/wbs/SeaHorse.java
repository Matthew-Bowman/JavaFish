package com.wbs;

import org.marcprice.jff.interfaces.IDisplayObject;
import org.marcprice.jff.simulation.DisplayObject;

/**
 * JavaFish is a class that implements Asset to appear as a JavaFish
 * @author Matthew Bowman
 * @version 27.02.2023
 */

public class SeaHorse implements Asset {
    /*************** FIELDS ***************/
    // DECLARE a constant String for the texture path, call it _TEXTURE_NAME:
    private static final String _TEXTURE_NAME = "./textures/SeaHorse.png";

    // DECLARE a constant float for the lowest position on the x-axis, call it _LOWER_X:
    public static final float _LOWER_X = 0.025f;

    // DECLARE a constant float for the lowest position on the x-axis, call it _UPPER_X:
    public static final float _UPPER_X = 0.975f;

    // DECLARE a constant float for the lowest position on the x-axis, call it _LOWER_Y:
    public static final float _LOWER_Y = 0.045f;

    // DECLARE a constant float for the lowest position on the x-axis, call it _UPPER_Y:
    public static final float _UPPER_Y = 0.7f;

    // DECLARE an IDisplayObject for the Asset to be rendered onto the scene, call it _iDisplayObject:
    private IDisplayObject _iDisplayObject;

    // DECLARE an AssetBehaviour for the Assets update loop, call it _assetBehaviour:
    private AssetBehaviour _assetBehaviour;

    /*************** CONSTRUCTORS ***************/
    /**
     * JavaFish constructor to set up initial state
     * @param xPosition holds the starting x position
     * @param yPosition holds the starting y position
     * @param speed holds the movement speed
     */
    public SeaHorse(float xPosition, float yPosition, float speed, float scale) throws Exception {
        // INSTANTIATE IDisplayObject:
        _iDisplayObject = new DisplayObject(_TEXTURE_NAME, xPosition, yPosition, scale);

        // INSTANTIATE AssetBehaviour:
        _assetBehaviour = new DiagonalMovement(xPosition, yPosition, _LOWER_X, _UPPER_X, _LOWER_Y, _UPPER_Y, speed);
    }

    /*************** PUBLIC METHODS ***************/

    /**
     * METHOD: updates the state of the Asset
     */
    public void update() {
        // UPDATE the AssetBehaviour state:
        _assetBehaviour.update();

        // APPLY AssetBehaviour state to IDisplayObject:
        _iDisplayObject.setPositionX(_assetBehaviour.getXPosition());
        _iDisplayObject.setPositionY(_assetBehaviour.getYPosition());

        if(_assetBehaviour.getDirection() == -1)
            _iDisplayObject.setLeftFacing();
        else
            _iDisplayObject.setRightFacing();

    }

    /**
     * METHOD: A simple getter for the IDisplayObject field
     * @return the IDisplayObject instance
     */
    public IDisplayObject getIDisplayObject() {
        // RETURN IDisplayObject:
        return _iDisplayObject;
    }

    /**
     * METHOD: A simple getter for the AssetBehaviour field
     * @return the AssetBehaviour instance
     */
    public AssetBehaviour getAssetBehaviour() {
        return _assetBehaviour;
    }

    /*************** PRIVATE METHODS ***************/
}
