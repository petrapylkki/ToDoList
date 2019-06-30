package com.example.todoexample

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_add_item.*
import java.lang.Exception


class AddItemActivity : AppCompatActivity() {

    private val realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
    }

    fun addItem(v: View) {
    /*
        if (etxt_title.equals("")) {
            var alertDialog = AlertDialog.Builder(this)
                .setTitle("jotain")
                .setMessage("jotainhaha")
                .setPositiveButton("Ok") { dialog, which ->
                    dialog.dismiss()
                }
                .setNegativeButton("no") { dialog, which ->
                    //sit tehää jotain
                }
                .show()
        }*/
            //Dialogi-ikkuna
            var alertDialog = AlertDialog.Builder(this)
                .setTitle(this.resources.getString((R.string.dialog_title)))
                .setMessage(this.resources.getString((R.string.dialog_message)))
                .setPositiveButton("Ok") { dialog, which ->


                    var maxId = realm.where(ToDoListItem::class.java).max("id")

                    var nextId = if (maxId == null) 1 else maxId.toInt() + 1

                    var todoItem = ToDoListItem(nextId, etxt_title.text.toString(), etxt_body.text.toString())

                    try {
                        realm.beginTransaction()
                        realm.copyToRealmOrUpdate(todoItem)
                        realm.commitTransaction()

                        val intent = Intent(this, MainActivity::class.java)
                        setResult(Activity.RESULT_OK, intent)

                    } catch (e: Exception) {
                        println(e)
                    }
                    finish()
                }
                .show()
            alertDialog.show()
        }
    }
