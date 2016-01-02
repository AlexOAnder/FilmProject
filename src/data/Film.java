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

	public int getFilmId() {
		return FilmId;
	}

	public void setFilmId(int filmId) {
		FilmId = filmId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public FilmType getType() {
		return Type;
	}

	public void setType(FilmType type) {
		Type = type;
	}

	public double getRating() {
		return Rating;
	}

	public void setRating(double rating) {
		Rating = rating;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public double getRentCost() {
		return RentCost;
	}

	public void setRentCost(double rentCost) {
		RentCost = rentCost;
	}
}
