/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.explicitintent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declare varible
    private TextView mDisplayText;
    private EditText mNameEntry;
    private Button mDoSomethingCoolButton;


    //Start method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asign value to variable
        mDisplayText = (TextView) findViewById(R.id.tv_display);
        mDoSomethingCoolButton = (Button) findViewById(R.id.b_do_something_cool);
        mNameEntry = (EditText) findViewById(R.id.et_text_entry);

        Intent intentThatStartedThisActivity = getIntent();

        if(intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {

            String textEntred = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
            mDisplayText.setText(textEntred);

        }

        mDoSomethingCoolButton.setOnClickListener(new OnClickListener() {

            // if button has ben clicked
            @Override
            public void onClick(View v) {

                String texEntred = mNameEntry.getText().toString();

                Context context = MainActivity.this;

                Class destinationActivity = ChildActivity.class;

                Intent startChildActivityIntent = new Intent(context, destinationActivity);

                startChildActivityIntent.putExtra(Intent.EXTRA_TEXT,texEntred+"\n You are in ChildActivity");

                startActivity(startChildActivityIntent);

            }
        });
    }
}

