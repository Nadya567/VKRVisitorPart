package com.example.vkrfoodapplication;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.io.FileOutputStream;

public class FileOperations {

    public String fileName = "favoriteFoodFile.txt";

    /*public void openFile()
    {
        try {
            InputStream inputStream = openFileInput(fileName);

            if(inputStream != null)
            {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            }
        }

    }

    public void saveFile(String name, String price)
    {
        try
        {
            OutputStream outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(name);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }*/
}
