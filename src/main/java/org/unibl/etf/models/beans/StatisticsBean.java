package org.unibl.etf.models.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.unibl.etf.dao.LogDAO;
import org.unibl.etf.dao.impl.LogDAOImpl;
import org.unibl.etf.models.dto.Log;
import org.unibl.etf.models.dto.LogLevel;

public class StatisticsBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final int PAGE_SIZE=10;
	
	private LogDAO logDAO;
	
	public StatisticsBean() {
		this.logDAO=new LogDAOImpl();
	}

	public List<Log> findAll(int page){
		List<Log> result=new ArrayList<Log>();
		try {
			result=this.logDAO.findAll(page, PAGE_SIZE);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public int numOfPages() {
		try {
			int n=this.logDAO.numberOfLogs();
			System.out.println(n);
			return (int) Math.ceil(n/((double)PAGE_SIZE));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
