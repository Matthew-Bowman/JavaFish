package com.wbs;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

/**
 * AssetManager manages the Asset types
 * @author Matthew Bowman
 * @version 27.02.2023
 */

public class AssetManager {
    /*************** FIELDS ***************/

    // DECLARE an ArrayList<Asset> for the Assets in a scene, call it _assets:
    private ArrayList<Asset> _assets;

    // DECLARE a Random for the random number generation, call it _random:
    private Random _random;

    // DECLARE a float for the lowest speed, call it _speedMin:
    private float _speedMin = 0.002f;

    // DECLARE a float for the highest speed, call it _speedMax:
    private float _speedMax = 0.003f;

    /*************** CONSTRUCTORS ***************/
    /**
     * Constructor for the AssetManager class
     */
    public AssetManager() {
        // INSTANTIATE ArrayList<Asset>:
        _assets = new ArrayList<Asset>();

        // INSTANTIATE Random:
        _random = new Random();
    }

    /*************** PUBLIC METHODS ***************/
    /**
     * METHOD: instantiates Asset objets and appends them _assets
     * @param requiredClass contains the class to create
     * @param amount contains the amount of objects to instantiate - MIN: 1 | MAX: 10
     * @param <T> a generic type extending from Asset
     */
    public<T extends Asset> void createAssets(Class<T> requiredClass, int amount) throws InvalidAmountException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // CHECK if amount is within specified range:
        if (amount < 1 || amount > 11)
            throw new InvalidAmountException();

        // DECLARE floats for the boundaries:
        float lowerX, upperX, lowerY, upperY;

        // TRY to get field constants for the boundaries of the Asset:
        try {
            // GET field constants:
            lowerX = (float) requiredClass.getDeclaredField("_LOWER_X").get(requiredClass);
            upperX = (float) requiredClass.getDeclaredField("_UPPER_X").get(requiredClass);
            lowerY = (float) requiredClass.getDeclaredField("_LOWER_Y").get(requiredClass);
            upperY = (float) requiredClass.getDeclaredField("_UPPER_Y").get(requiredClass);
        }
        catch (Exception e) {
            // DEFAULT field constants:
            lowerX = 0f;
            upperX = 1f;
            lowerY = 0f;
            upperY = 1f;

            // OUTPUT error:
            System.out.println("Could not get declared fields");
        }

        // ITERATE over amount:
        for(int i = 0; i < amount; i++) {
            // GENERATE the random positions & speed:
            float xPosition = generateRandomFloat(lowerX, upperX);
            float yPosition = generateRandomFloat(lowerY, upperY);
            float speed = generateRandomFloat(_speedMin, _speedMax);

            // TRY to instantiate the Asset and add it to _assets:
            try {
                Asset tempAsset = requiredClass.getDeclaredConstructor(float.class, float.class, float.class, float.class).newInstance(xPosition, yPosition, speed, 0.05f);
                _assets.add(tempAsset);
            } catch (Exception e) {
                System.out.println("Desired Asset subclass does not meet constructing requirements");
            }
        }
    }

    /**
     * METHOD: Iterates over each item in the _assets list and updates it
     */
    public void updateAssets() {
        // ITERATE over _assets to update each Asset:
        _assets.forEach(asset -> {
            asset.update();
        });
    }

    /**
     * METHOD: A getter for the _assets field
     * @return a list of Asset
     */
    public ArrayList<Asset> getAssets() {
        // RETURN _assets:
        return _assets;
    }

    /*************** PRIVATE METHODS ***************/

    /**
     * METHOD: Generates a random float between two values
     * @param min holds a float for the smallest possible value
     * @param max holds a float for the largest possible value
     * @return a random float
     */
    private float generateRandomFloat(float min, float max) {
        // GENERATE random float:
        float randomFloat = _random.nextFloat(min, max);

        // RETURN random float:
        return randomFloat;
    }
}
