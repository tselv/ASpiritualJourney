package DefaultPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.Field.Store;

public class BigInputDocuments implements InputDocuments {

	ArrayList<String> titles = new ArrayList<String>();
	ArrayList<String> IDs = new ArrayList<String>();
	ArrayList<String> contents = new ArrayList<String>();
	ArrayList<Document> docs = new ArrayList<Document>();
	Scanner reader;
	
	public BigInputDocuments() throws IOException {
		this("C:\\Users\\Work\\Documents\\input.txt");
		System.out.println("Requires change in default constructor.");
	}
	
	
	public BigInputDocuments(String path) throws IOException {
		reader = new Scanner(new BufferedReader(new FileReader(path)));
	}
	
	@Override
	public ArrayList<Document> getDocArray() {
		if(docs.size() != 0)
			return docs;
		
		
		while(reader.hasNext()) {
			Document doc = new Document();
			
			reader.useDelimiter("[\\:][T]");
			String id = reader.next().trim().substring(3);
			doc.add(new StringField("id", id, Store.YES));
//			System.out.println("ID:");
//			System.out.println(id);

			reader.useDelimiter("[\\:][B]");
			String title = reader.next().trim().substring(4);
			doc.add(new StringField("title", title, Store.YES));
//			System.out.println("Title:");
//			System.out.println(title);


			reader.useDelimiter("[\\:][D][\\:]");
			String content = reader.next().trim().substring(4);
			doc.add(new StringField("content", content, Store.YES));
//			System.out.println("Content:");
//			System.out.println(content);
			
			docs.add(doc);
		}
		
		
		return docs;
	}

}
