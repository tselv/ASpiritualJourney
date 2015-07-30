package com.DefaultPackage.Input;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;

public class FixedInputDocuments extends GuicePainsMe {	
	protected ArrayList<Document> docs = new ArrayList<Document>();
	FixedDocIterator it = new FixedDocIterator();
	
	FixedInputDocuments() {
		ArrayList<String> titles = new ArrayList<String>();
		ArrayList<String> contents = new ArrayList<String>();
		titles.add("Tharun");
		contents.add("This is a test sentence to see what happens.");
		
		titles.add("Word");
		contents.add("What is life but a walking shadow.");
		
		titles.add("Java is Fun");
		contents.add("A programmers guide to java scjp certification.");
		makeDocArray(titles, contents);
	}


	private void makeDocArray(ArrayList<String> titles, ArrayList<String> contents) {
		ArrayList<Document> docs = new ArrayList<Document>();
		
		for(int i = 0; i < titles.size(); ++i) {
			Document doc = new Document();
			doc.add(new TextField("title", titles.get(i), Store.YES));
			doc.add(new TextField("content", contents.get(i), Store.YES));
			docs.add(doc);
		}
		this.docs = docs;
	}

	@Override
	public Iterator<Document> iterator() {
		return it;
	}
	
	public class FixedDocIterator implements Iterator<Document> {
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
