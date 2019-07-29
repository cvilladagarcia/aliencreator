/**
 * 
 */
package com.cvillada.factorypattern.implementation;

import com.cvillada.factorypattern.definition.Shape;

/**
 * @author Cristhian Andres Villada Garcia
 *
 */
public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}

}
