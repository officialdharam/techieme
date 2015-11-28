package com.patterns.creational.abstractfactory;

import com.patterns.creational.model.CopperNail;
import com.patterns.creational.model.Glue;
import com.patterns.creational.model.Nail;
import com.patterns.creational.model.TeakWood;
import com.patterns.creational.model.Wood;
import com.patterns.creational.model.YellowWoodGlue;

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
