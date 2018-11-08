package model;
import model.Source;

import model.Batt;

import model.Modelmath;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;
//import model.Complex;
import model.Inverse;


public class ACMGmodel{
	double r;
	double rr;
	double ra;
	double rb;
	double rc;
	double rg;
	double ro;
	double xx;
	double xa;
	double xb;
	double xc;
	double vbase;
	double xbase;
	double rbase;
	double pbase;
	double qbase;
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
	
	double a1;
	double b1;
	double c1;
	double ll;
	double sl;
	//set p,q for power flow equation
	double v1;
	double v2;
	double v3;
	double v4;
	double s1;
	double s2;
	double s3;
	double s4;
	
	double []x;
	double [] f_x;
	double [][] J;
	double [][] J1;
	double []del_x;
	double []del_f;
	
	double p2;
	double p3;
	double p4;
	double q2;
	double q3;
	double q4;
	
	double powerfactor;
	
	int count;
	
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
	ACSource src1;
	
	Batt src2;
	
	
	double SOURCE_1_droopCoeff;
	double SOURCE_1_unregVtag;
	double SOURCE_1_psetpoint;
	int SOURCE_1_DROOP_SELECT;
	double SOURCE_2_droopCoeff;
	double SOURCE_2_unregVtag;
	double SOURCE_2_psetpoint;
	int SOURCE_2_DROOP_SELECT;
	int SOURCE_1_BATTERY_CHARGE_SELECT;
	int SOURCE_2_BATTERY_CHARGE_SELECT;
	
	double src1unregc;
	double src2unregc;
	double src1regc;
	double src2regc;
	double src1noloadv;
	double src2noloadv;
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
    
    double MAIN_CURRENT;
    double COM_MAIN_CURRENT;
    double COM_BUS1_CURRENT;
    double COM_B1L1_CURRENT;
    double COM_B1L2_CURRENT;
    double COM_B1L3_CURRENT;
    double COM_B1L4_CURRENT;
    double COM_B1L5_CURRENT;
    double COM_BUS2_CURRENT;
    double COM_B2L1_CURRENT;
    double COM_B2L2_CURRENT;
    double COM_B2L3_CURRENT;
    double COM_B2L4_CURRENT;
    double COM_B2L5_CURRENT;
    double IND_MAIN_CURRENT;
    double IND_BUS1_CURRENT;
    double IND_B1L1_CURRENT;
    double IND_B1L2_CURRENT;
    double IND_B1L3_CURRENT;
    double IND_B1L4_CURRENT;
    double IND_B1L5_CURRENT;
    double IND_BUS2_CURRENT;
    double IND_B2L1_CURRENT;
    double IND_B2L2_CURRENT;
    double IND_B2L3_CURRENT;
    double IND_B2L4_CURRENT;
    double IND_B2L5_CURRENT;
    double RES_MAIN_CURRENT;
    double RES_BUS1_CURRENT;
    double RES_B1L1_CURRENT;
    double RES_B1L2_CURRENT;
    double RES_B1L3_CURRENT;
    double RES_B1L4_CURRENT;
    double RES_B1L5_CURRENT;
    double RES_BUS2_CURRENT;
    double RES_B2L1_CURRENT;
    double RES_B2L2_CURRENT;
    double RES_B2L3_CURRENT;
    double RES_B2L4_CURRENT;
    double RES_B2L5_CURRENT;
    double RES_BUS3_CURRENT;
    double RES_B3L1_CURRENT;
    double RES_B3L2_CURRENT;
    double RES_B3L3_CURRENT;
    double RES_B3L4_CURRENT;
    double RES_B3L5_CURRENT;
    double RES_BUS4_CURRENT;
    double RES_B4L1_CURRENT;
    double RES_B4L2_CURRENT;
    double RES_B4L3_CURRENT;
    double RES_B4L4_CURRENT;
    double RES_B4L5_CURRENT;
    
  //source currents
    
    
    String logfilename = "modellog.csv";
	PrintWriter log = null;
	String[] signallist =  {
			"COM_MAIN_CURRENT", "COM_BUS1_CURRENT", "COM_B1L1_CURRENT",
		    "COM_B1L2_CURRENT", "COM_B1L3_CURRENT", "COM_B1L4_CURRENT",
		    "COM_B1L5_CURRENT", "COM_BUS2_CURRENT", "COM_B2L1_CURRENT",
		    "COM_B2L2_CURRENT", "COM_B2L3_CURRENT", "COM_B2L4_CURRENT",
		    "COM_B2L5_CURRENT", "IND_MAIN_CURRENT", "IND_BUS1_CURRENT",
		    "IND_B1L1_CURRENT", "IND_B1L2_CURRENT", "IND_B1L3_CURRENT",
		    "IND_B1L4_CURRENT", "IND_B1L5_CURRENT", "IND_BUS2_CURRENT",
		    "IND_B2L1_CURRENT", "IND_B2L2_CURRENT", "IND_B2L3_CURRENT",
		    "IND_B2L4_CURRENT", "IND_B2L5_CURRENT", "RES_MAIN_CURRENT",
		    "RES_BUS1_CURRENT",  "RES_B1L1_CURRENT", "RES_B1L2_CURRENT",
		    "RES_B1L3_CURRENT", "RES_B1L4_CURRENT", "RES_B1L5_CURRENT",
		    "RES_BUS2_CURRENT", "RES_B2L1_CURRENT", "RES_B2L2_CURRENT",
		    "RES_B2L3_CURRENT", "RES_B2L4_CURRENT", "RES_B2L5_CURRENT",
		    "RES_BUS3_CURRENT", "RES_B3L1_CURRENT", "RES_B3L2_CURRENT",
		    "RES_B3L3_CURRENT", "RES_B3L4_CURRENT", "RES_B3L5_CURRENT",
		    "RES_BUS4_CURRENT", "RES_B4L1_CURRENT", "RES_B4L2_CURRENT",
		    "RES_B4L3_CURRENT", "RES_B4L4_CURRENT", "RES_B4L5_CURRENT",
		    "RES_B5_CURRENT", "RES_B5L1_CURRENT", "RES_B5L2_CURRENT",
		    "RES_B5L3_CURRENT", "RES_B5L4_CURRENT", "RES_B5L5_CURRENT",
		    
		    "SOURCE_1_RegCurrent","SOURCE_2_RegCurrent","SOURCE_1_RegVoltage","SOURCE_2_RegVoltage",
			"SOURCE_1_UnregCurrent","SOURCE_2_UnregCurrent","SOURCE_1_UnregVoltage","SOURCE_2_UnregVoltage",
			"SOURCE_1_noLoadVoltage", "SOURCE_2_noLoadVoltage",
			
			"COM_MAIN_VOLTAGE",	"IND_MAIN_VOLTAGE", "RES_MAIN_VOLTAGE",
			"SOURCE_1_User","SOURCE_2_User",
			
			"COM_MAIN_USER", "COM_BUS1_USER", "COM_BUS1LOAD1_USER",
            "COM_BUS1LOAD2_USER", "COM_BUS1LOAD3_USER", "COM_BUS1LOAD4_USER",
            "COM_BUS1LOAD5_USER", "COM_BUS2_USER", "COM_BUS2LOAD1_USER",
            "COM_BUS1LOAD2_USER", "COM_BUS1LOAD3_USER", "COM_BUS1LOAD4_USER",
            "COM_BUS1LOAD5_USER", "IND_MAIN_USER", "IND_BUS1_USER",
            "IND_BUS1LOAD1_USER", "IND_BUS1LOAD2_USER", "IND_BUS1LOAD3_USER",
            "IND_BUS1LOAD4_USER", "IND_BUS1LOAD5_USER", "IND_BUS2_USER",
            "IND_BUS2LOAD1_USER", "IND_BUS1LOAD2_USER", "IND_BUS1LOAD3_USER",
            "IND_BUS1LOAD4_USER", "IND_BUS1LOAD5_USER", "RES_MAIN_USER",
            "RES_BUS1_USER", "RES_BUS1LOAD1_USER", "RES_BUS1LOAD2_USER",
            "RES_BUS1LOAD3_USER", "RES_BUS1LOAD4_USER", "RES_BUS1LOAD5_USER",
            "RES_BUS2_USER", "RES_BUS2LOAD1_USER", "RES_BUS2LOAD2_USER",
            "RES_BUS2LOAD3_USER", "RES_BUS2LOAD4_USER", "RES_BUS2LOAD5_USER",
            "RES_BUS3_USER", "RES_BUS3LOAD1_USER", "RES_BUS3LOAD2_USER",
            "RES_BUS3LOAD3_USER", "RES_BUS3LOAD4_USER", "RES_BUS3LOAD5_USER",
            "RES_BUS4_USER", "RES_BUS4LOAD1_USER", "RES_BUS4LOAD2_USER",
            "RES_BUS4LOAD3_USER", "RES_BUS4LOAD4_USER", "RES_BUS4LOAD5_USER",
            "RES_BUS5_USER", "RES_BUS5LOAD1_USER", "RES_BUS5LOAD2_USER",
            "RES_BUS5LOAD3_USER", "RES_BUS5LOAD4_USER", "RES_BUS5LOAD5_USER",
			
            "SOURCE_1_droopCoeff", "SOURCE_2_droopCoeff","SOURCE_1_unregVtag",
			"SOURCE_2_unregVtag", "SOURCE_1_DROOP_SELECT",
			"SOURCE_2_DROOP_SELECT", "SOURCE_1_BATTERY_CHARGE_SELECT",
			"SOURCE_2_BATTERY_CHARGE_SELECT", "powerfactor",
			
			
				
						
		    
	};

