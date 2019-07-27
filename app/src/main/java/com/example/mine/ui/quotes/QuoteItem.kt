package com.example.mine.ui.quotes

import com.example.mine.R
import com.example.mine.data.db.entities.entites.Quote
import com.example.mine.databinding.QuoteItemBinding
import com.xwray.groupie.databinding.BindableItem


class QuoteItem(
    private val quote: Quote
) : BindableItem<QuoteItemBinding>(){

    override fun getLayout() = R.layout.quote_item

    override fun bind(viewBinding: QuoteItemBinding, position: Int) {
        viewBinding.setQuote(quote)
    }
}