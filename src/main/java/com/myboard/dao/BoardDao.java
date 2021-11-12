package com.myboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.myboard.dto.BoardDto;

public class BoardDao {
	
	DataSource dataSource;
	
	public BoardDao() {
		Context context;
		try {
			context = new InitialContext();//was와 연결된 context

			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle");
			
		} catch (NamingException e) {
			e.printStackTrace();
		} 
		
		
	}

	public ArrayList<BoardDto> list() {
		
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT b_no, b_name, b_subject, b_content, b_date FROM sfb_board ORDER BY b_no desc";
			
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {

				int b_no = resultSet.getInt("b_no");
				String b_name = resultSet.getString("b_name");
				String b_subject = resultSet.getString("b_subject");
				String b_content = resultSet.getString("b_content");
				Timestamp b_date = resultSet.getTimestamp("b_date");
				
				BoardDto dto = new BoardDto(b_no, b_name, b_subject, b_content, b_date);
				dtos.add(dto);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dtos;
	}

	public void write(String b_name,String b_subject,String b_content,Timestamp b_date) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "insert into sfb_board(b_no,b_name,b_subject,b_content,b_date) "
					+ "values(sfb_board_seq.nextval,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, b_name);
			preparedStatement.setString(2, b_subject);
			preparedStatement.setString(3, b_content);
			preparedStatement.setTimestamp(4, b_date);
			
			int rn = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	public BoardDto contentView(String strNo) {
		
		BoardDto dto = null;
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from sfb_board where b_no=?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strNo));
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int b_no = resultSet.getInt("b_no");
				String b_name = resultSet.getString("b_name");
				String b_subject = resultSet.getString("b_subject");
				String b_content = resultSet.getString("b_content");
				Timestamp b_date = resultSet.getTimestamp("b_date");
				
				dto = new BoardDto(b_no,b_name,b_subject,b_content,b_date);
						
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
	}

	public void modify(String b_no, String b_name, String b_subject, String b_content) {
		
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update sfb_board set b_name=?, b_subject=?,b_content=? where b_no=?";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, b_name);
			preparedStatement.setString(2, b_subject);
			preparedStatement.setString(3, b_content);
			preparedStatement.setInt(4, Integer.parseInt(b_no));
			
			int rn = preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void delete(String b_no) {

		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			String query = "delete from sfb_board where b_no = ?";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, Integer.parseInt(b_no));
			
			int rn = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
