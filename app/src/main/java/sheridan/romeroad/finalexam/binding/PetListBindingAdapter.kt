package sheridan.romeroad.finalexam.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import sheridan.romeroad.finalexam.PetListAdapter
import sheridan.romeroad.finalexam.domain.Envelope

/**
 * Student ID: 991555778
 * finalexam
 * created by davidromero
 * on 2021-12-14
 **/

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, list: List<Envelope>?) {
    val adapter = recyclerView.adapter as PetListAdapter
    adapter.submitList(list)
}