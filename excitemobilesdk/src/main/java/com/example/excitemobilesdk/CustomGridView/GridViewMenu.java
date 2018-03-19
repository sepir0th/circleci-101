/*
 * Copyright (c) 2016 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.example.excitemobilesdk.CustomGridView;

import android.os.Parcel;
import android.os.Parcelable;

public class GridViewMenu implements Parcelable {
  private String menuTitle;
  private String menuSubtitle;
  private int imageResource;

  public GridViewMenu(String menuTitle, int imageResource) {
    this.menuTitle = menuTitle;
    this.imageResource = imageResource;
  }


  public String getMenuTitle() {
    return menuTitle;
  }

  public String getMenuSubitle() {
    return menuSubtitle;
  }

  public int getImageResource() {
    return imageResource;
  }

  public void setMenuSubitle(String menuSubtitle) {
    this.menuSubtitle = menuSubtitle;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeString(getMenuTitle());
  }

  public static final Parcelable.Creator<GridViewMenu> CREATOR
          = new Parcelable.Creator<GridViewMenu>() {
    public GridViewMenu createFromParcel(Parcel in) {
      return new GridViewMenu(in);
    }

    public GridViewMenu[] newArray(int size) {
      return new GridViewMenu[size];
    }
  };

  private GridViewMenu(Parcel in) {
    menuTitle = in.readString();
  }
}