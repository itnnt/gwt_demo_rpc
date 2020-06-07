package com.mySampleApplication.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MessageServiceAsync {
    void getMessage(String input, AsyncCallback<Message> async);
}
