package model;

public class Batt extends Source{
	double soc;
	double batq;
	double cap;
	double maxpow;
	double outz;
	
	double[] soctab;
	double[] ocvtab;
		
	public Batt(double droopcoeff, double nlv, double soc){
		super(droopcoeff, nlv);
		this.soc = soc;
		this.maxpow = 100;
		this.cap = 1.2;
		this.batq = this.soc * this.cap;
		this.outz = .025;
		
		this.soctab = new double[]{0.0, 0.25, 0.5, 0.75, 1.0};
		this.ocvtab = new double[]{11.8, 12.0, 12.2, 12.4, 12.7};
	}
	
	public double simstep(double outi,double outv){		
		double inp = infromout(outv, outi);
		double ocv = getocv();
		//calculate voltage at input to converter
		this.inv = ocv - outi * this.outz;
		//determine input current from voltage
		this.ini = inp/this.inv;
		
		this.updatesoc();
		
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
		int rindex = -1;
		double slope = 0.0;
		
		for(int i = 0; i < this.soctab.length; i++)
		{
			if(this.soc <= this.soctab[i])
			{
				rindex = i;
				break;
			}
		}
		if(rindex < 0)
		{
			return this.ocvtab[this.ocvtab.length - 1];
		}
		if(rindex == 0)
		{
			return this.ocvtab[0];
		}
		
		slope = (this.ocvtab[rindex] - this.ocvtab[rindex - 1])/(this.soctab[rindex] - this.soctab[rindex - 1]);
		
		
		return slope*(this.soc - this.soctab[rindex - 1]) + this.ocvtab[rindex - 1];
	}
	
	public double getmaxpow(double soc){
		//do something soc dependent laer
		return this.maxpow;
	}
	
	public void updatesoc(){
		this.batq -= outi*.02;
		this.soc = this.batq/this.cap;
	}
}
