package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
	}

	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		System.out.println(prendreParole() +  "« Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée. »");
	}
	
	public void faireUneDonation(Musee musee) {
		System.out.println("Le gaulois " + getNom() + ": « Je donne au musee tous mes trophees :");
		for (int i = 0; i < nbTrophees; i++) {
			System.out.println("- " + this.trophees[i]);
			Trophee trophee = new Trophee(this, trophees[i]);
			musee.donnerTrophees(this, trophee);
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix;
		Romain cesar;
		asterix = new Gaulois("Astérix", 8);
		cesar = new Romain("César", 5);
		asterix.boirePotion(7);
		asterix.parler("Bonjour, je vais te frapper.");
		asterix.frapper(cesar);
	}
}