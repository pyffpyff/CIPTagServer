package model;
import model.Source;

import model.Batt;

import model.Modelmath;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;
import model.Complex;
import model.Inverse;

public class ACMGmodel{
	double r;
	double ra;
	double rb;
	double rc;
	double rg;
	double ro;
	double xa;
	double xb;
	double xc;
	
	//load resistances
	double lr;
	

	
	//convert to conductivities
	double y;
	double ya;
	double yb;
	double yc;
	double yd;
	double yg;
	double yo;
	
	double ly;
	
	
	//set p,q for power flow equation
	double v1;
	double v2;
	double v3;
	double v4;
	double s1;
	double s2;
	double s3;
	double s4;
	
	double x;
		
	double p2;
	double p3;
	double p4;
	double q2;
	double q3;
	double q4;
	
	
	int dim;
	
	int COM_MAIN_USER;
    int COM_BUS1_USER;   
    int COM_BUS1_LOAD1_USER;   
    int COM_BUS1_LOAD2_USER; 
    int COM_BUS1_LOAD3_USER;   
    int COM_BUS1_LOAD4_USER;   
    int COM_BUS1_LOAD5_USER;   
    int COM_BUS2_USER;   
    int COM_BUS2_LOAD1_USER;   
    int COM_BUS2_LOAD2_USER;   
    int COM_BUS2_LOAD3_USER;   
    int COM_BUS2_LOAD4_USER;   
    int COM_BUS2_LOAD5_USER;  
    int IND_MAIN_USER;   
    int IND_BUS1_USER;   
    int IND_BUS1_LOAD1_USER;   
    int IND_BUS1_LOAD2_USER;   
    int IND_BUS1_LOAD3_USER;   
    int IND_BUS1_LOAD4_USER;   
    int IND_BUS1_LOAD5_USER;   
    int IND_BUS2_USER;   
    int IND_BUS2_LOAD1_USER;   
    int IND_BUS2_LOAD2_USER;   
    int IND_BUS2_LOAD3_USER;   
    int IND_BUS2_LOAD4_USER;   
    int IND_BUS2_LOAD5_USER;   
    int RES_MAIN_USER;   
    int RES_BUS1_USER;   
    int RES_BUS1_LOAD1_USER;   
    int RES_BUS1_LOAD2_USER;   
    int RES_BUS1_LOAD3_USER;   
    int RES_BUS1_LOAD4_USER;   
    int RES_BUS1_LOAD5_USER;   
    int RES_BUS2_USER;   
    int RES_BUS2_LOAD1_USER;   
    int RES_BUS2_LOAD2_USER;   
    int RES_BUS2_LOAD3_USER;   
    int RES_BUS2_LOAD4_USER;   
    int RES_BUS2_LOAD5_USER;   
    int RES_BUS3_USER;   
    int RES_BUS3_LOAD1_USER;   
    int RES_BUS3_LOAD2_USER;  
    int RES_BUS3_LOAD3_USER;   
    int RES_BUS3_LOAD4_USER;   
    int RES_BUS3_LOAD5_USER;   
    int RES_BUS4_USER;   
    int RES_BUS4_LOAD1_USER;   
    int RES_BUS4_LOAD2_USER;   
    int RES_BUS4_LOAD3_USER;   
    int RES_BUS4_LOAD4_USER;   
    int RES_BUS4_LOAD5_USER;   
    int RES_BUS5_USER;   
    int RES_BUS5_LOAD1_USER;  
    int RES_BUS5_LOAD2_USER;   
    int RES_BUS5_LOAD3_USER;   
    int RES_BUS5_LOAD4_USER;   
    int RES_BUS5_LOAD5_USER;
    
 //   int source1_user;
    int SOURCE_1_User;
	int SOURCE_2_User;
	
 //	check PLC about all information about source 
    
    
    int src1loc;
	int src2loc;
	
	double src1regv;
	double src2regv;
	
	double src1unregv;
	double src2unregv;
	
