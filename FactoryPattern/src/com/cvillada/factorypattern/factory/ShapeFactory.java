/**
 * 
 */
package com.cvillada.factorypattern.factory;

import com.cvillada.factorypattern.definition.Shape;
import com.cvillada.factorypattern.implementation.Circle;
import com.cvillada.factorypattern.implementation.Rectangle;
import com.cvillada.factorypattern.implementation.Square;

/**
 * @author Cristhian Andres Villada Garcia
 *
 */
public class ShapeFactory {

	// use getShape method to get object of type shape
	public Shape getShape(String shapeType) {
		
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();

		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();

		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}

		return null;
	}

}
