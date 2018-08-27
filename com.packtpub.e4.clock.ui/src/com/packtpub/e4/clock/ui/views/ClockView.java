package com.packtpub.e4.clock.ui.views;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;


public class ClockView extends ViewPart {

	public void createPartControl(Composite parent) {
		
		final ClockWidget clock = new ClockWidget(parent,SWT.NONE);
		
	}

	
	public void setFocus() {
	}
}