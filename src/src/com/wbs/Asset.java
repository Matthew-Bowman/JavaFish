package com.wbs;
import org.marcprice.jff.interfaces.IDisplayObject;

/**
 * Asset Interface for the Asset manager
 * @author Matthew Bowman
 * @version 27.02.2023
 */


public interface Asset {
    /**
     * METHOD: updates the state of the Asset
     */
    public void update();

    /**
     * METHOD: A simple getter for the IDisplayObject field
     * @return the IDisplayObject of an Asset
     */
    public IDisplayObject getIDisplayObject();

    /**
     * METHOD: A simple getter for the AssetBehaviour field
     * @return the AssetBehaviour of an Asset
     */
    public AssetBehaviour getAssetBehaviour();
}
