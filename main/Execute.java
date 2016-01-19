package main;


public class Execute extends Ability{
	/**
	 * Damage in runda curenta; daca adversarul are damage mai mic de o anumita limita va fi ucis
	 * Race modifiers se aplica doar asupra damage-ului, nu si asupra pragului minim de viata.
	 */
	private double damage;
	private double procent;
	/**
	 * Initiliaza procentul si damage-ul de baza la valoarea initiala setata funtie de level 
	 * @param level-ul eroului
	 */
	public Execute(int level){
		procent = 30;
		baseDamage = 200 + procent*level;
	}
	/**
	 * calculeaza damage-ul pe care il da victimei functie de race modifier
	 * @param hero este parametrul pe care il primeste metoda, eroul pentru care se aplica modificatorul
	 * @return-ul pe care il trimite victimei
	 */
	public double Attack(Hero hero){
		if(hero.getLevel() > 40){
			hero.setLevel(40);
		}
		if(hero.HP_Current < hero.HP_Limit) hero.isAlive = false;
		
		if(hero instanceof Knight){
			damage = baseDamage;
		}
		if(hero instanceof Pyromancer){
			damage = 1.1 * baseDamage;
		}
		if(hero instanceof Rogue){
			damage = 1.15 * baseDamage;
		}
		if(hero instanceof Wizard){
			damage = baseDamage - 0.2 * baseDamage;
		}
		return damage;
	}
	/**
	 * 
	 * @return procent -ul corespunzator eroului pentru care se aplica race modifier
	 */
	public double getProcent() {
		return procent;
	}
	/**
	 * Seteaza variabila procent la valoarea primita ca parametru
	 * @param procent -ul corespunzator eroului pentru care se aplica race modifier
	 */
	public void setProcent(double procent) {
		this.procent = procent;
	}
	/**
	 * @return damage -ul cu race modifier
	 */
	public double getDamage() {
		return damage;
	}
	/**
	 * @param damage -ul cu range modifiers
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
}
