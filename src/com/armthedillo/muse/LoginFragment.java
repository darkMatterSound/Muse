package com.armthedillo.muse;

import java.util.Arrays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.Request;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;


public class LoginFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.login, container, false);
	    LoginButton loginButton = (LoginButton) view.findViewById(R.id.loginButton);
	    loginButton.setFragment(this);
	    loginButton.setReadPermissions(Arrays.asList("user_likes", "user_status"));

	    return view;
	}
	
	private static final String TAG = "LoginFragment";
	
	private void onSessionStateChange(Session session, SessionState state, Exception exception) {
		if (exception != null) {
			Log.i(TAG, String.format("Exception: %s", exception.toString()));
		}
	    if (state.isOpened()) {
	        Log.i(TAG, "Logged in...");
	        // Request user data and show the results
            Request.newMeRequest(session, new Request.GraphUserCallback() {
            	
                @Override
                public void onCompleted(GraphUser user, Response response) {
                    if (user != null) {
                        //HERE: DISPLAY USER'S PICTURE
                        userPicture.setProfileId(user.getId());
                    }
                }
            }).executeAsync();
	    } else if (state.isClosed()) {
	        Log.i(TAG, "Logged out...");
	        userPicture.setProfileId(null);
	    }
	}
	
	private Session.StatusCallback callback = new Session.StatusCallback() {
	    @Override
	    public void call(Session session, SessionState state, Exception exception) {
	        onSessionStateChange(session, state, exception);
	    }
	};
	
	private UiLifecycleHelper uiHelper;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    uiHelper = new UiLifecycleHelper(getActivity(), callback);
	    uiHelper.onCreate(savedInstanceState);
	}
	
	@Override
	public void onResume() {
	    super.onResume();
	    uiHelper.onResume();
	    // For scenarios where the main activity is launched and user
	    // session is not null, the session state change notification
	    // may not be triggered. Trigger it if it's open/closed.
	    Session session = Session.getActiveSession();
	    if (session != null &&
	           (session.isOpened() || session.isClosed()) ) {
	        onSessionStateChange(session, session.getState(), null);
	    }

	    uiHelper.onResume();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    uiHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onPause() {
	    super.onPause();
	    uiHelper.onPause();
	}

	@Override
	public void onDestroy() {
	    super.onDestroy();
	    uiHelper.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    uiHelper.onSaveInstanceState(outState);
	}

}
