/*
 * Copyright (C) 2018 Piotr Wittchen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pwittchen.neurosky.library;

import android.bluetooth.BluetoothAdapter;
import androidx.annotation.NonNull;
import com.github.pwittchen.neurosky.library.exception.BluetoothNotEnabledException;
import com.github.pwittchen.neurosky.library.listener.DeviceMessageListener;
import com.github.pwittchen.neurosky.library.validation.DefaultPreconditions;
import com.github.pwittchen.neurosky.library.validation.Preconditions;
import com.neurosky.thinkgear.TGDevice;

public class NeuroSky {

    private boolean rawSignalEnabled = false;

    private TGDevice device;

    private DeviceMessageHandler handler;

    private Preconditions preconditions;

    public NeuroSky(final DeviceMessageListener listener) {
        this(listener, new DefaultPreconditions());
    }

    protected NeuroSky(final DeviceMessageListener listener, @NonNull Preconditions preconditions) {
        this.preconditions = preconditions;
        if (preconditions.isBluetoothAdapterInitialized()) {
            handler = new DeviceMessageHandler(listener);
            device = new TGDevice(BluetoothAdapter.getDefaultAdapter(), handler);
        }
    }

    public void connect() throws BluetoothNotEnabledException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void openConnection() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void disconnect() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void closeConnection() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void enableRawSignal() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void disableRawSignal() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isRawSignalEnabled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void start() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void startMonitoring() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void stopMonitoring() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean canConnect() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isConnected() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isConnecting() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public TGDevice getDevice() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public DeviceMessageHandler getHandler() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
