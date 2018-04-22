package de.remmecke.android.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Linse on 21.04.2018.
 Warning: Never pass context into ViewModel instances. Do not store Activity, Fragment, or View instances or their Context in the ViewModel.
 For example, an Activity can be destroyed and created many times during the lifecycle of a ViewModel as the device is rotated. If you store a reference to the Activity in the ViewModel, you end up with references that point to the destroyed Activity. This is a memory leak.
 If you need the application context, use AndroidViewModel, as shown in this codelab.

 Important: ViewModel is not a replacement for the onSaveInstanceState() method, because the ViewModel does not survive a process shutdown. Learn more here.
 */

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getmAllWords();
    }

    public LiveData<List<Word>> getmAllWords() {return mAllWords;}

    public void insert(Word word){mRepository.insert(word); }

}
