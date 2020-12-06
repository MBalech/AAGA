class Exercice9{
	Generator generator = new Generator();
	public Exercice9() {}
	
	private long getV0 (long v1, long v2) {
		Long V1 = v1 << 16;
		while (generator.getRand48(V1) != v2) {
			V1 = V1+1;
			System.out.println(V1);
		}
		
		return V1;
	}
	
	public void lancement() {
		Long v0 = getV0(-956251567L, -2113186617L);
		System.out.println(v0);
	}
}

public class Td1Exo9 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercice9 exo = new Exercice9();
		exo.lancement();
	}

}
