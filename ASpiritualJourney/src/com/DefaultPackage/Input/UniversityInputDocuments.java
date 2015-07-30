package com.DefaultPackage.Input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexableField;

import DefaultPackage.FirstClass;

public class UniversityInputDocuments extends GuicePainsMe {
	String filePath;
	public UniversityInputDocuments() {
		this(FirstClass.UNINPUTFILE);
	}

	public UniversityInputDocuments(String path) {
		this.filePath = path;
	}

	@Override
	public Iterator<Document> iterator() {
		return new UniDocIterator();
	}
	
	public class UniDocIterator implements Iterator<Document> {
		private Scanner reader;
		
		public UniDocIterator() {
			try {
				reader = new Scanner(new BufferedReader(new FileReader(filePath)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		@Override
		public boolean hasNext() {
			return reader.hasNextLine();
		}

		@Override
		public Document next() {
			Document doc = new Document();
			String temp;
			Integer temp2;
			
			reader.findInLine("[-\\w]+");//skip delimiter
			doc.add(new TextField("name", reader.findInLine("[-\\w]+"), Store.YES));
			reader.nextLine();
			reader.findInLine("[\\w]+");//skip delimiter
			doc.add(new TextField("state", reader.findInLine("[-\\w]+"), Store.YES));
			reader.nextLine();
			temp = reader.findInLine("[\\w]+");//skip delimiter
			if( temp.toLowerCase().equals("location") ) {
				doc.add(new TextField("location", reader.findInLine("[-\\w]+"), Store.YES));
				reader.nextLine();
				temp = reader.findInLine("[\\w]+");//skip delimiter
			}
			doc.add(new TextField("control", reader.findInLine("[-\\w]+"), Store.YES));
			System.out.println("Control: " + doc.get("control"));
			System.out.println("State: " + doc.get("state"));
			System.out.println("Name: " + doc.get("name"));
			reader.nextLine();
			doc.add(new IntField("minNumStudents", Integer.parseInt(reader.findInLine("[\\d]+")) , Store.YES));//In thousands
			temp = reader.findInLine("[\\d]+");
			temp2 = ( temp != null ? Integer.parseInt(temp) : Integer.MAX_VALUE);
			doc.add(new IntField("maxNumStudents", temp2 , Store.YES));
			reader.nextLine();
			doc.add(new IntField("percentMale", Integer.parseInt(reader.findInLine("[\\d]+")) , Store.YES)); //Percentage out of 100
			reader.nextLine();
			doc.add(new IntField("facultyRatio", Integer.parseInt(reader.findInLine("[\\d]+")) , Store.YES)); //Number of students per 1 faculty member
			reader.nextLine();
			doc.add(new IntField("satVerbal", Integer.parseInt(reader.findInLine("[\\d]+")) , Store.YES)); //verbal score
			reader.nextLine();
			doc.add(new IntField("satMath", Integer.parseInt(reader.findInLine("[\\d]+")) , Store.YES)); //math score
			reader.nextLine();
			doc.add(new IntField("minExpenses", Integer.parseInt(reader.findInLine("[\\d]+")) , Store.YES)); //in thousands
			temp = reader.findInLine("[\\d]+");
			temp2 = ( temp != null ? Integer.parseInt(temp) : Integer.MAX_VALUE);
			doc.add(new IntField("maxExpenses", temp2 , Store.YES));
			reader.nextLine();
			doc.add(new IntField("finiancialAid", Integer.parseInt(reader.findInLine("[\\d]+")) , Store.YES)); //percentage of students with it
			reader.nextLine();
			doc.add(new IntField("minNumApplicants", Integer.parseInt(reader.findInLine("[\\d]+")) , Store.YES)); //in thousands
			temp = reader.findInLine("[\\d]+");
			temp2 = ( temp != null ? Integer.parseInt(temp) : Integer.MAX_VALUE);
			doc.add(new IntField("maxNumApplicants", temp2 , Store.YES)); 
			reader.nextLine();
			doc.add(new IntField("admitted", Integer.parseInt(reader.findInLine("[\\d]+")) , Store.YES)); //percent of students admitted
			reader.nextLine();
			doc.add(new IntField("enrolled", Integer.parseInt(reader.findInLine("[\\d]+")) , Store.YES)); //percent of students enrolled
			reader.nextLine();
			reader.findInLine("[\\d][-][\\d]"); //skip delimiter
			doc.add(new IntField("academics", Integer.parseInt(reader.findInLine("[\\d]")) , Store.YES)); //academics on a scale of 1-5
			reader.nextLine();
			reader.findInLine("[\\d][-][\\d]"); //skip delimiter
			doc.add(new IntField("social", Integer.parseInt(reader.findInLine("[\\d]")) , Store.YES)); //social on a scale of 1-5
			reader.nextLine();
			reader.findInLine("[\\d][-][\\d]"); //skip delimiter
			doc.add(new IntField("qof", Integer.parseInt(reader.findInLine("[\\d]")) , Store.YES)); //quality of life on a scale of 1-5

			while(reader.findInLine("[)][)]") == null) {
				reader.nextLine();
				reader.findInLine("[\\w]+[-][\\w]+"); //skip delimiter
				doc.add(new TextField("emphasis", reader.findInLine("[-\\w]+"), Store.YES));
			}
			
			
			
			System.out.println("Test for University data");
			for(IndexableField f: doc.getFields())
				System.out.println(f.toString());
			System.out.println("----------------------------------------------------------------------------");
			
			if(hasNext())
				reader.nextLine();
			return doc;
		}

		@Override
		public void remove() {}
		
	}

}