	int MAIN_FAULT;
	int COM_MAIN_FAULT;
    int COM_BUS1_FAULT;   
    int COM_BUS1_LOAD1_FAULT;   
    int COM_BUS1_LOAD2_FAULT; 
    int COM_BUS1_LOAD3_FAULT;   
    int COM_BUS1_LOAD4_FAULT;   
    int COM_BUS1_LOAD5_FAULT;   
    int COM_BUS2_FAULT;   
    int COM_BUS2_LOAD1_FAULT;   
    int COM_BUS2_LOAD2_FAULT;   
    int COM_BUS2_LOAD3_FAULT;   
    int COM_BUS2_LOAD4_FAULT;   
    int COM_BUS2_LOAD5_FAULT;  
    int IND_MAIN_FAULT;   
    int IND_BUS1_FAULT;   
    int IND_BUS1_LOAD1_FAULT;   
    int IND_BUS1_LOAD2_FAULT;   
    int IND_BUS1_LOAD3_FAULT;   
    int IND_BUS1_LOAD4_FAULT;   
    int IND_BUS1_LOAD5_FAULT;   
    int IND_BUS2_FAULT;   
    int IND_BUS2_LOAD1_FAULT;   
    int IND_BUS2_LOAD2_FAULT;   
    int IND_BUS2_LOAD3_FAULT;   
    int IND_BUS2_LOAD4_FAULT;   
    int IND_BUS2_LOAD5_FAULT;   
    int RES_MAIN_FAULT;   
    int RES_BUS1_FAULT;   
    int RES_BUS1_LOAD1_FAULT;   
    int RES_BUS1_LOAD2_FAULT;   
    int RES_BUS1_LOAD3_FAULT;   
    int RES_BUS1_LOAD4_FAULT;   
    int RES_BUS1_LOAD5_FAULT;   
    int RES_BUS2_FAULT;   
    int RES_BUS2_LOAD1_FAULT;   
    int RES_BUS2_LOAD2_FAULT;   
    int RES_BUS2_LOAD3_FAULT;   
    int RES_BUS2_LOAD4_FAULT;   
    int RES_BUS2_LOAD5_FAULT;   
    int RES_BUS3_FAULT;   
    int RES_BUS3_LOAD1_FAULT;   
    int RES_BUS3_LOAD2_FAULT;  
    int RES_BUS3_LOAD3_FAULT;   
    int RES_BUS3_LOAD4_FAULT;   
    int RES_BUS3_LOAD5_FAULT;   
    int RES_BUS4_FAULT;   
    int RES_BUS4_LOAD1_FAULT;   
    int RES_BUS4_LOAD2_FAULT;   
    int RES_BUS4_LOAD3_FAULT;   
    int RES_BUS4_LOAD4_FAULT;   
    int RES_BUS4_LOAD5_FAULT;   
    int RES_BUS5_FAULT;   
    int RES_BUS5_LOAD1_FAULT;  
    int RES_BUS5_LOAD2_FAULT;   
    int RES_BUS5_LOAD3_FAULT;   
    int RES_BUS5_LOAD4_FAULT;   
    int RES_BUS5_LOAD5_FAULT;
    
    double MAIN_VOLTAGE;
    double COM_MAIN_VOLTAGE;
    double IND_MAIN_VOLTAGE;
    double RES_MAIN_VOLTAGE;
    
    double COM_MAIN_CURRENT;
    double COM_B1_CURRENT;
    double COM_B1L1_CURRENT;
    double COM_B1L2_CURRENT;
    double COM_B1L3_CURRENT;
    double COM_B1L4_CURRENT;
    double COM_B1L5_CURRENT;
    double COM_B2_CURRENT;
    double COM_B2L1_CURRENT;
    double COM_B2L2_CURRENT;
    double COM_B2L3_CURRENT;
    double COM_B2L4_CURRENT;
    double COM_B2L5_CURRENT;
    double IND_MAIN_CURRENT;
    double IND_B1_CURRENT;
    double IND_B1L1_CURRENT;
    double IND_B1L2_CURRENT;
    double IND_B1L3_CURRENT;
    double IND_B1L4_CURRENT;
    double IND_B1L5_CURRENT;
    double IND_B2_CURRENT;
    double IND_B2L1_CURRENT;
    double IND_B2L2_CURRENT;
    double IND_B2L3_CURRENT;
    double IND_B2L4_CURRENT;
    double IND_B2L5_CURRENT;
    double RES_MAIN_CURRENT;
    double RES_B1_CURRENT;
    double RES_B1L1_CURRENT;
    double RES_B1L2_CURRENT;
    double RES_B1L3_CURRENT;
    double RES_B1L4_CURRENT;
    double RES_B1L5_CURRENT;
    double RES_B2_CURRENT;
    double RES_B2L1_CURRENT;
    double RES_B2L2_CURRENT;
    double RES_B2L3_CURRENT;
    double RES_B2L4_CURRENT;
    double RES_B2L5_CURRENT;
    double RES_B3_CURRENT;
    double RES_B3L1_CURRENT;
    double RES_B3L2_CURRENT;
    double RES_B3L3_CURRENT;
    double RES_B3L4_CURRENT;
    double RES_B3L5_CURRENT;
    double RES_B4_CURRENT;
    double RES_B4L1_CURRENT;
    double RES_B4L2_CURRENT;
    double RES_B4L3_CURRENT;
    double RES_B4L4_CURRENT;
    double RES_B4L5_CURRENT;
    double RES_B5_CURRENT;
    double RES_B5L1_CURRENT;
    double RES_B5L2_CURRENT;
    double RES_B5L3_CURRENT;
    double RES_B5L4_CURRENT;
    double RES_B5L5_CURRENT;
    
