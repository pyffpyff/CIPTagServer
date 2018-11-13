package model;

public class ACSource extends Source{
	double maxpow;

	public ACSource(double droopcoeff, double nlv, double maxp){
		super(droopcoeff,nlv);
		this.maxpow = maxp;		
	}

	public double simstep(double outi, double outv){
		double inp = outi*outv/.9;
		
		this.inv = 15;
		
		this.ini = inp/this.inv;
		
		if(inp < this.maxpow && outi < 5){
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



}