package com.wns.cassdispense.cashmanspringboot.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.wns.cassdispense.cashmanspringboot.dao.CashDao;
import com.wns.cassdispense.cashmanspringboot.model.DenominationModel;
import com.wns.cassdispense.cashmanspringboot.model.DenominationModelList;

@Service
public class CashDaoImpl implements CashDao {

	private Map<String, DenominationModel> db = new HashMap<>();

	/*
	 * param cashMadelList
	 */
	@Override
	public void addNotes(DenominationModelList cashMadelList) {

		for (DenominationModel model : cashMadelList.getList()) {

			if (db.containsKey(model.getDenominationValue())) {
				int prevCount = model.getDenominationValueCount();

				DenominationModel denominationModel = db.get(model.getDenominationValue());
				int newValue = denominationModel.getDenominationValueCount();

				int res = prevCount + newValue;

				denominationModel.setDenominationValueCount(res);

				db.put(model.getDenominationValue(), denominationModel);

			} else {
				db.put(model.getDenominationValue(), model);
			}

		}

	}

	/*
	 * param cashMadelList
	 */
	@Override
	public void updateNote(DenominationModelList cashMadelList) {
		for (DenominationModel model : cashMadelList.getList()) {

			if (db.containsKey(model.getDenominationValue())) {
				int newValue = model.getDenominationValueCount();

				DenominationModel denominationModel = db.get(model.getDenominationValue());

				denominationModel.setDenominationValueCount(newValue);

				db.put(model.getDenominationValue(), denominationModel);

			} else {
				db.put(model.getDenominationValue(), model);
			}

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wns.cassdispense.cashmanspringboot.dao.CashDao#countNotess()
	 */
	@Override
	public DenominationModelList countNotess() {

		DenominationModelList denominationModelList = new DenominationModelList();
		List<DenominationModel> list = new ArrayList<>();

		Set<String> keySet = db.keySet();

		for (String key : keySet) {
			list.add(db.get(key));

		}
		denominationModelList.setList(list);

		return denominationModelList;
	}

}
