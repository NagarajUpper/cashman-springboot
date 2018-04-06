package com.wns.cassdispense.cashmanspringboot.dao;

import com.wns.cassdispense.cashmanspringboot.model.DenominationModelList;

public interface CashDao {
	
	void addNotes(DenominationModelList list);

	DenominationModelList  countNotess();

	void updateNote(DenominationModelList list);

}
