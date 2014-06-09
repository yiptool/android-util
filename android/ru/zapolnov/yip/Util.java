
package ru.zapolnov.yip;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import java.util.HashMap;

public final class Util
{
	public static final int UIAlignUnspecified = 0;
	public static final int UIAlignLeft = 0x01;
	public static final int UIAlignRight = 0x02;
	public static final int UIAlignHCenter = 0x03;
	public static final int UIAlignTop = 0x10;
	public static final int UIAlignBottom = 0x20;
	public static final int UIAlignVCenter = 0x30;

	public static final int UIAlignTopLeft = UIAlignTop | UIAlignLeft;
	public static final int UIAlignTopRight = UIAlignTop | UIAlignRight;
	public static final int UIAlignBottomLeft = UIAlignBottom | UIAlignLeft;
	public static final int UIAlignBottomRight = UIAlignBottom | UIAlignRight;
	public static final int UIAlignCenter = UIAlignHCenter | UIAlignVCenter;

	public static final int UIAlignHorizontalMask = 0x03;
	public static final int UIAlignVerticalMask = 0x30;

	private static final HashMap<String, Typeface> m_Typefaces = new HashMap<String, Typeface>();

	public static void layoutChild(View child, int alignment, float x, float y, float w, float h,
		float xScale, float yScale, float wScale, float hScale, float horzScale, float vertScale)
	{
		float widgetX = x * xScale;
		float widgetY = y * yScale;
		float widgetW = w * wScale;
		float widgetH = h * hScale;

		if ((alignment & UIAlignHorizontalMask) == UIAlignHCenter)
			widgetX += (w * horzScale - widgetW) * 0.5f;
		else if ((alignment & UIAlignHorizontalMask) == UIAlignRight)
			widgetX += w * horzScale - widgetW;

		if ((alignment & UIAlignVerticalMask) == UIAlignVCenter)
			widgetY += (h * vertScale - widgetH) * 0.5f;
		else if ((alignment & UIAlignVerticalMask) == UIAlignBottom)
			widgetY += h * vertScale - widgetH;

		child.layout((int)widgetX, (int)widgetY, (int)(widgetX + widgetW), (int)(widgetY + widgetH));
	}

	public static Typeface getTypeface(AssetManager assetManager, String name)
	{
		Typeface typeface = m_Typefaces.get(name);
		if (typeface != null)
			return typeface;

		typeface = Typeface.createFromAsset(assetManager, name);
		m_Typefaces.put(name, typeface);

		return typeface;
	}
}
