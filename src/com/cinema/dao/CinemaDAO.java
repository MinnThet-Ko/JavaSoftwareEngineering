package com.cinema.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cinema.models.Cinema;
import com.hm.assignment8.utils.DatabaseUtil;

public class CinemaDAO implements AbstractDAO<Cinema>{

	@Override
	public List<Cinema> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Cinema parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Cinema parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Cinema parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cinema selectByID(int i) {
		Cinema resultCinema = new Cinema();
		String query = "select * from cinema where id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setInt(0, i);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				resultCinema.setId(rs.getInt(0));
				resultCinema.setName(rs.getString(1));
				resultCinema.setAddress(rs.getString(2));
			}
			return resultCinema;
		}catch(SQLException e) {
			
		}
		return null;
	}

}
