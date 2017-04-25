package model;

public class Source {
	double outv;
	double outi;
	double inv;
	double ini;
	
	double pset;
	
	
	double eff;
	double droopcoeff;
	double nlv;
	
	//included just for compatibility
	double outc;
	double cpowsp;
	
	public Source(double droopcoeff, double nlv){
		this.eff = .8;
		this.droopcoeff = droopcoeff;
		this.nlv = nlv;
		this.pset = 0;
	}
	
	public double infromout(double v, double i){
		return v*i/eff;
	}
}
