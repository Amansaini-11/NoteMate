package com.example.notemate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.notemate.ui.fragments.MindMapFragment
import com.example.notemate.ui.fragments.NotesFragment
import com.example.notemate.ui.fragments.RecordingFragment
import com.example.notemate.ui.fragments.ToDoFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val framelayout = findViewById<FrameLayout>(R.id.framelayout)

        val btnNotes = findViewById<Button>(R.id.btnNotes)
        val btnTodo = findViewById<Button>(R.id.btnToDo)
        val btnMindmap = findViewById<Button>(R.id.btnMindmap)
        val btnrecording = findViewById<Button>(R.id.btnRecording)
        val btnSettings = findViewById<Button>(R.id.btnSettings)


        supportFragmentManager.commit {
            replace<NotesFragment>(R.id.framelayout)
        }

        btnNotes.setOnClickListener {

            supportFragmentManager.commit {
                replace<NotesFragment>(R.id.framelayout)
            }

        }

        btnTodo.setOnClickListener {

            supportFragmentManager.commit {
                replace<ToDoFragment>(R.id.framelayout)
                addToBackStack(null)
            }
        }

        btnMindmap.setOnClickListener {

            supportFragmentManager.commit {
                replace<MindMapFragment>(R.id.framelayout)
                addToBackStack(null)
            }
        }

        btnrecording.setOnClickListener {

            supportFragmentManager.commit {
                replace<RecordingFragment>(R.id.framelayout)
                addToBackStack(null)
            }
        }

        btnSettings.setOnClickListener {

            val i = Intent(this , SettingsActivity::class.java)
            startActivity(i)

        }
    }
}