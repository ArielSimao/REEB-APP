package andre.prjreebv3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread timeThread = new Thread(){//criando a splash screen
            @Override
            public void run(){
                try{
                    sleep(3000);//tempo de 3 mil milisegundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(MainActivity.this, Menu.class);//criando uma intent para conversar com a classe Menu da outra activity
                    startActivity (intent);
                }
            }
        };
        timeThread.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}
