package model;

public class BattCharger {
	Batt batt;
	double cpowsp = 0;
	double cpowmax = 100;
	double outz = 2.5;
	double outv = 12;
	double outc = 0;
	double eff = .8;
	double mininv = 9.0;
	
	//the following two variables are included just for compatibility
	double inv = 12;
	double ini = 0;
	
	boolean debug = false;
	
	public BattCharger(Batt battery){
		this.batt = battery;
	}
	
	public double simstep(double inc, double inv){
		if(debug){
			System.out.println(String.format("battery simstep: V: %f, I: %f", inv, inc));
		}
		double inp = -inv * inc;
		double outp = outv*outc;
		if(outp > inp*eff){
			//output power is greater than available -- drop voltage to decrease output power
			outv = outv - .01*(outp - inp*.8);
			if(debug){
				System.out.println(String.format("output p too high: %f > %f",outp, inp*eff));
			}
		}
		else{
			if(cpowsp > outp){
				// we want to consume more power and it is available
				outv = outv + .025*(cpowsp - outv*outc);
				if(debug){
					System.out.println(String.format("charge power below setpoint: %f > %f", cpowsp, outp));
				}
			}
		}
		
		//change input voltage to draw more or less power as necessary
		inv = inv - .01*(cpowsp - inp*eff);
		if(inv < mininv){
			inv = mininv;
		}
		
		//determine battery state
		double ocv = batt.getocv();
		outc = (outv - ocv)/outz;
				
		batt.updatesoc();
		
		
		return inv;
	}
	
	

}
