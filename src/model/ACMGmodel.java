package model;
import model.Source;

import model.Batt;

import model.Modelmath;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;

public class ACMGmodel{
	//load resistances
	double lr12;
	double lr23;
	double lr24;
	double lr25;
	
	//convert to conductivities
	double ly12;
	double ly23;
	double ly24;
	double ly25;
	
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
    	//load resistances the value is just random set now. need check
    	this.lr12=10;
    	this.lr23=10;
    	this.lr24=10;
    	this.lr25=10;
    	
    	this.ly12 = 1/lr12;
    	this.ly23 = 1/lr23;
    	this.ly24 = 1/lr24;
    	this.ly25 = 1/lr25;
    	
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
		
		//double[] gencurrents = new double[4];
		//double[] busvoltages = new double[4];
    
		//build admittance matrix
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   }
    
    
        