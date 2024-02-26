package me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import me.vaimon.antgallery.databinding.ItemPictureBinding
import me.vaimon.antgallery.models.Picture

class PictureRecyclerViewAdapter(
    private val onItemClickListener: OnItemClickListener? = null
) : RecyclerView.Adapter<PictureRecyclerViewAdapter.ViewHolder>() {

    private val pictures: MutableList<Picture> = mutableListOf()

    private val onClickListener = View.OnClickListener {
        val item = it.tag as Picture
        onItemClickListener?.onPictureClick(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPictureBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pictures[position]

        holder.binding.ivPicture.load(item.imgUri){
            crossfade(true)
        }

        onClickListener.also {
            with(holder.itemView) {
                tag = item
                setOnClickListener(it)
            }
        }
    }

    override fun getItemCount(): Int = pictures.size

    fun replaceWithNewPictures(newPictureList: List<Picture>) {
        val listDiff = DiffUtil.calculateDiff(PictureDiffUtil(pictures, newPictureList))
        pictures.clear()
        pictures.addAll(newPictureList)
        listDiff.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(val binding: ItemPictureBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface OnItemClickListener {
        fun onPictureClick(item: Picture)
    }

    class PictureDiffUtil(
        private val oldList: List<Picture>,
        private val newList: List<Picture>,
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].imgUri == newList[newItemPosition].imgUri
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].title == newList[newItemPosition].title
        }
    }
}