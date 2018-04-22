package de.remmecke.android.roomwordsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Linse on 21.04.2018.
 */

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder{
        private final TextView wordItemView;

        public WordViewHolder(View itemView) {
            super(itemView);
            this.wordItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Word> mWords;

    WordListAdapter(Context context){ mInflater = LayoutInflater.from(context); }


    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false );
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if(mWords != null){
            Word current = mWords.get(position);
            holder.wordItemView.setText(current.getWord());
        }else{
            holder.wordItemView.setText("No Word");
        }
    }

    void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mWords!= null)
            return mWords.size();
        return 0;
    }
}
