package main;

public class Drain extends Ability{
	/**
	 * @author Lavinia Tache
	 */
	private double damage;
	private double procent; 
	private double baseProcent;
	private double procentHP;
	private int level;
	private double HP_baza;
	/** 
	 *  Scade din viata adversarului proportional cu cat are deja
	 *  Se va calcula astfel un procent de baza functie de level caruia i se va aplica ulterior race modifiers.
	 *  Damage = procent * HP de baza
	 */
	Drain(int level){
		this.level = level;
		baseProcent = 0.2 + 0.05*level;
	}
	/**
	 * Constructorul initializeaza levelul si procentul de baza functie de aceasta	
	 * @param level -ul la care se afla eroul
	 */
	public double Attack(Hero hero) {
		if( 0.3 * hero.getHP_Maxim() < hero.getHP_Current() ){
			HP_baza = 0.3 * hero.getHP_Maxim();
		}
		else HP_baza = hero.getHP_Current();
		if(hero instanceof Knight){
			procent = baseProcent + 0.2 * baseProcent;
		}
		if(hero instanceof Rogue){
			procent = baseProcent - 0.2 * baseProcent;
		}
		if( hero instanceof Pyromancer){
			procent = baseProcent - 0.1 * baseProcent;
		}
		if( hero instanceof Wizard ){
			procent = baseProcent + 0.05 * baseProcent;
		}
		return procent * HP_baza;
	}
	/**
	 * calculeaza damage-ul pe care il da victimei functie de race modifier
	 * @param hero este parametrul pe care il primeste metoda, eroul pentru care se aplica modificatorul
	 * @return-ul pe care il trimite victimei
	 */
	public double getDamage() {
		return damage;
	}
	/**
	 * @return damage -ul cu race modifier
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	/**
	 * Seteaza damage -ul la valoarea primita ca parametru de catre metoda
	 * @param damage -ul cu race modifier
	 */
	public double getProcent() {
		return procent;
	}
	/**
	 * 
	 * @return procent -ul corespunzator race modifier
	 */
	public void setProcent(double procent) {
		this.procent = procent;
	}
}
