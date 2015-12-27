package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Film {

	public int FilmId;
	public String Name;
	public FilmType Type;
	public double Rating;
	public int Year;
	public double RentCost;
	
	public Film(ResultSet rs) throws SQLException	{
		FilmId = rs.getInt("FilmId");
		Name = rs.getString("Name");
		
		int tmp  = rs.getInt("Type");
		Type = FilmType.fromInt(tmp);
		
		Rating = rs.getDouble("Rating");
		Year = rs.getInt("Year");
		RentCost = rs.getDouble("RentCost");
	}
}
