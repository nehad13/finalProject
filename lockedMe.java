package com.phase1project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import
	java.util.LinkedList;
	import java.util.Scanner;
	
	public class lockedMe
	{
		static final String errorMessage = "Some error occured please contact admin@LockedMe.Com";
				static final String projectFilesPath = "C:\\Users\\User\\Desktop\\SimplilearnPhase1Project";
	

	public static void main(String[]args) throws IOException
	{
	Scanner obj = new Scanner(System.in);
	int ch;
	do
	{
	displayMenu();
	System.out.println("Enter your choice");
	ch=Integer.parseInt(obj.nextLine());
	switch(ch)
	{
	case 1:
	getAllFiles();
	break;
	case 2:createFiles();
	break;
	case 3: deleteAllFiles();
	break;
	case 4: searchFiles();
	break;
	case 5: System.exit(0);
	break;
	default:System.out.println("Invalid option");
	}
	}
	while(ch>0);
	obj.close();
	}

	public static void displayMenu()
	{
	System.out.println("\t=================================");
	System.out.println("\tWelcome to LockedMe.com");
	System.out.println("\t=================================");
	System.out.println("\tDesigned by Neha Dubey");
	
	System.out.println("\t1. Display all the files");
	System.out.println("\t2. Add a new file");
	System.out.println("\t3. Delete a file");
	System.out.println("\t4. Search a file");
	System.out.println("\t5. Exit");
	
	}
	
	
	public static void getAllFiles()
	{/*This method will return all the files from the directory*/
	try {
	File folder = new File(projectFilesPath);
	File[] listOfFiles = folder.listFiles();
	Arrays.sort(listOfFiles);
	if(listOfFiles.length==0)
	{
	System.out.println("No Files exist");
	}
	else
	{
	for(var l:listOfFiles)
	{
	System.out.println(l.getName());
	}
	 }
	 }
	catch(Exception Ex)
	{
	System.out.println(errorMessage);
	}
	}

	/*This method will add a new file in the directory*/
	
	public static void createFiles() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name");
		String fileName= sc.nextLine();
		 
		try {
			FileOutputStream fos = new FileOutputStream(projectFilesPath+"\\"+fileName);
			System.out.println("Enter the file content");
			String content= sc.nextLine();
			byte b[]= content.getBytes();
			try {
				fos.write(b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("File is saved on given location path");
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	/*This method will delete the file based on the user input if it exists*/
	
	public static void deleteAllFiles()
	{
	Scanner obj = new Scanner(System.in);

	System.out.println("Enter the file name to be deleted");
	String fileName = obj.nextLine();
	try
	{
	File file = new File(projectFilesPath+"\\"+fileName);
	if(file.exists())
	{
	file.delete();
	System.out.println("File deleted SuccessFully : "+fileName);
	}
	else
	System.out.println("File does not exists");
	}
	catch(Exception ex)
	{
	System.out.println(errorMessage);
	}
	
	} 
	
	/*This method will search the files from the directory*/
	
	public static void searchFiles()
	{
	Scanner obj = new Scanner(System.in);
	System.out.println("Enter the file name to be Searched");
	String fileName = obj.nextLine();
	
	try
	{
	File folder = new File(projectFilesPath);
	File[] listOfFiles = folder.listFiles();
	LinkedList<String> filenames = new LinkedList<String>();
	for(var l:listOfFiles)
	filenames.add(l.getName());
	if(filenames.contains(fileName))
	System.out.println("File is available");
	else
	System.out.println("File is not available");
	}
	catch(Exception ex)
	{
	System.out.println(errorMessage);
	} 
	}
}
