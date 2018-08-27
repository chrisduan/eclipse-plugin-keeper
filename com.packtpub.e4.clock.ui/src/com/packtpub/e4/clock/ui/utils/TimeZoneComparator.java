package com.packtpub.e4.clock.ui.utils;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

@SuppressWarnings("rawtypes")
public class TimeZoneComparator implements Comparator{

	public int compare(Object o1, Object o2) {
		
		if (o1 instanceof TimeZone && o2 instanceof TimeZone) {
			return ((TimeZone) o1).getID().compareTo(((TimeZone) o2).getID());
		} else {
			throw new IllegalArgumentException();
		}
	}

	public Comparator reversed() {
		return null;
	}

	public Comparator thenComparing(Comparator other) {
		return null;
	}

	public Comparator thenComparing(Function keyExtractor,
			Comparator keyComparator) {
		return null;
	}

	public Comparator thenComparing(Function keyExtractor) {
		return null;
	}

	public Comparator thenComparingInt(ToIntFunction keyExtractor) {
		return null;
	}

	public Comparator thenComparingLong(ToLongFunction keyExtractor) {
		return null;
	}

	public Comparator thenComparingDouble(ToDoubleFunction keyExtractor) {
		return null;
	}

	public static Comparator reverseOrder() {
		return null;
	}

	public static Comparator naturalOrder() {
		return null;
	}

	public static Comparator nullsFirst(Comparator comparator) {
		return null;
	}

	public static Comparator nullsLast(Comparator comparator) {
		return null;
	}

	public static Comparator comparing(Function keyExtractor,
			Comparator keyComparator) {
		return null;
	}

	public static Comparator comparing(Function keyExtractor) {
		return null;
	}

	public static Comparator comparingInt(ToIntFunction keyExtractor) {
		return null;
	}

	public static Comparator comparingLong(ToLongFunction keyExtractor) {
		return null;
	}

	public static Comparator comparingDouble(ToDoubleFunction keyExtractor) {
		return null;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Set<TimeZone>> getTimeZones() {
		String[] ids = TimeZone.getAvailableIDs();
		Map<String, Set<TimeZone>> timeZones = new TreeMap<String, Set<TimeZone>>();
		for (int i = 0; i < ids.length; i++) {
			String[] parts = ids[i].split("/");
			if (parts.length == 2) {
				String region = parts[0];
				Set<TimeZone> zones = timeZones.get(region);
				if (zones == null) {
					zones = new TreeSet<TimeZone>(new TimeZoneComparator());
					timeZones.put(region, zones);
				}
				TimeZone timeZone = TimeZone.getTimeZone(ids[i]);
				zones.add(timeZone);
			}
		}
		return timeZones;
	}
}
