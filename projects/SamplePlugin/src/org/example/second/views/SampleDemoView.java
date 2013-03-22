package org.example.second.views;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class SampleDemoView extends ViewPart {

	public SampleDemoView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		Button button = new Button(parent, SWT.NONE);
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
				Display.getCurrent().asyncExec(new Runnable() {
					@Override
					public void run() {
						Shell shell = PlatformUI.getWorkbench()
								.getActiveWorkbenchWindow().getShell();
						MessageDialog.openInformation(shell, "123", "abc");
					}
				});
			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}
}
