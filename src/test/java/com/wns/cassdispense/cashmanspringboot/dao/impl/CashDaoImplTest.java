package com.wns.cassdispense.cashmanspringboot.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.wns.cassdispense.cashmanspringboot.model.DenominationModel;
import com.wns.cassdispense.cashmanspringboot.model.DenominationModelList;

@RunWith(MockitoJUnitRunner.class)
public class CashDaoImplTest {

	@InjectMocks
	private CashDaoImpl cashDaoImpl;

	@Test
	public void testAdd() {

		DenominationModelList denominationModelList = new DenominationModelList();
		List<DenominationModel> list = new ArrayList<>();
		DenominationModel model = new DenominationModel();

		model.setDenominationValue("20");
		model.setDenominationValueCount(100);

		DenominationModel model2 = new DenominationModel();

		model2.setDenominationValue("50");
		model2.setDenominationValueCount(100);

		list.add(model);
		list.add(model2);
		denominationModelList.setList(list);

		cashDaoImpl.addNotes(denominationModelList);
		Assert.assertTrue(denominationModelList.getList().size() != 0);

	}

	@Test
	public void testUpdateNote() {

		DenominationModelList denominationModelList = new DenominationModelList();
		List<DenominationModel> list = new ArrayList<>();
		DenominationModel model = new DenominationModel();

		model.setDenominationValue("20");
		model.setDenominationValueCount(30);

		DenominationModel model2 = new DenominationModel();

		model2.setDenominationValue("50");
		model2.setDenominationValueCount(30);

		list.add(model);
		list.add(model2);
		denominationModelList.setList(list);

		cashDaoImpl.updateNote(denominationModelList);
		Assert.assertTrue(denominationModelList.getList().size() != 0);
	}

	@Test
	public void testCounttnotes() {
		DenominationModelList countNotess = cashDaoImpl.countNotess();
		Assert.assertNotNull(countNotess);

	}
}
