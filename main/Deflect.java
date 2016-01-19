package main;
	/**
	 * @author Lavinia Tache
	 *
	 */
public class Deflect extends Ability {
	/**
	 * da damage egal cu procent din damage-ul pe care il primeste de la adversar
	 * 		da damage egal cu procent din damage-ul pe care il primeste de la adversar
	 * 		damage-ul pe care il primeste de la adversar si caruia ii aplica procent nu tine cont de race modifiers,
	 * 		insa tine cont de land modifiers
	 *		aceasta abilitate nu se aplica unui Wizard
	 */
	private double damage;
	private double baseProcent;
	private double procent;
	/**
	 * Initializeaza procentul si damage-ul de baza la valorile calculate in functie de level	
	 * @param level -ul curent
	 */
	public Deflect(int level){
		baseProcent = 0.35 + 0.02 * level;
		if(baseProcent > 0.7){
			baseProcent = 0.7;
		}
	}
	/**
	 * calculeaza damage-ul pe care il da victimei functie de race modifier
	 * @param hero este parametrul pe care il primeste metoda, eroul pentru care se aplica modificatorul
	 * @return-ul pe care il trimite victimei
	 */
	public double Attack(Hero hero) {
		if(hero instanceof Rogue){
			procent = baseProcent + 0.2 * baseProcent;
			damage = procent * hero.getGeneralDamage();
		}
		if(hero instanceof Knight){
			procent = baseProcent + 0.4 * baseProcent;
			damage = procent * hero.getGeneralDamage();
		}
		if(hero instanceof Pyromancer){
			procent = baseProcent + 0.3 * baseProcent;
			damage = procent * hero.generalDamage;
		}
		if(hero instanceof Wizard){
			damage = 0;
		}
		return damage;
	}
	/**
	 * @return damage-ul cu race modifier
	 */
	public double getDamage() {
		return damage;
	}
	/**
	 * Seteaza damage-ul la valoarea primita ca parametru
	 * @param damage-ul cu race modifier
	 */
	public void setDamage(double damage) {
		this.damage = damage;
	}
	/**
	 * @return baseDamage fara race modifier
	 */
	public double getBaseDamage() {
		return baseDamage;
	}
	/**
	 * Seteaza baseDamage-ul la valoarea primita ca parametru
	 * @param baseDamage-ul cu race modifier
	 */
	public void setBaseDamage(double baseDamage) {
		this.baseDamage = baseDamage;
	}
	/**
	 * @return procent -ul pe care il aplica pentru race modifier
	 */
	public double getProcent() {
		return procent;
	}
	/**
	 * Seteaza procent la valoarea primita ca parametru
	 * @param procent -ul pentru race modifier
	 */
	public void setProcent(double procent) {
		this.procent = procent;
	}
}
