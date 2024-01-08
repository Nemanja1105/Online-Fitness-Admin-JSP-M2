package org.unibl.etf.models.dto;

public enum LogLevel {
	INFO("success"),WARNING("warning"),ERROR("danger"),FATAL("danger");
	private String color;
	
	private LogLevel(String color) {
		this.color=color;
	}
	
	public String getColor() {
		return this.color;
	}

}
