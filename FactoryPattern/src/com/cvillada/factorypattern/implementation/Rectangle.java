/**
 * 
 */
package com.cvillada.factorypattern.implementation;

import com.cvillada.factorypattern.definition.Shape;

/**
 * @author Cristhian Andres Villada Garcia
 *
 */
public class Rectangle implements Shape {
	
	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}

}
