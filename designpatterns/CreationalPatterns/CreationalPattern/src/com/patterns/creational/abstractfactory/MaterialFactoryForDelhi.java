package com.patterns.creational.abstractfactory;

import com.patterns.creational.abstractfactory.model.CopperNail;
import com.patterns.creational.abstractfactory.model.Glue;
import com.patterns.creational.abstractfactory.model.Nail;
import com.patterns.creational.abstractfactory.model.TeakWood;
import com.patterns.creational.abstractfactory.model.Wood;
import com.patterns.creational.abstractfactory.model.YellowWoodGlue;

public class MaterialFactoryForDelhi implements AbstractMaterialFactory {

	@Override
	public Wood getWood() {
		return new TeakWood();
	}

	@Override
	public Nail getNail() {
		return new CopperNail();
	}

	@Override
	public Glue getGlue() {
		return new YellowWoodGlue();
	}

}
