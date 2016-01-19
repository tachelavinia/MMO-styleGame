package main;

public abstract class Ability{
	protected double damage;
	protected double baseDamage;
	/**
	 * calculeaza damage-ul pe care il da victimei functie de race modifier
	 * @param hero este parametrul pe care il primeste metoda, eroul pentru care se aplica modificatorul
	 * @return-ul pe care il trimite victimei
	 */
	public abstract double Attack(Hero hero);
	/**
	 * @return damage-ul pe care il trimite catre victima
	 */	
	public double getDamage() {
		return damage;
	}
	/**
	 * seteaza damage-ul pe care il va trimite catre victima la damage-ul calculat cu race modifiers
	 * @param damage -ul cu race modifier
	 */
	public void setDamage(double damage) {
		this.damage = damage;
	}
	/**
	 * @return baseDamage -ul fara race modifiers
	 */
	public double getBaseDamage() {
		return baseDamage;
	}
	/**
	 * setez damage-ul eroului curent la o valoare primita ca parametru de catre metoda
	 * @param baseDamage-ul fara race modifier
	 */
	public void setBaseDamage(double baseDamage) {
		this.baseDamage = baseDamage;
	}
}

