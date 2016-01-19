package main;


abstract public class Hero {
	
	protected int HP_Current;
	protected int HP_Maxim;
	protected int HP_Limit;
	protected int level = 0;
	protected int XP = 0;
	protected boolean isAlive = true;
	protected int movable = 0;
	protected String land;
	protected double specialLandProcent;
	protected String name;
	protected Ability ability1;
	protected Ability ability2;
	protected int over = 0;
	protected boolean overRoundDamage = false;
	protected double generalDamage = 0;
	/**
	 * Clasa Hero este clasa abstracta superclasa pentru fiecare tip particular de erou.
	 * Un erou este reprezentat in principal de HP, XP, level si doua variabile de tip Abilitate functie de care
	 * isi calculeaza damage ( cu race modifiers ).
	 * 
	 * De asemnea, prin metoda abstracta acceptAttack(Hero hero) se apeleaza Attack(Hero hero ) in cadrul caruia
	 * eroul isi actualizeaza HP-ul. HP -= damage, unde damage este un double intors de functia Attack.
	 * @param hero tipul eroului
	 * @return damage cu race modifers
	 */
	abstract public int acceptAttack(Hero hero);

	public boolean isMovable(int movable){
		this.movable = movable;
		if(movable > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean specialLand(String celula){
		if( land.equals(celula)){
			return true;
		}
		else
			return false;
	}
	
	public int getMovable() {
		return movable;
	}
	public void setMovable(int movable) {
		this.movable = movable;
	}
	/**
	 * 
	 * @return isAlive true daca eroul nu a murit - false altfel
	 */
	public boolean isAlive() {
		return isAlive;
	}
	/**
	 * Seteaza starea eroului la valoarea primita ca parametru
	 * @param isAlive true daca eroul nu a murit - false altfel
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	/**
	 * 
	 * @return level -ul curent al eroului
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * Seteaza variabila level la valoarea primita ca argument
	 * @param level -ul curent al eroului
	 */
	public void setLevel(int level) {
		this.level = 0;
	}
	/**
	 * @return XP -ul eroului
	 */
	public int getXP() {
		return XP;
	}
	/**
	 * Seteaza valoarea XP -ului la valoarea primita ca argument
	 * @param xP -ul eroului
	 */
	public void setXP(int xP) {
		XP = xP;
	}
	/**
	 * @return HP_Current reprezinta viata eroului
	 */
	public long getHP_Current() {
		return HP_Current;
	}
	/**
	 * Seteaza variabila la valoarea primita ca parametru
	 * @param HP_Current viata eroului
	 */
	public void setHP_Current(int l) {
		HP_Current = l;
	}
	/**
	 * retuneaza HP_Maxim pentru un anumit level
	 * @return HP_Maxim
	 */
	public long getHP_Maxim() {
		return HP_Maxim;
	}
	/**
	 * Seteaza variabila la valoarea primita ca parametru
	 * @param hP_Maxim reprezinta viata eroului
	 */
	public void setHP_Maxim(int hP_Maxim) {
		HP_Maxim = hP_Maxim;
	}
	/**
	 * @return HP_Limit limita de HP pentru abilitate
	 */
	public int getHP_Limit() {
		return HP_Limit;
	}
	/**
	 * @return specialLandProcent procent pentru modificator de teren
	 */
	public void setHP_Limit(int hP_Limit) {
		HP_Limit = hP_Limit;
	}
	/**
	 * Seteaza variabila la valoarea primita ca parametru
	 * @param specialLandProcent limita de HP pentru abilitate
	 */
	public double getSpecialLandProcent() {
		return specialLandProcent;
	}
	/**
	 * Seteaza variabila la valoarea primita ca parametru
	 * @param specialLandProcent limita de HP pentru abilitate
	 */
	public void setSpecialLandProcent(double specialLandProcent) {
		this.specialLandProcent = specialLandProcent;
	}
	/**
	 * 
	 * @return ability1 reprezentand prima abilitate speciala a eroului
	 */
	public Ability getAbility1() {
		return ability1;
	}
	/**
	 * 
	 * @return ability2 reprezentand a doua abilitate speciala a eroului
	 */
	public void setAbility1(Ability ability1) {
		this.ability1 = ability1;
	}
	/**
	 * 
	 * @return over numarul special de runde pe care se aplica damage over time
	 */
	public Ability getAbility2() {
		return ability2;
	}
	/**
	 * 
	 * @return over numarul special de runde pe care se aplica damage over time
	 */
	public int getOver() {
		return over;
	}
	/**
	 * Seteaza variabila la valoarea primita ca parametru
	 * @param over numarul special de runde pe care se aplica damage over time
	 */
	public void setOver(int over) {
		this.over = over;
	}
	/**
	 * @return overRoundDamage damage over time
	 */
	public boolean isOverRoundDamage() {
		return overRoundDamage;
	}
	/**
	 * Seteaza variabila la valoarea primita ca parametru
	 * @param overRoundDamage damage over time
	 */
	public void setOverRoundDamage(boolean overRoundDamage) {
		this.overRoundDamage = overRoundDamage;
	}
	/**
	 * 
	 * @return generalDamage damage fara modifiers
	 */
	public double getGeneralDamage() {
		return generalDamage;
	}
	/**
	 * Seteaza variabila la valoarea primita ca parametru
	 * @param generalDamage damage fara modifiers
	 */
	public void setGeneralDamage(double generalDamage) {
		this.generalDamage = generalDamage;
	}
	/**
	 * 
	 * @return land tipul de teren special pentru erou
	 */
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
}
