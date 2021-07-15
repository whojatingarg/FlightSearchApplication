package com.nagarro.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.nagarro.constants.Constants;
import com.nagarro.dao.FlightDao;
import com.nagarro.dao.FlightFileDao;
import com.nagarro.dto.Flight;
import com.nagarro.dto.FlightFile;
import com.nagarro.utilities.DateParserUtil;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

/**
 * @author jatinkumar02
 *
 * FlightLoader class loads flights from CSV files to the mySQL database. It
 * also periodically checks for new flights and adds it to database when found.
 *
 */
@Service
public class FlightLoaderService {

	@Autowired
	private FlightFileDao flightFileDao;
	
	@Autowired
	private FlightDao flightDao;
	
	private final static Logger LOG = Logger.getLogger(FlightLoaderService.class);

	private File folder = new File(Constants.FOLERPATH);
	private File[] folderFiles;
	private List<FlightFile> dbFiles;
	private FileReader fileReader;

	private CSVParser csvParser = new CSVParserBuilder().withSeparator('|').build();
	private CSVReader csvReader;

	/**
	 * This method is executed periodically to check for new flights and update
	 * database if any new flights are found. dbFiles is list of FLightFile objects
	 * from the database that are the objects of CSV files that are read already.
	 * folderFiles is a array of File objects of CSV files that are currently
	 * present in the target folder.
	 *
	 */
	@Scheduled(fixedRate = 9000, initialDelay = 5000)
	public void loadFlights() {
		
		LOG.info("Starting flight loading process..... \n \n");
		
		dbFiles = flightFileDao.getAllFlightFiles();
		folderFiles = folder.listFiles();
		
		checkNewFlights();
		
		LOG.info("Flights loaded successfully. \n \n");
		
	}

	/**
	 * This method checks for new Flights by comparing dbFiles and folderFiles.
	 * Unmatched files are new files which are then loaded. Matched files are
	 * checked for new entries.
	 * 
	 */
	private void checkNewFlights() {
		// TODO Auto-generated method stub
		for(File folderFile : folderFiles) {
			
			FlightFile flightFile = new FlightFile();
			flightFile.setFileName(folderFile.getName());
			
			LOG.info("Checking for new files..");
			if(!dbFiles.contains(flightFile)) {
				
				readFlightsFromFile(flightFile,folderFile);
				
			}else {
				
				LOG.info("No new files found.");
				checkForNewEntriesInFile(flightFile,folderFile);
			
			}
		}
		
	}

	/**
	 * This method compares the number of rows present in the matching files. In
	 * case new rows are found it creates the Flight object of that row and persist
	 * it in Flight table. Also the FlightFile object is updated and persisted.
	 * 
	 * @param folderflightFile
	 * @param folderFile
	 * 
	 */
	private void checkForNewEntriesInFile(FlightFile flightFile, File folderFile) {
		// TODO Auto-generated method stub
		LOG.info("Checking for new entries in existing file: " + flightFile.getFileName());
		
		try {
			fileReader = new FileReader(folderFile);
			csvReader = new CSVReaderBuilder(fileReader).withCSVParser(csvParser).build();
			List<String[]> allFlightData = csvReader.readAll();
			int noOfEntriesInFile = allFlightData.size() - 1;
			
			
			FlightFile dbFlightFile = flightFileDao.getFlightFile(flightFile.getFileName());
			int noOfEntriesInDB = dbFlightFile.getRowCount();
			
			if(noOfEntriesInDB != noOfEntriesInFile) {
				LOG.info(" New entries found in file: " + folderFile.getName());
				
				for(int rowNumber = 1 + noOfEntriesInDB; rowNumber < allFlightData.size(); rowNumber++) {
					Flight newFLight = createFlightObject(allFlightData.get(rowNumber));
					flightDao.addFlight(newFLight);
				}
				
				flightFile.setRowCount(noOfEntriesInFile);
				flightFileDao.updateFlightFile(flightFile);
			
			}else {
				
				LOG.info("No new flight entry found in " + folderFile.getName());
			
			}
			
		}catch(FileNotFoundException e) {
		
			LOG.error("File not found : " + folderFile.getName());
		
		} catch (IOException e) {
			
			LOG.error("Input Output Exception occured while reading : " +folderFile.getName());
		
		}catch(Exception e) {
			
			LOG.fatal("Unknown Exception occured while reading : " + folderFile.getName());
		}
	
	}

	
	/**
	 * This method creates flight object of entries present in the newly found CSV
	 * file and persist it in database. Also the a FlightFile object of the new CSV
	 * file is created that stores file name and number of rows read.
	 * 
	 * @param folderflightFile
	 * @param folderFile
	 *
	 */
	private void readFlightsFromFile(FlightFile flightFile, File folderFile) {
		// TODO Auto-generated method stub
		LOG.info("New file found : " + flightFile.getFileName());
		try {

			fileReader = new FileReader(folderFile);
			csvReader = new CSVReaderBuilder(fileReader).withCSVParser(csvParser).build();
			List<String[]> allFlightData = csvReader.readAll();
			int noOfEntriesInFile = allFlightData.size() - 1;

			for (int rowNumber = 1; rowNumber < allFlightData.size(); rowNumber++) {
				Flight newFlight = createFlightObject(allFlightData.get(rowNumber));
				flightDao.addFlight(newFlight);
			}

			flightFile.setRowCount(noOfEntriesInFile);
			flightFileDao.addFlightFile(flightFile);

		} catch (FileNotFoundException fileNotFoundException) {
			LOG.error("File not found : " + folderFile.getName());

		} catch (IOException ioException) {
			LOG.error("Input Output Exception occured while reading : " + folderFile.getName());

		} catch (Exception exception) {
			LOG.fatal("Unknown Exception occured while reading : " + folderFile.getName());
		}
		
		
	}


	/**
	 * This method creates a Flight object of a row from CSV file.
	 * 
	 * @param flightData CSV file row data.
	 * @return Flight object
	 *
	 */
	private Flight createFlightObject(String[] flightData) {
		// TODO Auto-generated method stub
		Flight flight = new Flight();
		flight.setFlightNumber(flightData[0]);
		flight.setDepartLocation(flightData[1]);
		flight.setArrivalLocation(flightData[2]);
		
		//parsing string into date object.
		Date flightDate = DateParserUtil.getDate(flightData[3]);
		
		flight.setFlightDate(flightDate);
		
		flight.setFlightTime(flightData[4]);
		flight.setFlightDuration(Double.parseDouble(flightData[5]));
		flight.setFare(Integer.parseInt(flightData[6]));
		flight.setSeatAvailablility(flightData[7].charAt(0));
		flight.setFlightClass(flightData[8]);
		return flight;
		
	}

}
