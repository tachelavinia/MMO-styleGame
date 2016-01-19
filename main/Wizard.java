package main;


public class Wizard extends Hero{
	/**
	 * Capacitate mentala superioara : rezista in mediu de desert
	 */
	public Wizard(){
		HP_Current = 400;
		level = 0;
		HP_Maxim = Math.round(400 + 30 * level);
		XP = 0;
		land = "D";	
		ability1 = new Drain(level);
		ability2 = new Deflect(level);
		generalDamage = ability1.getBaseDamage() + ability2.getBaseDamage();
		specialLandProcent = 1.1;
		isAlive = true;
		over = 0;
	}
	/**
	 * isi actualizeaza HP_Current functie de damage-ul pe care il primeste
	 */
	public int acceptAttack(Hero hero) {
		HP_Current -= Math.round(hero.ability1.Attack(this) + hero.ability2.Attack(this));
		return HP_Current;	
	}
}
