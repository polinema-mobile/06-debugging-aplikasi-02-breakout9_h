package com.example.new_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Button Angka
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    // Button Operator
    private Button b_equal, b_multi, b_divide, b_add, b_sub;
    // Button Lainnya
    private Button b_clear, b_dot, b_mod, b_pl_minus;

    // Text dan Karakter
    private TextView txtInput;
    private TextView txtOutput;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQUAL = '=';
    private final char EXTRA = '@';
    private final char MODULUS = '%';
    private char ACTION;
    private double valueInput = Double.NaN;
    private double valueOutput;

    private void viewSetup() {
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);
        b0 = findViewById(R.id.btn0);

        b_add = findViewById(R.id.btn_add);
        b_sub = findViewById(R.id.btn_sub);
        b_multi = findViewById(R.id.btn_multi);
        b_divide = findViewById(R.id.btn_divide);
        b_mod = findViewById(R.id.btn_mod);
        b_equal = findViewById(R.id.btn_equal);

        b_clear = findViewById(R.id.button_clear);
        b_dot = findViewById(R.id.button_dot);
        b_pl_minus = findViewById(R.id.button_pl_minus);

        txtInput = findViewById(R.id.input);
        txtOutput = findViewById(R.id.output);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewSetup();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                txtInput.setText(txtInput.getText().toString() + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                txtInput.setText(txtInput.getText().toString() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                txtInput.setText(txtInput.getText().toString() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                txtInput.setText(txtInput.getText().toString() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                txtInput.setText(txtInput.getText().toString() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                txtInput.setText(txtInput.getText().toString() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                txtInput.setText(txtInput.getText().toString() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                txtInput.setText(txtInput.getText().toString() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                txtInput.setText(txtInput.getText().toString() + "9");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                txtInput.setText(txtInput.getText().toString() + "0");
            }
        });

        b_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                txtInput.setText(txtInput.getText().toString() + ".");
            }
        });

        b_mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() > 0) {
                    ACTION = MODULUS;
                    operation();
                    if (!ifReallyDecimal()) {
                        txtOutput.setText(valueInput + "%");
                    } else {
                        txtOutput.setText((int) valueInput + "%");
                    }
                    txtInput.setText(null);
                } else {
                    txtOutput.setText("Error");
                }
            }
        });

        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() > 0) {
                    ACTION = ADDITION;
                    operation();
                    if (!ifReallyDecimal()) {
                        txtOutput.setText(valueInput + "+");
                    } else {
                        txtOutput.setText((int) valueInput + "+");
                    }
                    txtInput.setText(null);
                } else {
                    txtOutput.setText("Error");
                }
            }
        });

        b_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() > 0) {
                    ACTION = SUBTRACTION;
                    operation();
                    if (txtInput.getText().length() > 0)
                        if (!ifReallyDecimal()) {
                            txtOutput.setText(valueInput + "-");
                        } else {
                            txtOutput.setText((int) valueInput + "-");
                        }
                    txtInput.setText(null);
                } else {
                    txtOutput.setText("Error");
                }
            }
        });

        b_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() > 0) {
                    ACTION = MULTIPLICATION;
                    operation();
                    if (!ifReallyDecimal()) {
                        txtOutput.setText(valueInput + "×");
                    } else {
                        txtOutput.setText((int) valueInput + "×");
                    }
                    txtInput.setText(null);
                } else {
                    txtOutput.setText("Error");
                }
            }
        });

        b_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() > 0) {
                    ACTION = DIVISION;
                    operation();
                    if (ifReallyDecimal()) {
                        txtOutput.setText((int) valueInput + "/");
                    } else {
                        txtOutput.setText(valueInput + "/");
                    }
                    txtInput.setText(null);
                } else {
                    txtOutput.setText("Error");
                }
            }
        });

        // Convert Positive Number to Negative, and Negative to Positive
        b_pl_minus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (!txtInput.getText().toString().isEmpty()) {
                    valueInput = Double.parseDouble(txtInput.getText().toString());
                    ACTION = EXTRA;
                    txtOutput.setText("-" + txtInput.getText().toString());
                    txtInput.setText("");
                } else if (!txtOutput.getText().toString().contains("-")) {
                    txtOutput.setText("-" + txtOutput.getText().toString());
                } else if (txtOutput.getText().toString().contains("-")){
                    txtOutput.setText(txtOutput.getText().toString().replace("-", ""));
                } else {
                    Toast.makeText(getApplicationContext(), "Belum ada Angka", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() > 0) {
                    operation();
                    ACTION = EQUAL;
                    if (!ifReallyDecimal()) {
                        txtOutput.setText(String.valueOf(valueInput));
                    } else {
                        txtOutput.setText(String.valueOf((int) valueInput));
                    }
                    txtInput.setText(null);
                } else {
                    txtOutput.setText("Error");
                }
            }
        });

        b_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() > 0) {
                    CharSequence name = txtInput.getText().toString();
                    txtInput.setText(name.subSequence(0, name.length() - 1));
                } else {
                    valueInput = Double.NaN;
                    valueOutput = Double.NaN;
                    txtInput.setText("");
                    txtOutput.setText("");
                }
            }
        });

        // Empty text views on long click.
        b_clear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                valueInput = Double.NaN;
                valueOutput = Double.NaN;
                txtInput.setText("");
                txtOutput.setText("");
                return true;
            }
        });
    }

    private void operation() {
        if (!Double.isNaN(valueInput)) {
            if (txtOutput.getText().toString().charAt(0) == '-') {
                valueInput = (-1) * valueInput;
            }
            valueOutput = Double.parseDouble(txtInput.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    valueInput += valueOutput;
                    break;
                case SUBTRACTION:
                    valueInput -= valueOutput;
                    break;
                case MULTIPLICATION:
                    valueInput *= valueOutput;
                    break;
                case DIVISION:
                    valueInput /= valueOutput;
                    break;
                case EXTRA:
                    valueInput = (-1) * valueInput;
                    break;
                case MODULUS:
                    valueInput = valueInput % valueOutput;
                    break;
                case EQUAL:
                    break;
            }
        } else {
            valueInput = Double.parseDouble(txtInput.getText().toString());
        }
    }

    // Remove error message that is already written there.
    private void ifErrorOnOutput() {
        if (txtOutput.getText().toString().equals("Error")) {
            txtOutput.setText("");
        }
    }

    // Whether value if a double or not
    private boolean ifReallyDecimal() {
        return valueInput == (int) valueInput;
    }

    private void noOperation() {
        String inputExpression = txtOutput.getText().toString();
        if (!inputExpression.isEmpty() && !inputExpression.equals("Error")) {
            if (inputExpression.contains("-")) {
                inputExpression = inputExpression.replace("-", "");
                txtOutput.setText("");
                valueInput = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("+")) {
                inputExpression = inputExpression.replace("+", "");
                txtOutput.setText("");
                valueInput = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("/")) {
                inputExpression = inputExpression.replace("/", "");
                txtOutput.setText("");
                valueInput = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("%")) {
                inputExpression = inputExpression.replace("%", "");
                txtOutput.setText("");
                valueInput = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("×")) {
                inputExpression = inputExpression.replace("×", "");
                txtOutput.setText("");
                valueInput = Double.parseDouble(inputExpression);
            }
        }
    }

    // Make text small if too many digits.
    private void exceedLength() {
        if (txtInput.getText().toString().length() > 10) {
            txtInput.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        }
    }
}