package com.example.lenovo.myapplication.CustomGridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.myapplication.CustomGridview.Book;
import com.example.lenovo.myapplication.R;

/**
 * Created by erwinlim on 13/02/18.
 */

public class BooksAdapter extends BaseAdapter {

    private final Context mContext;
    private final Book[] books;

    // 1
    public BooksAdapter(Context context, Book[] books) {
        this.mContext = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // 1
        final Book book = books[position];

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linearlayout_book, null);
        }

        final TextView productName = convertView.findViewById(R.id.textview_book_name);
        final ImageView productImg = convertView.findViewById(R.id.imageview_cover_art);

        productName.setText(book.getName());
        productImg.setImageResource(book.getImageResource());

        return convertView;
    }
}
