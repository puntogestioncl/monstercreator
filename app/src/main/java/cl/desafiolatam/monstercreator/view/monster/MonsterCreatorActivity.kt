package cl.desafiolatam.monstercreator.view.monster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatam.monstercreator.R
import cl.desafiolatam.monstercreator.model.Monster
import cl.desafiolatam.monstercreator.model.MonsterAttributes
import cl.desafiolatam.monstercreator.viewmodel.AllMonsterViewModel
import cl.desafiolatam.monstercreator.viewmodel.MonsterCreatorViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_monster_creator.*
import kotlinx.android.synthetic.main.activity_monster_creator.view.*
import kotlinx.android.synthetic.main.content_main.*

class MonsterCreatorActivity : AppCompatActivity() {
    private lateinit var viewModel: MonsterCreatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monster_creator)



        // in this activity must place a recyclerView with all the monster on the DB
        saveButton.setOnClickListener{

            viewModel = ViewModelProvider(this).get(MonsterCreatorViewModel::class.java)
            var estado: Boolean = true


            if (nameEditText.text.isEmpty()){
                Snackbar.make(layoutMonster, "Campo Nombre es requerido", Snackbar.LENGTH_LONG).show()
                estado = false
            }
            if(intelligence.selectedItem.toString().isEmpty()){
                Snackbar.make(layoutMonster, "Campo Inteligencia es requerido", Snackbar.LENGTH_LONG).show()
                estado = false
            }
            if(strength.selectedItem.toString().isEmpty()){
                Snackbar.make(layoutMonster, "Campo Inteligencia es requerido", Snackbar.LENGTH_LONG).show()
                estado = false
            }
            if(endurance.selectedItem.toString().isEmpty()){
                Snackbar.make(layoutMonster, "Campo Inteligencia es requerido", Snackbar.LENGTH_LONG).show()
                estado = false
            }

            if (estado){
                var newMonster: Monster = Monster(MonsterAttributes(intelligence.selectedItem.toString().toInt(), strength.selectedItem.toString().toInt(), endurance.selectedItem.toString().toInt()), 400, nameEditText.text.toString(), R.drawable.asset05)
                viewModel.insertMonster(newMonster)
            }

        }

        avatarImageView.setOnClickListener{

        }
    }

    /*Spinner spinner = new Spinner(this);
    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
    (this, android.R.layout.simple_spinner_item,
    spinnerArray); //selected item will look like a spinner set from XML
    spinnerArrayAdapter.setDropDownViewResource(android.R.layout
    .simple_spinner_dropdown_item);
    spinner.setAdapter(spinnerArrayAdapter);*/
}
