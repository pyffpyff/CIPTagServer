package model;

public class Modelmath {
	//solves U = Y*K using Gaussian elimination with partial pivoting
		public static double[] gausselim(double[][] Y, double[] K){
			int dim = K.length;
			int imax = 0;
			double temp = 0;
			
			double[] intermediate = new double[dim];
			double[] solution = new double[dim];
			double[][] P = new double[dim][dim];
			double[][] L = new double[dim][dim];
			
			for(int i = 0;i<dim;i++){
				P[i][i] = 1;
				L[i][i] = 1;
			}
			
			for(int k = 0;k<dim-1;k++){
				//first find pivot row
				imax = k;
				for(int i = k;i<dim;i++){
					if(Y[i][k] > Y[imax][k]){
						imax = i;
					}
				}
				//switch rows
				Y = switchrows(Y,imax,k,-100);
				L = switchrows(L,imax,k,k-1);
				P = switchrows(P,imax,k,-100);
				
				/*
				System.out.println(String.format("k: %d, imax: %d", k, imax));
				
				System.out.println("Y");
				printmat(Y);
				System.out.println("L");
				printmat(L);
				System.out.println("P");
				printmat(P);
				*/
				
				//eliminate
				for(int j = k+1;j<dim;j++){
					L[j][k] = Y[j][k]/Y[k][k];
					for(int i = k;i<dim;i++){
						Y[j][i] = Y[j][i] - L[j][k]*Y[k][i];
					}
				}
			}
			
			/*
			System.out.println("printing U");
			printmat(Y);
			System.out.println("printing L");
			printmat(L);
			System.out.println("printing P");
			printmat(P);
			System.out.println("printing K");
			printvec(K);		
			*/
			
			//Y is now upper triangular
			//LUx = Pb
			//solve Ly = Pb using forward substitution
			intermediate = forsub(L,matvecmul(P,K));

			//printvec(matvecmul(P,K));
			//printvec(intermediate);
			
			//solve Ux = y using backward substitution
			solution = backsub(Y,intermediate);		
			//printvec(solution);
			
			return solution;
		}
		
		public static double[][] switchrows(double[][] A, int row1, int row2, int limit){
			int dim = A.length;
			double temp;
			
			if(limit > dim || limit < -98){
				limit = dim;
			}
			
			for(int i = 0;i<limit;i++){
				temp = A[row1][i];
				A[row1][i] = A[row2][i];
				A[row2][i] = temp;
			}
			return A;
		}
		
		//solves Lx = b using forward substitution
		public static double[] forsub(double[][] L, double[] b){
			int dim = b.length;
			double[] solution = new double[dim];
			
			for(int i = 0;i<dim;i++){
				solution[i] = b[i];
				for(int j = 0;j<i;j++){
					solution[i] -= L[i][j]*solution[j];
				}
				solution[i] = solution[i]/L[i][i];
			}
			
			return solution;
		}
		
		//solves Ux = b using backward substitution
		public static double[] backsub(double[][] U, double[] b){
			int dim = b.length;
			double[] solution = new double[dim];
			for(int i = dim-1;i>=0;i--){
				solution[i] = b[i];
				for(int j = dim-1;j>i;j--){
					solution[i] -= solution[j]*U[i][j];
				}
				solution[i] = solution[i]/U[i][i];
			}
			
			return solution;
		}
		
		public static double[] matvecmul(double[][] A, double[] x){
			int dim = x.length;
			double[] solution = new double[dim];
			
			for(int i = 0;i<dim;i++){
				solution[i] = 0;
				for(int j = 0;j<dim;j++){
					solution[i] += A[i][j]*x[j];
				}
			}
			return solution;
		}
		
		public static double[] vecadd(double[] x, double[] y){
			int dim = x.length;
			double[] solution = new double[dim];
			for(int i = 0; i< dim; i++){
				solution[i] = x[i] + y[i];
			}
			return solution;
		}
		
		public static double[] vecsub(double[] x, double[] y){
			int dim = x.length;
			double[] solution = new double[dim];
			for(int i = 0; i< dim; i++){
				solution[i] = x[i] - y[i];
			}
			return solution;
		}
		
		public static double vecmaxabs(double[] x){
			double result = 0;
			int dim = x.length;
			for(int i = 0;i<dim;i++){
				if(Math.abs(x[i]) > result){
					result = Math.abs(x[i]);
				}
			}
			return result;
		}
		
		public static void printmat(double[][] A){
			int dim = A.length;
			System.out.println(String.format("dimension: %d", dim));
			for(int i = 0;i<dim;i++){
				for(int j = 0;j<dim;j++){
					System.out.print(String.format("%5.2f ", A[i][j]));
				}
				System.out.print("\n");
			}
		}
		
		public static void printvec(double[] x){
			int dim = x.length;
			System.out.println(String.format("\nlength: %d",dim));
			for(int i = 0;i<dim;i++){
				System.out.println(String.format("%f",x[i]));
			}
		}

}
