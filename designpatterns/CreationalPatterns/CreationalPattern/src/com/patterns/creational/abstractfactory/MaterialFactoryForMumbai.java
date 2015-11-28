package com.patterns.creational.abstractfactory;

import com.patterns.creational.abstractfactory.model.Glue;
import com.patterns.creational.abstractfactory.model.IronNail;
import com.patterns.creational.abstractfactory.model.MahoganyWood;
import com.patterns.creational.abstractfactory.model.Nail;
import com.patterns.creational.abstractfactory.model.WhiteCraftGlue;
import com.patterns.creational.abstractfactory.model.Wood;

public class MaterialFactoryForMumbai implements AbstractMaterialFactory {

	@Override
	public Wood getWood() {
		return new MahoganyWood();
	}

	@Override
	public Nail getNail() {
		return new IronNail();
	}

	@Override
	public Glue getGlue() {
		return new WhiteCraftGlue();
	}

}
