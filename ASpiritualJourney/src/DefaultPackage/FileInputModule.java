package DefaultPackage;

import com.DefaultPackage.Input.FileInputDocuments;
import com.google.inject.Binder;
import com.google.inject.Module;

public class FileInputModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(Iterable.class).annotatedWith(InputDoc.class).to(FileInputDocuments.class);
	}

}
