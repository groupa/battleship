class ComputerShot {

	/**Define counter variables for the 'for' loops: */
	int i,j;



	void shotCheckerSteps(Map enemyMap) {
		/**Take each row of a 2d array: */
		for (i=0; i < enemyMap.GetMap().length; i++) {
			/**Take each 2nd element of this row (a checkers map): */
			for (j=0; j < enemyMap.GetMap()[i].length; j = j + 2) {

				enemyMap.setCell(i,j,1);


			}

		}
		for (i=0; i < enemyMap.GetMap().length; i++) {
			for (j=0; j < enemyMap.GetMap()[i].length; j++) {
System.out.print(" " + enemyMap.getCell(i,j));
			}
		System.out.println("");
		}
	}
}
