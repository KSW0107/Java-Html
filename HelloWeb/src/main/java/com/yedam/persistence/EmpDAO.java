package com.yedam.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.domain.Employee;

public class EmpDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public void close() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 사원 목록
	public List<Employee> getEmpList() {
		List<Employee> list = new ArrayList<>();
		try {
			String sql = "select * from employees order by 1 desc";
			conn = DAO.getConnenct();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getString("hire_date"));
				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	// 사원등록
	public boolean insertEmployee(Employee emp) {
		try {
			String sql = "insert into employees(employee_id,first_name,last_name,email,job_id,hire_date) values(?,?,?,?,?,?)";
			conn = DAO.getConnenct();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getEmployeeId());
			psmt.setString(2, emp.getFirstName());
			psmt.setString(3, emp.getLastName());
			psmt.setString(4, emp.getEmail());
			psmt.setString(5, emp.getJobId());
			psmt.setString(6, emp.getHireDate());

			int r = psmt.executeUpdate();
			System.out.println("처리된 건수 : " + r);

			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	// 사원삭제
	public boolean deleteEmp(int eid) {
		try {
			String sql = "delete from employees where employee_id=?";
			conn = DAO.getConnenct();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eid);

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	public Employee getEmp(int id) {
		Employee emp = null;
		try {
			String sql = "SELECT * FROM employees WHERE employee_id = ?";
			conn = DAO.getConnenct();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);

			rs = psmt.executeQuery();

			if (rs.next()) {
				emp = new Employee();

				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getString("hire_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return emp;
	}

	public boolean modifyMember(Employee emp) {
		try {
			String sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ? WHERE employee_id = ?";
			conn = DAO.getConnenct();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getFirstName());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setInt(4, emp.getEmployeeId());

			int r = psmt.executeUpdate();

			if (r > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	// 로그인(사원번호, 이메일)
	public Employee loginCheck(Employee emp) {
		conn = DAO.getConnenct();
		String sql = "SELECT * FROM employees WHERE employee_id=? and email=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getEmployeeId());
			psmt.setString(2, emp.getEmail());
			rs = psmt.executeQuery();

			if (rs.next()) {
				Employee result = new Employee();
				result.setEmployeeId(rs.getInt("employee_id"));
				result.setFirstName(rs.getString("first_name"));
				result.setLastName(rs.getString("last_name"));
				result.setEmail(rs.getString("email"));
				result.setJobId(rs.getString("job_id"));

				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}
}
