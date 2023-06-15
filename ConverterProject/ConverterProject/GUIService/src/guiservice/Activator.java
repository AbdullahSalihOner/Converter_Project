package guiservice;

import java.util.Locale;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import guiservice.gui.frm1;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("It is working");
		Locale locale = Locale.getDefault();
		System.out.println(locale.getLanguage());
		frm1.main(null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
