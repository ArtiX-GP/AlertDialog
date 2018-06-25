package ru.smandroid.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onClick(View view) {
        String[] actions = {
                "Показать простое окно",
                "Показать окно с тремя кнопками",
                "Показать окно с выбором"
        };
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("Сделайте выбор");
        builder.setItems(actions, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        showDialogWithoutButton();
                        break;
                    case 1:
                        showSimpleDialog();
                        break;
                    case 2:
                        showDialogMultiplyChoose();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.create();
        builder.show();
    }

    // Создание диалога с множественным выбором.
    private void showDialogMultiplyChoose() {
        final String[] actions = {
                "Хлеб",
                "Молоко",
                "Печенье",
                "Сахар",
                "Вода"
        };
        final boolean[] actionsChecked = {
                false,
                false,
                false,
                true,
                false
        };
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("Множественный выбор");
        builder.setMultiChoiceItems(
                actions,
                actionsChecked,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                       actionsChecked[i] = b;
                    }
                });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String s = "Вы выбрали ";
                for (int i2 = 0; i2 < actionsChecked.length; i2++) {
                    if (actionsChecked[i2])
                        s += actions[i2] + " ";
                }
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });
        builder.create();
        builder.show();
    }

    // Создание диалога без кнопок.
    private void showDialogWithoutButton() {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("Простое окно");
        builder.setMessage("Привет, Мир!");
        builder.create();
        builder.show();
    }

    // Простое диалоговое окно с 3 кнопками.
    public void showSimpleDialog() {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("Важное сообщение!");
        builder.setMessage("Покорми котика");
        builder.setCancelable(false);
        builder.setPositiveButton("Я покормил!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Вы красавчик!", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Я не покормил!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Вы плохой человек!", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        builder.setNeutralButton("Он не мой", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Заберите котика себе!", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        builder.create();
        builder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
