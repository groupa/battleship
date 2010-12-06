class ComputerShot {

	/**This class implements the computer 'thinking' of where to shoot
	 * It returns a 'move' variable, that is simply a couple of X and Y coordinates
	 */


	/**HOW TO:
	 * To use this class, first create a Map instance:
	 *
	 * || Map enemyMap = new Map(10,10);
	 *
	 * then create a computerShot instance:
	 *
	 * || ComputerShot computerShot = new ComputerShot ();
	 *
	 * then create a 'checkered' map:
	 *
	 * || Map checkeredMap;
	 * || checkeredMap = computerShot.shotCheckerSteps(enemyMap);
	 *
	 * then generate new shot coordinates by passing a 'checkered' map and a lastShot coordinats to the computerShot instance:
	 *
	 * || computerShot.checkForPreviousHits(checkeredMap, lastShot);
	 */




	/**The values for the cells in the map are the following:
	 * 9 - useless cell, was thrown out initially after generating a 'checkers' map, will never choose it with random chooser, but will shoot it 
	 * 10 - regular cell, have never shoot it
	 * 1 - regular cell, have shot it and missed
	 * 2 - regular cell, have shot it and hit the target
	 * 3 - regular cell, have shot it, hit the target and hit the whole ship
	 */


	/** ---
	 * Start of class' code
	 * ---
	 */

	/**Define counter variables for the 'for' loops: */
	int i,j;
	/**Set up a 'move' variable that computer enemy will return - it holds coordinates of computer's shot*/
	Shot move = new Shot(0,0);



	/**Generate a map that is 'checkered' - each 2nd cell is excluded (the map is still 10x10, but each 2nd cell has a value of 9) */
	Map shotCheckerSteps(Map enemyMap) {
		/**First we will just make all the rows hold 9 and 10 values for cells: */
		/**Take each uneven row of a 2-d array: */
		for (i=0; i < enemyMap.GetMap().length; i++) {
			/**Take each uneven element of this row (a checkers map): */
			for (j=0; j < enemyMap.GetMap()[i].length; j = j + 2) {

				enemyMap.setCell(i,j+1,9);
				enemyMap.setCell(i,j,10);


			}

		}
		/**Second we will take each second row and interchange 9 and 10 values in them: */
		/**[EVEN] Take each even row of a 2-d array: */
		for (i=0; i < enemyMap.GetMap().length; i = i + 2) {
			/**Take each even element of this row (a checkers map): */
			for (j=0; j < enemyMap.GetMap()[i].length; j = j + 2) {

				enemyMap.setCell(i,j+1,10);
				enemyMap.setCell(i,j,9);


			}

		}
		/**Draw a result of 'checkering' the map: */
		for (i=0; i < enemyMap.GetMap().length; i++) {
			for (j=0; j < enemyMap.GetMap()[i].length; j++) {
				System.out.print(" " + enemyMap.getCell(i,j));
			}
			System.out.println("");
		}
		/**---End of drawing a map */

		/**This returns an object of Map class, but its cells has values of 9 and 10 in 'checkers' order: */
		return enemyMap;
	}


	/**The actual 'shooting' method: tries to shoot around the lastShot if it was successful, otherwise shoots cell by cell through a checkered map: */
	Shot checkForPreviousHits (Map enemyMap, Shot lastShot) {


		/**Check for the last shot, If there was a hit, then try to shoot around this previous cell */
		if (enemyMap.getCell(lastShot.getX(), lastShot.getY()) == 2) {
			System.out.println("Computer: The last shot was successful: " + lastShot.getX() + ", " + lastShot.getY());
			/**The checking of surrounding cells is done counterclockwise, starting from the upper cell (diagonal cells are not checked): */
			/**Check the upper cell: */
			if (enemyMap.getCell(lastShot.getX() - 1, lastShot.getY()) >= 9) 
			{

				/**Draw a current map for the computer (where it shoot already and where he has not): */

				System.out.println("Computer: here is my current enemy map (what I know about my enemy):");

				for (i=0; i < enemyMap.GetMap().length; i++) {
					for (j=0; j < enemyMap.GetMap()[i].length; j++) {
						System.out.print(" " + enemyMap.getCell(i,j));
					}
					System.out.println("");
				}
				/**End of drawing a map
				 * ---
				 */


				System.out.println("Computer: Here is a neighbour cell of the last successful shot cell and I have never shoot it before: " + (lastShot.getX() - 1)  + ", " + lastShot.getY());
				move.setX(lastShot.getX() - 1);
				move.setY(lastShot.getY());
				System.out.println("The computer made a shot: " + move.getX() + ", " + move.getY());



				return move;
			}
			/**Check the left cell: */
			else if (enemyMap.getCell(lastShot.getX(), lastShot.getY() - 1) >= 9) 
			{
				/**Draw a current map for the computer (where it shoot already and where he has not): */

				System.out.println("Computer: here is my current enemy map (what I know about my enemy):");

				for (i=0; i < enemyMap.GetMap().length; i++) {
					for (j=0; j < enemyMap.GetMap()[i].length; j++) {
						System.out.print(" " + enemyMap.getCell(i,j));
					}
					System.out.println("");
				}
				/**End of drawing a map
				 * ---
				 */


				System.out.println("Computer: Here is a neighbour cell of the last successful shot cell and I have never shoot it before: " + (lastShot.getX())  + ", " + (lastShot.getY() -1));
				move.setX(lastShot.getX());
				move.setY(lastShot.getY() - 1);
				System.out.println("The computer made a shot: " + move.getX() + ", " + move.getY());
				return move;
			}
			/**Check the lower cell: */
			else if (enemyMap.getCell(lastShot.getX() + 1, lastShot.getY()) >= 9) 
			{
				/**Draw a current map for the computer (where it shoot already and where he has not): */

				System.out.println("Computer: here is my current enemy map (what I know about my enemy):");

				for (i=0; i < enemyMap.GetMap().length; i++) {
					for (j=0; j < enemyMap.GetMap()[i].length; j++) {
						System.out.print(" " + enemyMap.getCell(i,j));
					}
					System.out.println("");
				}
				/**End of drawing a map
				 * ---
				 */

				System.out.println("Computer: Here is a neighbour cell of the last successful shot cell and I have never shoot it before: " + (lastShot.getX() +1)  + ", " + lastShot.getY());
				move.setX(lastShot.getX() + 1);
				move.setY(lastShot.getY());
				System.out.println("The computer made a shot: " + move.getX() + ", " + move.getY());
				return move;
			}
			/**Check the right cell: */
			else if (enemyMap.getCell(lastShot.getX(), lastShot.getY() + 1) >= 9) 
			{
				/**Draw a current map for the computer (where it shoot already and where he has not): */

				System.out.println("Computer: here is my current enemy map (what I know about my enemy):");

				for (i=0; i < enemyMap.GetMap().length; i++) {
					for (j=0; j < enemyMap.GetMap()[i].length; j++) {
						System.out.print(" " + enemyMap.getCell(i,j));
					}
					System.out.println("");
				}
				/**End of drawing a map
				 * ---
				 */

				System.out.println("Computer: Here is a neighbour cell of the last successful shot cell and I have never shoot it before: " + lastShot.getX()  + ", " + (lastShot.getY() +1));
				move.setX(lastShot.getX());
				move.setY(lastShot.getY() + 1);
				System.out.println("The computer made a shot: " + move.getX() + ", " + move.getY());
				return move;
			}


		}




		/**---
		 * If there is no successful lastShot (with the status of 2) then we will just iterate through all the checkered map and will shoot the cells that have status of 10: */

		/**A cell by cell shot on a checkered map: */
		else {

			/**Loop through all the cells to check their status: */
			for (i=1; i < enemyMap.GetMap().length - 1; i++) {
				for (j=1; j < enemyMap.GetMap()[i].length -1; j++) {
					/**Check if a cell has a status 10 - a new cell that has never been shoot */
					if (enemyMap.getCell(i,j) == 10) {
						System.out.println("Computer: The previous shot was unsuccessful: " + move.getX() + ", " + move.getY());

						Shot move = new Shot(i, j);
						System.out.println("The computer made a shot: " + move.getX() + ", " + move.getY());
						return move;

					}
				}

			}

		}
		return move;
	}
}
