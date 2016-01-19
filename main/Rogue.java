package main;


public class Rogue extends Hero {
	/**
	 *  Expert in sneak-attacks
	 */
	public Rogue(){
		HP_Current = 600;
		HP_Maxim = Math.round(600 + 40*level);
		XP = 0;
		level = 0;
		ability1 = new Backstab(level);
		ability2 = new Paralysis(level);
		generalDamage = ability1.getBaseDamage() + ability2.getBaseDamage();
		land = "W";
		specialLandProcent = 1.15;
		isAlive = true;
		over = 4;
	}
	/**
	 * isi actualizeaza HP_Current functie de damage-ul pe care il primeste
	 */
	public int acceptAttack(Hero hero){
		HP_Current -= ( hero.ability1.Attack(this) + hero.ability2.Attack(this) );
		return HP_Current;
	}
}
