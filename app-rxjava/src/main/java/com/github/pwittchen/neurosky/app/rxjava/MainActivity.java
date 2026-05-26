package com.github.pwittchen.neurosky.app.rxjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.github.pwittchen.neurosky.library.RxNeuroSky;
import com.github.pwittchen.neurosky.library.message.enums.BrainWave;
import com.github.pwittchen.neurosky.library.message.enums.Signal;
import com.github.pwittchen.neurosky.library.message.enums.State;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Locale;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private final static String LOG_TAG = "NeuroSky";

    private RxNeuroSky neuroSky;

    private Disposable disposable;

    @BindView(R.id.tv_state)
    TextView tvState;

    @BindView(R.id.tv_attention)
    TextView tvAttention;

    @BindView(R.id.tv_meditation)
    TextView tvMeditation;

    @BindView(R.id.tv_blink)
    TextView tvBlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void onResume() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void onPause() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void handleStateChange(final State state) {
        if (neuroSky != null && state.equals(State.CONNECTED)) {
            neuroSky.start();
        }
        tvState.setText(state.toString());
        Log.d(LOG_TAG, state.toString());
    }

    private void handleSignalChange(final Signal signal) {
        switch(signal) {
            case ATTENTION:
                tvAttention.setText(getFormattedMessage("attention: %d", signal));
                break;
            case MEDITATION:
                tvMeditation.setText(getFormattedMessage("meditation: %d", signal));
                break;
            case BLINK:
                tvBlink.setText(getFormattedMessage("blink: %d", signal));
                break;
        }
        Log.d(LOG_TAG, String.format("%s: %d", signal.toString(), signal.getValue()));
    }

    private String getFormattedMessage(String messageFormat, Signal signal) {
        return String.format(Locale.getDefault(), messageFormat, signal.getValue());
    }

    private void handleBrainWavesChange(final Set<BrainWave> brainWaves) {
        if (brainWaves.isEmpty()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (BrainWave bw : brainWaves) {
            String message = String.format(Locale.getDefault(), "%s: %d", bw.toString(), bw.getValue());
            stringBuilder.append(message).append(", ");
        }
        Log.d(LOG_TAG, stringBuilder.substring(0, stringBuilder.toString().length() - 2));
    }

    @SuppressLint("CheckResult")
    @OnClick(R.id.btn_connect)
    void connect() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressLint("CheckResult")
    @OnClick(R.id.btn_disconnect)
    void disconnect() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressLint("CheckResult")
    @OnClick(R.id.btn_start_monitoring)
    void startMonitoring() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressLint("CheckResult")
    @OnClick(R.id.btn_stop_monitoring)
    void stopMonitoring() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
