/*
 * Copyright (c) 2021 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.uspace.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.uspace.BR
import com.raywenderlich.android.uspace.databinding.ItemDragonBinding
import com.raywenderlich.android.uspace.ui.models.Dragon
import javax.inject.Inject

class DragonAdapter @Inject constructor() : RecyclerView.Adapter<DragonAdapter.DragonViewHolder>() {

  private val dragon: MutableList<Dragon> = mutableListOf()

  inner class DragonViewHolder(private val binding: ItemDragonBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(dragon: Dragon) {
      binding.setVariable(BR.dragon, dragon)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragonViewHolder {
    val binding = ItemDragonBinding.inflate(LayoutInflater.from(parent.context))
    return DragonViewHolder(binding)
  }

  override fun onBindViewHolder(holder: DragonViewHolder, position: Int) {
    val person = dragon[position]
    holder.bind(person)
  }

  override fun getItemCount() = dragon.size

  fun addItems(dragon: List<Dragon>) {
    this.dragon.addAll(dragon)
    notifyDataSetChanged()
  }
}
