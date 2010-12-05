



class ComputerShot {

	int i,j;





	void generateAllShotLocations (Map enemyMap)
	{
		for (i=0; i < enemyMap.GetMap().length; i++) {
			for (j=0; j < enemyMap.GetMap()[i].length; j++) {
				System.out.println("Hi: " + enemyMap.GetMap()[i][j]);
			}
		}


	}

}
