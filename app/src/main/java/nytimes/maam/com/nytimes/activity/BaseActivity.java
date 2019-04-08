package nytimes.maam.com.nytimes.activity;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import nytimes.maam.com.nytimes.R;

public class BaseActivity  extends AppCompatActivity {

    private Dialog loadingDialog;
    public void showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = new Dialog(this);
            loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            loadingDialog.setCancelable(false);
            loadingDialog.setContentView(R.layout.dialog_loading);
            loadingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        }
        if (!loadingDialog.isShowing())
            loadingDialog.show();
    }

    public void dismissLoadingDialog() {
        if (loadingDialog != null)
            loadingDialog.dismiss();
    }


    public void showMessage(final String... message) {
        final Dialog dialog = new Dialog(this, R.style.show_message_dialog_theme);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_message_dialog);

        TextView tvMessage = (TextView) dialog.findViewById(R.id.tvMessage);
        TextView tvClose = (TextView) dialog.findViewById(R.id.tvClose);
        tvMessage.setText(message[0]);
        tvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                if (message.length > 1 && message[1].equals("FINISH"))
                    finish();
            }
        });
        dialog.show();
    }
}
