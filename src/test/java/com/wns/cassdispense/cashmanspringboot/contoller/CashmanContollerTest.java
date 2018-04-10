package com.wns.cassdispense.cashmanspringboot.contoller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.wns.cassdispense.cashmanspringboot.model.DenominationModel;
import com.wns.cassdispense.cashmanspringboot.model.DenominationModelList;
import com.wns.cassdispense.cashmanspringboot.service.CashService;

@RunWith(MockitoJUnitRunner.class)
public class CashmanContollerTest {

	@InjectMocks
	private CashmanContoller cashmanContoller;

	@Mock
	private CashService cashService;

	@Test
	public void testaddNotes() {

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

		cashmanContoller.addNotes1(denominationModelList);
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

		Mockito.when(cashService.countNotes()).thenReturn(denominationModelList);
		cashmanContoller.countNotes();
		Assert.assertTrue(denominationModelList.getList().size() == 2);

	}

	@Test
	public void testGetNoteCountCase1() {

		Mockito.when(cashmanContoller.getNoteCount(100))
				.thenReturn("50 Notes are:" + 2 + " & 20 Notes are : " + 0 + "issued");
		String noteCount = cashmanContoller.getNoteCount(100);
		String expected = "50 Notes are:" + 2 + " & 20 Notes are : " + 0 + "issued";
		Assert.assertEquals(expected, noteCount);

	}
	
	@Test
	public void testGetNoteCountCase2() {
		Mockito.when(cashmanContoller.getNoteCount(20))
				.thenReturn("50 Notes are:" + 0 + " & 20 Notes are : " + 1 + "issued");
		String noteCount = cashmanContoller.getNoteCount(20);
		String expected = "50 Notes are:" + 0 + " & 20 Notes are : " + 1 + "issued";
		Assert.assertEquals(expected, noteCount);

	}
	
	@Test
	public void testGetNoteCountCase3() {
		Mockito.when(cashmanContoller.getNoteCount(40))
				.thenReturn("50 Notes are:" + 0 + " & 20 Notes are : " + 2 + "issued");
		String noteCount = cashmanContoller.getNoteCount(40);
		String expected = "50 Notes are:" + 0 + " & 20 Notes are : " + 2 + "issued";
		Assert.assertEquals(expected, noteCount);

	}
	
	@Test
	public void testGetNoteCountCase4() {
		Mockito.when(cashmanContoller.getNoteCount(200))
				.thenReturn("50 Notes are:" + 4 + " & 20 Notes are : " + 0 + "issued");
		String noteCount = cashmanContoller.getNoteCount(200);
		String expected = "50 Notes are:" + 4 + " & 20 Notes are : " + 0 + "issued";
		Assert.assertEquals(expected, noteCount);

	}

}