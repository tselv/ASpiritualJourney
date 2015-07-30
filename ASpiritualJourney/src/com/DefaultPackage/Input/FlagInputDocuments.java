package com.DefaultPackage.Input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;

import com.google.inject.Inject;

import DefaultPackage.FirstClass;

public class FlagInputDocuments extends GuicePainsMe {
	String filePath;
	
	@Inject
	public FlagInputDocuments() {
		this(FirstClass.FLAGINPUTFILE);
	}

	public FlagInputDocuments(String path) {
		this.filePath = path;
	}

	@Override
	public Iterator<Document> iterator() {
		return new FlagDocIterator();
	}
	
	public class FlagDocIterator implements Iterator<Document> {
		private Scanner reader;
		
		public FlagDocIterator() {
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
			if(!hasNext())
				throw new NoSuchElementException();
			Document doc = new Document();
			String delimiter = "[-\\w]+";
			doc.add(new TextField("country", reader.findInLine(delimiter), Store.YES));
			doc.add(new TextField("landMass", (LandMass.values()[Integer.parseInt(reader.findInLine(delimiter))-1]).toString(), Store.YES));
			doc.add(new TextField("zone", (Zone.values()[Integer.parseInt(reader.findInLine(delimiter))-1]).toString(), Store.YES));
			doc.add(new IntField("area", Integer.parseInt(reader.findInLine(delimiter)) , Store.YES));
			doc.add(new IntField("population", Integer.parseInt(reader.findInLine(delimiter)) , Store.YES));
			doc.add(new TextField("language", (Language.values()[Integer.parseInt(reader.findInLine(delimiter))-1]).toString(), Store.YES));
			doc.add(new TextField("religion", (Religion.values()[Integer.parseInt(reader.findInLine(delimiter))]).toString(), Store.YES));
			doc.add(new IntField("bars", Integer.parseInt(reader.findInLine(delimiter)) , Store.YES));
			doc.add(new IntField("strips", Integer.parseInt(reader.findInLine(delimiter)) , Store.YES));
			doc.add(new IntField("colors", Integer.parseInt(reader.findInLine(delimiter)) , Store.YES));
			doc.add(new StringField("red", reader.findInLine(delimiter), Store.YES));
			doc.add(new StringField("green", reader.findInLine(delimiter), Store.YES));
			doc.add(new StringField("blue", reader.findInLine(delimiter), Store.YES));
			doc.add(new StringField("gold", reader.findInLine(delimiter), Store.YES));
			doc.add(new StringField("white", reader.findInLine(delimiter), Store.YES));
			doc.add(new StringField("black", reader.findInLine(delimiter), Store.YES));
			doc.add(new StringField("orange", reader.findInLine(delimiter), Store.YES));
			doc.add(new TextField("mainHue", reader.findInLine(delimiter), Store.YES));
			doc.add(new IntField("circles", Integer.parseInt(reader.findInLine(delimiter)) , Store.YES));
			doc.add(new IntField("crosses", Integer.parseInt(reader.findInLine(delimiter)) , Store.YES));
			doc.add(new IntField("saltires", Integer.parseInt(reader.findInLine(delimiter)) , Store.YES));
			doc.add(new IntField("quarters", Integer.parseInt(reader.findInLine(delimiter)) , Store.YES));
			doc.add(new IntField("sunstars", Integer.parseInt(reader.findInLine(delimiter)) , Store.YES));
			doc.add(new StringField("crescent", reader.findInLine(delimiter), Store.YES));
			doc.add(new StringField("triangle", reader.findInLine(delimiter), Store.YES));
			doc.add(new StringField("icon", reader.findInLine(delimiter), Store.YES));
			doc.add(new StringField("animate", reader.findInLine(delimiter), Store.YES));
			doc.add(new StringField("text", reader.findInLine(delimiter), Store.YES));
			doc.add(new StringField("topleft", reader.findInLine(delimiter), Store.YES));
			doc.add(new StringField("bottomright", reader.findInLine(delimiter), Store.YES));
//			System.out.println("Test for Flag data");
//			for(IndexableField f: doc.getFields())
//				System.out.println(f.toString());
			
			if(hasNext())
				reader.nextLine();
			
			return doc;
		}

		@Override
		public void remove() {}
	}
	
	private enum LandMass {NorthAmerica, SouthAmerica, Europe, Africa, Asia, Oceania};
	private enum Zone {NE, SE, SW, NW};
	private enum Language {English, Spanish, French, German, Slavic, OtherIndoEuropean, Chinese, Arabic, JapaneseTurkishFinnishMagyar, Others};
	private enum Religion {Catholic, Other, Christian, Muslim, Buddhist, Hindu, Ethnic, Marxist, Others}; //Need to add 1
	

}
