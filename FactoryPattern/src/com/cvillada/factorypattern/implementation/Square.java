/**
 * 
 */
package com.cvillada.factorypattern.implementation;

import com.cvillada.factorypattern.definition.Shape;

/**
 * @author Cristhian Andres Villada Garcia
 *
 */
public class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
	
}
