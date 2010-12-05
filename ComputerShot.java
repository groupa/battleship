class ComputerShot {


	/**The values for the cells in the map are the following:
	 * 9 - useless cell, was thrown out initially after generating a 'checkers' map, will never shoot on it
	 * 0 - regular cell, have never shoot it
	 * 1 - regular cell, have shot it and missed
	 * 2 - regular cell, have shot it and hit the target
	 * 3 - regular cell, have shot it, hit the target and hit the whole ship

	/**Define counter variables for the 'for' loops: */
	int i,j;



	Map shotCheckerSteps(Map enemyMap) {
		/**Take each uneven row of a 2-d array: */
		for (i=0; i < enemyMap.GetMap().length; i++) {
			/**Take each uneven element of this row (a checkers map): */
			for (j=0; j < enemyMap.GetMap()[i].length; j = j + 2) {

				enemyMap.setCell(i,j+1,9);
				enemyMap.setCell(i,j,1);


			}

		}
		/**[EVEN] Take each even row of a 2-d array: */
		for (i=0; i < enemyMap.GetMap().length; i = i + 2) {
			/**Take each uneven element of this row (a checkers map): */
			for (j=0; j < enemyMap.GetMap()[i].length; j = j + 2) {

				enemyMap.setCell(i,j+1,1);
				enemyMap.setCell(i,j,9);


			}

		}
		for (i=0; i < enemyMap.GetMap().length; i++) {
			for (j=0; j < enemyMap.GetMap()[i].length; j++) {
				System.out.print(" " + enemyMap.getCell(i,j));
			}
			System.out.println("");
		}
		return enemyMap;
	}

	void checkForPreviousHits (Map enemyMap) {
		for (i=0; i < enemyMap.GetMap().length; i++) {
			for (j=0; j < enemyMap.GetMap()[i].length; j++) {
				if (enemyMap.getCell(i,j) == 2) {
					if (enemyMap.getCell(i,j+2) == 2) {
					}

				}
			}
		}

	}
}
