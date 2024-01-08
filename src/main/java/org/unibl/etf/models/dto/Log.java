package org.unibl.etf.models.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log implements Serializable{
	private static final long serialVersionUID = 1L;
	private LogLevel level;
	private Date date;
	private String description;
	private static SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	
	public Log() {
		super();
	}

	public Log(LogLevel level, Date date, String description) {
		super();
		this.level = level;
		this.date = date;
		this.description = description;
	}

	public LogLevel getLevel() {
		return level;
	}

	public void setLevel(LogLevel level) {
		this.level = level;
	}

	public String getDate() {
		return formatter.format(date);
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
