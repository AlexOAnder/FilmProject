package interfaces;

import java.util.List;

import Entities.Film;
import Entities.FilmType;

public interface IFilmRepository extends IRepository<Film>{
	
	Film GetById(int id) throws Exception;
	List<Film> GetByName(String name) throws Exception;
	List<Film> GetByType(FilmType type) throws Exception;
}