	public static void main(String[] args){		
		ACMGmodel acmg = new ACMGmodel();
		
		acmg.solvemodel(true);
		
	}
    
    public ACMGmodel() {
    	//radomly set value first
    	this.r = 0.05;
    	this.rr = 0;
		this.ra = 1.1;
		this.rb = 1.2;
		this.rc = 1.3;
		this.rg = 0.1;
		this.ro = 0.1;
		this.xx = 0;
		this.xa = 0.1;
		this.xb = 0.2;
		this.xc = 0.3;
		
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
    	this.SOURCE_2_User = 1;
    			
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
	    
	    this.powerfactor = 0;
	    
		this.src1loc = 1;
		this.src2loc = 2;
		
		this.src1regv = 24;
		this.src2regv = 24;
		
		this.src1unregv = 24;
		this.src2unregv = 24;
		
		this.src1noloadv = 24;
		this.src2noloadv = 24;
	
		this.src1regc = 0;
		this.src2regc = 0;
		
		this.src1unregc = 0;
		this.src2unregc = 0;
		
	    this.vbase=24;
	    this.rbase=1;
	    this.xbase=0.2;
	    this.pbase=576;
	    this.qbase=2880;
	       
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
		double[][] T = new double[dim][dim];
		double[] U = new double[dim];
		double[] K = new double[dim];
		
		
		a1 = Math.pow(ra, 2)+Math.pow(xa, 2);
		
		Y[0][1] = -Math.sqrt(a1);
		b1 = Math.pow(rb, 2)+Math.pow(xb, 2);
		Y[0][2] = -Math.sqrt(b1);
		c1 = Math.pow(rc, 2)+Math.pow(xc, 2);
		Y[0][3] = -Math.sqrt(c1);
		ll = Math.pow(rr, 2)+Math.pow(xx, 2);
		sl = Math.pow(c1, 2);
			

		int connindex = 4;
		int SOURCE_1_connindex = -1;
		int SOURCE_2_connindex = -1;
		   
		if(SOURCE_1_User == 1){
			Y[src1loc][connindex] =1;	
			SOURCE_1_connindex = connindex;
			connindex++;
			
		}
		if(SOURCE_2_User == 1){
			Y[src2loc][connindex] =1;	
			SOURCE_2_connindex = connindex;
			connindex++;
		}
    
		//make the matrix symmetric
				for(int i= 0;i<dim;i++){
					for(int j = i+1;j<dim;j++){
						Y[j][i] = Y[i][j];
					}
				}
    
		//sum elements of rows and negate to find diagonal
		double a0;
		a0 = Math.pow((ra+rb+rc), 2)+Math.pow((xa+xb+xc), 2);
		Y[0][0] = -Math.sqrt(a0);
				
		
		Y[1][1] = - Y[1][0] ;
		Y[2][2] = - Y[2][0];
		Y[3][3] = - Y[3][0] ;
		
		
    
		for(int i = 0;i<K.length;i++){
			if(i<6){
				K[i] = 0;
			}
			if(i == SOURCE_1_connindex){
				
					K[i] = src1regv;
								
			}
			else if(i == SOURCE_2_connindex){
				
					K[i] = src2regv;
				}			
			}		
		
		for(int m=0;m<6;m++) {
			for(int n=0;n<6;n++) {
				T[m][n]=Y[m][n];
			}
		}
		
		//these entries help us find the unknown currents
		if(SOURCE_1_User == 1){
			T[SOURCE_1_connindex][SOURCE_1_connindex] = -ro * SOURCE_1_User;
		}
		if(SOURCE_2_User == 1){
			T[SOURCE_2_connindex][SOURCE_2_connindex] = -ro * SOURCE_2_User;
		}
/*		
		System.out.print("Y:");
		Modelmath.printmat(Y);
		System.out.println();
*/			
		U = Modelmath.gausselim(T,K);
		
		
		this.v1 = 1.0;
		this.s1 = 0;
		
		this.s2 = 0;
		this.s3 = 0;
		this.s4 = 0;
			
		this.v2 = 1.0;
		this.v3 = 1.0;
		this.v4 = 1.0;
		
		double [] x = { s2, s3, s4,v2, v3, v4};
		double epsilon = 0.0001;
		int maxiter = 30;
		this.count = 1;
		
			
		for (count = 1;count < maxiter;count++) {
/*			
			System.out.println();
			System.out.print("start    ");
			System.out.print(" iteration: ");
			System.out.println(count);
			
			System.out.println("x:");
			for(int i=0;i<6;i++) {
				System.out.print(x[i]);
				System.out.print("   ");
			}
			System.out.println();
*/			
			this.p2 =Math.pow(x[0], 2)/ra/pbase;
			this.p3 =Math.pow(x[1], 2)/rb/pbase;
			this.p4 =Math.pow(x[2], 2)/rc/pbase;
			this.q2 =Math.pow(x[3], 2)/xa/qbase;
			this.q3 =Math.pow(x[4], 2)/xb/qbase;
			this.q4 =Math.pow(x[5], 2)/xc/qbase;
			
			double [] b = {p2, p3, p4, q2, q3, q4};
/*			System.out.println("b:");
			for(int i=0;i<6;i++) {
				System.out.print(b[i]);
				System.out.print("   ");
			}
			System.out.println();
*/			
			
			double f1;//p2
			double f2;//p3
			double f3;//p4
			double f4;//q2
			double f5;//q3
			double f6;//q4
	                                             
			
			f1 = Math.abs(x[3])*(Math.abs(Y[1][0])*Math.cos(x[0]-Math.atan(xa/ra))+Math.abs(Y[1][1])*Math.abs(x[3])*-Math.cos(Math.atan(xa/ra))+Math.abs(Y[1][2])*Math.abs(x[4])*Math.cos(x[0]-x[1]-0)+Math.abs(Y[1][3])*Math.abs(x[5])*Math.cos(x[0]-x[2]-0));
			f2 = Math.abs(x[4])*(Math.abs(Y[2][0])*Math.cos(x[1]-Math.atan(xb/rb))+Math.abs(Y[2][1])*Math.abs(x[3])*Math.cos(x[1]-x[0]-0)+Math.abs(Y[2][2])*Math.abs(x[4])*-Math.cos(Math.atan(xb/rb))+Math.abs(Y[2][3])*Math.abs(x[5])*Math.cos(x[1]-x[2]-0));
			f3 = Math.abs(x[5])*(Math.abs(Y[3][0])*Math.cos(x[2]-Math.atan(xc/rc))+Math.abs(Y[3][1])*Math.abs(x[3])*Math.cos(x[2]-x[0]-0)+Math.abs(Y[3][2])*Math.abs(x[4])*Math.cos(x[2]-x[1]-0)+Math.abs(Y[3][3])*Math.abs(x[5])*-Math.cos(Math.atan(xc/rc)));
			f4 = Math.abs(x[3])*(Math.abs(Y[1][0])*Math.sin(x[0]-Math.atan(xa/ra))+Math.abs(Y[1][1])*Math.abs(x[3])*-Math.sin(Math.atan(xa/ra))+Math.abs(Y[2][3])*Math.abs(x[4])*Math.sin(x[0]-x[1]-0)+Math.abs(Y[1][3])*Math.abs(x[5])*Math.sin(x[0]-x[2]-0));
			f5 = Math.abs(x[4])*(Math.abs(Y[2][0])*Math.sin(x[1]-Math.atan(xb/rb))+Math.abs(Y[2][1])*Math.abs(x[3])*Math.sin(x[1]-x[0]-0)+Math.abs(Y[2][2])*Math.abs(x[4])*-Math.sin(Math.atan(xb/rb))+Math.abs(Y[2][3])*Math.abs(x[5])*Math.sin(x[1]-x[2]-0));
			f6 = Math.abs(x[5])*(Math.abs(Y[3][0])*Math.sin(x[2]-Math.atan(xc/rc))+Math.abs(Y[3][1])*Math.abs(x[3])*Math.sin(x[2]-x[0]-0)+Math.abs(Y[3][2])*Math.abs(x[4])*Math.sin(x[2]-x[1]-0)+Math.abs(Y[3][3])*Math.abs(x[5])*-Math.sin(Math.atan(xc/rc)));
				
			
			double [] f_x = {f1,f2,f3,f4,f5,f6};
/*			System.out.println("f_x:");
			for(int i=0;i<6;i++) {
				System.out.print(f_x[i]);
				System.out.print("   ");
			}
			System.out.println();
*/			
			double [] Del_f = new double [6];
			
		
		
			for(int i = 0;i<6;i++){
				Del_f[i] = b[i] - f_x[i];
			}
/*			
			System.out.println("Del_f:");
			for(int i=0;i<6;i++) {
				System.out.print(Del_f[i]);
				System.out.print("   ");
			}
			System.out.println();
*/			
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
			
			dp2ds2 = -Math.abs(x[3])*(Math.abs(Y[1][0])*Math.sin(x[0]-Math.atan(xa/ra))+Math.abs(Y[1][2])*Math.abs(x[4])*Math.sin(x[0]-x[1]-0)+Math.abs(Y[1][3])*Math.abs(x[5])*Math.sin(x[0]-x[2]-0));
			dp2ds3 = Math.abs(x[3])*Math.abs(Y[1][2])*Math.abs(x[4])*Math.sin(x[0]-x[1]-0);
			dp2ds4 = Math.abs(x[3])*Math.abs(Y[1][3])*Math.abs(x[5])*Math.sin(x[0]-x[2]-0);
			dp2dv2 = Math.abs(Y[1][0])*Math.cos(x[0]-Math.atan(xa/ra))+2*Math.abs(x[3])*Math.abs(Y[1][1])*-Math.cos(Math.atan(xa/ra))+Math.abs(Y[1][2])*Math.abs(x[4])*Math.cos(x[0]-x[1]-0)+Math.abs(Y[1][3])*Math.abs(x[5])*Math.cos(x[0]-x[2]-0);
			dp2dv3 = Math.abs(x[3])*Math.abs(Y[1][2])*Math.cos(x[0]-x[1]-0);
			dp2dv4 = Math.abs(x[3])*Math.abs(Y[1][3])*Math.cos(x[0]-x[2]-0);
			
			dq2ds2 = Math.abs(x[3])*(Math.abs(Y[1][0])*Math.cos(x[0]-Math.atan(xa/ra))+Math.abs(Y[1][2])*Math.abs(x[4])*Math.cos(x[0]-x[1]-0)+Math.abs(Y[1][3])*Math.abs(x[5])*Math.cos(x[0]-x[2]-0));
			dq2ds3 = -Math.abs(x[3])*Math.abs(Y[1][2])*Math.abs(x[4])*Math.cos(x[0]-x[1]-0);
			dq2ds4 = -Math.abs(x[3])*Math.abs(Y[1][3])*Math.abs(x[5])*Math.cos(x[0]-x[2]-0);
			dq2dv2 = Math.abs(Y[1][0])*Math.sin(x[0]-Math.atan(xa/ra))-2*Math.abs(x[3])*Math.abs(Y[1][1])*-Math.sin(Math.atan(xa/ra))+Math.abs(Y[1][2])*Math.abs(x[4])*Math.sin(x[0]-x[1]-0)+Math.abs(Y[1][3])*Math.abs(x[5])*Math.sin(x[0]-x[2]-0);
			dq2dv3 = Math.abs(x[3])*Math.abs(Y[1][2])*Math.sin(x[0]-x[1]-0);
			dq2dv4 = Math.abs(x[3])*Math.abs(Y[1][3])*Math.sin(x[0]-x[2]-0);
			
			dp3ds2 = Math.abs(x[4])*Math.abs(Y[2][1])*Math.abs(x[3])*Math.sin(x[1]-x[0]-0);
			dp3ds3 = -Math.abs(x[4])*(Math.abs(Y[2][0])*Math.sin(x[1]-Math.atan(xb/rb))+Math.abs(Y[2][1])*Math.abs(x[3])*Math.sin(x[1]-x[0]-0)+Math.abs(Y[2][3])*Math.abs(x[5])*Math.sin(x[1]-x[2]-0));	
			dp3ds4 = Math.abs(x[4])*Math.abs(Y[2][3])*Math.abs(x[5])*Math.sin(x[1]-x[2]-0);
			dp3dv2 = Math.abs(x[4])*Math.abs(Y[2][1])*Math.cos(x[1]-x[0]-0); 
			dp3dv3 = Math.abs(Y[2][0])*Math.cos(x[1]-Math.atan(xb/rb))+Math.abs(Y[2][1])*Math.abs(x[3])*Math.cos(x[1]-x[0]-0)+2*Math.abs(x[4])*Math.abs(Y[2][2])*-Math.cos(Math.atan(xb/rb))+Math.abs(Y[2][3])*Math.abs(x[5])*Math.cos(x[1]-x[2]-0);
			dp3dv4 = Math.abs(x[4])*Math.abs(Y[2][3])*Math.cos(x[1]-x[2]-0);
	
			dq3ds2 = -Math.abs(x[4])*Math.abs(Y[2][1])*Math.abs(x[3])*Math.cos(x[1]-x[0]-0);
			dq3ds3 = Math.abs(x[4])*(Math.abs(Y[2][0])*Math.cos(x[1]-Math.atan(xb/rb))+Math.abs(Y[2][1])*Math.abs(x[3])*Math.cos(x[1]-x[0]-0)+Math.abs(Y[2][3])*Math.abs(x[5])*Math.cos(x[1]-x[2]-0));	
			dq3ds4 = -Math.abs(x[4])*Math.abs(Y[2][3])*Math.abs(x[5])*Math.cos(x[1]-x[2]-0);
			dq3dv2 = Math.abs(x[4])*Math.abs(Y[2][1])*Math.sin(x[1]-x[0]-0); 
			dq3dv3 = Math.abs(Y[2][0])*Math.sin(x[1]-Math.atan(xb/rb))+Math.abs(Y[2][1])*Math.abs(x[3])*Math.sin(x[1]-x[0]-0)+2*Math.abs(x[4])*Math.abs(Y[2][2])*-Math.sin(Math.atan(xb/rb))+Math.abs(Y[2][3])*Math.abs(x[5])*Math.sin(x[1]-x[2]-0);
			dq3dv4 = Math.abs(x[4])*Math.abs(Y[2][3])*Math.sin(x[1]-x[2]-0);
	
			dp4ds2 = Math.abs(x[5])*Math.abs(Y[3][1])*Math.abs(x[3])*Math.sin(x[2]-x[0]-0);
			dp4ds3 = Math.abs(x[5])*Math.abs(Y[3][2])*Math.abs(x[4])*Math.sin(x[2]-x[1]-0);
			dp4ds4 = -Math.abs(x[5])*(Math.abs(Y[3][0])*Math.sin(x[2]-Math.atan(xc/rc))+Math.abs(Y[3][1])*Math.abs(x[3])*Math.cos(x[2]-x[0]-0)+Math.abs(Y[3][2])*Math.abs(x[4])*Math.sin(x[2]-x[1]-0));
			dp4dv2 = Math.abs(x[5])*Math.abs(Y[3][1])*Math.cos(x[2]-x[0]-0); 
			dp4dv3 = Math.abs(x[5])*Math.abs(Y[3][2])*Math.cos(x[2]-x[1]-0);
			dp4dv4 = Math.abs(Y[3][0])*Math.cos(x[2]-Math.atan(xc/rc))+Math.abs(Y[3][1])*Math.abs(x[3])*Math.cos(x[2]-x[0]-0)+Math.abs(Y[3][2])*Math.abs(x[4])*Math.cos(x[2]-x[1]-0)+2*Math.abs(x[5])*Math.abs(Y[3][3])*-Math.cos(Math.atan(xc/rc));
			
			dq4ds2 = -Math.abs(x[5])*Math.abs(Y[3][1])*Math.abs(x[3])*Math.cos(x[2]-x[0]-0);
			dq4ds3 = -Math.abs(x[5])*Math.abs(Y[3][2])*Math.abs(x[4])*Math.cos(x[2]-x[1]-0);
			dq4ds4 = Math.abs(x[5])*(Math.abs(Y[3][0])*Math.cos(x[2]-Math.atan(xc/rc))+Math.abs(Y[3][1])*Math.abs(x[3])*Math.cos(x[2]-x[0]-0)+Math.abs(Y[3][2])*Math.abs(x[4])*Math.cos(x[2]-x[1]-0));
			dq4dv2 = Math.abs(x[5])*Math.abs(Y[3][1])*Math.sin(x[2]-x[0]-0); 
			dq4dv3 = Math.abs(x[5])*Math.abs(Y[3][2])*Math.sin(x[2]-x[1]-0);
			dq4dv4 = Math.abs(Y[3][0])*Math.sin(x[2]-Math.atan(xc/rc))+Math.abs(Y[3][1])*Math.abs(x[3])*Math.sin(x[2]-x[0]-0)+Math.abs(Y[3][2])*Math.abs(x[4])*Math.sin(x[2]-x[1]-0)+2*Math.abs(x[5])*Math.abs(Y[3][3])*-Math.sin(Math.atan(xc/rc));
			
			double [][] J =  {{dp2ds2, dp2ds3, dp2ds4, dp2dv2, dp2dv3, dp2dv4},  {dp3ds2, dp3ds3, dp3ds4, dp3dv2,
					 dp3dv3, dp3dv4},{dp4ds2, dp4ds3, dp4ds4, dp4dv2, dp4dv3, dp4dv4},{dq2ds2, dq2ds3, dq2ds4, dq2dv2, dq2dv3, dq2dv4}, 
					{dq3ds2, dq3ds3, dq3ds4, dq3dv2, dq3dv3, dq3dv4},  {dq4ds2, dq4ds3, dq4ds4, dq4dv2, dq4dv3, dq4dv4}
				};
			
			this.J1 = Inverse.invert(J); 
/*			System.out.print("J:");
			Modelmath.printmat(J);
			System.out.println();
*/			
			del_x =Matrix(J1,Del_f);
/*			
			System.out.println("del_x:");
			for(int i = 0; i<6;i++) {
				System.out.print(del_x[i]);
				System.out.print("   ");
			}
*/			
			for(int i = 0; i<6;i++) {
				x[i] = x[i] + del_x[i];
			}
/*			System.out.println("x:");
			for(int i = 0; i<6;i++) {
				System.out.print(x[i]);
				System.out.print("   ");
			}
			
			System.out.println();		
*/						
		}
		
		MAIN_VOLTAGE = 1.0 * 24;
		COM_MAIN_VOLTAGE = x[3] * 24;
		IND_MAIN_VOLTAGE = x[4] * 24;
		RES_MAIN_VOLTAGE = x[5] * 24;
		
		COM_MAIN_CURRENT = -(MAIN_VOLTAGE - COM_MAIN_VOLTAGE)*Y[0][1]*24;
		IND_MAIN_CURRENT = -(MAIN_VOLTAGE - IND_MAIN_VOLTAGE)*Y[0][2]*24;
		RES_MAIN_CURRENT = -(MAIN_VOLTAGE - RES_MAIN_VOLTAGE)*Y[0][3]*24;
		MAIN_CURRENT = COM_MAIN_CURRENT + IND_MAIN_CURRENT + RES_MAIN_CURRENT;
		
		COM_BUS1_CURRENT = 0.5*COM_MAIN_CURRENT;
		COM_BUS2_CURRENT = 0.5*COM_MAIN_CURRENT;
		COM_B1L1_CURRENT = 0.2*COM_BUS1_CURRENT;
		COM_B1L2_CURRENT = 0.2*COM_BUS1_CURRENT;
		COM_B1L3_CURRENT = 0.2*COM_BUS1_CURRENT;
		COM_B1L4_CURRENT = 0.2*COM_BUS1_CURRENT;
		COM_B1L5_CURRENT = 0.2*COM_BUS1_CURRENT;
		COM_B2L1_CURRENT = 0.2*COM_BUS2_CURRENT;
		COM_B2L2_CURRENT = 0.2*COM_BUS2_CURRENT;
		COM_B2L3_CURRENT = 0.2*COM_BUS2_CURRENT;
		COM_B2L4_CURRENT = 0.2*COM_BUS2_CURRENT;
		COM_B2L5_CURRENT = 0.2*COM_BUS2_CURRENT;
		
		IND_BUS1_CURRENT = 0.5*IND_MAIN_CURRENT;
		IND_BUS2_CURRENT = 0.5*IND_MAIN_CURRENT;
		IND_B1L1_CURRENT = 0.2*IND_BUS1_CURRENT;
		IND_B1L2_CURRENT = 0.2*IND_BUS1_CURRENT;
		IND_B1L3_CURRENT = 0.2*IND_BUS1_CURRENT;
		IND_B1L4_CURRENT = 0.2*IND_BUS1_CURRENT;
		IND_B1L5_CURRENT = 0.2*IND_BUS1_CURRENT;
		IND_B2L1_CURRENT = 0.2*IND_BUS2_CURRENT;
		IND_B2L2_CURRENT = 0.2*IND_BUS2_CURRENT;
		IND_B2L3_CURRENT = 0.2*IND_BUS2_CURRENT;
		IND_B2L4_CURRENT = 0.2*IND_BUS2_CURRENT;
		IND_B2L5_CURRENT = 0.2*IND_BUS2_CURRENT;
		
		RES_BUS1_CURRENT = 0.25*RES_MAIN_CURRENT;
		RES_BUS2_CURRENT = 0.25*RES_MAIN_CURRENT;
		RES_BUS3_CURRENT = 0.25*RES_MAIN_CURRENT;
		RES_BUS4_CURRENT = 0.25*RES_MAIN_CURRENT;
		RES_B1L1_CURRENT = 0.2*RES_BUS1_CURRENT;
		RES_B1L2_CURRENT = 0.2*RES_BUS1_CURRENT;
		RES_B1L3_CURRENT = 0.2*RES_BUS1_CURRENT;
		RES_B1L4_CURRENT = 0.2*RES_BUS1_CURRENT;
		RES_B1L5_CURRENT = 0.2*RES_BUS1_CURRENT;
		RES_B2L1_CURRENT = 0.2*RES_BUS2_CURRENT;
		RES_B2L2_CURRENT = 0.2*RES_BUS2_CURRENT;
		RES_B2L3_CURRENT = 0.2*RES_BUS2_CURRENT;
		RES_B2L4_CURRENT = 0.2*RES_BUS2_CURRENT;
		RES_B2L5_CURRENT = 0.2*RES_BUS2_CURRENT;
		RES_B3L1_CURRENT = 0.2*RES_BUS3_CURRENT;
		RES_B3L2_CURRENT = 0.2*RES_BUS3_CURRENT;
		RES_B3L3_CURRENT = 0.2*RES_BUS3_CURRENT;
		RES_B3L4_CURRENT = 0.2*RES_BUS3_CURRENT;
		RES_B3L5_CURRENT = 0.2*RES_BUS3_CURRENT;
		RES_B4L1_CURRENT = 0.2*RES_BUS4_CURRENT;
		RES_B4L2_CURRENT = 0.2*RES_BUS4_CURRENT;
		RES_B4L3_CURRENT = 0.2*RES_BUS4_CURRENT;
		RES_B4L4_CURRENT = 0.2*RES_BUS4_CURRENT;
		RES_B4L5_CURRENT = 0.2*RES_BUS4_CURRENT;
		
		
		//source currents
		
		if(SOURCE_1_User == 1){
			
			src1regc = MAIN_CURRENT;
	}
	else {
			src1regc = 0;
		
	}
	if(SOURCE_2_User == 1){
		
			src2regc = MAIN_CURRENT;
		}			
	
	else{
		
			src2regc = 0;
		
	}
		//System.out.println(String.format("regv: %f",src3regv));
		//System.out.println(String.format("regc: %f",src3regc));
		
			
		//write to log
	   
		this.log.println(String.format("%s,%s,%s,%s,%s,%s,%s\n",
				String.valueOf(MAIN_VOLTAGE),String.valueOf(COM_MAIN_VOLTAGE),String.valueOf(IND_MAIN_VOLTAGE),String.valueOf(RES_MAIN_VOLTAGE),
				String.valueOf(COM_MAIN_CURRENT),String.valueOf(IND_MAIN_CURRENT),String.valueOf(RES_MAIN_CURRENT)));
/*		
		if(debugging){
			System.out.println("BUS VOLTAGES:");
			System.out.println(String.format("Main bus: %f", MAIN_VOLTAGE));
			System.out.println(String.format("Commercial Main Bus: %f", COM_MAIN_VOLTAGE));
			System.out.println(String.format("Industrial Main Bus: %f", IND_MAIN_VOLTAGE));	
			System.out.println(String.format("Residential Main Bus: %f", RES_MAIN_VOLTAGE));
			System.out.println("BUS CURRENT:");
			System.out.println(String.format("Main bus: %f", MAIN_CURRENT));
			System.out.println(String.format("Commercial Main Bus: %f", COM_MAIN_CURRENT));
			System.out.println(String.format("Industrial Main Bus: %f", IND_MAIN_CURRENT));	
			System.out.println(String.format("Residential Main Bus: %f", RES_MAIN_CURRENT));
			System.out.println("Source VOLTAGES:");
			System.out.println(String.format("Source 1: %f", src1regv));
			System.out.println(String.format("Source 2: %f", src2regv));
			System.out.println("Source CURRENT:");
			System.out.println(String.format("Source 1: %f", src1regc));
			System.out.println(String.format("Source 2: %f", src2regc));
			
		}
*/		
}

    
    public Object[] fakeinterface(String mode, String[] tags, Object[] values){
		Object[] retval = new Object[tags.length];
		if(mode.equals("read")){
				for(int i = 0;i<tags.length;i++){
					if(tags[i].equals("MAIN_CURRENT")){
						retval[i] = new Float(MAIN_CURRENT);
					}
					else if(tags[i].equals("COM_MAIN_CURRENT")){
						retval[i] = new Float(COM_MAIN_CURRENT);
					}
					else if(tags[i].equals("COM_BUS1_CURRENT")){
						retval[i] = new Float(COM_BUS1_CURRENT);
					}
					else if(tags[i].equals("COM_B1L1_CURRENT")){
						retval[i] = new Float(COM_B1L1_CURRENT);
					}
					else if(tags[i].equals("COM_B1L2_CURRENT")){
						retval[i] = new Float(COM_B1L2_CURRENT);
					}
					else if(tags[i].equals("COM_B1L3_CURRENT")){
						retval[i] = new Float(COM_B1L3_CURRENT);
					}
					else if(tags[i].equals("COM_B1L4_CURRENT")){
						retval[i] = new Float(COM_B1L4_CURRENT);
					}
					else if(tags[i].equals("COM_B1L5_CURRENT")){
						retval[i] = new Float(COM_B1L5_CURRENT);
					}
					else if(tags[i].equals("COM_BUS2_CURRENT")){
						retval[i] = new Float(COM_BUS2_CURRENT);
					}
					else if(tags[i].equals("COM_B2L1_CURRENT")){
						retval[i] = new Float(COM_B2L1_CURRENT);
					}
					else if(tags[i].equals("COM_B2L2_CURRENT")){
						retval[i] = new Float(COM_B2L2_CURRENT);
					}
					else if(tags[i].equals("COM_B2L3_CURRENT")){
						retval[i] = new Float(COM_B2L3_CURRENT);
					}
					else if(tags[i].equals("COM_B2L4_CURRENT")){
						retval[i] = new Float(COM_B2L4_CURRENT);
					}
					else if(tags[i].equals("COM_B2L5_CURRENT")){
						retval[i] = new Float(COM_B2L5_CURRENT);
					}
					else if(tags[i].equals("IND_MAIN_CURRENT")){
						retval[i] = new Float(IND_MAIN_CURRENT);
					}
					else if(tags[i].equals("IND_BUS1_CURRENT")){
						retval[i] = new Float(IND_BUS1_CURRENT);
					}
					else if(tags[i].equals("IND_B1L1_CURRENT")){
						retval[i] = new Float(IND_B1L1_CURRENT);
					}
					else if(tags[i].equals("IND_B1L2_CURRENT")){
						retval[i] = new Float(IND_B1L2_CURRENT);
					}
					else if(tags[i].equals("IND_B1L3_CURRENT")){
						retval[i] = new Float(IND_B1L3_CURRENT);
					}
					else if(tags[i].equals("IND_B1L4_CURRENT")){
						retval[i] = new Float(IND_B1L4_CURRENT);
					}
					else if(tags[i].equals("IND_B1L5_CURRENT")){
						retval[i] = new Float(IND_B1L5_CURRENT);
					}
					else if(tags[i].equals("IND_BUS2_CURRENT")){
						retval[i] = new Float(IND_BUS2_CURRENT);
					}
					else if(tags[i].equals("IND_B2L1_CURRENT")){
						retval[i] = new Float(IND_B2L1_CURRENT);
					}
					else if(tags[i].equals("IND_B2L2_CURRENT")){
						retval[i] = new Float(IND_B2L2_CURRENT);
					}
					else if(tags[i].equals("IND_B2L3_CURRENT")){
						retval[i] = new Float(IND_B2L3_CURRENT);
					}
					else if(tags[i].equals("IND_B2L4_CURRENT")){
						retval[i] = new Float(IND_B2L4_CURRENT);
					}
					else if(tags[i].equals("IND_B2L5_CURRENT")){
						retval[i] = new Float(IND_B2L5_CURRENT);
					}
					else if(tags[i].equals("RES_MAIN_CURRENT")){
						retval[i] = new Float(RES_MAIN_CURRENT);
					}
					else if(tags[i].equals("RES_BUS1_CURRENT")){
						retval[i] = new Float(RES_BUS1_CURRENT);
					}
					else if(tags[i].equals("RES_B1L1_CURRENT")){
						retval[i] = new Float(RES_B1L1_CURRENT);
					}
					else if(tags[i].equals("RES_B1L2_CURRENT")){
						retval[i] = new Float(RES_B1L2_CURRENT);
					}
					else if(tags[i].equals("RES_B1L3_CURRENT")){
						retval[i] = new Float(RES_B1L3_CURRENT);
					}
					else if(tags[i].equals("RES_B1L4_CURRENT")){
						retval[i] = new Float(RES_B1L4_CURRENT);
					}
					else if(tags[i].equals("RES_B1L5_CURRENT")){
						retval[i] = new Float(RES_B1L5_CURRENT);
					}
					else if(tags[i].equals("RES_BUS2_CURRENT")){
						retval[i] = new Float(RES_BUS2_CURRENT);
					}
					else if(tags[i].equals("RES_B2L1_CURRENT")){
						retval[i] = new Float(RES_B2L1_CURRENT);
					}
					else if(tags[i].equals("RES_B2L2_CURRENT")){
						retval[i] = new Float(RES_B2L2_CURRENT);
					}
					else if(tags[i].equals("RES_B2L3_CURRENT")){
						retval[i] = new Float(RES_B2L3_CURRENT);
					}
					else if(tags[i].equals("RES_B2L4_CURRENT")){
						retval[i] = new Float(RES_B2L4_CURRENT);
					}
					else if(tags[i].equals("RES_B2L5_CURRENT")){
						retval[i] = new Float(RES_B2L5_CURRENT);
					}	
					else if(tags[i].equals("RES_BUS3_CURRENT")){
						retval[i] = new Float(RES_BUS3_CURRENT);
					}
					else if(tags[i].equals("RES_B3L1_CURRENT")){
						retval[i] = new Float(RES_B3L1_CURRENT);
					}
					else if(tags[i].equals("RES_B3L2_CURRENT")){
						retval[i] = new Float(RES_B3L2_CURRENT);
					}
					else if(tags[i].equals("RES_B3L3_CURRENT")){
						retval[i] = new Float(RES_B3L3_CURRENT);
					}
					else if(tags[i].equals("RES_B3L4_CURRENT")){
						retval[i] = new Float(RES_B3L4_CURRENT);
					}
					else if(tags[i].equals("RES_B3L5_CURRENT")){
						retval[i] = new Float(RES_B3L5_CURRENT);
					}
					else if(tags[i].equals("RES_BUS4_CURRENT")){
						retval[i] = new Float(RES_BUS4_CURRENT);
					}
					else if(tags[i].equals("RES_B4L1_CURRENT")){
						retval[i] = new Float(RES_B4L1_CURRENT);
					}
					else if(tags[i].equals("RES_B4L2_CURRENT")){
						retval[i] = new Float(RES_B4L2_CURRENT);
					}
					else if(tags[i].equals("RES_B4L3_CURRENT")){
						retval[i] = new Float(RES_B4L3_CURRENT);
					}
					else if(tags[i].equals("RES_B4L4_CURRENT")){
						retval[i] = new Float(RES_B4L4_CURRENT);
					}
					else if(tags[i].equals("RES_B4L5_CURRENT")){
						retval[i] = new Float(RES_B4L5_CURRENT);
					}
					else if(tags[i].equals("SOURCE_1_RegCurrent")){
						retval[i] = new Float(src1regc);
					}
					else if(tags[i].equals("SOURCE_2_RegCurrent")){
						retval[i] = new Float(src2regc);
					}				
					else if(tags[i].equals("SOURCE_1_RegVoltage")){
						retval[i] = new Float(src1regv);
					}
					else if(tags[i].equals("SOURCE_2_RegVoltage")){
						retval[i] = new Float(src2regv);
					}
					else if(tags[i].equals("SOURCE_1_UnregCurrent")){
						retval[i] = new Float(src1unregc);
					}
					else if(tags[i].equals("SOURCE_2_UnregCurrent")){
						retval[i] = new Float(src2unregc);
					}				
					else if(tags[i].equals("SOURCE_1_UnregVoltage")){
						retval[i] = new Float(src1unregv);
					}
					else if(tags[i].equals("SOURCE_2_UnregVoltage")){
						retval[i] = new Float(src2unregv);
					}	
					else if(tags[i].equals("SOURCE_1_noLoadVoltage")){
						retval[i] = new Float(src1unregv);
					}
					else if(tags[i].equals("SOURCE_2_noLoadVoltage")){
						retval[i] = new Float(src2unregv);
					}
					else if(tags[i].equals("MAIN_BUS_Voltage")){
						retval[i] = new Float(MAIN_VOLTAGE);
					}
					else if(tags[i].equals("COM_MAIN_VOLTAGE")){
						retval[i] = new Float(COM_MAIN_VOLTAGE);
					}
					else if(tags[i].equals("IND_MAIN_VOLTAGE")){
						retval[i] = new Float(IND_MAIN_VOLTAGE);
					}
					else if(tags[i].equals("RES_MAIN_VOLTAGE")){
						retval[i] = new Float(RES_MAIN_VOLTAGE);
					}
					else if(tags[i].equals("SOURCE_1_User")){
						retval[i] = int2bool(SOURCE_1_User);
					}	
					else if(tags[i].equals("SOURCE_2_User")){
						retval[i] = int2bool(SOURCE_2_User);
					}	
					else if(tags[i].equals("COM_MAIN_USER")){
						retval[i] = int2bool(COM_MAIN_USER);
					}
					else if(tags[i].equals("COM_BUS1_USER")){
						retval[i] = int2bool(COM_BUS1_USER);
					}
					else if(tags[i].equals("COM_BUS1LOAD1_USER")){
						retval[i] = int2bool(COM_BUS1_LOAD1_USER);
					}
					else if(tags[i].equals("COM_BUS1LOAD2_USER")){
						retval[i] = int2bool(COM_BUS1_LOAD2_USER);
					}
					else if(tags[i].equals("COM_BUS1LOAD3_USER")){
						retval[i] = int2bool(COM_BUS1_LOAD3_USER);
					}
					else if(tags[i].equals("COM_BUS1LOAD4_USER")){
						retval[i] = int2bool(COM_BUS1_LOAD4_USER);
					}
					else if(tags[i].equals("COM_BUS1LOAD5_USER")){
						retval[i] = int2bool(COM_BUS1_LOAD5_USER);
					}
					else if(tags[i].equals("COM_BUS2_USER")){
						retval[i] = int2bool(COM_BUS2_USER);
					}
					else if(tags[i].equals("COM_BUS2LOAD1_USER")){
						retval[i] = int2bool(COM_BUS2_LOAD1_USER);
					}
					else if(tags[i].equals("COM_BUS2LOAD2_USER")){
						retval[i] = int2bool(COM_BUS2_LOAD2_USER);
					}
					else if(tags[i].equals("COM_BUS2LOAD3_USER")){
						retval[i] = int2bool(COM_BUS2_LOAD3_USER);
					}
					else if(tags[i].equals("COM_BUS2LOAD4_USER")){
						retval[i] = int2bool(COM_BUS2_LOAD4_USER);
					}
					else if(tags[i].equals("COM_BUS2LOAD5_USER")){
						retval[i] = int2bool(COM_BUS2_LOAD5_USER);
					}	
					else if(tags[i].equals("IND_MAIN_USER")){
						retval[i] = int2bool(IND_MAIN_USER);
					}
					else if(tags[i].equals("IND_BUS1_USER")){
						retval[i] = int2bool(IND_BUS1_USER);
					}
					else if(tags[i].equals("IND_BUS1LOAD1_USER")){
						retval[i] = int2bool(IND_BUS1_LOAD1_USER);
					}
					else if(tags[i].equals("IND_BUS1LOAD2_USER")){
						retval[i] = int2bool(IND_BUS1_LOAD2_USER);
					}
					else if(tags[i].equals("IND_BUS1LOAD3_USER")){
						retval[i] = int2bool(IND_BUS1_LOAD3_USER);
					}
					else if(tags[i].equals("IND_BUS1LOAD4_USER")){
						retval[i] = int2bool(IND_BUS1_LOAD4_USER);
					}
					else if(tags[i].equals("IND_BUS1LOAD5_USER")){
						retval[i] = int2bool(IND_BUS1_LOAD5_USER);
					}
					else if(tags[i].equals("IND_BUS2_USER")){
						retval[i] = int2bool(IND_BUS2_USER);
					}
					else if(tags[i].equals("IND_BUS2LOAD1_USER")){
						retval[i] = int2bool(IND_BUS2_LOAD1_USER);
					}
					else if(tags[i].equals("IND_BUS2LOAD2_USER")){
						retval[i] = int2bool(IND_BUS2_LOAD2_USER);
					}
					else if(tags[i].equals("IND_BUS2LOAD3_USER")){
						retval[i] = int2bool(IND_BUS2_LOAD3_USER);
					}
					else if(tags[i].equals("IND_BUS2LOAD4_USER")){
						retval[i] = int2bool(IND_BUS2_LOAD4_USER);
					}
					else if(tags[i].equals("IND_BUS2LOAD5_USER")){
						retval[i] = int2bool(IND_BUS2_LOAD5_USER);
					}
					else if(tags[i].equals("RES_MAIN_USER")){
						retval[i] = int2bool(RES_MAIN_USER);
					}
					else if(tags[i].equals("RES_BUS1_USER")){
						retval[i] = int2bool(RES_BUS1_USER);
					}
					else if(tags[i].equals("RES_BUS1LOAD1_USER")){
						retval[i] = int2bool(RES_BUS1_LOAD1_USER);
					}
					else if(tags[i].equals("RES_BUS1LOAD2_USER")){
						retval[i] = int2bool(RES_BUS1_LOAD2_USER);
					}
					else if(tags[i].equals("RES_BUS1LOAD3_USER")){
						retval[i] = int2bool(RES_BUS1_LOAD3_USER);
					}
					else if(tags[i].equals("RES_BUS1LOAD4_USER")){
						retval[i] = int2bool(RES_BUS1_LOAD4_USER);
					}
					else if(tags[i].equals("RES_BUS1LOAD5_USER")){
						retval[i] = int2bool(RES_BUS1_LOAD5_USER);
					}
					else if(tags[i].equals("RES_BUS2_USER")){
						retval[i] = int2bool(RES_BUS2_USER);
					}
					else if(tags[i].equals("RES_BUS2LOAD1_USER")){
						retval[i] = int2bool(RES_BUS2_LOAD1_USER);
					}
					else if(tags[i].equals("RES_BUS2LOAD2_USER")){
						retval[i] = int2bool(RES_BUS2_LOAD2_USER);
					}
					else if(tags[i].equals("RES_BUS2LOAD3_USER")){
						retval[i] = int2bool(RES_BUS2_LOAD3_USER);
					}
					else if(tags[i].equals("RES_BUS2LOAD4_USER")){
						retval[i] = int2bool(RES_BUS2_LOAD4_USER);
					}
					else if(tags[i].equals("RES_BUS2LOAD5_USER")){
						retval[i] = int2bool(RES_BUS2_LOAD5_USER);
					}
					else if(tags[i].equals("RES_BUS3_USER")){
						retval[i] = int2bool(RES_BUS3_USER);
					}
					else if(tags[i].equals("RES_BUS3LOAD1_USER")){
						retval[i] = int2bool(RES_BUS3_LOAD1_USER);
					}
					else if(tags[i].equals("RES_BUS3LOAD2_USER")){
						retval[i] = int2bool(RES_BUS3_LOAD2_USER);
					}
					else if(tags[i].equals("RES_BUS3LOAD3_USER")){
						retval[i] = int2bool(RES_BUS3_LOAD3_USER);
					}
					else if(tags[i].equals("RES_BUS3LOAD4_USER")){
						retval[i] = int2bool(RES_BUS3_LOAD4_USER);
					}
					else if(tags[i].equals("RES_BUS3LOAD5_USER")){
						retval[i] = int2bool(RES_BUS3_LOAD5_USER);
					}
					else if(tags[i].equals("RES_BUS4_USER")){
						retval[i] = int2bool(RES_BUS4_USER);
					}
					else if(tags[i].equals("RES_BUS4LOAD1_USER")){
						retval[i] = int2bool(RES_BUS4_LOAD1_USER);
					}
					else if(tags[i].equals("RES_BUS4LOAD2_USER")){
						retval[i] = int2bool(RES_BUS4_LOAD2_USER);
					}
					else if(tags[i].equals("RES_BUS4_LOAD3_USER")){
						retval[i] = int2bool(RES_BUS4_LOAD3_USER);
					}
					else if(tags[i].equals("RES_BUS4LOAD4_USER")){
						retval[i] = int2bool(RES_BUS4_LOAD4_USER);
					}
					else if(tags[i].equals("RES_BUS4LOAD5_USER")){
						retval[i] = int2bool(RES_BUS4_LOAD5_USER);
					}
					else if(tags[i].equals("RES_BUS5_USER")){
						retval[i] = int2bool(RES_BUS5_USER);
					}
					else if(tags[i].equals("RES_BUS5LOAD1_USER")){
						retval[i] = int2bool(RES_BUS5_LOAD1_USER);
					}
					else if(tags[i].equals("RES_BUS5LOAD2_USER")){
						retval[i] = int2bool(RES_BUS5_LOAD2_USER);
					}
					else if(tags[i].equals("RES_BUS5LOAD3_USER")){
						retval[i] = int2bool(RES_BUS5_LOAD3_USER);
					}
					else if(tags[i].equals("RES_BUS5LOAD4_USER")){
						retval[i] = int2bool(RES_BUS5_LOAD4_USER);
					}
					else if(tags[i].equals("RES_BUS5LOAD5_USER")){
						retval[i] = int2bool(RES_BUS5_LOAD5_USER);
					}	
					else if(tags[i].equals("SOURCE_1_droopCoeff")){
						retval[i] = new Float(SOURCE_1_droopCoeff);
					}
					else if(tags[i].equals("SOURCE_2_droopCoeff")){
						retval[i] = new Float(SOURCE_2_droopCoeff);
					}
					else if(tags[i].equals("SOURCE_1_regVtag")){
						retval[i] = new Float(src1regv);
					}
					else if(tags[i].equals("SOURCE_2_regVtag")){
						retval[i] = new Float(src2regv);
					}
					else if(tags[i].equals("SOURCE_1_unregVtag")){
						retval[i] = new Float(src1unregv);
					}
					else if(tags[i].equals("SOURCE_2_unregVtag")){
						retval[i] = new Float(src2unregv);
					}
					else if(tags[i].equals("SOURCE_1_regItag")){
						retval[i] = new Float(src1regc);
					}
					else if(tags[i].equals("SOURCE_2_regItag")){
						retval[i] = new Float(src2regc);
					}
					else if(tags[i].equals("SOURCE_1_unregItag")){
						retval[i] = new Float(src1unregc);
					}
					else if(tags[i].equals("SOURCE_2_unregItag")){
						retval[i] = new Float(src2unregc);
					}
					else if(tags[i].equals("SOURCE_1_DROOP_SELECT")){
						retval[i] = int2bool(SOURCE_1_DROOP_SELECT);
					}
					else if(tags[i].equals("SOURCE_2_DROOP_SELECT")){
						retval[i] = int2bool(SOURCE_2_DROOP_SELECT);
					}	
					else if(tags[i].equals("SOURCE_1_BATTERY_CHARGE_SELECT")){
						retval[i] = int2bool(SOURCE_1_BATTERY_CHARGE_SELECT);
					}	
					else if(tags[i].equals("SOURCE_2_BATTERY_CHARGE_SELECT")){
						retval[i] = int2bool(SOURCE_2_BATTERY_CHARGE_SELECT);
					}
					else if(tags[i].equals("powerfactor")){
						retval[i] = new Float(powerfactor);
					}
			}	
		}
		else if (mode.equals("write")) {
			for(int i = 0;i<tags.length;i++){
				if(tags[i].equals("SOURCE_1_USER")){
					SOURCE_1_User = bool2int(retval[i]);
				}	
				else if(tags[i].equals("SOURCE_2_USER")){
					SOURCE_2_User = bool2int(retval[i]);
				}
				else if(tags[i].equals("COM_MAIN_USER")){
					COM_MAIN_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("COM_BUS1_USER")){
					COM_BUS1_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("COM_BUS1LOAD1_USER")){
					COM_BUS1_LOAD1_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("COM_BUS1LOAD2_USER")){
					COM_BUS1_LOAD2_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("COM_BUS1LOAD3_USER")){
					COM_BUS1_LOAD3_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("COM_BUS1LOAD4_USER")){
					COM_BUS1_LOAD4_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("COM_BUS1LOAD5_USER")){
					COM_BUS1_LOAD5_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("COM_BUS2_USER")){
					COM_BUS2_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("COM_BUS2LOAD1_USER")){
					COM_BUS2_LOAD1_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("COM_BUS2LOAD2_USER")){
					COM_BUS2_LOAD2_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("COM_BUS2LOAD3_USER")){
					COM_BUS2_LOAD3_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("COM_BUS2LOAD4_USER")){
					COM_BUS2_LOAD4_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("COM_BUS2LOAD5_USER")){
					COM_BUS2_LOAD5_USER = bool2int(retval[i]);
				}	
				else if(tags[i].equals("IND_MAIN_USER")){
					IND_MAIN_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("IND_BUS1_USER")){
					IND_BUS1_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("IND_BUS1LOAD1_USER")){
					IND_BUS1_LOAD1_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("IND_BUS1LOAD2_USER")){
					IND_BUS1_LOAD2_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("IND_BUS1LOAD3_USER")){
					IND_BUS1_LOAD3_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("IND_BUS1LOAD4_USER")){
					IND_BUS1_LOAD4_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("IND_BUS1LOAD5_USER")){
					IND_BUS1_LOAD5_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("IND_BUS2_USER")){
					IND_BUS2_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("IND_BUS2LOAD1_USER")){
					IND_BUS2_LOAD1_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("IND_BUS2LOAD2_USER")){
					IND_BUS2_LOAD2_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("IND_BUS2LOAD3_USER")){
					IND_BUS2_LOAD3_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("IND_BUS2LOAD4_USER")){
					IND_BUS2_LOAD4_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("IND_BUS2LOAD5_USER")){
					IND_BUS2_LOAD5_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_MAIN_USER")){
					RES_MAIN_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS1_USER")){
					RES_BUS1_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS1LOAD1_USER")){
					RES_BUS1_LOAD1_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS1LOAD2_USER")){
					RES_BUS1_LOAD2_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS1LOAD3_USER")){
					RES_BUS1_LOAD3_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS1LOAD4_USER")){
					RES_BUS1_LOAD4_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS1LOAD5_USER")){
					RES_BUS1_LOAD5_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS2_USER")){
					RES_BUS2_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS2LOAD1_USER")){
					RES_BUS2_LOAD1_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS2LOAD2_USER")){
					RES_BUS2_LOAD2_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS2LOAD3_USER")){
					RES_BUS2_LOAD3_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS2LOAD4_USER")){
					RES_BUS2_LOAD4_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS2LOAD5_USER")){
					RES_BUS2_LOAD5_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS3_USER")){
					RES_BUS3_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS3LOAD1_USER")){
					RES_BUS3_LOAD1_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS3LOAD2_USER")){
					RES_BUS3_LOAD2_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS3LOAD3_USER")){
					RES_BUS3_LOAD3_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS3LOAD4_USER")){
					RES_BUS3_LOAD4_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS3LOAD5_USER")){
					RES_BUS3_LOAD5_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS4_USER")){
					RES_BUS4_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS4LOAD1_USER")){
					RES_BUS4_LOAD1_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS4LOAD2_USER")){
					RES_BUS4_LOAD2_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS4LOAD3_USER")){
					RES_BUS4_LOAD3_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS4LOAD4_USER")){
					RES_BUS4_LOAD4_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS4LOAD5_USER")){
					RES_BUS4_LOAD5_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS5_USER")){
					RES_BUS5_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS5LOAD1_USER")){
					RES_BUS5_LOAD1_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS5LOAD2_USER")){
					RES_BUS5_LOAD2_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS5LOAD3_USER")){
					RES_BUS5_LOAD3_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS5LOAD4_USER")){
					RES_BUS5_LOAD4_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("RES_BUS5LOAD5_USER")){
					RES_BUS5_LOAD5_USER = bool2int(retval[i]);
				}
				else if(tags[i].equals("SOURCE_1_User")){
					SOURCE_1_User = bool2int(retval[i]);
				}
				else if(tags[i].equals("SOURCE_2_User")){
					SOURCE_2_User = bool2int(retval[i]);
				}
				else if(tags[i].equals("SOURCE_1_droopCoeff")){
					SOURCE_1_droopCoeff = bool2int(retval[i]);
				}
				else if(tags[i].equals("SOURCE_2_droopCoeff")){
					SOURCE_2_droopCoeff = bool2int(retval[i]);
				}
				else if(tags[i].equals("SOURCE_1_unregVtag")){
					SOURCE_1_unregVtag = bool2int(retval[i]);
				}
				else if(tags[i].equals("SOURCE_2_unregVtag")){
					SOURCE_2_unregVtag = bool2int(retval[i]);
				}
				else if(tags[i].equals("SOURCE_1_unregVtag")){
					SOURCE_1_unregVtag = bool2int(retval[i]);
				}
				else if(tags[i].equals("SOURCE_2_unregVtag")){
					SOURCE_2_unregVtag = bool2int(retval[i]);
				}
				else if(tags[i].equals("SOURCE_1_noLoadVoltage")){
					SOURCE_1_unregVtag = bool2int(retval[i]);
				}
				else if(tags[i].equals("SOURCE_2_noLoadVoltage")){
					SOURCE_2_unregVtag = bool2int(retval[i]);
				}
				else if(tags[i].equals("SOURCE_1_DROOP_SELECT")){
					SOURCE_1_DROOP_SELECT = bool2int(retval[i]);
				}
				else if(tags[i].equals("SOURCE_2_DROOP_SELECT")){
					SOURCE_2_DROOP_SELECT = bool2int(retval[i]);
				}	
				else if(tags[i].equals("SOURCE_1_BATTERY_CHARGE_SELECT")){
					SOURCE_1_BATTERY_CHARGE_SELECT = bool2int(retval[i]);
				}	
				else if(tags[i].equals("SOURCE_2_BATTERY_CHARGE_SELECT")){
					SOURCE_2_BATTERY_CHARGE_SELECT = bool2int(retval[i]);
				}	
			}
		}	
		if(retval != null){
			System.out.println("fake interface returns the following:");
			for(int i = 0;i<retval.length;i++){
				if(retval[i] != null){
					System.out.print(tags[i]);
					System.out.print(" : ");
					System.out.println(retval[i].toString());
				}
				else{
					System.out.println(String.format("index %d is null", i));
				}
			}
		}
		else{
			System.out.println("fake interface returns null");
		}

		return retval;
				
		}
    
    
    public double obj2double(Object in){
		double retval = 0;
		if(in instanceof Number){
			retval = ((Number) in).doubleValue();
		}		
		return retval;
	}
	
	public Boolean int2bool(int in){		
		Boolean retval;
		if(in == 1){
			retval = new Boolean(true);
		}
		else if(in == 0){
			retval = new Boolean(false);
		}
		else{
			System.out.println(String.format("int2bool got bad value: %d",in));
			retval = null;
		}
		return retval;
	}
	
	
	public int bool2int(Object boo){
		int retval;
		if(boo.equals(new Boolean(true))){
			retval = 1;
		}
		else if(boo.equals(new Boolean(false))){
			retval = 0;
		}
		else{
			System.out.println(String.format("bool2int got bad value: %s",boo.toString()));
			retval = -1;
		}
		return retval;
	}
	
	 public double[] Matrix(double [][]a, double []b) {
	    	dim = b.length;
	    	double []c = new double [dim];
	    	    			
	    	for (int i=0;i<dim;i++) {
	    		double sum = 0;
				for (int j=0;j<dim;j++) {
					sum += a[i][j] * b [j];
				}
				c[i]=sum;
			}
	    	
	    return c;
	    }
    
    
    
}

		



