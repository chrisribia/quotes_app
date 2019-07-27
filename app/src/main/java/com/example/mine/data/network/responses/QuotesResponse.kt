package com.example.mine.data.network.responses

import com.example.mine.data.db.entities.entites.Quote

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)