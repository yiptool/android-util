
package ru.zapolnov.yip;

import android.content.Context;
import android.view.ViewGroup;

public final class DummyViewGroup extends ViewGroup
{
	public DummyViewGroup(Context context)
	{
		super(context);
	}

	/*@Override*/ public final boolean shouldDelayChildPressedState()
	{
		return false;
	}

	@Override public final void onMeasure(int widthSpec, int heightSpec)
	{
		setMeasuredDimension(MeasureSpec.getSize(widthSpec), MeasureSpec.getSize(heightSpec));
	}

	@Override public final void onLayout(boolean changed, int left, int top, int right, int bottom)
	{
	}
}
