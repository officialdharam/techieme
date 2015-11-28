package com.patterns.creational.abstractfactory;

import com.patterns.creational.abstractfactory.model.Glue;
import com.patterns.creational.abstractfactory.model.Nail;
import com.patterns.creational.abstractfactory.model.Wood;

public interface AbstractMaterialFactory {
	public Wood getWood();

	public Nail getNail();

	public Glue getGlue();
}
