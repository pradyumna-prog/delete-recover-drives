package Viruses;

import java.io.*;

public class RecycleFiles {
	
	static File fileNames;
	static File[] fileList;

	public static void main(String[] args) {
		fileNames = new File("F:\\deletedFiles\\");
		fetchDirectory(fileNames);
		if(fileList != null)
			System.out.println("Operation Successful");
		else {
			System.out.println("Operation Unsuccessful, drive not found");
		}
		
	}
	
	static public void fetchDirectory(File fileNames) {
		fileList = fileNames.listFiles();
		if(fileList != null) {
		File[] fileDirectoryList = new File[fileList.length];
		int k=0;
		
		for(File file: fileList) {
			File newFile = new File("H:\\", file.getName());
			if(!file.renameTo(newFile)) {
				fileDirectoryList[k++] = file;
			}
		}
		for(File file: fileDirectoryList) {
			if(file != null)
				fetchDirectory(file);
		}
		}
	}
}