package by.tr.web.dao.command.impl.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FilePathHelper {
	
	public String getFilePath(String filename){

		ClassLoader classLoader = this.getClass().getClassLoader();
		String trueFilePath = classLoader.getResource(filename).getFile();
		
		return trueFilePath;
	}

	
	public InputStream getFileStream(String filename) throws FileNotFoundException {
		
		ClassLoader classLoader = this.getClass().getClassLoader();
		String trueFilePath = classLoader.getResource(filename).getFile();
		InputStream inputFile = new FileInputStream(trueFilePath);
		
		return inputFile;
	}
	

}
