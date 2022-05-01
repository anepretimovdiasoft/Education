package ru.stavopol.education;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

import ru.stavopol.education.dao.TransferCsvSqlite;
import ru.stavopol.education.db.EducationDbOpenHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new TransferCsvSqlite(this, new EducationDbOpenHelper(this)).loadData();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_menu);

        bottomNavigationView.setItemOnTouchListener(R.id.menu_button_search, new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                NavController navController = NavHostFragment
                        .findNavController(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.nav_host)));

                if (navController.getCurrentDestination().getLabel().toString().equals("fragment_book")) {
                    navController.navigate(R.id.action_bookFragment_to_testFragment);
                }

                return false;
            }
        });

        bottomNavigationView.setItemOnTouchListener(R.id.menu_button_home, new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                NavController navController = NavHostFragment
                        .findNavController(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.nav_host)));


                if (navController.getCurrentDestination().getLabel().toString().equals("fragment_test")) {
                    navController
                            .navigate(R.id.action_testFragment_to_bookFragment);
                }

                return false;
            }
        });
    }
}