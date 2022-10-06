package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert (force>0);
		int forceDebut = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert (forceDebut > force);
	}
	
	private boolean forcePositive() {
		return (force > 0);
	}
	
	public static void main(String[] args) {
		Romain cesar;
		cesar = new Romain("César", 6);
		assert cesar.forcePositive();
		cesar.parler("Bonjour, tu vas me frapper.");
		cesar.recevoirCoup(8);
	}
}