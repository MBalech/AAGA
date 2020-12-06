class arbreBinaire {
	int R;
	int feuilleD;
	int feuilleG;
	arbreBinaire nD;
	arbreBinaire nG;
	
}
class ABR {
	private int feuille = 1;
	public ABR() {}
	
	public void createArbre(int taille) {
		int r = 1;
		int n = 1;
		//Initialisation:
		arbreBinaire noeud = new arbreBinaire();
		noeud.R = 0;
		
		noeud.feuilleD = feuille;
		
		feuille++;
		
		while (n < taille) {
			noeud = getArbre(noeud, r);
			n++;
		}
		
		System.out.println(toString(noeud));
	}
	
	private String toString(arbreBinaire binaire) {
		String str = binaire.R+" -> ";
		
		if(binaire.nD != null) {
			str += binaire.nD.R+"\n";
			str += toString(binaire.nD);
		}else{
			str += "f"+binaire.feuilleD+"\n";
		}
		
		str += binaire.R+" -> ";
		if(binaire.nG != null) {
			str += binaire.nG.R+"\n";
			str += toString(binaire.nG);
		}else{
			str += "f"+binaire.feuilleG+"\n";
		}
		
		return str+"\n";
	}
	
	private arbreBinaire getArbre(arbreBinaire arbre, int r){
		if(r > arbre.R) {
			if(arbre.nD == null) {
				arbreBinaire ajout = new arbreBinaire();
				ajout.R = r;
				ajout.feuilleD = feuille;
				feuille++;
				ajout.feuilleG = feuille;
				feuille++;
				arbre.nD = ajout;
				arbre.feuilleD = -1;
			}
			else {
				getArbre(arbre.nD, r);
			}
		}
		else {
			if(arbre.nG == null) {
				arbreBinaire ajout = new arbreBinaire();
				ajout.R = r;
				ajout.feuilleD = feuille;
				feuille++;
				ajout.feuilleG = feuille;
				feuille++;
				arbre.nD = ajout;
				arbre.feuilleG = -1;
			}
			else {
				getArbre(arbre.nG, r);
			}
		}
		r++;
		
		return arbre;
	}
}
public class Td2Exo11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ABR abr = new ABR();
		abr.createArbre(3);
	}

}
