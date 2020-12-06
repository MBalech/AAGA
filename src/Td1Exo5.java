class MuAndLambda {

	private long Y;

	public MuAndLambda(){}

	private void getMuAndLambda(long graine, int function) {

		int n = 1;
		boolean egal = true;
		int mu = 0;
		int lambda = 0;
		while (egal) {
			long Xn = calculateXn(n, graine, function);
			long Xn1 = calculateXn(2*n, graine, function);
			System.out.println(Xn+" "+Xn1);
			if(Xn == Xn1){
				lambda = 2*n - n;
				int i = 0;
				long XnL = calculateXn(n-i, graine, function);
				long XnLL = calculateXn(n-i+lambda, graine, function);
				mu = n;
				i++;
				while(XnL == XnLL) {
					XnL = calculateXn(n-i, graine, function);
					XnLL = calculateXn(n-i+lambda, graine, function);
					mu = n;
					i++;
				}
				if(XnL != XnLL) egal = false;
			}
			n++;
		}

		System.out.println("mu: "+mu+", lambda: "+lambda);
	}

	private long calculateXn(int n, long X, int function){
		for (int i = 1; i <= n; i++){
			//Si c'est K
			if (function == 0) {
				this.Y = (long) (X/Math.pow(10,9));
				X = algoK(X);
			}
			// Si c'est Von Neumann
			if( function == 1) {
				X = vonNeumann(X);
			}
		}
		return X;
	}

	private long algoK(long x2){
		long Z = (long) (x2/Math.pow(10,8));
		if (x2 < 5* Math.pow(10,9))
			x2 = (long) (5*Math.pow(10,9));
		x2 = (long) ((Math.pow(x2,2)/Math.pow(10,5)) % Math.pow(10,10));
		x2 = (1001001001*x2) % 10;
		if (x2 < Math.pow(10,8))
			x2 += 9814055677L;
		else
			x2 = 10*10 - x2;
		x2 = (long) (Math.pow(10,5)*(x2 % Math.pow(10,5)) + (x2/Math.pow(10,5)));
		x2 = (long) ((1001001001 * x2) % Math.pow(10,10));
		this.Y = this.Y - 1;
		Z = Z -1;
		if (x2 < Math.pow(10,5) )
			x2 =  (long) (Math.pow(x2,2) + 99999);
		else
			x2 = x2 - 99999;
		while (x2 < Math.pow(10,9))
			x2 = 10*x2;
		x2 = (long) ((x2*(x2-1)/Math.pow(10,5)) % Math.pow(10,10));
		if (this.Y > 0 ){
			this.Y = this.Y - 1;
			return algoK(x2);
		}
		else
			return x2;
	}
	
	private long vonNeumann(long n) {
		return (long) ((Math.pow(n, 2)/ Math.pow(10, 5)) % Math.pow(10, 10));
	}

	public void execute(){
		/*System.out.println("    >>>> Pour 6065038420");
		this.Y = (long) (6065038420L/Math.pow(10,9));
		System.out.println("X: "+algoK(6065038420L)+", Y:"+this.Y);
		System.out.println();
		/*System.out.println("    >>>> Pour 3830951656");
		this.Y = (long) (3830951656L/Math.pow(10,9));
		System.out.println("X: "+algoK(3830951656L)+", Y:"+this.Y);
		System.out.println();*/
		System.out.println("    >>>> Pour muAndLambda avec algoK ");
		//getMuAndLambda(6543298743L, 0);
		
		getMuAndLambda(1234567890L, 1);
	}
}
public class Td1Exo5 {
	// TODO Auto-generated method stub
	public static void main(String[] args) {
		MuAndLambda mu = new MuAndLambda();
		mu.execute();
	}
}