  //source currents
    
    
    String logfilename = "modellog.csv";
	PrintWriter log = null;
	String[] signallist =  {"Main Bus Voltage", "COM Main Bus Voltage",
			"IND Main Bus Voltage", "RES Main Bus Voltage",
			"COM_MAIN_CURRENT", "COM_B1_CURRENT", "COM_B1L1_CURRENT",
		    "COM_B1L2_CURRENT", "COM_B1L3_CURRENT", "COM_B1L4_CURRENT",
		    "COM_B1L5_CURRENT", "COM_B2_CURRENT", "COM_B2L1_CURRENT",
		    "COM_B2L2_CURRENT", "COM_B2L3_CURRENT", "COM_B2L4_CURRENT",
		    "COM_B2L5_CURRENT", "IND_MAIN_CURRENT", "IND_B1_CURRENT",
		    "IND_B1L1_CURRENT", "IND_B1L2_CURRENT", "IND_B1L3_CURRENT",
		    "IND_B1L4_CURRENT", "IND_B1L5_CURRENT", "IND_B2_CURRENT",
		    "IND_B2L1_CURRENT", "IND_B2L2_CURRENT", "IND_B2L3_CURRENT",
		    "IND_B2L4_CURRENT", "IND_B2L5_CURRENT", "RES_MAIN_CURRENT",
		    "RES_B1_CURRENT",  "RES_B1L1_CURRENT", "RES_B1L2_CURRENT",
		    "RES_B1L3_CURRENT", "RES_B1L4_CURRENT", "RES_B1L5_CURRENT",
		    "RES_B2_CURRENT", "RES_B2L1_CURRENT", "RES_B2L2_CURRENT",
		    "RES_B2L3_CURRENT", "RES_B2L4_CURRENT", "RES_B2L5_CURRENT",
		    "RES_B3_CURRENT", "RES_B3L1_CURRENT", "RES_B3L2_CURRENT",
		    "RES_B3L3_CURRENT", "RES_B3L4_CURRENT", "RES_B3L5_CURRENT",
		    "RES_B4_CURRENT", "RES_B4L1_CURRENT", "RES_B4L2_CURRENT",
		    "RES_B4L3_CURRENT", "RES_B4L4_CURRENT", "RES_B4L5_CURRENT",
		    "RES_B5_CURRENT", "RES_B5L1_CURRENT", "RES_B5L2_CURRENT",
		    "RES_B5L3_CURRENT", "RES_B5L4_CURRENT", "RES_B5L5_CURRENT",
		    "Source 1 Current", "Source 2 Current"
	};

	public static void main(String[] args){		
		ACMGmodel acmg = new ACMGmodel();
		
		acmg.solvemodel(true);
		
	}
    
