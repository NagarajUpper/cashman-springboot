package com.wns.cassdispense.cashmanspringboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.wns.cassdispense.cashmanspringboot.dao.CashDao;
import com.wns.cassdispense.cashmanspringboot.model.DenominationModel;
import com.wns.cassdispense.cashmanspringboot.model.DenominationModelList;
import com.wns.cassdispense.cashmanspringboot.service.impl.CashServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CashServiceImplTest {

	@InjectMocks
	private CashServiceImpl cashServiceImpl;

	@Mock
	private CashDao cashDao;

	@Test
	public void tesAddNotest() {

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

		cashServiceImpl.addNotes(denominationModelList);
		Assert.assertTrue(denominationModelList.getList().size() != 0);
	}

	@Test
	public void testCountNotes() {

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

		Mockito.when(cashDao.countNotess()).thenReturn(denominationModelList);
		cashServiceImpl.countNotes();
		Assert.assertTrue(denominationModelList.getList().size() == 2);

	}

	@Test
	public void testGetcash() {

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

		Mockito.when(cashDao.countNotess()).thenReturn(denominationModelList);

		String getcash = cashServiceImpl.getcash(100);
		String expected = "50 Notes are:2 & 20 Notes are : 0 has been issued";

		Assert.assertEquals(getcash, expected);

	}
	
	@Test
	public void testGetcashCase1() {

		DenominationModelList denominationModelList = new DenominationModelList();
		List<DenominationModel> list = new ArrayList<>();
		DenominationModel model = new DenominationModel();

		model.setDenominationValue("20");
		model.setDenominationValueCount(10);

		DenominationModel model2 = new DenominationModel();

		model2.setDenominationValue("50");
		model2.setDenominationValueCount(10);

		list.add(model);
		list.add(model2);
		denominationModelList.setList(list);

		Mockito.when(cashDao.countNotess()).thenReturn(denominationModelList);

		String getcash = cashServiceImpl.getcash(80);
		String expected = "50 Notes are:1 & 20 Notes are : 1 has been issued";

		Assert.assertEquals(getcash, expected);

	}

	@Test
	public void testGetcashCase2() {

		DenominationModelList denominationModelList = new DenominationModelList();
		List<DenominationModel> list = new ArrayList<>();
		DenominationModel model = new DenominationModel();

		model.setDenominationValue("20");
		model.setDenominationValueCount(20);

		DenominationModel model2 = new DenominationModel();

		model2.setDenominationValue("50");
		model2.setDenominationValueCount(4);

		list.add(model);
		list.add(model2);
		denominationModelList.setList(list);

		Mockito.when(cashDao.countNotess()).thenReturn(denominationModelList);

		String getcash = cashServiceImpl.getcash(50);
		String expected = "50 Notes are:1 & 20 Notes are : 0 has been issued";

		Assert.assertEquals(getcash, expected);

	}

	@Test
	public void testGetcashCase3() {

		DenominationModelList denominationModelList = new DenominationModelList();
		List<DenominationModel> list = new ArrayList<>();
		DenominationModel model = new DenominationModel();

		model.setDenominationValue("20");
		model.setDenominationValueCount(10);

		DenominationModel model2 = new DenominationModel();

		model2.setDenominationValue("50");
		model2.setDenominationValueCount(1);

		list.add(model);
		list.add(model2);
		denominationModelList.setList(list);

		Mockito.when(cashDao.countNotess()).thenReturn(denominationModelList);

		String getcash = cashServiceImpl.getcash(40);
		String expected = "50 Notes are:0 & 20 Notes are : 2 has been issued";

		Assert.assertEquals(getcash, expected);

	}

	@Test
	public void testGetcashCase4() {

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

		Mockito.when(cashDao.countNotess()).thenReturn(denominationModelList);

		String getcash = cashServiceImpl.getcash(150);
		String expected = "50 Notes are:3 & 20 Notes are : 0 has been issued";

		Assert.assertEquals(getcash, expected);

	}


}