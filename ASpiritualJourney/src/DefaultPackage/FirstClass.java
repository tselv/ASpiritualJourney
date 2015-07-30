package DefaultPackage;

import java.io.IOException;

import org.apache.lucene.document.Document;

import com.DefaultPackage.Input.FlagInputDocuments;
import com.DefaultPackage.Searcher.AbstractSearcher;
import com.DefaultPackage.Searcher.BooleanQuerySearcher;
import com.DefaultPackage.Writer.StandardWriter;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class FirstClass {
	public static final String BIGINPUTFILE = "C:\\Users\\Work\\Documents\\input.txt";
	public static final String FLAGINPUTFILE = "C:\\Users\\Work\\Documents\\flag.data.txt";
	public static final String UNINPUTFILE = "C:\\Users\\Work\\Documents\\university.data.txt";
	public static final String WRITERFOLDER = "C:\\Users\\Work\\Documents\\LuceneTest";
	public static final String INPUTFILE = "C:\\Users\\Work\\Documents\\LuceneTestFolder";
	
	
	public static void main(String[] args) throws IOException {		
//		Iterable<Document> docMaker = new FlagInputDocuments();
//		StandardWriter writer = new StandardWriter(docMaker);
//		writer.write();
//		AbstractSearcher searcher = new BooleanQuerySearcher(writer);
		//searcher.addExtraQuery("content", "sentence");
		
		
		Injector injector = Guice.createInjector(new FlagInputModule());
		AbstractSearcher searcher = injector.getInstance(BooleanQuerySearcher.class);
		searcher.printSearch("country", "zimbabwe");
		//writer.close();
	}

}
