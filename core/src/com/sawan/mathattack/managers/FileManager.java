/**
 * File name:	FileManager.java
 * Version:		1.0
 * Date:		@date 13:11:39
 * Author:		Sawan J. Kapai Harpalani
 * Copyright:	Copyright 200X Sawan J. Kapai Harpalani
 *
 *				This file is part of Math Attack.
 *
 *				Math Attack is free software: you can redistribute it 
 *				and/or modify it under the terms of the GNU General
 *				Public License as published by the Free Software 
 *				Foundation, either version 3 of the License, 
 *				or (at your option) any later version.
 *
 *				Math Attack is distributed in the hope that it will 
 *				be useful, but WITHOUT ANY WARRANTY; without even 
 *				the implied warranty of MERCHANTABILITY or FITNESS 
 *				FOR A PARTICULAR PURPOSE. See the GNU General Public
 *			    License for more details.
 *
 *				You should have received a copy of the GNU General 
 *				Public License along with Math Attack. If not, see 
 *				http://www.gnu.org/licenses/.
 */

package com.sawan.mathattack.managers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.sawan.mathattack.settings.MtxLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class FileManager.
 */
public class FileManager {
	//
	/** The Constant logTag. */
	protected static final String logTag = "MtxFileManagerLog";
	
	/** The log active. */
	public static boolean logActive = true;
	//
	/** The current line. */
	@SuppressWarnings("unused")
	private static String currentLine = "";

	// File Type
	/**
	 * The Enum FileType.
	 */
	public enum FileType {
		
		/** The internal file. */
		INTERNAL_FILE, 
 /** The local file. */
 LOCAL_FILE, 
 /** The external file. */
 EXTERNAL_FILE
	}

