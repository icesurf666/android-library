package com.example.osadc.list.Presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.osadc.list.Detail;
import com.example.osadc.list.Model.Book;
import com.example.osadc.list.R;

import java.util.List;

/**
 * Created by vykra on 03.03.2016.
 */
public class BooksAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private final List<Book> mBooks;

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_card, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(cardView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, final int position)
    {
        final Book currentBook = mBooks.get(position);
        final Context appContext = holder.itemView.getContext();

        View.OnClickListener primaryClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(appContext, Detail.class);
                appContext.startActivity(detailIntent);
            }
        };

        View.OnClickListener secondaryClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentIndex = mBooks.indexOf(currentBook);
                mBooks.remove(currentBook);
                notifyItemRemoved(currentIndex);
            }
        };
        holder.fillData(mBooks.get(position), primaryClickListener, secondaryClickListener);
    }

    @Override
    public int getItemCount()
    {
        return mBooks.size();
    }

    public void addItem(Book newBook)
    {
        mBooks.add(newBook);
        notifyItemInserted(mBooks.indexOf(newBook));
    }

    public BooksAdapter(List<Book> booksList)
    {
        this.mBooks = booksList;
    }
}
