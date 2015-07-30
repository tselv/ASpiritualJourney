package com.DefaultPackage.Input;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;

import DefaultPackage.FirstClass;

public class FileInputDocuments extends GuicePainsMe {
	protected ArrayList<File> files = new ArrayList<File>();
	protected ArrayList<Document> docs = new ArrayList<Document>();
	FileDocIterator it = new FileDocIterator();
	
	

	FileInputDocuments() {
		this(FirstClass.INPUTFILE);
	}
	
	FileInputDocuments(String path) {
		File file = new File(path);
		getFiles(file);
		
		try {
			createDocs(docs);
		} catch (IOException e) {
			System.out.println("Something went horribly wrong, and I don't know how to fix it");
			e.printStackTrace();
		}
	}


		
	protected void getFiles(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory())
	        	getFiles(fileEntry);
	        else
	            files.add(fileEntry);
	    }
	}

	protected void createDocs(ArrayList<Document> docs) throws IOException {
		for(final File fileEntry : files) {
			Document doc = new Document();
			String title = fileEntry.getName();
			String contents = readFileContents(fileEntry.getPath(), StandardCharsets.UTF_8);
			doc.add(new TextField("title", title, Store.YES));
			doc.add(new TextField("content", contents, Store.YES));
			docs.add(doc);
		}
	}
	
	protected String readFileContents(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	
	
	@Override
	public Iterator<Document> iterator() {
		return it;
	}
	
	public class FileDocIterator implements Iterator<Document> {
		private int index = 0;
		
		@Override
		public boolean hasNext() {
			return index != docs.size();
		}

		@Override
		public Document next() {
			return docs.get(index++);
		}

		@Override
		public void remove() {
			docs.remove(--index);
		}
		
		
	}

}
