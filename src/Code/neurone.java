package Code;

public class neurone{
	// Coefficient générique de mise à jour des poids, commun à tous les neurones
	public static float eta = 0.8f;
	
	// Tolérance générique permettant d'accepter la sortie d'un neurone comme valable
	public static float ToleranceSortie =  20f;//1.e-2f;
	
	// Tableau des points synaptiques d'un neurone
	private float[] synapses;
	
	// Valeur de sortie d'un neurone (à "Not A Number" par défaut)
	private float sortie = Float.NaN;
	
	// Fonction d'activation d'un neurone (peut facilement être modifiée par héritage)
	public float activation(final float valeur) {
		//System.out.println("valeur"+valeur);
		if (valeur>220-ToleranceSortie || valeur<220+ToleranceSortie)
		{
			//System.out.println("La 3");
			return 220;
		}
		else if (valeur>440-ToleranceSortie || valeur<440+ToleranceSortie)
		{
			//System.out.println("La 4");
			return 440;
		}
		else if (valeur>932-ToleranceSortie || valeur<932+ToleranceSortie)
		{
			//System.out.println("La# 5");
			return 932;
		}
		else 
			return 0;
			
	}
	
	// Constructeur d'un neurone
	public neurone(final int nbEntrees)
	{
		// Le tableau des poids synaptiques est une case plus grand que le nombre
		// de synapses, car la case en plus joue alors le rôle de "biais"
		synapses = new float[nbEntrees+1];
		
		// On initialise tous les poids de manière alétoire, biais compris
		for (int i = 0; i < nbEntrees+1; ++i)
			synapses[i] = (float)(Math.random()*2.-1.);
	}
	
	// Accesseur pour la valeur de sortie
	public float sortie() {return sortie;}
	
	// Donne accès aux valeurs des poids synaptiques et au biais
	public float[] synapses() {return synapses;}
	
	// Calcule la valeur de sortie en fonction des entrées, des poids synaptiques,
	// du biais et de la fonction d'activation
	public void metAJour(final float entrees)
	{
		// On démarre en extrayant le biais
		float somme = synapses[synapses.length-1];
		
		// Puis on ajoute les produits entrée-poids synaptique
		for (int i = 0; i < synapses.length-1; ++i)
			somme += entrees*synapses[i];
		
		// On fixe la sortie du neurone relativement à la fonction d'activation
		sortie = activation(somme);
	}
	
	// Fonction d'apprentissage permettant de mettre à jour les valeurs des 
	// poids synaptiques ainsi que du biais en fonction de données supervisées
	public void apprentissage(final float[] entrees, final float[] resultats)
	{
		// Un "drapeau" indiquant si toutes les entrées ont permis de trouver
		// les résultats attendus (=> l'apprentissage est alors fini), ou s'il
		// y a au moins un cas qui ne correspond pas (=> apprentissage pas fini)
		boolean apprentissageFini = false;
		while(apprentissageFini==false)
		{
			apprentissageFini=true;
			for(int k =0;k<entrees.length;k++)
			{
				this.metAJour(entrees[k]);
				//System.out.println("sortie-resultats="+Math.abs(this.sortie-resultats[k]));
				//System.out.println("sortie="+this.sortie);
				if(Math.abs(this.sortie-resultats[k])>this.ToleranceSortie)
				{
					this.synapses[k]=this.synapses[k]+entrees[k]*this.eta*(resultats[k]-this.sortie);
					this.synapses[this.synapses.length-1]=this.synapses[this.synapses.length-1]+this.eta*(resultats[k]-this.sortie);
					apprentissageFini=false;
				}
			}
		}
			
	}
		
		// On boucle tant que l'apprentissage n'est pas fini
			// On part du principe que tout va bien se passer => drapeau à vrai
			// Pour chacune des entrées fournies
				// On calcule la sortie du neurone en fonction de ces entrées
				// On regarde la différence avec le résultat attendu
				// Si l'erreur dépasse la tolérance autorisée 
					// On met à jour les poids synaptiques
					// On met à jour le biais 
					// On mémorise que l'apprentissage n'est pas finalisé
	
	public static void main(String[] args)
	{
		/* Tableau des entrées de la fonction ET (-1 = faux, 1 = vrai)
		final float[][] entrees = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
		
		// Tableau des sorties de la fonction ET
		final float[] resultats = {-1, -1, -1, 1};
		final float[] resultatsou = {-1, 1, 1, 1};
		// On crée un neurone taillé pour apprendre la fonction ET
		final neurone n = new neurone(entrees[0].length);
		final neurone n2= new neurone(entrees[0].length);
		// On lance l'apprentissage de la fonction ET sur ce neurone
		n.apprentissage(entrees, resultats);
		n2.apprentissage(entrees, resultatsou);
		// On affiche les valeurs des synapses et du biais
		for (float f : n.synapses())
			System.out.print(f+" ");
		System.out.println("");
		
		// On affiche chaque cas appris
		System.out.println("neurone1");
		/*for (int i = 0; i < entrees.length; ++i)
		{
			// Pour une entrée donnée
			final float[] entree = entrees[i];
			
			// On met à jour la sortie du neurone
			n.metAJour(entree);
			
			// On affiche cette sortie
			System.out.println("Entree "+i+" : "+n.sortie());
		}
		System.out.println("neurone2");
		for (int i = 0; i < entrees.length; ++i)
		{
			// Pour une entrée donnée
			final float[] entree = entrees[i];
			
			// On met à jour la sortie du neurone
			n2.metAJour(entree);
			
			// On affiche cette sortie
			System.out.println("Entree "+i+" : "+n2.sortie());
		}*/
	}
}
