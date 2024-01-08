package org.unibl.etf.models.beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.unibl.etf.models.dto.Log;
import org.unibl.etf.models.dto.LogLevel;

public class StatisticsBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public List<Log> findAll(){
		return Arrays.asList(new Log(LogLevel.ERROR, new Date(), "Opis1"),
				new Log(LogLevel.WARNING, new Date(), "Opis2"),
				new Log(LogLevel.INFO, new Date(), "Opis3"),
				new Log(LogLevel.FATAL, new Date(), "Opis4"),
				new Log(LogLevel.INFO, new Date(), "Opis5"),
				new Log(LogLevel.WARNING, new Date(), "Opis6"),
				new Log(LogLevel.FATAL, new Date(), "Opis1"));
	}

}
