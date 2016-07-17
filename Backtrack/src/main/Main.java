package main;

import java.util.Random;

public class Main {
	
	 public static int[] g ;
	public static int[] f;
	//public static int[] x;
	public static final int N = 10;
	public static int b;
	public static int backtrack1 =0;
	public static int backtrack2 =0;
	static int optf =0;
	static int[] optx = new int[N];
	
	 public static void main(String[] args) {
		g = new int[10];
		f = new int[10];
		int[] x = new int[10];
		 Random r = new Random();
		
		 for (int i =0; i< 10 ; i++){
			 f[i]= r.nextInt(10);
			
			 g[i]= r.nextInt(10);
			 System.out.println("f"+i+": "+ f[i] +" | " +"g"+i+": "+ g[i]);
			 x[i]=0;
			 b+=g[i];
		 }
		 int gg=b;
		
		 b= b/3 *2;
		System.out.println("Backtrack1");
		backtrack1(-1, x);
		System.out.println(" f | g | x | optx | ");
		for(int i = 0; i< x.length; i++){
			System.out.println(" " +f[i] + " | " +g[i] + " | " +x[i] + " |  " +optx[i] + "   |" );
		}
	
		System.out.println("optf: " + optf);
		System.out.println("b: " + b);
		 System.out.println("gg: " +gg);
		 
		 System.out.println("Backtrack2");
		 optf=0;
		 for (int i =0; i< 10 ; i++){
			 optx[i]=0;
			 x[i]=0;
		 }
		 backtrack2(-1, x);
		 System.out.println(" f | g | x | optx | ");
			for(int i = 0; i< x.length; i++){
				System.out.println(" " +f[i] + " | " +g[i] + " | " +x[i] + " |  " +optx[i] + "   |" );
			}
		
			System.out.println("optf: " + optf);
			System.out.println("b: " + b);
			 System.out.println("gg: " +gg);
			 System.out.println("Backctrack1:" +backtrack1);
			 System.out.println("Backctrack2:" +backtrack2);
}

	 public static void backtrack1(int k, int[] x){
		backtrack1++;
		int aktf =0;
		if(k==N-1){
		int tmp=0;
		
		for(int i =0; i<x.length; i++){
			tmp+=g[i]*x[i];
			
		}
		if(tmp<=b){
			for(int i =0; i<x.length; i++){
				aktf+=f[i]*x[i];
				
			}
			if(aktf > optf ){
				optf=aktf;
				for(int i = 0; i< x.length; i++){
					optx[i]=x[i];
				}
				
				return;
			}
		}
		
	}
	else{
		
		x[k+1]=0;
		
		backtrack1(k+1, x );
		x[k+1]=1;
		
		backtrack1(k+1, x );
		
	}
	}
	 
	 
	 public static void backtrack2(int k, int[] x){
		 backtrack2++;
			int aktf =0;
			if(k==N-1){
			int tmp=0;
			
			for(int i =0; i<x.length; i++){
				tmp+=g[i]*x[i];
				
			}
			if(tmp<=b){
				for(int i =0; i<x.length; i++){
					aktf+=f[i]*x[i];
					
				}
				if(aktf > optf ){
					optf=aktf;
					for(int i = 0; i< x.length; i++){
						optx[i]=x[i];
					}
					
					return;
				}
			}
			
		}
		else{
			
			x[k+1]=0;
			
			backtrack2(k+1, x );
			x[k+1]=1;
			
			backtrack1(k+1, x );
			int tmp2 =0;
			for(int i =0; i<k+2; i++ ){
				tmp2+=g[i]*x[i];
			}
			if(tmp2<=b){
				backtrack2(k+1, x);
			}
		}
		}
	 
}