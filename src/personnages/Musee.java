package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Trophee trophee) {
		trophees[nbTrophee] = trophee;
		nbTrophee++;
	}
	
	public String extraireInstructionsCaml() {
		String texte = "let musee = [\n";
		for (int i = 0; i < nbTrophee; i++) {
			texte = "	\"" + trophees[i].getGaulois() + "\", \"" + trophees[i].getEquipement() + "\";\n";
		}
		return texte;
	}
}