package com.ikhprog.dodgefight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by a on 2015-07-07.
 */
public class InputView extends RelativeLayout
{
	private Button mbtnCenter, mbtnUp, mbtnDown, mbtnLeft, mbtnRight;

	public static interface OnInputListener
	{
		public void onMove(int dx, int dy);
		public void onFire();
	}

	public InputView(Context context)
	{
		super(context);
		init();
	}

	public InputView(Context context, AttributeSet attr)
	{
		super(context, attr);
		init();
	}

	public InputView(Context context, AttributeSet attr, int defStyle)
	{
		super(context, attr, defStyle);
		init();
	}

	private void init()
	{
		View v = View.inflate(getContext(), R.layout.view_input, this);
		mbtnCenter = (Button)v.findViewById(R.id.input_center_btn);
		mbtnUp = (Button)v.findViewById(R.id.input_up_btn);
		mbtnDown = (Button)v.findViewById(R.id.input_down_btn);
		mbtnLeft = (Button)v.findViewById(R.id.input_left_btn);
		mbtnRight = (Button)v.findViewById(R.id.input_right_btn);
	}

	public int getDx()
	{
		return (mbtnLeft.isPressed() ? -1 : 0) + (mbtnRight.isPressed() ? 1 : 0);
	}
	public int getDy()
	{
		return (mbtnUp.isPressed() ? -1 : 0) + (mbtnDown.isPressed() ? 1 : 0);
	}
	public boolean isFirePressed()
	{
		return mbtnCenter.isPressed();
	}
}