	/**
	 * Read lines from text file.
	 *
	 * @param strFile            file to read
	 * @param lineNumber            line number to read
	 * @param fileType            the type of file to retrieve file (INTERNAL, LOCAL, EXTERNAL)
	 * @return the string
	 */
	public static String readLine(String strFile, int lineNumber,
			FileType fileType) {
		// Identify file type and get storage location
		FileHandle file = getFile(strFile, fileType);

		// Start buffered reader
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				file.read()));
		String currentLine = null;
		int counter = 0;
		try {
			while ((currentLine = reader.readLine()) != null) {
				if (counter == lineNumber) {
					MtxLogger.log(logActive, true, logTag, "READ LINE: "
							+ currentLine);
					break;
				}
				counter++;
			}
			reader.close();
		} catch (IOException e) {
			MtxLogger.log(logActive, true, logTag, "CANT READ LINE: File: "
					+ strFile + ", Line Number: " + lineNumber);
			e.printStackTrace();
		}
		return currentLine;
	}

	/**
	 * Write new lines in text file.
	 *
	 * @param strFile            file to write
	 * @param value            value to write to new line
	 * @param fileType            the type of file to retrieve file (INTERNAL, LOCAL, EXTERNAL)
	 */
	public static void writeLine(String strFile, String value, FileType fileType) {
		try {
			FileHandle file = getFile(strFile, fileType);
			FileWriter fw = new FileWriter(file.file(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(value);
			bw.newLine();
			bw.close();
			MtxLogger.log(logActive, true, logTag, "Write New Line: File: "
					+ strFile + ", value: " + value);
		} catch (IOException e) {
			MtxLogger.log(logActive, true, logTag, "CANT WRITE LINE: File: "
					+ strFile);
			e.printStackTrace();
		}
	}

	/**
	 * Re-Write an existing line in a text file without effecting other lines.
	 *
	 * @param strFile            file to write
	 * @param lineNumber            line number to write
	 * @param newValue            the new value to write over existing line
	 * @param fileType            the type of file to retrieve file (INTERNAL, LOCAL, EXTERNAL)
	 */
	public static void writeExistingLine(String strFile, int lineNumber,
			String newValue, FileType fileType) {
		try {
			FileHandle file = getFile(strFile, fileType);
			ArrayList<String> lineByLineTextList = getUpdatedTextInfo(strFile,
					lineNumber, newValue);
			FileWriter fw = new FileWriter(file.file(), false);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < lineByLineTextList.size(); i++) {
				if (lineByLineTextList.get(i) != null) {
					bw.write(lineByLineTextList.get(i));
					bw.newLine();
				}
			}
			bw.close();
		} catch (IOException e) {
			MtxLogger.log(logActive, true, logTag, "CANT WRITE LINE: File: "
					+ strFile + ", Line Number: " + lineNumber);
			e.printStackTrace();
		}
	}

	/**
	 * Gets the updated text info.
	 *
	 * @param strFile the str file
	 * @param lineNumber the line number
	 * @param newValue the new value
	 * @return the updated text info
	 */
	private static ArrayList<String> getUpdatedTextInfo(String strFile,
			int lineNumber, String newValue) {
		ArrayList<String> lineByLineTextList = new ArrayList<String>();
		FileHandle file = Gdx.files.local(strFile);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				file.read()));
		String currentLine = null;
		int counter = 0;
		try {
			while ((currentLine = reader.readLine()) != null) {
				if (counter == lineNumber) {
					MtxLogger.log(logActive, true, logTag,
							"WRITE EXISTING LINE: OLD: " + currentLine
									+ " - NEW: " + newValue);
					lineByLineTextList.add(newValue);
				} else {
					lineByLineTextList.add(currentLine);
				}
				counter++;
			}
			reader.close();
		} catch (IOException e) {
		}
		return lineByLineTextList;
	}

	/**
	 * If a line consist of comma separated values, it returns each value in
	 * ArrayList.
	 *
	 * @param strFile            file to read
	 * @param lineNumber            line number to read, starts from 1
	 * @param fileType            the type of file to retrieve file (INTERNAL, LOCAL, EXTERNAL)
	 * @return the values seperated by comma in line
	 */
	public static ArrayList<String> getValuesSeperatedByCommaInLine(
			String strFile, int lineNumber, FileType fileType) {
		String lineString = readLine(strFile, lineNumber, fileType);
		ArrayList<String> values = new ArrayList<String>(
				Arrays.asList(lineString.split(",")));
		return values;
	}

	/**
	 * Create a file in a LOCAL storage. Good place the store game data in text
	 * files
	 *
	 * @param fileName the file name
	 */
	public static void createTextFileInLocalStorage(String fileName) {
		// Get local storage
		String localDir = Gdx.files.getLocalStoragePath();

		// Create files
		try {
			new FileWriter(localDir + fileName);
			Gdx.app.log("SettingLog", "TXT FILE CREATED: " + fileName);
		} catch (IOException e) {
			Gdx.app.log("SettingLog", "CANT CREATE TEXT FILE: File: "
					+ fileName);
			e.printStackTrace();
		}
	}

	/**
	 * Get number of lines in a text file.
	 *
	 * @param strFile the str file
	 * @param fileType the file type
	 * @return the number ofl ines in text file
	 */
	public static int getNumberOflInesInTextFile(String strFile,
			FileType fileType) {
		FileHandle file = getFile(strFile, fileType);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				file.read()));
		currentLine = "";
		int counter = 0;
		try {
			while ((currentLine = reader.readLine()) != null) {
				counter++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Gdx.app.log("SettingLog", "NUMBER OF LINES: " + file.name() + ": "
				+ counter);
		return counter;
	}

	/**
	 * Get file from one of the storages, there are three storages, INTERNAL
	 * (Read Only), LOCAL, EXTERNAL (SD CARD).
	 *
	 * @param strFile            file name to retrieve
	 * @param fileType            file type for location identification
	 * @return the file
	 */
	public static FileHandle getFile(String strFile, FileType fileType) {
		FileHandle file = null;
		if (fileType == FileType.INTERNAL_FILE) {
			try {
				file = Gdx.files.internal(strFile);
			} catch (Exception e) {
				MtxLogger.log(logActive, true, logTag,
						"!!! FILE IS NOT INTERNAL OR NOT EXIST: " + strFile);
			}
		} else if (fileType == FileType.LOCAL_FILE) {
			try {
				file = Gdx.files.local(strFile);
			} catch (Exception e) {
				MtxLogger.log(logActive, true, logTag,
						"!!! FILE IS NOT LOCAL OR NOT EXIST: " + strFile);
			}
		} else if (fileType == FileType.EXTERNAL_FILE) {
			try {
				file = Gdx.files.external(strFile);
			} catch (Exception e) {
				MtxLogger.log(logActive, true, logTag,
						"!!! FILE IS NOT EXTERNAL OR NOT EXIST: " + strFile);
			}
		}
		return file;
	}
	
	/**
	 * Initiate ma file.
	 *
	 * @param strFile the str file
	 * @param fileType the file type
	 */
	public static void initiateMAFile(String strFile, FileType fileType) {
		for (int i = 0; i < 8; i++) {
			writeLine(strFile, "0", fileType);
		}
	}
}
