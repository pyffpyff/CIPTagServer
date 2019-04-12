package model;


//runs a dcmg model in a new thread
public class ModelRunner extends Thread {
	public ACMGmodel model;
	public int interval;
	
	//runs the model model every interval milliseconds
	public ModelRunner(ACMGmodel model, int interval){
		this.model = model;
		
		if(interval < 10){
			this.interval = 10;
		}
		else{
			this.interval = interval;
		}
		
	}
	
	public void run(){
		while(true){
			try{
				synchronized(model){
					long now = System.currentTimeMillis();
				//	System.out.println("start");
				//	System.out.println(now);
					model.solvemodel(false);
				//	long now2 = System.currentTimeMillis();
				//	System.out.println("end");
				//	System.out.println(now2);
				}
				
				Thread.sleep(interval);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}

	}
	
}