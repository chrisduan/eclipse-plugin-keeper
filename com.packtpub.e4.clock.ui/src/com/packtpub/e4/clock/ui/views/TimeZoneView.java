package com.packtpub.e4.clock.ui.views;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.part.ViewPart;

import com.packtpub.e4.clock.ui.utils.TimeZoneComparator;

public class TimeZoneView extends ViewPart{

	@Override
	public void createPartControl(Composite parent) {
		Map<String, Set<TimeZone>> timeZones = TimeZoneComparator
				.getTimeZones();
		CTabFolder tabs = new CTabFolder(parent, SWT.BOTTOM);
		Iterator<Entry<String, Set<TimeZone>>> regionIterator = timeZones
				.entrySet().iterator();
		while (regionIterator.hasNext()) {
			Entry<String, Set<TimeZone>> region = regionIterator.next();
			CTabItem item = new CTabItem(tabs, SWT.NONE);
			item.setText(region.getKey());
			
			//Composite clocks = new Composite(tabs, SWT.NONE);
			//item.setControl(clocks);
			
			ScrolledComposite scrolled = new ScrolledComposite(tabs,SWT.H_SCROLL | SWT.V_SCROLL);
			Composite clocks = new Composite(scrolled, SWT.NONE);
			item.setControl(scrolled);
			scrolled.setContent(clocks);
			clocks.setLayout(new RowLayout());
			clocks.setBackground(Display.getDefault()
					.getSystemColor(SWT.COLOR_LIST_BACKGROUND));
			
			RGB rgb = new RGB(128, 128, 128);
			TimeZone td = TimeZone.getDefault();
			Iterator<TimeZone> timezoneIterator = region.getValue().
			iterator();
			while (timezoneIterator.hasNext()) {
			TimeZone tz = timezoneIterator.next();
			
			//ClockWidget clock = new ClockWidget(clocks, SWT.NONE, rgb);
			Group group = new Group(clocks,SWT.SHADOW_ETCHED_IN);
			group.setText(tz.getID().split("/")[1]);
			ClockWidget clock = new ClockWidget(group, SWT.NONE, rgb);
			group.setLayout(new FillLayout());
			clock.setOffset((
			tz.getOffset(System.currentTimeMillis()) -
			td.getOffset(System.currentTimeMillis())) / 3600000);
			}
			
			Point size = clocks.computeSize(SWT.DEFAULT,SWT.DEFAULT);
			scrolled.setMinSize(size);
			scrolled.setExpandHorizontal(true);
			scrolled.setExpandVertical(true);
		}
		tabs.setSelection(0);
	}

	@Override
	public void setFocus() {
		
	}

}
