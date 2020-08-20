package cl.desafiolatam.monstercreator.view.allMonsters

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.monstercreator.R
import cl.desafiolatam.monstercreator.model.Monster
import cl.desafiolatam.monstercreator.view.allMonsters.AllMonstersAdapter.MonsterViewHolder

class AllMonstersAdapter(private val listMonster: List<Monster>) : RecyclerView.Adapter<MonsterViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonsterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.monster_item, parent, false )
        return MonsterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMonster.size
    }

    override fun onBindViewHolder(holder: MonsterViewHolder, position: Int) {
        holder.monsterName.text = listMonster[position].name
        holder.monsterPoint.text = listMonster[position].monsterPoints.toString()
    }

    class MonsterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var monsterImageView : ImageView
        var monsterName: TextView
        var monsterPoint: TextView

        init {
            monsterImageView = itemView.findViewById(R.id.monsterImageView)
            monsterName = itemView.findViewById(R.id.monsterName)
            monsterPoint =  itemView.findViewById(R.id.monsterPoints)
        }
    }
}