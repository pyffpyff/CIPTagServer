package model; 
import model.Modelmath;

//This is sample program to find the inverse of a matrix

    
     

    public class Inverse{ 

    
    

    	public static double[][] invert(double a[][]) 

        {

            int n = a.length;
            double h[][] = new double [n][n];
            for (int i =0;i<n;i++) {
            	for (int j=0;j<n;j++)
            		h[i][j]=a[i][j];
            }
            	

            double x[][] = new double[n][n];

            double b[][] = new double[n][n];

            int index[] = new int[n];

            for (int i=0; i<n; ++i) 

                b[i][i] = 1;

     

     // Transform the matrix into an upper triangle

            gaussian(h, index);

     

     // Update the matrix b[i][j] with the ratios stored

            for (int i=0; i<n-1; ++i)

                for (int j=i+1; j<n; ++j)

                    for (int k=0; k<n; ++k)

                        b[index[j]][k]

                        	    -= h[index[j]][i]*b[index[i]][k];
           
     // Perform backward substitutions

            for (int i=0; i<n; ++i) 

            {

                x[n-1][i] = b[index[n-1]][i]/h[index[n-1]][n-1];

                for (int j=n-2; j>=0; --j) 

                {

                    x[j][i] = b[index[j]][i];

                    for (int k=j+1; k<n; ++k) 

                    {

                        x[j][i] -= h[index[j]][k]*x[k][i];

                    }

                    x[j][i] /= h[index[j]][j];

                }

            }
             
            return x;

        }

     

    // Method to carry out the partial-pivoting Gaussian

    // elimination.  Here index[] stores pivoting order.

     

        public static void gaussian(double a[][], int index[]) 

        {

            int n = a.length;
            
            double c[] = new double[n];

     

     // Initialize the index

            for (int i=0; i<n; ++i) 

                index[i] = i;

     

     // Find the rescaling factors, one from each row

            for (int i=0; i<n; ++i) 

            {

                double c1 = 0;

                for (int j=0; j<n; ++j) 

                {

                    double c0 = Math.abs(a[i][j]);

                    if (c0 > c1) c1 = c0;

                }

                c[i] = c1;

            }

     

     // Search the pivoting element from each column

            int k = 0;

            for (int j=0; j<n-1; ++j) 

            {

                double pi1 = 0;

                for (int i=j; i<n; ++i) 

                {

                    double pi0 = Math.abs(a[index[i]][j]);

                    pi0 /= c[index[i]];

                    if (pi0 > pi1) 

                    {

                        pi1 = pi0;

                        k = i;

                    }

                }

     

       // Interchange rows according to the pivoting order

                int itmp = index[j];

                index[j] = index[k];

                index[k] = itmp;

                for (int i=j+1; i<n; ++i) 	

                {

                    double pj = a[index[i]][j]/a[index[j]][j];

     

     // Record pivoting ratios below the diagonal

                    a[index[i]][j] = pj;

     

     // Modify other elements accordingly

                    for (int l=j+1; l<n; ++l)

                        a[index[i]][l] -= pj*a[index[j]][l];

                }

            }

        }
        public static void main(String[] args) {
        // example 1 - solving a system of equations
     		double[][] a = {{1,2},{3,4}};//{ { 1, 1, 1 }, { 0, 2, 5 }, { 2, 5, -1 } };
     		System.out.println("a:");
     		Modelmath.printmat(a);
     		double[][] b = invert(a);
     		System.out.println("inverse matrix:");
     		Modelmath.printmat(b);
     		System.out.println("a*1/a:");
     	/*	double[][] c = {{1,2},{3,4}};
     		double[][] d = new double[a.length][a.length];
     		for (int i=0;i<a.length;i++) {
     			for(int j=0;j<a.length;j++) {
     				d[i][j]=b[i][j];
     			}
     		}
     		*/
     		Modelmath.printmat(Matrix2(a,b));
     		System.out.println();
        }
        
        
        public static double[][] Matrix2(double [][]a, double [][]b) {
        	int dim = b.length;
        	
        	double [][] c = new double [dim][dim];
        	
        	for (int k=0;k<dim;k++) {
        		for (int l=0;l<dim;l++) {
           			double sum =0;
        	
        		for(int j=0; j<dim;j++) {
        			sum += a[l][j]*b[j][k];
        			
        		}
        		c[k][l]= sum;
           			
       		//	System.out.println(sum);
    		
        	}
        	}
        
        return c;
        }
    }
    