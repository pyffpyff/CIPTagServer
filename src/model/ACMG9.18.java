package model;
import model.Source;

import model.Batt;

import model.Modelmath;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;
import model.complex;

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
		Y[1][2] = -ya;
		Y[1][3] = -yb;
		Y[1][4] = -yc;
		
		
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
				for(int i= 1;i<dim+1;i++){
					for(int j = i+1;j<dim;j++){
						Y[j][i] = Y[i][j];
					}
				}
    
		//sum elements of rows and negate to find diagonal
		for(int i = 1;i<5;i++){
			double sum = 0;
			for(int j = 1;j<5;j++){
				sum += Y[i][j];
			}
			Y[i][i] = -sum;
		}		
    
    
		for(int i = 1;i<K.length;i++){
			if(i<3){
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
					
		//display matrix for debugging
		//if(debugging){
		//	Modelmath.printmat(Y);
		//}
				
				
		//solve for the vector of unknowns
		//U = Modelmath.gausselim(Y,K);
		//decompose vector
		//???????
		
	
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
		
		double f1;
		double f2;
		double f3;
		double f4;
		double f5;
		double f6;
		
		f1 = v2*(Y[2][1]*Math.cos(a))
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		for(int i = 0;i<U.length;i++){
			if(i<4){
				busvoltages[i] = U[i];
			}
			else if(i>4 && i<7){
				gencurrents[i-4] = -U[i];
			}
		}
		
		
		
		
		//give tag values that are readable more convenient names
						
    
    
    
   }
    
    
        

    
