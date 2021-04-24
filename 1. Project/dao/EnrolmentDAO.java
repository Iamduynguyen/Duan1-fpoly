package dao;

import java.util.List;

import model.Enrolment;

public interface EnrolmentDAO {
	List<Enrolment> getAll() throws Exception;

	Enrolment getById(String sid, int cid) throws Exception;

	boolean add(Enrolment enrolment) throws Exception;

	boolean update(Enrolment enrolment) throws Exception;

	boolean delete(Enrolment enrolment) throws Exception;
}
