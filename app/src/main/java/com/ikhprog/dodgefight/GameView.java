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

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import java.util.LinkedList;

/**
 * Created by a on 2015-06-30.
 */
public class GameView extends View
{
	private Paint mptPlayer, mptBullet, mptBulletHit;
	private Point mPlayer = null;
	private LinkedList<Bullet> mlstBullet = null;

	public GameView(Context context)
	{
		super(context);
		init();
	}

	public GameView(Context context, AttributeSet attr)
	{
		super(context, attr);
		init();
	}

	public GameView(Context context, AttributeSet attr, int defStyle)
	{
		super(context, attr, defStyle);
		init();
	}

	private void init()
	{
		mptPlayer = new Paint(Paint.ANTI_ALIAS_FLAG);
		mptPlayer.setColor(0xff00ffff);
		mptBullet = new Paint(Paint.ANTI_ALIAS_FLAG);
		mptBullet.setColor(0xffffffff);
		mptBulletHit = new Paint(Paint.ANTI_ALIAS_FLAG);
		mptBulletHit.setColor(0xffff3419);
	}

	public Point getPlayer() { return mPlayer; }
	public void setPlayer(Point p) { mPlayer = p; }
	public LinkedList<Bullet> getBulletList() { return mlstBullet; }
	public void setBulletList(LinkedList<Bullet> lst) { mlstBullet = lst; }

	@Override
	protected void onDraw(Canvas canvas)
	{
		if (mPlayer != null)
		{
			canvas.drawCircle(mPlayer.x, mPlayer.y, 2, mptPlayer);
		}

		if (mlstBullet != null)
		{
			for (Bullet bullet : mlstBullet)
			{
				canvas.drawCircle(bullet.x, bullet.y, 2, bullet.bHit ? mptBullet : mptBulletHit);
			}
		}
	}
}
