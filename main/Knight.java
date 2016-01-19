package main;


public class Knight extends Hero {
	
	public Knight(){
		HP_Current = 900;
		HP_Maxim =  Math.round(900 + 80*level);
		HP_Limit = (int) Math.round(0.2*HP_Maxim + 0.01*level);
		XP = 0;
		level = 0;
		land = "L";
		ability1 = new Execute(level);
		ability2 = new Slam(level);
		generalDamage = ability1.getBaseDamage() + ability2.getBaseDamage();
		specialLandProcent = 1.15;
		
		isAlive = true;
		over = 0;
}

	public int acceptAttack(Hero hero){
		HP_Current -= ( hero.ability1.Attack(this) + hero.ability2.Attack(this) );
		return HP_Current;
	}
}
