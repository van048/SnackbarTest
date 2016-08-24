package cn.ben.snackbartest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /**
         * 可以把它理解成一个加强版的Toast
         * Context已无需多讲，而Snackbar的参数中传入一个View是几个意思呢
         * Toast是个系统级窗口，相当于悬浮在所有View的上面
         * SnackBar会遍历整个View Tree来找到一个合适的View承载SnackBar的View
         * 如果你想要实现上面的动画交互效果的话最好是传入CoordinatorLayout对象
         */
//        Snackbar.make(fab, "it is Snackbar", Snackbar.LENGTH_SHORT)
//                .setActionTextColor(Color.WHITE)
//                .setCallback(new Snackbar.Callback() {
//                    @Override
//                    public void onDismissed(Snackbar snackbar, int event) {
//                        super.onDismissed(snackbar, event);
//                        Toast.makeText(MainActivity.this, "Snackbar dismiss", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onShown(Snackbar snackbar) {
//                        super.onShown(snackbar);
//                        Toast.makeText(MainActivity.this, "Snackbar show", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setAction("点我", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(MainActivity.this, "it is Toast", Toast.LENGTH_SHORT).show();
//                    }
//
//                }).show();

//        Snackbar bar = Snackbar.make(fab, "it is Snackbar", Snackbar.LENGTH_SHORT);
//        View v = bar.getView();
//        v.setBackgroundColor(Color.GREEN);
//        bar.show();

        Snackbar mSnackbar = Snackbar.make(fab, "it is Snackbar", Snackbar.LENGTH_SHORT);
        View v = mSnackbar.getView();
        ViewGroup.LayoutParams vl = v.getLayoutParams();
        CoordinatorLayout.LayoutParams cl = new CoordinatorLayout.LayoutParams(vl.width, vl.height);
        //设置显示位置居中
        cl.gravity = Gravity.CENTER;
        v.setLayoutParams(cl);
        //设置字体为红色
        ((TextView) v.findViewById(R.id.snackbar_text)).setTextColor(Color.RED);
        //设置背景色为绿色
        v.setBackgroundColor(Color.GREEN);
        //自定义动画
        //v.setAnimation();
        //设置icon
        ImageView iconImage = new ImageView(MainActivity.this);
        iconImage.setImageResource(R.mipmap.ic_launcher);
        //icon插入布局
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) v;
        snackbarLayout.addView(iconImage, 0);
        //设置按钮为蓝色
        mSnackbar.setActionTextColor(Color.BLUE).setAction("点我", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
