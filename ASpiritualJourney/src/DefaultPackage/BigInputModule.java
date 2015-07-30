package DefaultPackage;

import com.DefaultPackage.Input.BigInputDocuments;
import com.google.inject.Binder;
import com.google.inject.Module;

public class BigInputModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(Iterable.class).annotatedWith(InputDoc.class).to(BigInputDocuments.class);
	}

}
