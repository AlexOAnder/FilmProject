package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Film;
import Entities.FilmType;
import dbPackage.DataBaseProvider;

public class FilmRepository {

	public FilmRepository() {
	}

	public void Create(Film model){
        
	     String sql = "INSERT INTO fmdat.Film "+
	     "(FilmId,Name,Type,AvailableCount,Rating,RentCost)"
	    		 +" VALUES ("
	                + "'" + model.getFilmId() + "'" +","
	                + "'" + model.getName() + "'" +","
	                + "'" + model.getType().getId() + "'" +","
	                + "'" + model.getAvailableCount()+ "'" +","
	                + "'" + model.getRating()+ "'" +","
	                + "'" + model.getRentCost()+ "'" + ")";
	     try {
			ExecuteWithNoResult(sql);
	     } catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Update (Film model){
		String sql = "UPDATE fmdat.Film SET "
			                + "Name = '" + model.getName()+ "'" +","
			                + "Type = '" + model.getType().getId()+ "'" +","
			                + "AvailableCount = '" + model.getAvailableCount()+ "'" +","
			                + "Rating = '" + model.getRating()+ "'" + ")"
			                + "RentCost = '" + model.getRentCost()+ "'" + ")"
			                + "WHERE FilmId = "+ model.getFilmId() ;
	     try {
			ExecuteWithNoResult(sql);
	     } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Delete (Film model){
		String sql = "DELETE fmdat.Film WHERE FilmId = "+ model.getFilmId() ;
		try {
			ExecuteWithNoResult(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Film> GetAll() throws Exception{
		String sql = "SELECT * FROM fmdat.Film;";
		return GetResultSetList(sql);
	}
	
	public Film GetById(int id) throws Exception{
		String sql = "SELECT * FROM fmdat.Film Where FilmId = "+id+" ;";
		List<Film> result = GetResultSetList(sql);
		if (result == null){
			return null;
		}
		if (result.size()>1){
			throw new Exception("Wrong number of customers! More than 1 - > Owibka v logike bd");
		}
		
		return result.get(0);
	}
	
	public List<Film> GetByName(String name) throws Exception{
		
		String sql = "SELECT * FROM fmdat.Film Where Name like /%"+name+"/% ;";
		List<Film> result = GetResultSetList(sql);
		return result;
	}
	
	public List<Film> GetByType(FilmType type) throws Exception{
		
		String sql = "SELECT * FROM fmdat.Film Where Type = "+type.getId()+" ;";
		List<Film> result = GetResultSetList(sql);
		return result;
	}
	
	private void ExecuteWithNoResult(String sql) throws Exception{
		try {
			Statement s = DataBaseProvider.GetNewStatement();
			s.executeUpdate(sql);
			s.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
	    }
	}

	private List<Film> GetResultSetList(String sql) throws Exception
	{
		List<Film> FilmsList = new ArrayList<Film >();
		try {
			Statement s = DataBaseProvider.GetNewStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()){
				Film tmp = new Film(rs);
				FilmsList.add(tmp);
			}
			if (FilmsList.isEmpty())	{
				return null;
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return FilmsList;	
	}
}
