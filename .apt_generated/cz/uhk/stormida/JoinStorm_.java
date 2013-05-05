//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package cz.uhk.stormida;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import com.googlecode.androidannotations.api.BackgroundExecutor;
import cz.uhk.stormida.R.id;

public final class JoinStorm_
    extends JoinStorm
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
        etName = ((EditText) findViewById(id.etNewStorm_name));
        etPass = ((EditText) findViewById(id.etNewStorm_pass));
        {
            View view = findViewById(id.btJoinStorm);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        JoinStorm_.this.joinStorm();
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

    public static JoinStorm_.IntentBuilder_ intent(Context context) {
        return new JoinStorm_.IntentBuilder_(context);
    }

    @Override
    public void showToast(final CharSequence msg) {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                try {
                    JoinStorm_.super.showToast(msg);
                } catch (RuntimeException e) {
                    Log.e("JoinStorm_", "A runtime exception was thrown while executing code in a runnable", e);
                }
            }

        }
        );
    }

    @Override
    public void checkPass(final Model.Topic Topic) {
        BackgroundExecutor.execute(new Runnable() {


            @Override
            public void run() {
                try {
                    JoinStorm_.super.checkPass(Topic);
                } catch (RuntimeException e) {
                    Log.e("JoinStorm_", "A runtime exception was thrown while executing code in a runnable", e);
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
            intent_ = new Intent(context, JoinStorm_.class);
        }

        public Intent get() {
            return intent_;
        }

        public JoinStorm_.IntentBuilder_ flags(int flags) {
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
