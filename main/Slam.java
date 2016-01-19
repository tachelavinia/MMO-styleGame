package main;

public class Slam extends Ability {
	private double damage;
	private double procent;
	/**	
	 *  Constructor cu parametrul level initiliaza valorile specifice eroului la valorile de baza
	 *  functie de level
	 */
	Slam(int level){
		procent = 40;
		baseDamage = (int) Math.round(100 + procent*level);
	}
	/**
	 * calculeaza damage pentru fiecare erou cu care se lupta tinand cont de race modifier
	 */
	public double Attack(Hero hero){
		if(hero instanceof Knight){
			damage = 1.2 * baseDamage;
		}
		if(hero instanceof Pyromancer){
			damage = 0.9 * baseDamage;
		}
		if(hero instanceof Rogue){
			damage = 0.8 * baseDamage;
		}
		if(hero instanceof Wizard){
			damage = baseDamage + 0.05 * baseDamage;
		}
		return damage;
	}

	public double getProcent() {
		return procent;
	}

	public void setProcent(double procent) {
		this.procent = procent;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}


	
}
