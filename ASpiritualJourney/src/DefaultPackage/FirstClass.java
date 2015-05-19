package DefaultPackage;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopScoreDocCollector;

public class FirstClass {
	
	public static void main(String[] args) throws IOException {
		InputDocuments docMaker = new BigInputDocuments();
		ArrayList<Document> docs = docMaker.getDocArray();

//		StandardWriter writer = new StandardWriter();
//		writer.write(docs);
//		AbstractSearcher searcher = new TermQuerySearcher(writer);
//		searcher.printSearch("title", "Tharun");
//		writer.close();
	}

}
