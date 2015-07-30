package DefaultPackage;

import com.DefaultPackage.Writer.StandardWriter;
import com.google.inject.Binder;
import com.google.inject.Module;

public class StdWriterModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(StandardWriter.class).to(StandardWriter.class);
	}

}
