package com.abhigyan.user.assignment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView loadImage;
    ProgressBar progressBar;

    public class loadIcon extends AsyncTask<Integer, Integer, Bitmap>
    {

        @Override
        protected Bitmap doInBackground(Integer... integers) {

            Bitmap bitmap = BitmapFactory.decodeResource(getResources() ,integers[0]);

            for(int i=0 ;i<10;i++)
            {
                try
                {
                    Thread.sleep(2000);
                    publishProgress(i*10);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            return bitmap;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            progressBar.setVisibility(View.INVISIBLE);
            loadImage.setImageBitmap(bitmap);

        }
    }

    public void checkFunction(View view)
    {
        Toast.makeText(this, "I am alive!", Toast.LENGTH_SHORT).show();
    }
    public void loadFunction(View view)
    {
        new loadIcon().execute(R.drawable.ssj2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadImage = findViewById(R.id.loadImage);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
    }
}
