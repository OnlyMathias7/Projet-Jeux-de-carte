package class_traitement;


public class Regle {
private String message;
	
	public Regle(){
		
	}
	
	public String toString() {
		message="Bonjour, \nVoici les règles du jeu : ";
		message+="\nLe jeu se joue de 2 à 4 joueurs, chaque joueurs possèdent une mains de départ de 5 cartes. ";
		message+="\nLe joueurs possédant le 3 de carreau commence la partie sinon celui qui possède la carte la plus faible commence.";
		message+="\nPour y parvenir les joueurs ont la possibilité d’utiliser des combinaisons de cartes.";
		message+="\nLa difficulté de ce jeu va être le fait de toujours devoir jouer la même combinaison de départ mais avec un niveau de puissance +1 dans tous les cas";
		message+="\nil est également possible d’utiliser un 2 (carte la plus forte) qui mettra donc fin directement à la manche ou bien une bombe qui peut être contré par une bombe plus puissante.";
		message+="\nPar exemple, le premier joueur joue la carte 5, le joueur suivant devra OBLIGATOIREMENT jouer  un 6 (ou bien un 2 / une bombe),";
		message+="\n de même pour la combinaison 7/7 le joueur suivant devra obligatoirement jouer 8/8 (ou bien 2/2 ou une bombe).";
		message+="\nSi jamais le joueur suivant ne peut pas ou ne désire pas jouer, il «se couche» et pioche une carte, il devra attendre la fin de la manche.";
		message+="\nLa manche se termine lorsque la totalité des joueurs ne peut pas joué sur une combinaison placé par un joueur.";
		message+="\nLe joueur ayant gagné une manche devra donc relancer une autre manche avec une nouvelle combinaison s’il le désire.";
		message+="\n Si le joueur qui lance une manche ne peut pas jouer, il pioche une carte et c’est le joueur suivant qui commence.";
		message+="\nChaque joueur devra, au début de chacun de leurs tours, piocher une carte.";
		message+="\nUne fois la pioche vide, chaque il n'est plus possible de piocher donc la partie se finit avec les cartes en mains de chaques joueurs.";
		message+="\nLe premier joueur qui réussi à vider sa main remporte la partie.";
		
		return message;
	}

	public static void main(String[] args) {
		Regle n= new Regle();
		System.out.println(n.toString());
	}

}
