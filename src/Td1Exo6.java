
public class Td1Exo6 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exo6 exo = new Exo6();
		exo.question2();
		exo.question3();
		exo.question4();
	}

}

class Exo6{
	public Exo6() {}
	
	public long generator(long a, long m, long c, long Xn) {
		return (a*Xn+c) % m;
	}
	
	void question2() {
		long Xn = 657;
		long a = 8;
		long c = 3;
		long m = 7;
		System.out.println(" >>>>> Question 6.2");
		System.out.println(Xn);
		for(int i = 0; i < 10; i++) {
			long Xn1 = generator(a,m,c,Xn);
			System.out.println(Xn1);
			Xn = Xn1;
		}
	}
	
	void question3() {
		long a = 7;
		long c = 0;
		long m = 101;
		long Xn = 65324;
		System.out.println(" >>>>> Question 6.3");
		System.out.println(" >>>>> Pour a = 7");
		for(int i = 0; i < 200; i++) {
			long x = generator(a,m,c,Xn);
			long y = generator(a,m,c,x);
			System.out.println("Point de coordonnées= x: "+x+", y: "+y);
			Xn = x;
		}
		System.out.println();
		
		a = 12;
		System.out.println(" >>>>> Pour a = 12");
		for(int i = 0; i < 200; i++) {
			long x = generator(a,m,c,Xn);
			long y = generator(a,m,c,x);
			System.out.println("Point de coordonnées= x: "+x+", y: "+y);
			Xn = x;
		}
		System.out.println();
		
		a = 51;
		System.out.println(" >>>>> Pour a = 51");
		for(int i = 0; i < 200; i++) {
			long x = generator(a,m,c,Xn);
			long y = generator(a,m,c,x);
			System.out.println("Point de coordonnées= x: "+x+", y: "+y);
			Xn = x;
		}
	}
	
	void question4() {
		long a = 7;
		long c = 0;
		long m = 101;
		long Xn = 65324;
		System.out.println(" >>>>> Question 6.4");
		System.out.println(" >>>>> Pour a = 7");
		for(int i = 0; i < 200; i++) {
			long x = generator(a,m,c,Xn);
			long y = generator(a,m,c,x);
			long z = generator(a,m,c,y);
			System.out.println("Point de coordonnées= x: "+x+", y: "+y+", z: "+z);
			Xn = x;
		}
		System.out.println();
		
		a = 12;
		System.out.println(" >>>>> Pour a = 12");
		for(int i = 0; i < 200; i++) {
			long x = generator(a,m,c,Xn);
			long y = generator(a,m,c,x);
			long z = generator(a,m,c,y);
			System.out.println("Point de coordonnées= x: "+x+", y: "+y+", z: "+z);
			Xn = x;
		}
		System.out.println();
		
		a = 51;
		System.out.println(" >>>>> Pour a = 51");
		for(int i = 0; i < 200; i++) {
			long x = generator(a,m,c,Xn);
			long y = generator(a,m,c,x);
			long z = generator(a,m,c,y);
			System.out.println("Point de coordonnées= x: "+x+", y: "+y+", z: "+z);
			Xn = x;
		}
	}
}