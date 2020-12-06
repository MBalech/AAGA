import java.util.ArrayList;
import java.util.Random;

class noeud {
	int parent;
	int feuilled;
	int feuilleg;
	int position;
}

class ArbreRemy{
	private int noeud;
	
	public ArbreRemy(int noeud) {
		this.noeud = noeud;
	}
	
	private noeud[] initialisation () {
		int k = 0;
		int n = 1;
		noeud[] arbre = new noeud[k+1];
		
		int nouvelleFeuille = k + 2;
		
		int num = (int) (Math.random() * ((1 - 0) + 1)); // 0 pour droite, 1 pour gauche
		
		noeud noeud = new noeud();
		noeud.position = -1;
		if(num == 0) {
			noeud.feuilled = nouvelleFeuille;
			noeud.feuilleg = n;
		}
		else {
			noeud.feuilleg = nouvelleFeuille;
			noeud.feuilled = n;
		}
		
		
		arbre[k] = noeud;
		return arbre;
	}
	
	public noeud[] createArbre() {
		noeud[] arbre = initialisation();
		
		while(arbre.length < this.noeud) {
			int nouveauNoeud = arbre.length;
			noeud[] nouveauArbre = new noeud[arbre.length+1];
			for(int i = 0; i < arbre.length; i++) {
				nouveauArbre[i] = arbre[i];
			}
			
			int changeNoeud = 0;
			changeNoeud = (int) (Math.random() * (((arbre.length-1) - 1) + 1));
			int position = (int) (Math.random() * ((1 - 0) + 1)); // 0 pour droite, 1 pour gauche
			
			noeud noeud = new noeud();
			noeud.position = position;
			noeud.parent = changeNoeud;
			
			if(position == 0) {
				noeud.feuilled = nouveauNoeud+2;
				noeud.feuilleg = arbre[changeNoeud].feuilleg;
				nouveauArbre[changeNoeud].feuilleg = -1;
			}
			else {
				noeud.feuilled = arbre[changeNoeud].feuilled;
				noeud.feuilleg = nouveauNoeud+2;
				nouveauArbre[changeNoeud].feuilled = -1;
			}
			for(int i = 1; i < arbre.length; i++) {
				if(nouveauArbre[i].parent == changeNoeud && i != 0 && nouveauArbre[i].position == position) {
					nouveauArbre[i].parent = nouveauNoeud;
				}
			}
			
			nouveauArbre[nouveauNoeud] = noeud;
			
			arbre = nouveauArbre;
			//noeud noeud = new noeud ();
		}
		
		for(int i = 0; i < arbre.length; i++) {
			System.out.println("noeud: "+i+", position: "+arbre[i].position+", parent:"+arbre[i].parent+", enfant d: "+arbre[i].feuilled+", enfant g: "+arbre[i].feuilleg);
		}
		return arbre;
	}
}

public class Td2Exo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" >>>>>> Arbre de 10 noeuds");
		ArbreRemy remy = new ArbreRemy(10);
		remy.createArbre();
		
		System.out.println("\n >>>>>> Arbre de 30 noeuds");
		remy = new ArbreRemy(30);
		remy.createArbre();
		
		System.out.println("\n >>>>>> Arbre de 50 noeuds");
		remy = new ArbreRemy(50);
		remy.createArbre();
		
		System.out.println("\n >>>>>> Arbre de 100 noeuds");
		remy = new ArbreRemy(100);
		remy.createArbre();
		
		System.out.println("\n >>>>>> Arbre de 10000 noeuds");
		remy = new ArbreRemy(1000);
		remy.createArbre();
	
	}

}
