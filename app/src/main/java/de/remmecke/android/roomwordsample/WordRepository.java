package de.remmecke.android.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by Linse on 21.04.2018.
 */

public class WordRepository {

    private  WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<Word>> getmAllWords(){
        return mAllWords;
    }

     public void insert(Word word){
        new insertAsyncTask(mWordDao).execute(word);
     }

     private static class insertAsyncTask extends AsyncTask<Word, Void, Void>{

         private WordDao mAsyncTaskDao;

         public insertAsyncTask(WordDao dao) {
             mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
