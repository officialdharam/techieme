package com.patterns.creational.abstractfactory;

import com.patterns.creational.model.Glue;
import com.patterns.creational.model.IronNail;
import com.patterns.creational.model.MahoganyWood;
import com.patterns.creational.model.Nail;
import com.patterns.creational.model.WhiteCraftGlue;
import com.patterns.creational.model.Wood;

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
