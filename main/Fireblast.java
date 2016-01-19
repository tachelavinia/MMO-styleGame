package main;


public class Fireblast extends Ability{
	/**
	 * Damage mare in lupta curenta
	 */
	private double baseDamage;
	private double damage;
	private double procent;
	/**	
	 *  Constructor cu parametrul level initiliaza valorile specifice eroului la valorile de baza
	 *  functie de level
	 *  @param level -ul curent al eroului
	 */
	public Fireblast(int level){
		procent = 50;
		baseDamage = 350 + procent*level;
	}
	/**
	 * calculeaza damage-ul pe care il da victimei functie de race modifier
	 * @param hero este parametrul pe care il primeste metoda, eroul pentru care se aplica modificatorul
	 * @return-ul pe care il trimite victimei
	 */
	public double Attack(Hero hero){
		if(hero instanceof Knight){
			damage = 1.2 * baseDamage;
		}
		if(hero instanceof Pyromancer){
			damage = 0.9 * baseDamage;
		}
		if(hero instanceof Rogue){
			damage = baseDamage - 0.2 * baseDamage;
		}
		if(hero instanceof Wizard){
			damage = baseDamage + 0.05 * baseDamage;
		}
		return damage;
	}
	/**
	 * 
	 * @return procent -ul pentru race modifier
	 */
	public double getProcent() {
		return procent;
	}
	/**
	 * Seteaza procent-ul la valoarea primita ca parametru
	 * @param procent -ul pentru race modifier
	 */
	public void setProcent(int procent) {
		this.procent = procent;
	}
	/**
	 * @return damage -ul cu race modifier
	 */
	public double getDamage() {
		return damage;
	}
	/**
	 * Seteaza damage -ul la valoarea primita ca parametru
	 * @param damage -ul cu race modifier
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	/**
	 * @return baseDamage -ul fara race modifier
	 */
	public double getBaseDamage() {
		return baseDamage;
	}
	/**
	 * Seteaza baseDamage -ul de baza la valoarea primita ca parametru
	 * @param baseDamage -ul fara race modifier
	 */
	public void setBaseDamage(double baseDamage) {
		this.baseDamage = baseDamage;
	}
	/**
	 * Seteaza damage -ul de baza la valoarea primita ca parametru
	 * @param damage -ul cu race modifier
	 */
	public void setDamage(double damage) {
		this.damage = damage;
	}
	/**
	 * Seteaza procent -ul de baza la valoarea primita ca parametru
	 * @param procent -ul pentru race modifier
	 */
	public void setProcent(double procent) {
		this.procent = procent;
	}
	
}