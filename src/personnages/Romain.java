package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
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
	
	private void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipement == equipements[0]) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipements[0]);
			}
			else {
				equipements[1] = equipement;
				nbEquipement++;
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipements[1]);
			}
			break;
		default:
			equipements[0] = equipement;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'équipe avec un " + equipements[0]);
		}
	}
	
	private boolean forcePositive() {
		return (force > 0);
	}
	
	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus", 6);
		assert minus.forcePositive();
		minus.parler("Bonjour, tu vas me frapper.");
		minus.recevoirCoup(8);
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(casque);
	}
}