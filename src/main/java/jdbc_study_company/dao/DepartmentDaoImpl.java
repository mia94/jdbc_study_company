package jdbc_study_company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_study_company.dto.Department;
import jdbc_study_company.jdbc.ConnectionProvider;
import jdbc_study_company.jdbc.LogUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	
	@Override
	public List<Department> selectDepartmentByAll() {
		List<Department> list = new ArrayList<>();
		String sql = "select deptno, deptname, floor from department";
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
			while(rs.next()) {
				list.add(getDepartment(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private Department getDepartment(ResultSet rs) throws SQLException {
		String deptNo = rs.getString("deptno");
		String deptname = rs.getString("deptName");
		int floor = rs.getInt("floor");
		return new Department(deptNo, deptname,floor);
	}

	@Override
	public int insertDepartment(Department item) throws SQLException {
		System.out.println("insertDepartment 실행");
		String sql = "insert into department values(?,?,?)";
		int row = 0;
		try(Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql)){

			pstmt.setString(1, item.getDeptNo());
			pstmt.setString(2, item.getDaptName());
			pstmt.setInt(3, item.getFloor());
			LogUtil.prnLog(pstmt);
			row = pstmt.executeUpdate();
		}
		return row;
	}

	@Override
	public int deleteDepartment(Department item) throws SQLException {
		System.out.println("deleteDepartment 실행");
		String sql = "delete from department where deptno = ?";
		int row = 0;
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, item.getDeptNo());
			LogUtil.prnLog(pstmt);
			row = pstmt.executeUpdate();
		}
		return row;
	}

	@Override
	public int updateDepartment(Department item) throws SQLException {
		System.out.println("updateDepartment 실행");
		String sql = "update department set deptName = ? where deptno = ? ";
		int row = 0;
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, item.getDaptName());
			pstmt.setString(2, item.getDeptNo());
			LogUtil.prnLog(pstmt);
			row = pstmt.executeUpdate();
		}
		return row;
	}
	
	
	
}

















