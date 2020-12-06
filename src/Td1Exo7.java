public class Td1Exo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Generator generator = new Generator();
		
		generator.initialize();
	}

}

class Generator{
	private long graine = 0;
	private Exo6 exo = new Exo6();
	public Generator() {}
	
	private long RAND48() {
		long a = 25214903917L;
		long m = (long) Math.pow(2, 48);
		long c = 11;
		
		
		
		return (a * this.graine + c)%m;
		
	}
	
	private void question1() {
		System.out.println(" >>>>> Question 7.1");
		this.graine = 0;
		System.out.println(this.graine);
		for(int i = 0; i <10; i++) {
			long result = RAND48();
			System.out.println(result);
			this.graine = result;
		}
		System.out.println();
	}
	
	private void question2() {
		System.out.println(" >>>>> Question 7.2");
		this.graine = 156079716630527L;
		System.out.println(this.graine);
		for(int i = 0; i <10; i++) {
			long result = RAND48();
			
			this.graine = result;
			long get = result >> 16;
			System.out.println("Result: "+get);
		}
	}
	
	public void initialize() {
		question1();
		question2();
	}
	
	public long getRand48(long graine) {
		this.graine = graine;
		return RAND48();
	}
}