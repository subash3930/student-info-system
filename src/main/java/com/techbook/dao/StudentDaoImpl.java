package com.techbook.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.techbook.domain.Student;
import com.techbook.util.DbConnectionUtil;

public class StudentDaoImpl implements StudentDao{
	public static final String INSERT_SQL="insert into student_tbl(student_name,roll,dob,phoneNo,email,address)values(?,?,?,?,?,?)";

	@Override
	public int saveStudentInfo(Student student) {
		int saved =0;

		try(PreparedStatement ps=DbConnectionUtil.getConnection().prepareStatement(INSERT_SQL);){
		ps.setString(1,student.getStudentName());	
		ps.setInt(2,student.getRoll());
		ps.setDate(3,new Date(student.getDob().getTime()));
		ps.setLong(4,student.getPhoneNo());
		ps.setString(5,student.getEmail());
		ps.setString(6,student.getAddress());
		saved=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	return saved;
	
		
	}

}
