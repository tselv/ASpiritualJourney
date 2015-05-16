package DefaultPackage;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopScoreDocCollector;

public class TermQuerySearcher extends AbstractSearcher {

	public TermQuerySearcher(StandardWriter writer) {
		super(writer);
	}

	@Override
	public void printSearch(String field, String fieldValue) throws IOException {
		Term term = new Term(field, fieldValue);
		TermQuery termQuery = new TermQuery(term);

		QueryParser parser = new QueryParser(fieldValue, analyzer);
		Query query = null;
		try {
			 query = parser.parse(fieldValue);
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}
		
		TopScoreDocCollector collector = TopScoreDocCollector.create(5);
		searcher.search(termQuery, collector);
		
		ScoreDoc[] hits = collector.topDocs().scoreDocs;
		System.out.println("Size: " + hits.length);
		for(ScoreDoc hit : hits) {
			Document actualDoc = searcher.doc(hit.doc);
			System.out.println("Content: " + actualDoc.get("content"));
		}
	}

}
