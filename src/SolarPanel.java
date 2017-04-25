package model;


public class SolarPanel extends Source{
	double vf;
	double rsh;
	double rs;
	double vt;
	double io;
	double insoltoil;
	double insol;
	
		
	public SolarPanel(double droopcoeff, double nlv, double insol){
		super(droopcoeff, nlv);
		this.vt = 1.802;
		this.io = .000005;
		
		this.insol = insol;
		this.insoltoil = .02;
	}
	
		
	public double simstep(double outi, double outv){
		//System.out.println(String.format("I: %f, V: %f", outi,outv));
		//System.out.println(String.format("iput pow: %f",outi*outv));
		double inp = infromout(outv, outi);
		if(inp < this.getmaxpow(this.insol)){
			//max power constraint is not violated
			//solve for unreg v and i
			double[] result;
			result = getoppoint(this.insol, inp);
			inv = result[0];
			ini = result[1];
			
			//check to see if regulator drops out
			if(inv > 9){
				//panel voltage is high enough for normal operation
				//update power setpoint according to droop control
				this.pset = (this.nlv-outv)*this.droopcoeff;
				//System.out.println(String.format("pset: %f",pset));
				outv += .01*(this.pset-(outv*outi));
			}
			else{
				//convert drops out, drop output voltage dramatically
				
				this.pset = 0;
				outv += .01*(this.pset - (outv*outi));
			}
			//System.out.println(String.format("function regv: %f",outv));
					
			//System.out.println(outv);
			return outv;
		}
		else{
			//max power constraint is violated
			//determine source state
			inv = 9;
			ini = this.insoltoil*insol - this.io*(Math.pow(2.71828, this.inv/this.vt)-1);
			//and drop output voltage dramatically
			this.pset = 0;
			outv += .01*(this.pset - (outv*outi));
			return outv;
			
		}
	} 
	
	public double[] getoppoint(double insol, double power){
		double il = insoltoil * insol;
		double thresh = .00001;
		double diff = thresh + 1;
		double[][]  J = new double[2][2];
		double[] f = new double[2];
		double[] x = new double[2];
		double[] xold = new double[2];
		double[] y = new double[2];
		
		int itrctr = 0;
		
		x[0] = 20;
		x[1] = 1;
		//System.out.println(power);
		//System.out.println(String.format("1 v: %f, i: %f",x[0],x[1]));
		while((Math.abs(diff) > thresh) && (itrctr < 1000)){
			J[0][0] = -this.io*Math.pow(2.71828, x[0]/this.vt)/this.vt;
			J[0][1] = -1;
			J[1][0] = x[1];
			J[1][1] = x[0];
			//Modelmath.printmat(J);
			
			f[0] = il -this.io*(Math.pow(2.71828, x[0]/this.vt) - 1) - x[1];
			f[1] = x[0]*x[1] - power;
			//System.out.println(String.format("f v: %f, fi: %f",f[0],f[1]));
			xold = x;
			y = Modelmath.gausselim(J, f);
			//System.out.println(String.format("2 v: %f, i: %f",y[0],y[1]));
			x = Modelmath.vecsub(x, y);
			//System.out.println(String.format("3 v: %f, i: %f",x[0],x[1]));
			
			diff = Modelmath.vecmaxabs(Modelmath.vecsub(x, xold));
			itrctr++;
		}
		//System.out.println(String.format("%d itrsp op point: %f V, %f A", itrctr, x[0],x[1]));
		return x;
	}
	
	public double getmaxpow(double insol){
		double il = insoltoil *insol;
		double thresh = .00001;
		double diff = thresh + 1;
		double f;
		double fp;
		double v = 17;
		double vold;
		double power;
		
		int itrctr = 0;
		
		while((Math.abs(diff) > thresh) && (itrctr < 1000)){
			f = il + this.io -this.io*Math.pow(2.71828, v/this.vt)*(1 + (v/this.vt));
			fp = -(this.io/this.vt)*Math.pow(2.71828, v/this.vt)*(2 + (v/this.vt));
			vold = v;
			v = v-(f/fp);
			diff = v - vold;
			itrctr++;
		}
		power = v*(il -this.io*(Math.pow(2.71828, v/this.vt) - 1));
		//System.out.println(String.format("%d itr, max power point: %f W at %f V", itrctr-1, power, v));
		return power;
	}
}
