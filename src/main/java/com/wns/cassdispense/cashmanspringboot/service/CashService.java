package com.wns.cassdispense.cashmanspringboot.service;

import com.wns.cassdispense.cashmanspringboot.model.DenominationModelList;

public interface CashService {
	
	void addNotes(DenominationModelList list);
	
	DenominationModelList countNotes();

	String getcash(int amount);

}
