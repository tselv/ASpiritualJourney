package DefaultPackage;

import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.Field.Store;

public class FixedInputDocuments implements InputDocuments {	
	protected ArrayList<String> titles = new ArrayList<String>();
	protected ArrayList<String> contents = new ArrayList<String>();
	
	FixedInputDocuments() {
		titles.add("Tharun");
		contents.add("This is a test sentence to see what happens.");
		
		titles.add("Word");
		contents.add("What is life but a walking shadow.");
		
		titles.add("Java is Fun");
		contents.add("A programmers guide to java scjp certification.");
	}

	@Override
	public ArrayList<Document> getDocArray() {
		ArrayList<Document> docs = new ArrayList<Document>();
		
		for(int i = 0; i < titles.size(); ++i) {
			Document doc = new Document();
			doc.add(new StringField("title", titles.get(i), Store.YES));
			doc.add(new StringField("content", contents.get(i), Store.YES));
			docs.add(doc);
		}
		return docs;
	}
}
