package com.bluemapletach.app.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeDetails {
	private String timing;
	private String name = "santhosh";
	private String createddate;
	private String updateddate;
	private String createdby;
	private String updatedby;

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(String updateddate) {
		this.updateddate = updateddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Date today = Calendar.getInstance().getTime();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
	private String date = formatter.format(today);

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}
	private int timing_id;

	public int getTiming_id() {
		return timing_id;
	}

	public void setTiming_id(int timing_id) {
		this.timing_id = timing_id;
	}

	@Override
	public String toString() {
		return "TimeDetails [timing=" + timing + ", createddate=" + createddate + ", updateddate=" + updateddate
				+ ", createdby=" + createdby + ", updatedby=" + updatedby + ", timing_id=" + timing_id + "]";
	}
	
}
