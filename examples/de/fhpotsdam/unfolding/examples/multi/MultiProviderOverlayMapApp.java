package de.fhpotsdam.unfolding.examples.multi;

import processing.core.PApplet;
import codeanticode.glgraphics.GLConstants;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.ImmoScout;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;

/**
 * A two layer map. One map lays atop another one with same size and position.
 */
public class MultiProviderOverlayMapApp extends PApplet {

	UnfoldingMap map1;
	UnfoldingMap map2;

	public void setup() {
		size(800, 600, GLConstants.GLGRAPHICS);

		map1 = new UnfoldingMap(this, "map1", 0, 0, width, height, true, false, new Microsoft.RoadProvider());
		map1.zoomAndPanTo(new Location(52.439046f, 13.447266f), 8);

		map2 = new UnfoldingMap(this, "map2", 0, 0, width, height, true, false,
				new ImmoScout.HeatMapProvider());
		map2.zoomToLevel(8);
		map2.zoomAndPanTo(new Location(52.439046f, 13.447266f), 8);

		MapUtils.createDefaultEventDispatcher(this, map1, map2);
	}

	public void draw() {
		background(0);

		map1.draw();
		tint(255, 100);
		map2.draw();
	}

}
