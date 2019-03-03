package com.example.demo;

public class Holding {

	private String cash;	
	private String shares;
	private String bonds;
	private String assets;
	private String instance;
	

	public Holding(String cash, String shares, String bonds, String assets, String instance) {
		super();
		this.cash = cash;
		this.shares = shares;
		this.bonds = bonds;
		this.assets = assets;
		this.instance = instance;
	}


	public String getCash() {
		return cash;
	}

	public void setCash(String cash) {
		this.cash = cash;
	}

	public String getShares() {
		return shares;
	}

	public void setShares(String shares) {
		this.shares = shares;
	}

	public String getBonds() {
		return bonds;
	}

	public void setBonds(String bonds) {
		this.bonds = bonds;
	}

	public String getAssets() {
		return assets;
	}

	public void setAssets(String assets) {
		this.assets = assets;
	}


	public String getInstance() {
		return instance;
	}


	public void setInstance(String instance) {
		this.instance = instance;
	}

}