    public ACMGmodel() {
    	//radomly set value first
    	this.r = 0.05;
		this.ra = 0.11;
		this.rb = 0.12;
		this.rc = 0.13;
		this.rg = 0.1;
		this.ro = 0.1;
		this.xa = 0.001;
		this.xb = 0.001;
		this.xc = 0.1;
		
    	//load resistances the value is just random set now. need check
    	this.lr=10;
    	
    
    	
    	this.y = 1/r;
		this.ya = 1/ra;
		this.yb = 1/rb;
		this.yc = 1/rc;
		this.yg = 1/rg;
		this.yo = 1/ro;
		
    	
    	this.ly = 1/lr;
    	
    	
    	this.dim = 4;
    	
    	this.COM_MAIN_USER = 1;
        this.COM_BUS1_USER = 1;  
        this.COM_BUS2_USER = 1; 
        this.IND_MAIN_USER = 1;   
        this.IND_BUS1_USER = 1; 
        this.RES_MAIN_USER = 1;   
        this.RES_BUS1_USER = 1; 
        this.RES_BUS2_USER = 1;  
        this.RES_BUS3_USER = 1; 
        this.RES_BUS4_USER = 1; 
        this.RES_BUS5_USER = 1;
        
        
        
        this.COM_BUS1_LOAD1_USER = 0;   
        this.COM_BUS1_LOAD2_USER = 0; 
        this.COM_BUS1_LOAD3_USER = 0;   
        this.COM_BUS1_LOAD4_USER = 0;   
        this.COM_BUS1_LOAD5_USER = 0;           
        this.COM_BUS2_LOAD1_USER = 0;   
        this.COM_BUS2_LOAD2_USER = 0;   
        this.COM_BUS2_LOAD3_USER = 0;   
        this.COM_BUS2_LOAD4_USER = 0;   
        this.COM_BUS2_LOAD5_USER = 0;            
        this.IND_BUS1_LOAD1_USER = 0;   
        this.IND_BUS1_LOAD2_USER = 0;   
        this.IND_BUS1_LOAD3_USER = 0;   
        this.IND_BUS1_LOAD4_USER = 0;   
        this.IND_BUS1_LOAD5_USER = 0;   
        this.IND_BUS2_USER = 0;   
        this.IND_BUS2_LOAD1_USER = 0;   
        this.IND_BUS2_LOAD2_USER = 0;   
        this.IND_BUS2_LOAD3_USER = 0;   
        this.IND_BUS2_LOAD4_USER = 0;   
        this.IND_BUS2_LOAD5_USER = 0;            
        this.RES_BUS1_LOAD1_USER = 0;   
        this.RES_BUS1_LOAD2_USER = 0;   
        this.RES_BUS1_LOAD3_USER = 0;   
        this.RES_BUS1_LOAD4_USER = 0;   
        this.RES_BUS1_LOAD5_USER = 0;          
        this.RES_BUS2_LOAD1_USER = 0;   
        this.RES_BUS2_LOAD2_USER = 0;   
        this.RES_BUS2_LOAD3_USER = 0;   
        this.RES_BUS2_LOAD4_USER = 0;   
        this.RES_BUS2_LOAD5_USER = 0;            
        this.RES_BUS3_LOAD1_USER = 0;   
        this.RES_BUS3_LOAD2_USER = 0;  
        this.RES_BUS3_LOAD3_USER = 0;   
        this.RES_BUS3_LOAD4_USER = 0;   
        this.RES_BUS3_LOAD5_USER = 0;          
        this.RES_BUS4_LOAD1_USER = 0;   
        this.RES_BUS4_LOAD2_USER = 0;   
        this.RES_BUS4_LOAD3_USER = 0;   
        this.RES_BUS4_LOAD4_USER = 0;   
        this.RES_BUS4_LOAD5_USER = 0;              
        this.RES_BUS5_LOAD1_USER = 0;  
        this.RES_BUS5_LOAD2_USER = 0;   
        this.RES_BUS5_LOAD3_USER = 0;   
        this.RES_BUS5_LOAD4_USER = 0;   
        this.RES_BUS5_LOAD5_USER = 0;
    	
    	this.SOURCE_1_User = 1;
    	this.SOURCE_2_User = 0;
    	
    	this.src1loc = 1;
		this.src2loc = 1;
		
		this.COM_MAIN_FAULT = 0;
	    this.COM_BUS1_FAULT = 0;   
	    this.COM_BUS1_LOAD1_FAULT = 0;   
	    this.COM_BUS1_LOAD2_FAULT = 0; 
	    this.COM_BUS1_LOAD3_FAULT = 0;   
	    this.COM_BUS1_LOAD4_FAULT = 0;   
	    this.COM_BUS1_LOAD5_FAULT = 0;   
	    this.COM_BUS2_FAULT = 0;   
	    this.COM_BUS2_LOAD1_FAULT = 0;   
	    this.COM_BUS2_LOAD2_FAULT = 0;   
	    this.COM_BUS2_LOAD3_FAULT = 0;   
	    this.COM_BUS2_LOAD4_FAULT = 0;   
	    this.COM_BUS2_LOAD5_FAULT = 0;  
	    this.IND_MAIN_FAULT = 0;   
	    this.IND_BUS1_FAULT = 0;   
	    this.IND_BUS1_LOAD1_FAULT = 0;   
	    this.IND_BUS1_LOAD2_FAULT = 0;   
	    this.IND_BUS1_LOAD3_FAULT = 0;   
	    this.IND_BUS1_LOAD4_FAULT = 0;   
	    this.IND_BUS1_LOAD5_FAULT = 0;   
	    this.IND_BUS2_FAULT = 0;   
	    this.IND_BUS2_LOAD1_FAULT = 0;   
	    this.IND_BUS2_LOAD2_FAULT = 0;   
	    this.IND_BUS2_LOAD3_FAULT = 0;   
	    this.IND_BUS2_LOAD4_FAULT = 0;   
	    this.IND_BUS2_LOAD5_FAULT = 0;   
	    this.RES_MAIN_FAULT = 0;   
	    this.RES_BUS1_FAULT = 0;   
	    this.RES_BUS1_LOAD1_FAULT = 0;   
	    this.RES_BUS1_LOAD2_FAULT = 0;   
	    this.RES_BUS1_LOAD3_FAULT = 0;   
	    this.RES_BUS1_LOAD4_FAULT = 0;   
	    this.RES_BUS1_LOAD5_FAULT = 0;   
	    this.RES_BUS2_FAULT = 0;   
	    this.RES_BUS2_LOAD1_FAULT = 0;   
	    this.RES_BUS2_LOAD2_FAULT = 0;   
	    this.RES_BUS2_LOAD3_FAULT = 0;   
	    this.RES_BUS2_LOAD4_FAULT = 0;   
	    this.RES_BUS2_LOAD5_FAULT = 0;   
	    this.RES_BUS3_FAULT = 0;   
	    this.RES_BUS3_LOAD1_FAULT = 0;   
	    this.RES_BUS3_LOAD2_FAULT = 0;  
	    this.RES_BUS3_LOAD3_FAULT = 0;   
	    this.RES_BUS3_LOAD4_FAULT = 0;   
	    this.RES_BUS3_LOAD5_FAULT = 0;   
	    this.RES_BUS4_FAULT = 0;   
	    this.RES_BUS4_LOAD1_FAULT = 0;   
	    this.RES_BUS4_LOAD2_FAULT = 0;   
	    this.RES_BUS4_LOAD3_FAULT = 0;   
	    this.RES_BUS4_LOAD4_FAULT = 0;   
	    this.RES_BUS4_LOAD5_FAULT = 0;   
	    this.RES_BUS5_FAULT = 0;   
	    this.RES_BUS5_LOAD1_FAULT = 0;  
	    this.RES_BUS5_LOAD2_FAULT = 0;   
	    this.RES_BUS5_LOAD3_FAULT = 0;   
	    this.RES_BUS5_LOAD4_FAULT = 0;   
	    this.RES_BUS5_LOAD5_FAULT = 0;
	    
	  //print signal names for csv log file
	  		try{
	  			System.out.println("creating model log file");
	  			this.log = new PrintWriter(new FileOutputStream(new File(this.logfilename),true));
	  			for(int i = 0; i < this.signallist.length; i++)
	  			{
	  				if(i < this.signallist.length-1)
	  				{
	  					log.printf("%s,",this.signallist[i]);
	  				}
	  				else
	  				{
	  					log.printf("%s\n", this.signallist[i]);
	  				}
	  			}	
	  		}
	  		catch(Exception e)
	  		{
	  			System.out.println(e);
	  		}
	  	}
    public void cleanup(){
		System.out.println("Closing log file");
		this.log.close();
	}
    
    
    public void solvemodel(boolean debugging){
		//size matrix based on number of sources connected
		dim = 4 + SOURCE_1_User + SOURCE_2_User;
		double[][] Y = new double[dim][dim];
		double[] U = new double[dim];
		double[] K = new double[dim];
		
		//double[] gencurrents = new double[6];
		//double[] busvoltages = new double[6];
    
		//build admittance matrix
		Y[0][1] = -ya;
		Y[0][2] = -yb;
		Y[0][3] = -yc;
		
		
		int connindex = 4;
		int SOURCE_1_connindex = -1;
	//	int SOURCE_2_connindex = -1;
		   
		if(SOURCE_1_User == 1){
			Y[src1loc][connindex] = 1;	
			SOURCE_1_connindex = connindex;
			connindex++;
			
		}
	//	if(SOURCE_2_User == 1){
	//		Y[src2loc][connindex] = 1;	
	//		SOURCE_2_connindex = connindex;
	//		connindex++;
	//	}
    
		//make the matrix symmetric
				for(int i= 0;i<dim;i++){
					for(int j = i+1;j<dim;j++){
						Y[j][i] = Y[i][j];
					}
				}
    
		//sum elements of rows and negate to find diagonal
		for(int i = 0;i<4;i++){
			double sum = 0;
			for(int j = 0;j<4;j++){
				sum += Y[i][j];
			}
			Y[i][i] = -sum;
		}		
    
    
		for(int i = 0;i<K.length;i++){
			if(i<4){
				K[i] = 0;
			}
			if(i == SOURCE_1_connindex){
				if(SOURCE_1_?? == 1){
					K[i] = src1unregv;
				}
				else{
					K[i] = src1regv;
				}				
			}
			else if(i == SOURCE_2_connindex){
				if(SOURCE_2_?? == 1){
					K[i] = src2unregv;
				}
				else{
					K[i] = src2regv;
				}			
			}
		}
		
		//these entries help us find the unknown currents
		if(SOURCE_1_User == 1){
			Y[SOURCE_1_connindex][SOURCE_1_connindex] = -ro * SOURCE_1_User;
		}
	//	if(SOURCE_2_User == 1){
	//		Y[SOURCE_2_connindex][SOURCE_2_connindex] = -ro * SOURCE_2_User;
	//	}
					
		
	
		this.v1 = 1.0;
		
		this.s1 = 0;
		this.s2 = 0;
		this.s3 = 0;
		this.s4 = 0;
		
		
		this.v2 = 1.0;
		this.v3 = 1.0;
		this.v4 = 1.0;
		
		
		
		this.P2 = Math.pow(v2, 2)/ra;
		this.p3 = Math.pow(v3, 2)/rb;
		this.p4 = Math.pow(v4, 2)/rc;
		this.q2 = Math.pow(v2, 2)/xa;
		this.q3 = Math.pow(v3, 2)/xb;
		this.q4 = Math.pow(v4, 2)/xc;
		
		//double [] x;
		//double [] b;
		
		x = new double [6];
		b = new double [6];
		
		x = {v2, v3, v4, s2, s3, s4};
		b = {p2, p3, p4, q2, q3, q4};
		
		double epsilon = 0.0001;
		int maxiter = 30;
		
		
		while (count < maxiter) {
			
			double f1;//p2
			double f2;//p3
			double f3;//p4
			double f4;//q2
			double f5;//q3
			double f6;//q4
	                                             
			
			f1 = Math.abs(v2)*(Math.abs(Y[1][0])*Math.cos(s2-Complex.phase(Y[1][0]))+Math.abs(Y[1][1])*Math.abs(v2)*Math.cos(Complex.phase(Y[1][1]))+Math.abs(Y[1][2])*Math.abs(v3)*Math.cos(s2-s3-Complex.phase(Y[1][2]))+Math.abs(Y[1][3])*Math.abs(v4)*Math.cos(s2-s4-Complex.phase(Y[1][3])));
			f2 = Math.abs(v3)*(Math.abs(Y[2][0])*Math.cos(s3-Complex.phase(Y[2][0]))+Math.abs(Y[2][1])*Math.abs(v2)*Math.cos(s3-s2-Complex.phase(Y[2][1]))+Math.abs(Y[2][2])*Math.abs(v3)*Math.cos(Complex.phase(Y[2][2]))+Math.abs(Y[2][3])*Math.abs(v4)*Math.cos(s3-s4-Complex.phase(Y[2][3])));
			f3 = Math.abs(v4)*(Math.abs(Y[3][0])*Math.cos(s4-Complex.phase(Y[3][0]))+Math.abs(Y[3][1])*Math.abs(v2)*Math.cos(s4-s2-Complex.phase(Y[3][1]))+Math.abs(Y[3][2])*Math.abs(v3)*Math.cos(s4-s3-Complex.phase(Y[3][2]))+Math.abs(Y[3][3])*Math.abs(v4)*Math.cos(Complex.phase(Y[3][3])));
			f4 = Math.abs(v2)*(Math.abs(Y[1][0])*Math.sin(s2-Complex.phase(Y[1][0]))+Math.abs(Y[1][1])*Math.abs(v2)*Math.sin(Complex.phase(Y[1][1]))+Math.abs(Y[2][3])*Math.abs(v3)*Math.sin(s2-s3-Complex.phase(Y[1][2]))+Math.abs(Y[1][3])*Math.abs(v4)*Math.sin(s2-s4-Complex.phase(Y[1][3])));
			f5 = Math.abs(v3)*(Math.abs(Y[2][0])*Math.sin(s3-Complex.phase(Y[2][0]))+Math.abs(Y[2][1])*Math.abs(v2)*Math.sin(s3-s2-Complex.phase(Y[2][1]))+Math.abs(Y[2][2])*Math.abs(v3)*Math.sin(Complex.phase(Y[2][2]))+Math.abs(Y[2][3])*Math.abs(v4)*Math.sin(s3-s4-Complex.phase(Y[2][3])));
			f6 = Math.abs(v4)*(Math.abs(Y[3][0])*Math.sin(s4-Complex.phase(Y[3][0]))+Math.abs(Y[3][1])*Math.abs(v2)*Math.sin(s4-s2-Complex.phase(Y[3][1]))+Math.abs(Y[3][2])*Math.abs(v3)*Math.sin(s4-s3-Complex.phase(Y[3][2]))+Math.abs(Y[3][3])*Math.abs(v4)*Math.sin(Complex.phase(Y[3][3])));
			
			double [] f_x = new double [6];
			f_x = {f1,f2,f3,f4,f5,f6};
			double [] Del_f = new double [6];
			
			for(int i = 0;i<6;i++){
				Del_f[i] = b[i] - f_x[i];
			}
			
			if (Math.abs(Del_f[0])<epsilon && Math.abs(Del_f[1])<epsilon && Math.abs(Del_f[2])<epsilon && Math.abs(Del_f[3])<epsilon && Math.abs(Del_f[4])<epsilon && Math.abs(Del_f[5])<epsilon) {
				break;
				
			}
			
			//caculate Jacobian
			
			
			double dp2ds2;
			double dp2ds3;
			double dp2ds4;
			double dp2dv2;
			double dp2dv3;
			double dp2dv4;
			double dq2ds2;
			double dq2ds3;
			double dq2ds4;
			double dq2dv2;
			double dq2dv3;
			double dq2dv4;
			
			double dp3ds2;
			double dp3ds3;
			double dp3ds4;
			double dp3dv2;
			double dp3dv3;
			double dp3dv4;
			double dq3ds2;
			double dq3ds3;
			double dq3ds4;
			double dq3dv2;
			double dq3dv3;
			double dq3dv4;
			
			double dp4ds2;
			double dp4ds3;
			double dp4ds4;
			double dp4dv2;
			double dp4dv3;
			double dp4dv4;
			double dq4ds2;
			double dq4ds3;
			double dq4ds4;
			double dq4dv2;
			double dq4dv3;
			double dq4dv4;
			
			dp2ds2 = -Math.abs(v2)*(Math.abs(Y[1][0]*Math.sin(s2-Complex.phase(Y[1][0]))+Math.abs(Y[1][2])*Math.abs(v3)*Math.sin(s2-s3-Complex.phase(Y[1][2]))+Math.abs(Y[1][3])*Math.abs(v4)*Math.sin(s2-s4-Complex.phase(Y[1][3]))));
			dp2ds3 = Math.abs(v2)*Math.abs(Y[1][2])*Math.abs(v3)*Math.sin(s2-s3-Complex.phase(Y[1][2]));
			dp2ds4 = Math.abs(v2)*Math.abs(Y[1][3])*Math.abs(v4)*Math.sin(s2-s4-Complex.phase(y[1][3]));
			dp2dv2 = Math.abs(y[1][0])*Math.cos(s2-Complex.phase(y[1][0]))+2*Math.abs(v2)*Math.abs(y[1][1])*Math.cos(Complex.phase(Y[1][1]))+Math.abs(Y[1][2])*Math.abs(v3)*Math.cos(s2-s3-Complex.phase(Y[1][2]))+Math.abs(Y[1][3])*Math.abs(v4)*Math.cos(s2-s4-Complex.phase(Y[1][3]));
			dp2dv3 = Math.abs(v2)*Math.abs(Y[1][2])*Math.cos(s2-s3-Complex.phase(Y[1][2]));
			dp2dv4 = Math.abs(v2)*Math.abs(Y[1][3])*Math.cos(s2-s4-Complex.phase(Y[1][3]));
			
			dq2ds2 = Math.abs(v2)*(Math.abs(Y[1][0]*Math.cos(s2-Complex.phase(Y[1][0]))+Math.abs(Y[1][2])*Math.abs(v3)*Math.cos(s2-s3-Complex.phase(Y[1][2]))+Math.abs(Y[1][3])*Math.abs(v4)*Math.cos(s2-s4-Complex.phase(Y[1][3]))));
			dq2ds3 = -Math.abs(v2)*Math.abs(Y[1][2])*Math.abs(v3)*Math.cos(s2-s3-Complex.phase(Y[1][2]));
			dq2ds4 = -Math.abs(v2)*Math.abs(Y[1][3])*Math.abs(v4)*Math.cos(s2-s4-Complex.phase(y[1][3]));
			dq2dv2 = Math.abs(y[1][0])*Math.sin(s2-Complex.phase(y[1][0]))-2*Math.abs(v2)*Math.abs(y[1][1])*Math.sin(Complex.phase(Y[1][1]))+Math.abs(Y[1][2])*Math.abs(v3)*Math.sin(s2-s3-Complex.phase(Y[1][2]))+Math.abs(Y[1][3])*Math.abs(v4)*Math.sin(s2-s4-Complex.phase(Y[1][3]));
			dq2dv3 = Math.abs(v2)*Math.abs(Y[1][2])*Math.sin(s2-s3-Complex.phase(Y[1][2]));
			dq2dv4 = Math.abs(v2)*Math.abs(Y[1][3])*Math.sin(s2-s4-Complex.phase(Y[1][3]));
			
			dp3ds2 = Math.abs(v3)*Math.abs(Y[2][1])*Math.abs(v2)*Math.sin(s3-s3-Compelx.phase(Y[2][1]));
			dp3ds3 = -Math.abs(v3)*(Math.abs(Y[2][0]*Math.sin(s3-Complex.phase(Y[2][0]))+Math.abs(Y[2][1])*Math.abs(v2)*Math.sin(s3-s2-Complex.phase(Y[2][1]))+Math.abs(Y[2][3])*Math.abs(v4)*Math.sin(s3-s4-Complex.phase(Y[2][3]))));	
			dp3ds4 = Math.abs(v3)*Math.abs(Y[2][3])*Math.abs(v4)*Math.sin(s3-s4-Complex.phase(y[2][3]));
			dp3dv2 = Math.abs(v3)*Math.abs(Y[2][1])*Math.cos(s3-s2-Complex.phase(Y[2][1])); 
			dp3dv3 = Math.abs(y[2][0])*Math.cos(s3-Complex.phase(y[2][0]))+Math.abs(Y[2][1])*Math.abs(v2)*cos(s3-s2-Complex.phase(Y[2][1]))+2*Math.abs(v3)*Math.abs(y[2][2])*Math.cos(Complex.phase(Y[2][2]))+Math.abs(Y[2][3])*Math.abs(v4)*Math.cos(s3-s4-Complex.phase(Y[2][3]));
			dp3dv4 = Math.abs(v3)*Math.abs(Y[2][3])*Math.cos(s3-s4-Complex.phase(Y[2][3]));
	
			dq3ds2 = -Math.abs(v3)*Math.abs(Y[2][1])*Math.abs(v2)*Math.cos(s3-s3-Compelx.phase(Y[2][1]));
			dq3ds3 = Math.abs(v3)*(Math.abs(Y[2][0]*Math.cos(s3-Complex.phase(Y[2][0]))+Math.abs(Y[2][1])*Math.abs(v2)*Math.cos(s3-s2-Complex.phase(Y[2][1]))+Math.abs(Y[2][3])*Math.abs(v4)*Math.cos(s3-s4-Complex.phase(Y[2][3]))));	
			dq3ds4 = -Math.abs(v3)*Math.abs(Y[2][3])*Math.abs(v4)*Math.cos(s3-s4-Complex.phase(y[2][3]));
			dq3dv2 = Math.abs(v3)*Math.abs(Y[2][1])*Math.sin(s3-s2-Complex.phase(Y[2][1])); 
			dq3dv3 = Math.abs(y[2][0])*Math.sin(s3-Complex.phase(y[2][0]))+Math.abs(Y[2][1])*Math.abs(v2)*sin(s3-s2-Complex.phase(Y[2][1]))+2*Math.abs(v3)*Math.abs(y[2][2])*Math.sin(Complex.phase(Y[2][2]))+Math.abs(Y[2][3])*Math.abs(v4)*Math.sin(s3-s4-Complex.phase(Y[2][3]));
			dq3dv4 = Math.abs(v3)*Math.abs(Y[2][3])*Math.sin(s3-s4-Complex.phase(Y[2][3]));
	
			dp4ds2 = Math.abs(v4)*Math.abs(Y[3][1])*Math.abs(v2)*Math.sin(s4-s2-Compelx.phase(Y[3][1]));
			dp4ds3 = Math.abs(v4)*Math.abs(Y[3][2])*Math.abs(v3)*Math.sin(s4-s3-Complex.phase(Y[3][2]));
			dp4ds4 = -Math.abs(v4)*(Math.abs(Y[3][0])*Math.sin(s4-Complex.phase(Y[3][0]))+Math.abs(Y[3][1])*Math.abs(v2)*Math.cos(s4-s2-Complex.phase(Y[3][1]))+Math.abs(Y[3][2])*Math.abs(v3)*Math.sin(s4-s3-Complex.phase(Y[3][2])));
			dp4dv2 = Math.abs(v4)*Math.abs(Y[3][1])*Math.cos(s4-s2-Complex.phase(Y[3][1])); 
			dp4dv3 = Math.abs(v4)*Math.abs(Y[3][2])*Math.cos(s4-s3-Complex.phase(Y[3][2]));
			dp4dv4 = Math.abs(y[3][0])*Math.cos(s4-Complex.phase(y[3][0]))+Math.abs(Y[3][1])*Math.abs(v2)*Math.cos(s4-s2-Complex.phase(Y[3][1]))+Math.abs(Y[3][2])*Math.abs(v3)*Math.cos(s4-s3-Complex.phase(Y[3][2]))+2*Math.abs(v4)*Math.abs(y[3][3])*Math.cos(Complex.phase(Y[3][3]));
			
			dq4ds2 = -Math.abs(v4)*Math.abs(Y[3][1])*Math.abs(v2)*Math.cos(s4-s2-Compelx.phase(Y[3][1]));
			dq4ds3 = -Math.abs(v4)*Math.abs(Y[3][2])*Math.abs(v3)*Math.cos(s4-s3-Complex.phase(Y[3][2]));
			dq4ds4 = Math.abs(v4)*(Math.abs(Y[3][0])*Math.cos(s4-Complex.phase(Y[3][0]))+Math.abs(Y[3][1])*Math.abs(v2)*Math.cos(s4-s2-Complex.phase(Y[3][1]))+Math.abs(Y[3][2])*Math.abs(v3)*Math.cos(s4-s3-Complex.phase(Y[3][2])));
			dq4dv2 = Math.abs(v4)*Math.abs(Y[3][1])*Math.sin(s4-s2-Complex.phase(Y[3][1])); 
			dq4dv3 = Math.abs(v4)*Math.abs(Y[3][2])*Math.sin(s4-s3-Complex.phase(Y[3][2]));
			dq4dv4 = Math.abs(y[3][0])*Math.sin(s4-Complex.phase(y[3][0]))+Math.abs(Y[3][1])*Math.abs(v2)*Math.sin(s4-s2-Complex.phase(Y[3][1]))+Math.abs(Y[3][2])*Math.abs(v3)*Math.sin(s4-s3-Complex.phase(Y[3][2]))+2*Math.abs(v4)*Math.abs(y[3][3])*Math.sin(Complex.phase(Y[3][3]));
			
			
			double [][] J = new double [6][6];
			J = {{dp2ds2, dp2ds3, dp2ds4, dp2dv2, dp2dv3, dp2dv4}, {dq2ds2, dq2ds3,
					 dq2ds4, dq2dv2, dq2dv3, dq2dv4}, {dp3ds2, dp3ds3, dp3ds4, dp3dv2,
					 dp3dv3, dp3dv4}, {dq3ds2, dq3ds3, dq3ds4, dq3dv2, dq3dv3, dq3dv4},
					 {dp4ds2, dp4ds3, dp4ds4, dp4dv2, dp4dv3, dp4dv4}, {dq4ds2, dq4ds3,
					 dq4ds4, dq4dv2, dq4dv3, dq4dv4}
				};
			
			double [][] J1;
			
			Inverse invert = new Inverse();
			this.J1 = Inverse.invert(J1); 
					
			
			del_x = Modelmath.gausselim(J1,del_f);
			x= x + del_x;
			
		
		}
		
		COM_MAIN_CURRENT = -(MAIN_VOLTAGE - COM_MAIN_VOLTAGE)*Y[0][1];
		IND_MAIN_CURRENT = -(MAIN_VOLTAGE - IND_MAIN_VOLTAGE)*Y[0][2];
		RES_MAIN_CURRENT = -(MAIN_VOLTAGE - RES_MAIN_VOLTAGE)*Y[0][3];
		
		
    }
    
    
    
    
    
}

		
		
		
		
						
    
    
    
  
    
        

 