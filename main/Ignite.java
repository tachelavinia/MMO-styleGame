package main;

public class Ignite extends Ability {
	/**
	 * Damage mare in lupta curenta + damage mic urmatoarele doua runde
	 */
	protected double damage;
	protected double baseDamage;
	protected double procent;
	protected int over = 2;	
	
	public Ignite(int level){
		procent = 20;
		baseDamage = 150 + procent* level;
	}
	public int resetOver(int over){
		over = this.over;
		return over;
	}
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
	public double getBaseDamage() {
		return baseDamage;
	}
	public void setBaseDamage(double baseDamage) {
		this.baseDamage = baseDamage;
	}
	public int getOver() {
		return over;
	}
	public void setOver(int over) {
		this.over = over;
	}
	public void setDamage(double damage) {
		this.damage = damage;
	}
	
}
