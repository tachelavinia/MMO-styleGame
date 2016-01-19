package main;

	/**
	 * @author Lavinia Tache
	 *
	 */
	public class Backstab extends Ability {
	/** 
	 * Demage in lupta curenta cu posibilitate de critical hit
	 * Critical hit = o data la trei lovituri ( lovitura insemnand damage aplicat pe orice tip de teren )
	 * aceasta abilitate isi poate creste damage cu 1.5x daca se afla pe tipul de teren special - Woods
	 */
	protected double damage;
	protected double baseDamage;
	protected double procent;
	int contorDamage = 0;
	/**
	 * Constructorul initiliaza procentul si damage-ul de baza functie de level-ul la care se afla eroul
	 * @param level -ul curent
	 */
	public Backstab(int level){
		procent = 20;
		baseDamage = Math.round(200 + procent * level);
	}
	/**
	 * calculeaza damage-ul pe care il da victimei functie de race modifier
	 * @param hero este parametrul pe care il primeste metoda, eroul pentru care se aplica modificatorul
	 * @return-ul pe care il trimite victimei
	 */
	public double Attack(Hero hero){
		contorDamage++;
		if(hero instanceof Knight){
			damage = baseDamage - 0.1*baseDamage;
		}
		if(hero instanceof Pyromancer){
			damage = baseDamage + 0.25 * baseDamage;
		}
		if(hero instanceof Rogue){
			damage = baseDamage + 0.2 * baseDamage;
		}
		if(hero instanceof Wizard){
			damage = baseDamage + 0.25 * baseDamage;
		}
		return damage;
	}
	/**
	 * @param damage -ul cu race modifier
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	/**
	 * @return procent -ul utilizat la race modifier
	 */
	public double getProcent() {
		return procent;
	}
	/**
	 * @param procent -ul pentru race modifier
	 */
	public void setProcent(double procent) {
		this.procent = procent;
	}
	/**
	 * @return damage-ul cu race modifier
	 */
	public double getDamage() {
		return damage;
	}
	/**
	 * @param damage -ul initial primeste valoarea data ca parametru	
	 */
	public void setDamage(double damage) {
		this.damage = damage;
	}
	/**
	 * @return damage-ul fara race modifier	
	 */
	public double getBaseDamage() {
		return baseDamage;
	}
	/**
	 * @param baseDamage -ul primeste valoarea primita ca parametru metodei	
	 */
	public void setBaseDamage(double baseDamage) {
		this.baseDamage = baseDamage;
	}
	/**
	 * Abilitatea are damage prelungit pe un numar de runde returnate de aceasta metoda
	 * @return contorDamage numarul de utilizari ale abilitatii
	 */
	public int getContorDamage() {
		return contorDamage;
	}
	/**
	 * Seteaza numarul de runde la valoarea primita ca parametru
	 * @param contorDamage numarul de runde
	 */
	public void setContorDamage(int contorDamage) {
		this.contorDamage = contorDamage;
	}
}
