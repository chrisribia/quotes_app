package com.example.mine.ui.quotes

import androidx.lifecycle.ViewModel;
import com.example.mine.data.repository.QuotesRepository
import com.example.mine.utils.lazyDeferred


class QuoteViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}
