package main;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		String delims = " ";
		FileIO in = new FileIO(args[0], true);
		FileIO out = new FileIO(args[1], false);

		/**
		 * coordonatele arenei
		 */
		String[] dim = in.readLine().split(delims);
		int m = Integer.parseInt(dim[0]); /* numarul de linii */
		int n = Integer.parseInt(dim[1]); /* numarul de coloane */

		String teren = in.readLine();
		System.out.println("TEREN : " + teren);

		String[] pers = in.readLine().split(delims);
		int p = Integer.parseInt(pers[0]);
		/**
		 * citire personaje
		 */

		String[] hero = new String[p];
		int[] x_position = new int[p];
		int[] y_position = new int[p];
		for (int i = 0; i < p; i++) {
			String line = in.readLine();
			String[] splitLine = line.split(" ");
			for (int j = 0; j < splitLine.length; j++) {
				hero[i] = splitLine[0];
				x_position[i] = Integer.parseInt(splitLine[1]);
				y_position[i] = Integer.parseInt(splitLine[2]);

			}
		}

		/**
		 * fight
		 */
		Hero[] person = new Hero[p];

		for (int i = 0; i < p; i++) {
			switch (hero[i]) {

			case "K":
				person[i] = new Knight();
				break;
			case "P":
				person[i] = new Pyromancer();
				break;
			case "R":
				person[i] = new Rogue();
				break;
			case "W":
				person[i] = new Wizard();
				break;
			}
		}

		String[] runde = in.readLine().split(delims);
		int r = Integer.parseInt(runde[0]);

		/**
		 * Test 1vs1
		 */

		while (r != 0) {
			/**
			 * verificare modificatori pentru teren special
			 */

			if ((x_position[0] == x_position[1])
					&& (y_position[0] == y_position[1]) && person[0].isAlive
					&& person[1].isAlive) {
				/**
				 * OVERDAMAGE
				 */
				if (person[1].isOverRoundDamage() && person[1].getOver() > 0) {
					person[0].setHP_Current((int) Math.round(person[0]
							.getHP_Current()
							- person[1].ability2.Attack(person[0])));
					person[1].setOver(person[1].getOver() - 1);
				}

				if (person[0].isOverRoundDamage() && person[0].getOver() > 0) {
					person[1].setHP_Current((int) Math.round(person[1]
							.getHP_Current()
							- person[0].ability2.Attack(person[1])));
					person[0].setOver(person[0].getOver() - 1);
				}

				/**
				 * SPECIAL LAND
				 */
				if (person[0].getLand().equals(teren)) {
					System.out.println("pers0 teren special?");
					double damage = person[0].ability2.Attack(person[1])
							+ person[0].ability1.Attack(person[1]);
					double special_damage = person[0].getSpecialLandProcent()
							* damage;
					person[1].setHP_Current((int) Math.round(person[1]
							.getHP_Current() - special_damage));
					person[0].setOverRoundDamage(true);
				} else {
					person[1].acceptAttack(person[0]);
					System.out.println("Damage ab1 = "
							+ person[1].ability1.Attack(person[0]));
					System.out.println("Damage ab2 = "
							+ person[1].ability2.Attack(person[0]));
					person[0].setOverRoundDamage(true);
				}
				if (person[1].getLand().equals(teren)) {
					System.out.println("pers1 teren special");
					double damagee = person[1].ability2.Attack(person[0])
							+ person[1].ability1.Attack(person[0]);
					double special_damagee = person[1].getSpecialLandProcent()
							* damagee;
					person[0].setHP_Current((int) Math.round(person[0]
							.getHP_Current() - special_damagee));
					person[1].setOverRoundDamage(true);
				} else {
					person[0].acceptAttack(person[1]);
					System.out.println("TEST " + person[0].getHP_Current());
					person[1].setOverRoundDamage(true);
				}
				/**
				 * XP
				 */

				if (person[0].getHP_Current() < 0) {
					System.out.println("Intra aici! K moare");
					person[0].isAlive = false;
					if (0 > (200 - (person[1].getLevel() - person[0].getLevel()) * 40)) {
						person[1].setXP(5);
					} else
						person[1]
								.setXP((200 - (person[1].getLevel() - person[0]
										.getLevel()) * 40));
				}

				if (person[1].getHP_Current() < 0) {

					person[1].isAlive = false;
					if (0 > (200 - (person[0].getLevel() - person[1].getLevel()) * 40)) {
						person[0].setXP(5);
					} else
						person[0]
								.setXP((200 - (person[0].getLevel() - person[1]
										.getLevel()) * 40));
				}
			}
			r--;
		}

		System.out.println("Dupa terminarea rundelor....");
		if (!person[0].isAlive) {
			out.writeLine(hero[0] + " dead");
		} else {
			out.writeLine((hero[0] + " " + person[0].getLevel() + " "
					+ person[0].getXP() + " " + person[0].getHP_Current() + " "
					+ x_position[0] + " " + y_position[0]));
		}
		if (!person[1].isAlive) {
			System.out.println(hero[1] + " dead");
			out.writeLine(hero[1] + " dead");
		} else {
			out.writeLine((hero[1] + " " + person[1].getLevel() + " "
					+ person[1].getXP() + " " + person[1].getHP_Current() + " "
					+ x_position[1] + " " + y_position[1]));
			out.writeLine("");
			out.writeLine("");
		}

	}
}
