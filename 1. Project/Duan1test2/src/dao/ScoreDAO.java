package dao;

import java.util.List;

import model.Score;

public interface ScoreDAO {
	List<Score> getAll() throws Exception;

	Score getById(int id) throws Exception;

	boolean add(Score score) throws Exception;

	boolean update(Score score) throws Exception;

	boolean delete(Score score) throws Exception;
}
