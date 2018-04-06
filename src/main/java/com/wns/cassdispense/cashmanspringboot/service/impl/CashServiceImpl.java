package com.wns.cassdispense.cashmanspringboot.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wns.cassdispense.cashmanspringboot.dao.CashDao;
import com.wns.cassdispense.cashmanspringboot.model.DenominationModel;
import com.wns.cassdispense.cashmanspringboot.model.DenominationModelList;
import com.wns.cassdispense.cashmanspringboot.service.CashService;

/**
 * @author Nagaraj
 *
 */
@Service
public class CashServiceImpl implements CashService {

	private static final String _50 = "50";
	private static final String _20 = "20";
	@Autowired
	private CashDao cashDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wns.cassdispense.cashmanspringboot.service.CashService#addNotes(com.wns.
	 * cassdispense.cashmanspringboot.model.DenominationModelList)
	 */
	@Override
	public void addNotes(DenominationModelList list) {

		cashDao.addNotes(list);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wns.cassdispense.cashmanspringboot.service.CashService#countNotes()
	 */
	@Override
	public DenominationModelList countNotes() {

		DenominationModelList countNotess = cashDao.countNotess();

		return countNotess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wns.cassdispense.cashmanspringboot.service.CashService#getcash(int)
	 */
	@Override
	public String getcash(int amount) {

		DenominationModelList countNotess = cashDao.countNotess();
		String res = cashProcess(countNotess, amount);

		return res;
	}

	private String cashProcess(DenominationModelList countNotess, int amount) {
		Map<String, Integer> existingCount = new HashMap<>();
		List<DenominationModel> list = countNotess.getList();
		int twentycount = 0;
		int fiftycount = 0;

		for (DenominationModel denominationModel : list) {
			if (denominationModel.getDenominationValue().equals(_20)) {
				twentycount = denominationModel.getDenominationValueCount();

			}
			if (denominationModel.getDenominationValue().equals(_50)) {
				fiftycount = denominationModel.getDenominationValueCount();

			}

		}
		existingCount.put(_20, twentycount);
		existingCount.put(_50, fiftycount);

		Map<String, Integer> result = getmoney(existingCount, amount);

		DenominationModelList denominationModelList = new DenominationModelList();
		List<DenominationModel> updatelist = new ArrayList<>();

		for (DenominationModel denominationModel : list) {
			DenominationModel model = new DenominationModel();
			if (denominationModel.getDenominationValue().equals(_20)) {
				model.setDenominationValue(_20);
				model.setDenominationValueCount(result.get(_20));
				updatelist.add(model);

			}
			if (denominationModel.getDenominationValue().equals(_50)) {
				model.setDenominationValue(_50);
				model.setDenominationValueCount(result.get(_50));
				updatelist.add(model);

			}

		}
		denominationModelList.setList(updatelist);

		// update the backend with latest count
		cashDao.updateNote(denominationModelList);

		return "50 Notes are:" + result.get("Count50") + " & 20 Notes are : " + result.get("Count20")
				+ " has been issued";

	}

	private Map<String, Integer> getmoney(Map<String, Integer> existingCount, int amount) {

		int totalCount50 = 0;
		int totalCount20 = 0;
		int givenAmt = amount;

		if (givenAmt >= 50) {
			double a = (double) amount / (double) 50;
			if (existingCount.get(_50) >= a) {
				totalCount50 = (int) a;
				givenAmt = (int) ((a - totalCount50) * 50);
				existingCount.put(_50, existingCount.get(_50) - totalCount50);

			} else {

				totalCount50 = existingCount.get(_50);
				givenAmt = givenAmt - totalCount50 * 50;
				existingCount.put(_50, existingCount.get(_50) - totalCount50);
			}

		}

		if (givenAmt >= 20) {
			double a = (double) givenAmt / (double) 20;
			if (existingCount.get(_20) >= a) {
				totalCount20 = (int) a;
				givenAmt = (int) ((a - totalCount20) * 20);
				existingCount.put(_20, existingCount.get(_20) - totalCount20);
			} else {
				totalCount20 = existingCount.get(_20);
				givenAmt = givenAmt - totalCount20 * 20;
				existingCount.put(_20, existingCount.get(_20) - totalCount20);

			}

		}
		existingCount.put("Count20", totalCount20);
		existingCount.put("Count50", totalCount50);

		return existingCount;
	}

}
