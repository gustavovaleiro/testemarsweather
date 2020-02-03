package com.gustavovaleiro.testevaga.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolResult {
	@JsonProperty(value="AT")
	private SolAt at;

	public SolAt getAt() {
		return at;
	}

	public void setAt(SolAt at) {
		this.at = at;
	}
	
	
}
