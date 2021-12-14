package sheridan.romeroad.finalexam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sheridan.romeroad.finalexam.domain.Envelope

/**
 * Student ID: 991555778
 * finalexam
 * created by davidromero
 * on 2021-12-14
 **/
class PetListAdapter(
    private val onClick: (Envelope) -> Unit,
    private val onDelete: (Envelope) -> Unit
    ): ListAdapter<Envelope, PetListAdapter.ViewHolder>(ViewHolder.EnvelopeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PetListItemBinding.inflate(layoutInflater, parent, false)
        return RecyclerView.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.bind(position + 1, getItem(position))
    }

    inner class ViewHolder constructor(
        private val binding: PetListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(count: Int, envelope: Envelope) {
            binding.count.text = binding.root.context.getString(R.string.count, count)
            binding.envelope = envelope
            binding.root.setOnClickListener { onClick(envelope) }
            binding.deleteButton.setOnClickListener { onDelete(envelope) }
            binding.executePendingBindings()
        }
        class EnvelopeDiffCallback : DiffUtil.ItemCallback<Envelope>() {
            override fun areItemsTheSame(oldItem: Envelope, newItem: Envelope): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Envelope, newItem: Envelope): Boolean {
                return oldItem == newItem
            }
        }
}
