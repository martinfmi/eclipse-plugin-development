package com.example.xwt;

import java.io.File;
import java.net.MalformedURLException;

import org.eclipse.e4.xwt.XWT;
import org.eclipse.swt.widgets.Shell;

public class XWTSample {

	public static void main(String[] args) throws MalformedURLException,
			Exception {
		File xwt = new File("src/com/example/xwt/hello_world.xwt");
		Shell shell = (Shell) XWT.load(xwt.toURI().toURL());
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!shell.getDisplay().readAndDispatch()) {
				shell.getDisplay().sleep();
			}
		}

		// alternative approach (handles the event loop as well)
		// XWT.open(xwt.toURI().toURL());
	}
}
