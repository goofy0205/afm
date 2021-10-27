package com.kh.afm.admin.model.service;

import static com.kh.afm.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.afm.admin.model.dao.AdminDao;
import com.kh.afm.user.model.vo.DelUser;
import com.kh.afm.user.model.vo.User;

public class AdminService {
	
	// 어드민DAO
	private AdminDao adminDao = new AdminDao();

	/**
	 * 전체 회원 조회
	 */
	public List<User> selectAllUser(int startRownum, int endRownum) {
		Connection conn = getConnection();
		List<User> list = adminDao.selectAllMember(conn, startRownum, endRownum);
		close(conn);		
		
		return list;
	}

	/**
	 * 페이징 - 전체회원수 
	 */
	public int selectTotalContents() {
		Connection conn = getConnection();
		int totalContent = adminDao.selectTotalContents(conn);
		close(conn);
		return totalContent;
	}

	/**
	 * 탈퇴한 전체 회원 조회
	 */
	public List<DelUser> selectAllDelUser(int startRownum, int endRownum) {
		Connection conn = getConnection();
		List<DelUser> list = adminDao.selectAllDelUser(conn, startRownum, endRownum);
		close(conn);		
		
		return list;
	}

	/**
	 * 회원 검색하기
	 */
	public List<User> searchUser(Map<String, Object> param) {
		Connection conn = getConnection();
		List<User> list = adminDao.searchUser(conn, param);
		close(conn);
		return list;
	}

	/**
	 * 검색결과의 전체회원수
	 */
	public int searchUserCount(Map<String, Object> param) {
		Connection conn = getConnection();
		int totalContent = adminDao.searchUserCount(conn, param);
		close(conn);
		return totalContent;
	}

	/**
	 * 회원 정렬하기
	 */
	public List<User> sortUser(Map<String, Object> param) {
		Connection conn = getConnection();
		List<User> list = adminDao.sortUser(conn, param);
		close(conn);
		return list;
	}
}
