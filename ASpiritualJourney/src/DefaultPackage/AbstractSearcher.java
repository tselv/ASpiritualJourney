package DefaultPackage;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.IndexSearcher;

public abstract class AbstractSearcher {

	DirectoryReader ireader;
	IndexSearcher searcher;
	Analyzer analyzer;
	
	public AbstractSearcher(StandardWriter writer) {
		try {
			ireader = DirectoryReader.open(writer.getDirectory());
		} catch (IOException e) {
			e.printStackTrace();
		}
		searcher = new IndexSearcher(ireader);
		analyzer = writer.getAnalyzer();
	}
	
	public abstract void  printSearch(String field, String fieldValue) throws IOException;
}
