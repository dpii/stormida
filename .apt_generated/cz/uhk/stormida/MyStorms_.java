//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package cz.uhk.stormida;

import java.util.List;
import Model.Storm;
import Model.User;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.googlecode.androidannotations.api.BackgroundExecutor;
import cz.uhk.stormida.R.id;

public final class MyStorms_
    extends MyStorms
{

    private Handler handler_ = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    private void init_(Bundle savedInstanceState) {
    }

    private void afterSetContentView_() {
        lv = ((ListView) findViewById(id.lvStorms));
        lu = ((TextView) findViewById(id.tv_LoggedAs));
        {
            View view = findViewById(id.btCreate);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        MyStorms_.this.create();
                    }

                }
                );
            }
        }
        {
            View view = findViewById(id.btJoin);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        MyStorms_.this.join();
                    }

                }
                );
            }
        }
        {
            View view = findViewById(id.btLogout);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        MyStorms_.this.logout();
                    }

                }
                );
            }
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        afterSetContentView_();
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        afterSetContentView_();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        afterSetContentView_();
    }

    public static MyStorms_.IntentBuilder_ intent(Context context) {
        return new MyStorms_.IntentBuilder_(context);
    }

    @Override
    public void setLoggedUser(final User user) {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                try {
                    MyStorms_.super.setLoggedUser(user);
                } catch (RuntimeException e) {
                    Log.e("MyStorms_", "A runtime exception was thrown while executing code in a runnable", e);
                }
            }

        }
        );
    }

    @Override
    public void showToast(final CharSequence msg) {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                try {
                    MyStorms_.super.showToast(msg);
                } catch (RuntimeException e) {
                    Log.e("MyStorms_", "A runtime exception was thrown while executing code in a runnable", e);
                }
            }

        }
        );
    }

    @Override
    public void goAnon() {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                try {
                    MyStorms_.super.goAnon();
                } catch (RuntimeException e) {
                    Log.e("MyStorms_", "A runtime exception was thrown while executing code in a runnable", e);
                }
            }

        }
        );
    }

    @Override
    public void bindData(final List<Storm> topics) {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                try {
                    MyStorms_.super.bindData(topics);
                } catch (RuntimeException e) {
                    Log.e("MyStorms_", "A runtime exception was thrown while executing code in a runnable", e);
                }
            }

        }
        );
    }

    @Override
    public void getLoggedUser() {
        BackgroundExecutor.execute(new Runnable() {


            @Override
            public void run() {
                try {
                    MyStorms_.super.getLoggedUser();
                } catch (RuntimeException e) {
                    Log.e("MyStorms_", "A runtime exception was thrown while executing code in a runnable", e);
                }
            }

        }
        );
    }

    public static class IntentBuilder_ {

        private Context context_;
        private final Intent intent_;

        public IntentBuilder_(Context context) {
            context_ = context;
            intent_ = new Intent(context, MyStorms_.class);
        }

        public Intent get() {
            return intent_;
        }

        public MyStorms_.IntentBuilder_ flags(int flags) {
            intent_.setFlags(flags);
            return this;
        }

        public void start() {
            context_.startActivity(intent_);
        }

        public void startForResult(int requestCode) {
            if (context_ instanceof Activity) {
                ((Activity) context_).startActivityForResult(intent_, requestCode);
            } else {
                context_.startActivity(intent_);
            }
        }

    }

}
