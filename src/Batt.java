package model;

public class Batt extends Source{
	double soc;
	double batq;
	double cap;
	double maxpow;
	double outz;
		
	public Batt(double droopcoeff, double nlv, double soc){
		super(droopcoeff, nlv);
		this.soc = soc;
		this.maxpow = 100;
		this.cap = 7;
		this.batq = this.soc * this.cap;
		this.outz = .025;
	}
	
	public double simstep(double outi,double outv){		
		double inp = infromout(outv, outi);
		this.updatesoc();
		double ocv = getocv();
		//calculate voltage at input to converter
		this.inv = ocv - outi * this.outz;
		//determine input current from voltage
		this.ini = inp/this.inv;
		if(inp < this.getmaxpow(this.soc) && outi < 200){
			//max power constraint is not violated
			//update power setpoint according to droop control
			this.pset = (this.nlv-outv)*this.droopcoeff;
			outv += .001*(this.pset-(outv*outi));
			return outv;
		}
		else{
			//max power constraint is violated
			//and drop output voltage dramatically
			this.pset = 0;
			outv += .01*(this.pset - (outv*outi));
			return outv;
			
		}
		
		
	}
	
	public double getocv(){
		//do something better here later
		return 12;
	}
	
	public double getmaxpow(double soc){
		//do something soc dependent laer
		return this.maxpow;
	}
	
	public void updatesoc(){
		batq -= outi*.02;
		soc = batq/cap;
	}
}
