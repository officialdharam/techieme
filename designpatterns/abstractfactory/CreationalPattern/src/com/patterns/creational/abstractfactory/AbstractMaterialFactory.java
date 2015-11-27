package com.patterns.creational.abstractfactory;

import com.patterns.creational.model.Glue;
import com.patterns.creational.model.Nail;
import com.patterns.creational.model.Wood;

public interface AbstractMaterialFactory {
	public Wood getWood();

	public Nail getNail();

	public Glue getGlue();
}
