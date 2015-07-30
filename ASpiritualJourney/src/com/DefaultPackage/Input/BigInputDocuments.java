package com.DefaultPackage.Input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;

import static DefaultPackage.FirstClass.BIGINPUTFILE;;

public class BigInputDocuments extends GuicePainsMe {

	DocIterator it = new DocIterator();
	Scanner reader;
	
	public BigInputDocuments() throws IOException {
		this(BIGINPUTFILE);
		System.out.println("Requires change in default constructor.");
	}
	
	
	public BigInputDocuments(String path) throws IOException {
		reader = new Scanner(new BufferedReader(new FileReader(path)));
	}
	
	public Document getNextDoc() {
			Document doc = new Document();
			
			reader.useDelimiter("[\\:][T]");
			String id = reader.next().trim().substring(3);
			doc.add(new StringField("id", id, Store.YES));
//			System.out.println("ID:");
//			System.out.println(id);

			reader.useDelimiter("[\\:][B]");
			String title = reader.next().trim().substring(4);
			doc.add(new TextField("title", title, Store.YES));
//			System.out.println("Title:");
//			System.out.println(title);


			reader.useDelimiter("[\\:][D][\\:]");
			String content = reader.next().trim().substring(4);
			doc.add(new TextField("content", content, Store.YES));
//			System.out.println("Content:");
//			System.out.println(content);
			
			return doc;
	}
	
	@Override
	public Iterator<Document> iterator() {
		return it;
	}
	
	public class DocIterator implements Iterator<Document> {
		
		@Override
		public boolean hasNext() {
			return reader.hasNext();
		}

		@Override
		public Document next() {
			if(!hasNext())
				throw new NoSuchElementException();
			return getNextDoc();
		}

		@Override
		public void remove() {
			
		}
		
		
	}

}
