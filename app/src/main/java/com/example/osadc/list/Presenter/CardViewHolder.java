package com.example.osadc.list.Presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.osadc.list.Model.Book;
import com.example.osadc.list.R;

/**
 * Created by vykra on 03.03.2016.
 */
public class CardViewHolder extends RecyclerView.ViewHolder
{
    private final TextView mFirstLineView;
    private final TextView mSecondLineView;
    private final ImageView mRemoveButton;
    private Book mBook;
    public CardViewHolder(View itemView)
    {
        super(itemView);
        mFirstLineView = (TextView)itemView.findViewById(R.id.first_line);
        mSecondLineView = (TextView)itemView.findViewById(R.id.second_line);
        mRemoveButton = (ImageView)itemView.findViewById(R.id.secondary_action_button);
    }


    public void fillData(Book book, View.OnClickListener primaryAction, View.OnClickListener secondaryAction)
    {
        mBook = book;
        mFirstLineView.setText(mBook.BookAuthor + " - " + mBook.BookName);
        mSecondLineView.setText(mBook.BookDescription);
        itemView.setOnClickListener(primaryAction);
        mRemoveButton.setOnClickListener(secondaryAction);
    }
}
