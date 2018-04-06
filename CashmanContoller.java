package com.wns.cassdispense.cashmanspringboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wns.cassdispense.cashmanspringboot.model.DenominationModelList;
import com.wns.cassdispense.cashmanspringboot.service.CashService;

@RestController
public class CashmanContoller {

	@Autowired
	private CashService cashService;

	@RequestMapping(method = RequestMethod.POST, value = "/addNotes")
	public void addNotes1(@RequestBody DenominationModelList list) {

		cashService.addNotes(list);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/balanceNotes")
	public DenominationModelList countNotes() {
		return cashService.countNotes();

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/getCash/{amount}")
	public String getNoteCount(@PathVariable("amount") int amount) {
		
		String result=cashService.getcash(amount);
		
		return result;
		
	}

}
