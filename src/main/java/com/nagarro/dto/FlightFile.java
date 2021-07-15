package com.nagarro.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jatinkumar02
 *
 * FlightFile class is used to store information about the CSVFile that is read
 * already to avoid multiple read of a same file or an entry in that file.
 * FileName is name of CSV file. rowCount are the number of rows read already.
 * 
 */
@Entity
@Table(name = "Flight_Files")
public class FlightFile {

	@Id
	private String fileName;
	
	@Column(name="No_of_rows")
	private int rowCount;
	
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * @return the rowCount
	 */
	public int getRowCount() {
		return rowCount;
	}
	
	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	
	@Override
	public boolean equals(Object obj) {
		FlightFile flightFile = (FlightFile) obj;
		return this.getFileName().equals(flightFile.getFileName());
	}
	
}
