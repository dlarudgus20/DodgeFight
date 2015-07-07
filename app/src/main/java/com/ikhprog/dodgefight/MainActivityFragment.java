/*
 * Copyright (c) 2014, 임경현
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.ikhprog.dodgefight;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

public class MainActivityFragment extends Fragment
{
	private GameView mGameView;
	private Point mPlayer = new Point(0, 0);
	private LinkedList<Bullet> mlstBullet = new LinkedList<Bullet>();

    public MainActivityFragment()
    {
    }

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run()
			{
				mTimerHandler.sendMessage(mTimerHandler.obtainMessage(MOVE_TIMER_ID, MOVE_TIMER_FREQ));
				mTimerHandler.sendMessage(mTimerHandler.obtainMessage(CREATION_TIMER_ID, CREATION_TIMER_FREQ));
			}
		}, 1000);
	}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

	    mGameView = (GameView)v.findViewById(R.id.game_view);
	    mGameView.setPlayer(mPlayer);
	    mGameView.setBulletList(mlstBullet);

	    return v;
    }

	private static final int MOVE_TIMER_ID = 1;
	private static final int MOVE_TIMER_FREQ = 13;
	private static final int CREATION_TIMER_ID = 2;
	private static final int CREATION_TIMER_FREQ = 675;
	private final Handler mTimerHandler = new Handler() {
		@Override
		public void handleMessage(Message msg)
		{
			super.handleMessage(msg);
			switch (msg.what)
			{
				case MOVE_TIMER_ID:
					break;
				case CREATION_TIMER_ID:
					break;
			}
		}
	};
}
