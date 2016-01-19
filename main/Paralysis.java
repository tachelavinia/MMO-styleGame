package main;

public class Paralysis extends Ability {
	private double damage;
	private double procent;
	/**	
	 *  Constructor cu parametrul level initiliaza valorile specifice eroului la valorile de baza
	 *  functie de level
	 */
	Paralysis(int level){
		procent = 10;
		baseDamage = 40 + procent*level;
	}
	/** 
	 * damage pe care il trimite catre adversar cu race modifier
	 */
	public double Attack(Hero hero){
		if(hero instanceof Knight){
			damage = baseDamage - 0.2 * baseDamage;
		}
		if(hero instanceof Pyromancer){
			damage = baseDamage + 0.2 * baseDamage;
		}
		if(hero instanceof Rogue){
			damage = baseDamage - 0.1 * baseDamage;
		}
		return damage;
	}
	
	public double getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getProcent() {
		return procent;
	}

	public void setProcent(double procent) {
		this.procent = procent;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}
}
