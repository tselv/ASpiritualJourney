package DefaultPackage;

import com.DefaultPackage.Input.FixedInputDocuments;
import com.google.inject.Binder;
import com.google.inject.Module;

public class FixedInputModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(Iterable.class).annotatedWith(InputDoc.class).to(FixedInputDocuments.class);
	}

}
