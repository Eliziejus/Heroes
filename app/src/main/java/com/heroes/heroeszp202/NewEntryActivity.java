package com.heroes.heroeszp202;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class NewEntryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
        setTitle("New Entry");

        Intent intent = getIntent();
        Hero hero = (Hero) intent.getSerializableExtra(Adapter.ENTRY);

        final CheckBox checkBoxLithuania = findViewById(R.id.hero_Iron_man);
        final CheckBox checkBoxLatvia = findViewById(R.id.hero_Captain_America);
        final CheckBox checkBoxEstonia = findViewById(R.id.hero_Thor);
        final CheckBox checkBoxHero = findViewById(R.id.hero_Hulk);
        final EditText Command = findViewById(R.id.command);

        final RadioGroup groupHero = findViewById(R.id.powers);
        RadioButton button2k = findViewById(R.id.two_thousand);

        final Spinner spinnerUpdate = findViewById(R.id.strength);
        ArrayList<String> updateList = new ArrayList<String>();
        updateList.add(hero.getIntelligence());
        updateList.add(getResources().getString(R.string.new_entry_strength_2));
        updateList.add(getResources().getString(R.string.new_entry_strength_3));
        updateList.add(getResources().getString(R.string.new_entry_strength_4));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                updateList
        );
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Adapteri idedame i musu spinneri.
        spinnerUpdate.setAdapter(dataAdapter);


        final EditText editTextStrength = findViewById(R.id.speeds);

        Button buttonDisplaySelected = findViewById(R.id.display_selected_btn);



        checkBoxHero.setText(hero.getName());
        button2k.setText(hero.getSpeed());
        editTextStrength.setText(hero.getStrength());

        // Ant mygtuko paspaudimo parodyti visa vartotojo ivesta informacija.
        buttonDisplaySelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "";
                if (checkBoxLithuania.isChecked()) {
                    name += checkBoxLithuania.getText().toString() + ", ";
                }
                if (checkBoxLatvia.isChecked()) {
                    name += checkBoxLatvia.getText().toString() + ", ";
                }
                if (checkBoxEstonia.isChecked()) {
                    name += checkBoxEstonia.getText().toString() + ", ";
                }
                if (checkBoxHero.isChecked()) {
                    name += checkBoxHero.getText().toString() + ", ";
                }

                // get selected radio button from radioGroup
                int selectedId = groupHero.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                RadioButton selectedButton = (RadioButton) findViewById(selectedId);
                String speed = (selectedButton.getText().toString());

                String intelligence = String.valueOf(spinnerUpdate.getSelectedItem());

                String power = editTextStrength.getText().toString();

                editTextStrength.setError(null);
                if (Validation.isValidNumber(power)){
                    // Sukuriamas korona objektas is GUI elementu.

                    Hero hero1 = new Hero(intelligence,name,power, speed);

                    // Atvaizduojamas vartotojui objekto informacija.
                    Toast.makeText(
                            NewEntryActivity.this,
                            "Heroes: " + hero1.getIntelligence() + "\n " +
                                    "Strength: " + hero1.getName() + "\n " +
                                    "Speed: " + hero1.getPower() + "\n " +
                                    "Power: " + hero1.getSpeed() + "\n" +
                                    "Command: " + Command.getText().toString(),
                            Toast.LENGTH_SHORT
                    ).show();
                } else { // blogai įvesti confirmed duomenys
                    editTextStrength.setError(getResources().getString(R.string.new_entry_invalid_confirmed));
                    editTextStrength.requestFocus();
                }
            }
        });
    }
}
