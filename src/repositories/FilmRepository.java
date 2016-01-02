package repositories;

import dbPackage.DataBaseProvider;

public class FilmRepository {

	private DataBaseProvider provider;

	public FilmRepository() {
		provider = DataBaseProvider.GetInstance();
	}
}
