package Entities;

import java.sql.ResultSet;
import java.sql.SQLException;


/**Created by AlexOAnder 
 * 02.01.2016**/

public class Film {

	private int _filmId;
	private String _name;
	private FilmType _type;
	private double _rating;
	private int _year;
	private double _rentCost;
	private int _availableCount;
	
	public Film(ResultSet rs) throws SQLException	{
		
		setFilmId(rs.getInt("FilmId"));
		setName(rs.getString("Name"));
		setType(rs.getInt("Type"));

		setRating(rs.getDouble("Rating"));
		setYear(rs.getInt("Year"));
		
		setRentCost(rs.getDouble("RentCost"));
		setAvailableCount(rs.getInt("AvailableCount"));
	}

	public int getFilmId() {
		return _filmId;
	}

	public void setFilmId(int filmId) {
		// need to investigate - i think that setter is redundant
		_filmId = filmId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		if (name != "" && name != null)
			_name = name;
	}

	public FilmType getType() {
		return _type;
	}

	public void setType(int type) {
		if (type >= 0)
			_type = FilmType.fromInt(type);
	}

	public double getRating() {
		return _rating;
	}

	public void setRating(double rating) {
		if (rating < 5.0d && rating>0.0d)
			_rating = rating;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		 // yes, i know. That not right, but i sure that limit will work for sure)
		if (year>1890 && year<2100)  
			_year = year;
	}

	public double getRentCost() {
		return _rentCost;
	}

	public void setRentCost(double rentCost) {
		if (rentCost>0.0d)
			_rentCost = rentCost;
	}

	public int getAvailableCount() {
		return _availableCount;
	}

	public void setAvailableCount(int availableCount) {
		if (availableCount>0)
			this._availableCount = availableCount;
	}
}
