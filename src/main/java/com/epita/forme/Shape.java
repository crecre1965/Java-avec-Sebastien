package com.epita.forme;

public abstract class Shape {
	double area;
	int x;
	int y;
	
	public Shape() {
		area=20;
		x=0;
		y=0;
	
	} 
	
	void draw() {};
	abstract void translate(int x);
}
