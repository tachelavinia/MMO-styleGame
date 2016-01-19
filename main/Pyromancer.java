package main;


public class Pyromancer extends Hero {
	/**
	 * abil in manevrarea focului
	 */
	public Pyromancer(){
		HP_Current = 500;
		HP_Maxim = Math.round(500 + 50*level);
		XP = 0;
		level = 0;
		ability1 = new Fireblast(level);
		ability2 = new Ignite(level);
		generalDamage = ability1.getBaseDamage() + ability2.getBaseDamage();
		movable = 0;
		land = "V";
		specialLandProcent = 1.25;
		over = 2;
	}
	/**
	 * isi actualizeaza HP_Current functie de damage-ul pe care il primeste
	 */
	public int acceptAttack(Hero hero){
		System.out.println( " general damage ab1 " + ability1.getBaseDamage());
		System.out.println( " general damage ab2 " + ability2.getBaseDamage());
		HP_Current -= Math.round(hero.ability1.Attack(this) + hero.ability2.Attack(this));
		return HP_Current;		
	}
}
